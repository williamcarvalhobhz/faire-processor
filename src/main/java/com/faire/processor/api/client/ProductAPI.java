/**
 * This class implement the Faire's Products API, encapsulating the HTTP methods.
 */
package com.faire.processor.api.client;

import java.util.ArrayList;
import java.util.List;

import com.faire.processor.base.BaseHTTPClient;
import com.faire.processor.dtos.ProductDTO;
import com.faire.processor.dtos.ProductOptionDTO;
import com.faire.processor.dtos.ProductsPageDTO;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
public class ProductAPI {

	/**
	 * 
	 * @return List of all products in the platform
	 */
	public List<ProductDTO> findAllProducts(){
		
		//Gets all product pages and creates a list with all products.
		
		BaseHTTPClient<ProductsPageDTO, ProductsPageDTO> http = new BaseHTTPClient<ProductsPageDTO, ProductsPageDTO>(ProductsPageDTO.class);
		
		List<ProductDTO> products = new ArrayList<ProductDTO>();

		int page = 1;
		
		ProductsPageDTO response;
		
		do{
			response = http.get("products?page="+page);
			products.addAll(response.getProducts());
			page++;
			
		}while(response.getProducts().size()>0);

		return products;
	}
	
	/**
	 * 
	 * @param A option
	 * @return The updated option
	 */
	public ProductOptionDTO updateOption(final ProductOptionDTO option){
		BaseHTTPClient<ProductOptionDTO, ProductOptionDTO> http = new BaseHTTPClient<ProductOptionDTO, ProductOptionDTO>(ProductOptionDTO.class);
		
		return http.patch("products/options/" + option.getId(), option);
	}
}
