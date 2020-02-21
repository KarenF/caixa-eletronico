package br.com.compasso.caixaeletronico.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.caixaeletronico.dto.UsuarioDTO;
import br.com.compasso.caixaeletronico.entity.Usuario;
import br.com.compasso.caixaeletronico.response.Response;
import br.com.compasso.caixaeletronico.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping
	ResponseEntity<Response<UsuarioDTO>> create(@Valid @RequestBody UsuarioDTO dto, BindingResult result) {
		Response<UsuarioDTO> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		Usuario usuario = service.save(this.convertDtoToEntity(dto));
		response.setData(this.convertEntityToDto(usuario));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<Response<List<UsuarioDTO>>> findUser(@RequestParam(required = false) Usuario usuario) {

		Response<List<UsuarioDTO>> response = new Response<List<UsuarioDTO>>();
		List<Usuario> list = service.list();

		List<UsuarioDTO> dto = new ArrayList<>();
		list.forEach(i -> dto.add(this.convertEntityToDto(i)));
		response.setData(dto);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> detalhar(@PathVariable Long id) {
		Optional<Usuario> usuario = service.findById(id);
		if (usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		Optional<Usuario> usuario = service.findById(id);
		if (usuario.isPresent()) {
			service.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	private Usuario convertDtoToEntity(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setId(dto.getId());
		usuario.setNome(dto.getNome());
		usuario.setValor(dto.getValor());
		return usuario;
	}

	private UsuarioDTO convertEntityToDto(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(usuario.getId());
		dto.setNome(usuario.getNome());
		dto.setValor(usuario.getValor());
		return dto;
	}

}
