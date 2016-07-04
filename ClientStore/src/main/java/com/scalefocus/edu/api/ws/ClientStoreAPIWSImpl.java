package com.scalefocus.edu.api.ws;

import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.scalefocus.edu.api.ClientStoreAPI;
import com.scalefocus.edu.service.ClientStoreService;

@Controller
@WebService
public class ClientStoreAPIWSImpl implements ClientStoreAPI {
	
	@Autowired
	private ClientStoreService clientStoreService;

	public String sayHi() {
		return clientStoreService.sayHi();
	}

}
