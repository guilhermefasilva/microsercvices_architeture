package io.guilhermefasilva.microservice.client;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.guilhermefasilva.microservice.client.dto.ClientDtoRequest;
import io.guilhermefasilva.microservice.client.dto.ClientDtoResponse;
import io.guilhermefasilva.microservice.client.dto.ClientDtoUpdate;
import io.guilhermefasilva.microservice.client.model.Client;
import io.guilhermefasilva.microservice.client.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ClientRepository clientRepository;

	
	
	public ClientDtoResponse save(ClientDtoRequest clientRequest) {
		Client client = modelMapper.map(clientRequest, Client.class);
		clientRepository.save(client);
		return modelMapper.map(client, ClientDtoResponse.class);
	}
	
	public List<ClientDtoResponse> findAll() {
		List<Client> client = clientRepository.findAll();
		return client.stream()
				.map(c-> modelMapper.map(c, ClientDtoResponse.class))
				.collect(Collectors.toList());
	}
	
	public ClientDtoResponse update(Long id, ClientDtoUpdate clientUpdate) {
		Client client = clientRepository.findById(id).orElseThrow(()-> new RuntimeException("Id não encontrado"));
		client.setNome(clientUpdate.getNome());
		client.setSobreNome(clientUpdate.getSobreNome());
		clientRepository.save(client);
		return modelMapper.map(client, ClientDtoResponse.class);
	}
	
	public void delete(Long id) {
		Client client = clientRepository.findById(id).orElseThrow(()-> new RuntimeException("Id não encontrado"));
		this.clientRepository.delete(client);
	}
	
	
}
