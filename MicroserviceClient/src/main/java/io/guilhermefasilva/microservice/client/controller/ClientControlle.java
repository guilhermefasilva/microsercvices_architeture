package io.guilhermefasilva.microservice.client.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.guilhermefasilva.microservice.client.ClientService;
import io.guilhermefasilva.microservice.client.dto.ClientDtoRequest;
import io.guilhermefasilva.microservice.client.dto.ClientDtoResponse;
import io.guilhermefasilva.microservice.client.dto.ClientDtoUpdate;

@RestController
@RequestMapping("/clients")
public class ClientControlle {
	
	@Autowired
	private ClientService clientService;

	
	@PostMapping
	public ResponseEntity<ClientDtoResponse> create(@RequestBody ClientDtoRequest clientRequest){
		ClientDtoResponse clientResponse = clientService.save(clientRequest);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(clientResponse.getId()).toUri();
		return ResponseEntity.created(uri).body(clientResponse);
	}
	
	@PutMapping
	public ResponseEntity<ClientDtoResponse> update(@PathVariable Long id, ClientDtoUpdate clientUpdate){
		ClientDtoResponse clientResponse = clientService.update(id, clientUpdate);
		return ResponseEntity.ok().body(clientResponse);
	}
	
	@GetMapping
	public ResponseEntity<List<ClientDtoResponse>> findAll(){
		List<ClientDtoResponse> clientResponse = clientService.findAll();
		return ResponseEntity.ok().body(clientResponse);
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@PathVariable Long id){
		this.clientService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	
	
	
}
