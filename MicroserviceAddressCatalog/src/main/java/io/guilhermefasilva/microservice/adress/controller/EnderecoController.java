package io.guilhermefasilva.microservice.adress.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.guilhermefasilva.microservice.adress.dto.EnderecoDtoRequest;
import io.guilhermefasilva.microservice.adress.dto.EnderecoDtoResponse;
import io.guilhermefasilva.microservice.adress.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	
	@Autowired
	private EnderecoService enderecoService;

	@PostMapping
	public ResponseEntity<EnderecoDtoResponse> save(@RequestBody EnderecoDtoRequest enderecoRequest){
		EnderecoDtoResponse enderecoResponse = enderecoService.save(enderecoRequest);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(enderecoResponse.getId()).toUri();
		return ResponseEntity.created(uri).body(enderecoResponse);
	}
	
	@GetMapping
	public ResponseEntity<List<EnderecoDtoResponse>> getAll(){
		List<EnderecoDtoResponse> endereco = enderecoService.findAll();
		return ResponseEntity.ok().body(endereco);
	}
	@PutMapping("/{id}")
	public ResponseEntity<EnderecoDtoResponse> update(Long id, EnderecoDtoRequest enderrcoRequest){
		EnderecoDtoResponse enderecoResponse = enderecoService.update(id, enderrcoRequest);
		return ResponseEntity.ok().body(enderecoResponse);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(Long id){
		this.enderecoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
