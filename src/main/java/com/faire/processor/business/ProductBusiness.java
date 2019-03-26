package com.faire.processor.business;

import java.util.List;

import com.faire.processor.api.client.ProductAPI;
import com.faire.processor.dtos.ProductDTO;
import com.faire.processor.dtos.ProductOptionDTO;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
public class ProductBusiness {

	final ProductAPI productAPI = new ProductAPI();
	
	/**
	 * 
	 * @return list of all products in the platform
	 */
	public List<ProductDTO> findAllProducts(){
		return this.productAPI.findAllProducts();
	}
	
	/**
	 * 
	 * @param A option
	 * @return The updated option
	 */
	public ProductOptionDTO updateOption(final ProductOptionDTO option){
		return this.productAPI.updateOption(option);
	}
	
}
