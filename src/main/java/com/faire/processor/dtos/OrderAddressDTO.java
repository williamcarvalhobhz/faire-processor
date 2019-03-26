package com.faire.processor.dtos;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
@Data
public class OrderAddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String address1;
	private String address2;
	private String postal_code;
	private String city;
	private String state;
	private String state_code;
	private String phone_number;
	private String country;
	private String country_code;
	private String company_name;
}
