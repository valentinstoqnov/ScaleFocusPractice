package com.scalefocus.edu.api.rs;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scalefocus.edu.api.ClientStoreAPI;
import com.scalefocus.edu.api.model.ClientAPI;
import com.scalefocus.edu.db.model.Client;
import com.scalefocus.edu.service.ClientStoreService;

@Produces("application/json")
@Consumes({"application/json"})
@Path("/rs")
@Controller
public class ClientStoreAPIRSImpl implements ClientStoreAPI {
	
	@Autowired
	private ClientStoreService clientStoreService;
	
	ObjectMapper mapper = new ObjectMapper();
	
	/*@GET
	@Path("/hi")
	public String sayHi() {
		return clientStoreService.sayHi();
	}*/
	
	@POST
	@Path("/clients")
	@Consumes("application/json")
	@Produces("application/json")
	@Override
	public ClientAPI saveClient(ClientAPI client) {
		return clientStoreService.saveClient(client);
	}
	
	@PUT
	@Path("/clients/{clientId}")
	@Consumes("application/json")
	@Produces("application/json")
	@Override
	public ClientAPI updateClient(@PathParam("clientId") String clientId, ClientAPI client) {
		return clientStoreService.updateClient(clientId, client);
	}
	
	@DELETE
	@Path("/clients/{clientId}")
	@Override
	public void deleteClientById(@PathParam("clientId") String clientId) {
		clientStoreService.deleteClientById(clientId); 
	}

	@GET
	@Path("/clients/{param}")
	@Produces("application/json")
	@Override
	public ClientAPI getClientByIdOrEmail(@PathParam("param") String clientId, 
			@PathParam("param") String email) {
		return clientStoreService.getClientByIdOrEmail(clientId, email);
	}

	@GET
	@Path("/clients")
	@Produces("application/json")
	@Override
	public List<ClientAPI> findAllClients() {
		return clientStoreService.findAllClients();
	}
}