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
public class InventoriesPageDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<InventoryDTO> inventories;
}
