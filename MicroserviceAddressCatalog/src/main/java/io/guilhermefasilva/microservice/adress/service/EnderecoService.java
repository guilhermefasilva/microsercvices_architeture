package io.guilhermefasilva.microservice.adress.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.guilhermefasilva.microservice.adress.dto.EnderecoDtoRequest;
import io.guilhermefasilva.microservice.adress.dto.EnderecoDtoResponse;
import io.guilhermefasilva.microservice.adress.models.Endereco;
import io.guilhermefasilva.microservice.adress.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public EnderecoDtoResponse save(EnderecoDtoRequest enderecoRequest){
		Endereco endereco = modelMapper.map(enderecoRequest, Endereco.class);
		enderecoRepository.save(endereco);
		return modelMapper.map(endereco, EnderecoDtoResponse.class);
	}
	
	
	public EnderecoDtoResponse update(Long id, EnderecoDtoRequest enderecoRequest) {
		Endereco endereco = enderecoRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Id não encontrado"));
		endereco = modelMapper.map(enderecoRequest, Endereco.class);
		this.enderecoRepository.save(endereco);
		return modelMapper.map(endereco, EnderecoDtoResponse.class);
				
	}
	
	public List<EnderecoDtoResponse> findAll(){
		List<Endereco> endereco = enderecoRepository.findAll();
			return endereco.stream()
					.map(e -> modelMapper.map(e, EnderecoDtoResponse.class))
					.collect(Collectors.toList());
	}
	
	public void delete(Long id) {
		Endereco endereco = enderecoRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Id não encontrado"));
		this.enderecoRepository.delete(endereco);
				
	}
	

}
