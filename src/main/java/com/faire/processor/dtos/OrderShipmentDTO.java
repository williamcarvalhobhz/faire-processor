package com.faire.processor.dtos;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
@Data
public class OrderShipmentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String order_id;
	private Integer maker_cost_cents;
	private String carrier;
	private String tracking_code;
	private String created_at;
	private String updated_at;
}
