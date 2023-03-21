package me.dio.academia.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoServiceImpl service;

	@GetMapping
	public List<Aluno> getAll() {
		return service.getAll();
	}

	@GetMapping("/data-nascimento")
	public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNacimento) {
		return service.getAll(dataDeNacimento);
	}

	@GetMapping("/{id}")
	public Aluno getById(@PathVariable Long id) {
		return service.get(id);
	}

	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvaliacaoFisica(@PathVariable Long id) {
		return service.getAllAvaliacaoFisicaId(id);

	}

	@PostMapping
	public Aluno create(@RequestBody AlunoForm alunoForm) {
		return service.create(alunoForm);
	}

	@PutMapping("/atualizar/{id}")
	public Aluno atualizar(@PathVariable Long id, @RequestBody AlunoUpdateForm alunoUpdateForm) {
		return service.update(id, alunoUpdateForm);
	}

	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable Long id) {
		service.delete(id);
	}

}
