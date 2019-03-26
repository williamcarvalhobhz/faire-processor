package com.faire.processor.dtos;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
@Data
public class OrderItemDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String order_id;
	private String product_id;
	private String product_option_id;
	private Integer quantity;
	private String sku;
	private Integer price_cents;
	private String product_name;
	private String product_option_name;
	private Boolean includes_tester;
	private Integer tester_price_cents;
	private String created_at;
	private String updated_at;
}
