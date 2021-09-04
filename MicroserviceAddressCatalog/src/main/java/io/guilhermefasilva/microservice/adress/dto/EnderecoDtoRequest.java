package io.guilhermefasilva.microservice.adress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDtoRequest {
	
	private String logradouro;
	private int numero;
	private Long cep;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;

}
