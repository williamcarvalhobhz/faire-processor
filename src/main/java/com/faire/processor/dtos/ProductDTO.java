package com.faire.processor.dtos;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
@Data
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String brand_id;
	private String short_description;
	private String description;
	private Integer wholesale_price_cents;
	private Integer retail_price_cents;
	private Boolean active;
	private String name;
	private Integer unit_multiplier;
	private List<ProductOptionDTO> options;
	private String created_at;
	private String updated_at;
	
}
