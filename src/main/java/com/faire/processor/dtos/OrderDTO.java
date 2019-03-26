package com.faire.processor.dtos;

import java.io.Serializable;
import java.util.List;

import com.faire.processor.enums.OrderStatus;

import lombok.Data;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
@Data
public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private OrderStatus state;
	private String ship_after;
	private OrderAddressDTO address;
	private List<OrderItemDTO> items;
	private List<OrderShipmentDTO> shipments;
	private String created_at;
	private String updated_at;
}
