package br.edu.ufape.pw.agiota.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.pw.agiota.cadastro.InterfaceCadastroCliente;
import br.edu.ufape.pw.agiota.model.Cliente;

@Service
public class Fachada {
	@Autowired
	private InterfaceCadastroCliente cadastroCliente;

	public Cliente procurarClienteCpf(String cpf) {
		return cadastroCliente.procurarClienteCpf(cpf);
	}

	public Cliente adicionarCliente(Cliente entity) {
		return cadastroCliente.adicionarCliente(entity);
	}

	public Cliente atualizarCliente(Cliente entity) {
		return cadastroCliente.atualizarCliente(entity);
	}

	public Cliente carregarCliente(Long id) {
		return cadastroCliente.carregarCliente(id);
	}

	public List<Cliente> listarClientes() {
		return cadastroCliente.listarClientes();
	}

	public void removerCliente(Long id) {
		cadastroCliente.removerCliente(id);
	}
	
	
}
