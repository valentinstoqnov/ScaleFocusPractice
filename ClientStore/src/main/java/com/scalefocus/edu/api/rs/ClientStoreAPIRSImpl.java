package com.scalefocus.edu.api.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.scalefocus.edu.api.ClientStoreAPI;
import com.scalefocus.edu.service.ClientStoreService;

@Produces("application/json")
@Consumes({"application/json"})
@Path("/rs")
@Controller
public class ClientStoreAPIRSImpl implements ClientStoreAPI {
	
	@Autowired
	private ClientStoreService clientStoreService;

	@GET
	@Path("/hi")
	public String sayHi() {
		return clientStoreService.sayHi();
	}

}
