package com.scalefocus.edu.api;

import java.util.List;

import com.scalefocus.edu.api.model.ClientAPI;
import com.scalefocus.edu.db.model.Client;

public interface ClientStoreAPI {
	public ClientAPI saveClient(ClientAPI client);
	public ClientAPI updateClient(String clientId, ClientAPI client);
	public void deleteClientById(String clientId);
	public ClientAPI getClientByIdOrEmail(String clientId);
	public List<ClientAPI> findAllClients();
}
