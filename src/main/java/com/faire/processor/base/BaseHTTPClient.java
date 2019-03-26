/**
 * Provides base HTTP methods using the Jersey dependency.
 * This class uses GENERICS to specify the return and payload types.
 * Another especification is that is necessary to inform the
 * result type class in the constructor of this class.
 */
package com.faire.processor.base;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.HttpUrlConnectorProvider;

import com.faire.processor.app.FaireProcessorApplication;

/**
 * 
 * @author William Matos de Carvalho
 *
 * @param <R> Return type
 * @param <P> Payload type
 */
public class BaseHTTPClient<R, P> {

	private Class<R> returnType;

	public BaseHTTPClient(Class<R> returnType){
		this.returnType = returnType;
	}
	
	public R get(final String parameter){		
		
		Client client = ClientBuilder.newClient();		 		
		
		WebTarget webTarget = client.target(FaireProcessorApplication.getBaseUrl() + parameter);

		R response = (R) webTarget.request(MediaType.APPLICATION_JSON).header("X-FAIRE-ACCESS-TOKEN", FaireProcessorApplication.getApiKey()).get(returnType);

		return response;
	}
	
	public R patch(final String parameter, P payload){		
		
		//Patch is not supported by jersey in default case. It was necessary to do a workaround.
		
		Client client = ClientBuilder.newClient()
	            .property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
		
		WebTarget webTarget = client.target(FaireProcessorApplication.getBaseUrl() + parameter);

		R response = webTarget.request(MediaType.APPLICATION_JSON).header("X-FAIRE-ACCESS-TOKEN", FaireProcessorApplication.getApiKey()).method("PATCH", Entity.entity(payload, "application/json;charset=UTF-8"), returnType);

		return response;
	}	
	
	public R put(final String parameter, P payload){
		
		Client client = ClientBuilder.newClient();		 		
		
		WebTarget webTarget = client.target(FaireProcessorApplication.getBaseUrl() + parameter);
		
		Response response = webTarget.request(MediaType.APPLICATION_JSON).header("X-FAIRE-ACCESS-TOKEN", FaireProcessorApplication.getApiKey()).put(Entity.entity(payload, "application/json;charset=UTF-8"));

		return response.readEntity(returnType);		
		
	}

	public R post(final String parameter, P payload){
		
		Client client = ClientBuilder.newClient();		 		
		
		WebTarget webTarget = client.target(FaireProcessorApplication.getBaseUrl() + parameter);

		Response response = webTarget.request(MediaType.APPLICATION_JSON).header("X-FAIRE-ACCESS-TOKEN", FaireProcessorApplication.getApiKey()).post(Entity.json(payload));
		
		return response.readEntity(returnType);
	
	}
}
