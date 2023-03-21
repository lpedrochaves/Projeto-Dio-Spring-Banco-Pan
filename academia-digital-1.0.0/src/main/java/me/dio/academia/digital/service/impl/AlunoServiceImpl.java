package me.dio.academia.digital.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public Aluno create(AlunoForm form) {
		Aluno aluno = new Aluno();
		aluno.setNome(form.getNome());
		aluno.setCpf(form.getCpf());
		aluno.setBairro(form.getBairro());
		aluno.setDataDeNascimento(form.getDataDeNascimento());
		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno get(Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.get();
	}

	@Override
	public List<Aluno> getAll() {
		return alunoRepository.findAll();
	}

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		Aluno alunoUpdate = new Aluno();
		alunoUpdate.setNome(formUpdate.getNome());
		alunoUpdate.setCpf(aluno.get().getCpf());
		alunoUpdate.setBairro(formUpdate.getBairro());
		alunoUpdate.setDataDeNascimento(formUpdate.getDataDeNascimento());
		alunoUpdate = alunoRepository.save(alunoUpdate);
		return alunoUpdate;
	}

	@Override
	public void delete(Long id) {
		alunoRepository.deleteById(id);

	}

	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
		Aluno aluno = alunoRepository.findById(id).get();
		return aluno.getAvaliacoes();
	}
	
	public List<Aluno> getAll(String dataDeNascimento) {

	    if(dataDeNascimento == null) {
	      return alunoRepository.findAll();
	    } else {
	      LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
	      return alunoRepository.findByDataDeNascimento(localDate);
	    }

	  }

}
