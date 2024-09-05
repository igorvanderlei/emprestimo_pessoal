package br.edu.ufape.pw.agiota.model;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Cliente extends Pessoa{
	private String profissao;
	private String localTrabalho;
	private String telefoneTrabalho;
	
	
}
