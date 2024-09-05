package br.edu.ufape.pw.agiota.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.pw.agiota.fachada.Fachada;
import br.edu.ufape.pw.agiota.model.Cliente;


@RestController
public class ClienteController {
	@Autowired
	private Fachada fachada;
	
	@GetMapping("/cliente")
	@PreAuthorize("hasRole('ROLE_GERENTE')")
	List<Cliente> listarClientes() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Jwt principal = (Jwt) authentication.getPrincipal();
		System.out.println(principal.getClaimAsString("email"));
		System.out.println(principal.getSubject());
		return fachada.listarClientes();
	}
	
	@GetMapping("/public/cliente")
	List<Cliente> listarClientes2() {
		return fachada.listarClientes();
	}
	
	@GetMapping("/cliente/{id}")
	Cliente carregarCliente(@PathVariable Long id) {
		return fachada.carregarCliente(id);
	}
	
	@PostMapping("/cliente")
	Cliente salvarCliente(@RequestBody Cliente c) {
		return fachada.adicionarCliente(c);
	}

}
