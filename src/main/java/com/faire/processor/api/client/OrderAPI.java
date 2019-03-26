/**
 * This class implement the Faire's Orders API, encapsulating the HTTP methods.
 */
package com.faire.processor.api.client;

import java.util.ArrayList;
import java.util.List;

import com.faire.processor.base.BaseHTTPClient;
import com.faire.processor.dtos.OrderDTO;
import com.faire.processor.dtos.OrderItemDTO;
import com.faire.processor.dtos.OrdersPageDTO;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
public class OrderAPI {
	
	/**
	 * 
	 * @return List of new orders in the platform
	 */
	public List<OrderDTO> findNewOrders(){
		
		//Gets all order pages and creates a list with all orders.
		
		BaseHTTPClient<OrdersPageDTO, String> http = new BaseHTTPClient<OrdersPageDTO, String>(OrdersPageDTO.class);
		
		List<OrderDTO> products = new ArrayList<OrderDTO>();

		int page = 1;
		
		OrdersPageDTO response;
		
		final String excludedStates = "excluded_states=PRE_TRANSIT,IN_TRANSIT,DELIVERED,BACKORDERED,CANCELED";
		
		do{
			response = http.get("orders?"+excludedStates+"&page="+page);
			products.addAll(response.getOrders());
			page++;
			
		}while(response.getOrders().size()>0);

		return products;
	}
	
	/**
	 * 
	 * @param A order
	 * @return The accepted order
	 */
	public OrderDTO acceptOrder(final OrderDTO order){
		BaseHTTPClient<OrderDTO, OrderDTO> http = new BaseHTTPClient<OrderDTO, OrderDTO>(OrderDTO.class);
		
		return http.put("orders/" + order.getId() + "/processing", order);
	}
	
	/**
	 * 
	 * @param Order item
	 * @return Back-ordered item
	 */
	public OrderItemDTO backOrderItem(final OrderItemDTO orderItem){
		BaseHTTPClient<OrderItemDTO, OrderItemDTO> http = new BaseHTTPClient<OrderItemDTO, OrderItemDTO>(OrderItemDTO.class);
		
		return http.post("orders/" + orderItem.getId() + "/processing", orderItem);
	}
}
