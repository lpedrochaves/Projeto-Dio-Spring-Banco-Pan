package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

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
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private MatriculaServiceImpl service;

	@GetMapping
	public List<Matricula> getAll() {
		return service.getAll();
	}

	@GetMapping("/bairro")
	public List<Matricula> getAllBairro(@RequestParam(value = "bairro", required = false) String bairro) {
		return service.getAllBairro(bairro);
	}

	@GetMapping("/{id}")
	public Matricula getById(@PathVariable Long id) {
		return service.get(id);
	}

	@PostMapping
	public Matricula create(@Valid @RequestBody MatriculaForm form) {
		return service.create(form);
	}
	
	
	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable Long id) {
		service.delete(id);
	}
}
