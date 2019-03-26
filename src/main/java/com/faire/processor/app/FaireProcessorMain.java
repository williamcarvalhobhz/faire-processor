/**
 * This Application process the pending orders on the Faires's API, 
 * accepting if there is product items available or back-ordering 
 * if there isn't. 
 * 
 * TODO: Exception Handling, Statistics, Integration Tests, Multi-thread Processing.
 */

package com.faire.processor.app;

import java.util.Scanner;

import com.faire.processor.business.OrderBusiness;

/**
 * 
 * @author William Matos de Carvalho
 *
 */
public class FaireProcessorMain {
	private static Scanner scanner;

	public static void main(String[] args){
					
		System.out.println("Inform the API_KEY:");

		//Gets the API_KEY from keyboard
		scanner = new Scanner(System.in);
		String apiKey = scanner.nextLine();
		
		//If informed, updates the configuration
		if(!apiKey.isEmpty()){
			FaireProcessorApplication.setApiKey(apiKey);
		}else{
			System.out.println("Oh men! Without key, nothing done...");
			System.out.println("Closing...");
			System.exit(0);
		}
		
		System.out.println("I'm Processing orders... Please wait!");
		
		final OrderBusiness orderBusiness = new OrderBusiness();
		
		//Starts the order processing...
		orderBusiness.processOrders();
		
		System.out.println("Completed!");
		
	}
		
		
}
