package com.scalefocus.edu.service;

import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scalefocus.edu.api.model.AddressAPI;
import com.scalefocus.edu.api.model.ClientAPI;
import com.scalefocus.edu.db.dao.AddressRepository;
import com.scalefocus.edu.db.dao.ClientRepository;
import com.scalefocus.edu.db.model.Address;
import com.scalefocus.edu.db.model.Client;

@Service
public class ClientStoreService {

	@Autowired
	private DozerBeanMapper mapper;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

	private Client APIToDB(ClientAPI clientAPI) {
		return mapper.map(clientAPI, Client.class);
	}

	public ClientAPI saveClient(ClientAPI clientAPI) {
		Client dbClient = APIToDB(clientAPI);
		dbClient = clientRepository.save(dbClient);
		return mapper.map(dbClient, ClientAPI.class);
	}

	public ClientAPI updateClient(String clientId, ClientAPI clientAPI) {
		Client dbClient = clientRepository.findOne(clientId);
		if (dbClient != null) {
			clientAPI.setClientId(clientId);
			
			for(Address address : dbClient.getAddresses()) {
				addressRepository.delete(address.getAddressId());
			}
/*
			List<Address> dbAddresses = dbClient.getAddresses();
			List<AddressAPI> apiAddresses = clientAPI.getAddresses();
			
			for(int i = 0; i < apiAddresses.size(); i++) {
				AddressAPI apiAddress = apiAddresses.get(i);
				
				int index = dbAddresses.indexOf(mapper.map(apiAddress, Address.class));
				if(index >= 0 ) {
					Address dbAddress = dbAddresses.get(index);
					apiAddress.setAddressId(dbAddress.getAddressId());
					apiAddresses.set(i, apiAddress);
				}
			}
			
			clientAPI.setAddresses(apiAddresses);

			for (int i = 0; i < dbAddresses.size(); i++) {
				Address dbAddress = dbAddresses.get(i);
				String addressId = dbAddress.getAddressId();
				dbAddress.setAddressId(null);
				int index = apiAddresses.indexOf(mapper.map(dbAddress, AddressAPI.class));
				if (index >= 0) {
					AddressAPI apiAddress = apiAddresses.get(index);
					apiAddress.setAddressId(addressId);
					apiAddresses.set(i, apiAddress);
				}
			}
			clientAPI.setAddresses(apiAddresses);*/
			dbClient = clientRepository.save(APIToDB(clientAPI));
		}

		return mapper.map(dbClient, ClientAPI.class);
	}

	public void deleteClientById(String clientId) {
		if (clientRepository.exists(clientId)) {
			clientRepository.delete(clientId);
		}
	}

	public ClientAPI getClientByIdOrEmail(String clientId, String email) {
		return mapper.map(clientRepository.getByClientIdOrEmail(clientId, email), ClientAPI.class);
	}

	public List<ClientAPI> findAllClients() {
		List<ClientAPI> clients = new ArrayList<ClientAPI>();
		Iterable<Client> dbClients = clientRepository.findAll();
		for (Client client : dbClients) {
			clients.add(mapper.map(client, ClientAPI.class));
		}
		return clients;
	}
}
