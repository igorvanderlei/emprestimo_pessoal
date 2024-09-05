package br.edu.ufape.pw.agiota.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	

}
