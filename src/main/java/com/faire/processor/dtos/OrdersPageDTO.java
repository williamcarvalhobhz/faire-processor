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
public class OrdersPageDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer page;
	private Integer limit;
	private List<OrderDTO> orders;
}
