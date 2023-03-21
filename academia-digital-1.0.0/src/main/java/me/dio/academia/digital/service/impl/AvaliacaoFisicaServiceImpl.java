package me.dio.academia.digital.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService{
	
	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
	
	@Autowired 
	private AlunoRepository alunoRepository;

	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
		avaliacaoFisica.setAluno(aluno);
		avaliacaoFisica.setPeso(form.getPeso());
		avaliacaoFisica.setAltura(form.getAltura());
		return avaliacaoFisicaRepository.save(avaliacaoFisica);
	}

	@Override
	public AvaliacaoFisica get(Long id) {
		Optional<AvaliacaoFisica> avaliacao = avaliacaoFisicaRepository.findById(id);
		return avaliacao.get();
		
	}

	@Override
	public List<AvaliacaoFisica> getAll() {
		// TODO Auto-generated method stub
		return avaliacaoFisicaRepository.findAll();
	}

	@Override
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		Optional<AvaliacaoFisica> avaOptional = avaliacaoFisicaRepository.findById(id);
		AvaliacaoFisica avaliacao = new AvaliacaoFisica();
		avaliacao.setAltura(formUpdate.getAltura());
		avaliacao.setPeso(formUpdate.getPeso());
		avaliacao = avaliacaoFisicaRepository.save(avaliacao);
		return avaliacao;
	}

	@Override
	public void delete(Long id) {
		avaliacaoFisicaRepository.deleteById(id);
		
	}

}
