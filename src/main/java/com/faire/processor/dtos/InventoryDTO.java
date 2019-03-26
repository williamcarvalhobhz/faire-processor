package com.faire.processor.dtos;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
@Data
public class InventoryDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String sku;
	private Integer current_quantity;
	private Boolean discontinued;
	private String backordered_until;
}
