package com.scalefocus.edu.api.ws;

import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.scalefocus.edu.api.ClientStoreAPI;
import com.scalefocus.edu.api.model.ClientAPI;
import com.scalefocus.edu.db.model.Client;
import com.scalefocus.edu.service.ClientStoreService;

@Controller
@WebService
public class ClientStoreAPIWSImpl implements ClientStoreAPI {
	
	@Autowired
	private ClientStoreService clientStoreService;

	@Override
	public ClientAPI saveClient(ClientAPI client) {
		return clientStoreService.saveClient(client);
	}

	@Override
	public ClientAPI updateClient(String clientId, ClientAPI client) {
		return clientStoreService.updateClient(clientId, client);
	}

	@Override
	public void deleteClientById(String clientId) {
		clientStoreService.deleteClientById(clientId);	
	}

	@Override
	public ClientAPI getClientByIdOrEmail(String clientId) {
		return clientStoreService.getClientByIdOrEmail(clientId, clientId);
	}

	@Override
	public List<ClientAPI> findAllClients() {
		return clientStoreService.findAllClients();
	}
}
