/**
 * This class is responsible for generate a map of maps forming a hash
 * matrix of the product options. This strategy privileges performance
 * in GET operations. 
 * 
 * TODO: It's necessary to explore how much memory is required
 * 		 in production environment considering the products list 
 * 		 size.
 * 
 */
package com.faire.processor.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.faire.processor.dtos.ProductDTO;
import com.faire.processor.dtos.ProductOptionDTO;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
public class InventoryBusiness {
	
	private Map<String, Map<String,ProductOptionDTO>> options;
		
	/**
	 * Generates a map of maps of the product options.
	 */
	public void generateInventoryLevels(){
		
		ProductBusiness productBusiness = new ProductBusiness();			
		
		final List<ProductDTO> productDTOList = productBusiness.findAllProducts();
		
		final int productsCapacity = Math.round(productDTOList.size()) + 1;
		
		//This map's size doesn't change. For better performance the loadFactor was configured to 1 in order to not allow auto-expanding during the map population.		
		Map<String, Map<String,ProductOptionDTO>> rows = new HashMap<String, Map<String,ProductOptionDTO>>(productsCapacity, 1);
		
		for(ProductDTO productDTO : productDTOList){

			List<ProductOptionDTO> options = productDTO.getOptions();
			if(options.size() > 0){
								
				final int OptionsCapacity = Math.round(productDTO.getOptions().size()) + 1;
				
				//This map's size doesn't change. For better performance the loadFactor was configured to 1 in order to not allow auto-expanding during the map population.
				Map<String,ProductOptionDTO> columns = new HashMap<String,ProductOptionDTO>(OptionsCapacity, 1);
			
				for(ProductOptionDTO productOptionDTO : productDTO.getOptions()){
					
					columns.put(productOptionDTO.getId(), productOptionDTO);

				}
				
				rows.put(productDTO.getId(), columns);
			}

		}		
		
		options = rows;
	}	
	
	/**
	 * 
	 * @param A product ID
	 * @param A product option ID
	 * @return The product option object
	 */
	public ProductOptionDTO findInventoryLevel(final String productID, final String optionID){
		return this.options.get(productID).get(optionID);
	}
}
