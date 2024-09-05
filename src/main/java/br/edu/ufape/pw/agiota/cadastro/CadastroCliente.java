package br.edu.ufape.pw.agiota.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.pw.agiota.dados.RepositorioCliente;
import br.edu.ufape.pw.agiota.model.Cliente;

@Service
public class CadastroCliente implements InterfaceCadastroCliente {
	@Autowired
	private RepositorioCliente repositorioCliente;

	public Cliente procurarClienteCpf(String cpf) {
		return repositorioCliente.findByCpf(cpf);
	}

	public Cliente adicionarCliente(Cliente entity) {
		if(procurarClienteCpf(entity.getCpf()) == null)
			return repositorioCliente.save(entity);
		else
			throw new RegistroDuplicadoException("CPF ["+entity.getCpf()+"] já cadastrado." );
	}
	
	public Cliente atualizarCliente(Cliente entity) {
		Cliente cadastrado = procurarClienteCpf(entity.getCpf());
		if(cadastrado!=null && entity.getId() != cadastrado.getId())
			throw new RegistroDuplicadoException("CPF ["+entity.getCpf()+"] já cadastrado." );
		return repositorioCliente.save(entity);
	}
	
	public Cliente carregarCliente(Long id) {
		return repositorioCliente
					.findById(id)
					.orElseThrow(() -> new RegistroNaoEncontradoException("Cliente ["+id+"] não encontrado."));
	}

	public List<Cliente> listarClientes() {
		return repositorioCliente.findAll();
	}

	public void removerCliente(Long id) {
		repositorioCliente.deleteById(id);
	}
	
	
}
