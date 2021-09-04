package io.guilhermefasilva.microservice.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDtoUpdate {
	
	private String nome;
	private String sobreNome;

}
