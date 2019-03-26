package com.faire.processor.dtos;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
@Data
public class ProductOptionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String product_id;
	private Boolean active;
	private String name;
	private String sku;
	private Integer available_quantity;
	private String backordered_until;
	private String created_at;
	private String updated_at;
}
