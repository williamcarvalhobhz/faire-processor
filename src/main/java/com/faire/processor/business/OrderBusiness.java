/**
 * This class is responsible for process the orders in the platform
 * updating the product item levels and back-ordering if necessary.
 * 
 */
package com.faire.processor.business;

import java.util.List;

import com.faire.processor.api.client.OrderAPI;
import com.faire.processor.dtos.OrderDTO;
import com.faire.processor.dtos.OrderItemDTO;
import com.faire.processor.dtos.ProductOptionDTO;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
public class OrderBusiness {	
	
	final OrderAPI orderAPI = new OrderAPI();
	
	/**
	 * Process the new orders in the platform.
	 */
	public void processOrders(){
				
		final InventoryBusiness inventoryBusiness = new InventoryBusiness();
		
		//It's necessary to transform the products list in a map of maps
		inventoryBusiness.generateInventoryLevels();
		
		//Retrieve the new orders list
		List<OrderDTO> orderList = this.orderAPI.findNewOrders();		

		//Iterate the orders...
		for(OrderDTO order : orderList){
			
			//...and the order items.
			for(OrderItemDTO orderItem : order.getItems()){
				
				//For each item it searches in the map of maps the correspondent product item...
				final ProductOptionDTO productOption = inventoryBusiness.findInventoryLevel(orderItem.getProduct_id(), orderItem.getProduct_option_id());
				
				//...and checks the available quantity.
				if((productOption.getAvailable_quantity()!=null)&&(productOption.getAvailable_quantity() > orderItem.getQuantity())){
					
					//Accepts the order if there is quantity available...
					acceptOrder(order);
					
					//...and updates the product item quantity level.
					ProductBusiness productBusiness = new ProductBusiness();
					productOption.setAvailable_quantity(productOption.getAvailable_quantity() - orderItem.getQuantity());
					productBusiness.updateOption(productOption);
				}else{
					
					//If there isn't quantity available back-order the item.
					backOrderItem(orderItem);					
				}
			}

		}
	}
	
	/**
	 * 
	 * @param A order
	 * @return The accepted order
	 */
	public OrderDTO acceptOrder(final OrderDTO order){
		return this.orderAPI.acceptOrder(order);
	}
	
	/**
	 * 
	 * @param A order item
	 * @return The back-ordered order item
	 */
	public OrderItemDTO backOrderItem(final OrderItemDTO orderItem){
		return this.orderAPI.backOrderItem(orderItem);
	}
	
}
