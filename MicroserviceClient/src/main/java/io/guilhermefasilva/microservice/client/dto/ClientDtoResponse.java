package io.guilhermefasilva.microservice.client.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDtoResponse {
	
	private Long id;
	private String nome;
	private String sobreNome;
	private String cpf;
	private String sexo;
	private Date dataNascimento;

}
