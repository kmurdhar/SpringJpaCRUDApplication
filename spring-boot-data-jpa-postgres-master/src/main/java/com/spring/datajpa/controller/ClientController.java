package com.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.datajpa.model.Client;
import com.spring.datajpa.repository.ClientRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ClientController {

	@Autowired
	ClientRepository clientRepository;

	@PostMapping("/CreateClient")
	public ResponseEntity<Client> CreateClient(@RequestBody Client client) {
		try {

			// condition to validate Client_id
			if (validateID(client.getClientId())) {
				Client clientCreated = clientRepository.save(client);
				return new ResponseEntity<>(clientCreated, HttpStatus.CREATED);
			} else {
				return new ResponseEntity("Client_id is already available ", HttpStatus.IM_USED);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * get All clients
	 * 
	 * @param firstName
	 * @return
	 */

	@GetMapping("/clients")
	public ResponseEntity<List<Client>> getAllClients(@RequestParam(required = false) String firstName) {
		try {
			List<Client> clients = new ArrayList<Client>();

			if (firstName == null)
				clientRepository.findAll().forEach(clients::add);
			else
				clientRepository.findByFirstName(firstName).forEach(clients::add);

			if (clients.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(clients, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Find by clientId
	 * 
	 * @param client_id
	 * @return
	 */
	@GetMapping("/clients/client_id/{client_id}")
	public ResponseEntity<Client> getClientsById(@PathVariable("client_id") Integer client_id) {
		Optional<Client> clientData = Optional.of(clientRepository.findByClientId(client_id));

		if (clientData.isPresent()) {
			return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Find by Id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/clients/id/{id}")
	public ResponseEntity<Client> getClientsById(@PathVariable("id") long id) {
		Optional<Client> clientData = clientRepository.findById(id);

		if (clientData.isPresent()) {
			return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") long id, @RequestBody Client client) {
		Optional<Client> clientData = clientRepository.findById(id);

		if (clientData.isPresent() && validateMobileNo(client.getMobileNumber()) && validateID(client.getClientId())) {

			Client clientRecord = clientData.get();
			// validateID(null)
			clientRecord.setFirstName(client.getFirstName());
			clientRecord.setClientId(client.getClientId());
			clientRecord.setLastName(client.getLastName());
			clientRecord.setMobileNumber(client.getMobileNumber());
			clientRecord.setPhysicalAddress(client.getPhysicalAddress());
			return new ResponseEntity<>(clientRepository.save(clientRecord), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * client_id should be of 6 digit
	 * 
	 * @param client_id
	 */
	private boolean validateID(Integer client_id) {
		boolean isValid = false;
		if (clientRepository.findByClientId(client_id) == null && client_id < 999999) {
			isValid = true;
		}

		return isValid;

	}

	/**
	 * mobileNumber
	 * 
	 * @param client_id
	 */
	private boolean validateMobileNo(long mobNo) {
		boolean isValid = false;
		if (clientRepository.findByMobileNumber(mobNo) == null) {
			isValid = true;
		}

		return isValid;

	}

}
