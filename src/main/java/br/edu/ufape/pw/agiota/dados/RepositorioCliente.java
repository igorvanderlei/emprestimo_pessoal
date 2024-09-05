package br.edu.ufape.pw.agiota.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufape.pw.agiota.model.Cliente;

public interface RepositorioCliente extends JpaRepository<Cliente, Long> {
	public Cliente findByCpf(String cpf);
}
