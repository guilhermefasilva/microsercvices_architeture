package io.guilhermefasilva.microservice.adress.dto;

import lombok.Data;

@Data
public class EnderecoDtoResponse {
	
	private Long id;
	private String logradouro;
	private int numero;
	private Long cep;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;

}
