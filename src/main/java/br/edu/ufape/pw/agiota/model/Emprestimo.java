package br.edu.ufape.pw.agiota.model;

import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class Emprestimo {
	
	@ManyToOne
	private Cliente cliente;

}
