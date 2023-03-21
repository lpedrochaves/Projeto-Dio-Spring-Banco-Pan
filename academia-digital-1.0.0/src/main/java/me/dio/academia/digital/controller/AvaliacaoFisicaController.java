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
import org.springframework.web.bind.annotation.RestController;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {
	
	@Autowired
	private AvaliacaoFisicaServiceImpl service;
	
	@GetMapping
	public List<AvaliacaoFisica> getAll() {
		return service.getAll();
	}
	
	@PostMapping 
	public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm avaliacaoFisicaForm) {
		return service.create(avaliacaoFisicaForm);
	}
	
	@GetMapping("/{id}")
	public AvaliacaoFisica getById(@PathVariable Long id) {
		return service.get(id);
	}
	@PutMapping("/atualizar/{id}")
	public AvaliacaoFisica atualizar(@PathVariable Long id, @RequestBody AvaliacaoFisicaUpdateForm formUpdate) {
		return service.update(id, formUpdate);
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable Long id) {
		service.delete(id);
	}
}
