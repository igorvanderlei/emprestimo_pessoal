package br.edu.ufape.pw.agiota.cadastro;

import java.util.List;

import br.edu.ufape.pw.agiota.model.Cliente;

public interface InterfaceCadastroCliente {

	Cliente procurarClienteCpf(String cpf);

	Cliente adicionarCliente(Cliente entity);

	Cliente atualizarCliente(Cliente entity);

	Cliente carregarCliente(Long id);

	List<Cliente> listarClientes();

	void removerCliente(Long id);

}