package de.fhkoeln.gm.wba2.phase2.rest_webservice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;

public class RestWebserviceMain {
	
	/**
	 * @author Jorge H. F. Pereira
	 */
	public static void main(String[] args) {

		final String baseUri = Config.hostname + ":" + Config.port + "/";
		final Map<String, String> initParams = new HashMap<String, String>();
		
		initParams.put("com.sun.jersey.config.property.packages", "de.fhkoeln.gm.wba2.phase2.rest_webservice.resources");
		
		System.out.println("Starting grizzly...");

		SelectorThread threadSelector;
		
		try {
			threadSelector = GrizzlyWebContainerFactory.create(baseUri, initParams);
			threadSelector.setKeepAliveTimeoutInSeconds(-1);
			
			System.out.println(String.format(
									"Jersey app started with WADL available at %sapplication.wadl\n" +
									"Hit enter to stop it...", baseUri, baseUri));
			
			System.in.read();
			threadSelector.stopEndpoint();

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		System.exit(0);
		
	}

}
