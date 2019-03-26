/**
 * This class contains the application configuration.
 */
package com.faire.processor.app;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
public final class FaireProcessorApplication {
	
	@Getter
	@Setter
	private static String apiKey ="";	
	
	private static Boolean isProduction = false;
	
	private static String baseUrlStage = "https://www.faire-stage.com/api/v1/";
	
	private static String baseUrlProduction = "https://www.faire.com/api/v1/";
	
	public static String getBaseUrl(){
		
		if(isProduction){
			
			return baseUrlProduction;
			
		}else{
			
			return baseUrlStage;
			
		}
	}

}
