package me.dio.academia.digital.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "matriculas")
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_matricula")
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;

	private LocalDateTime dataDaMatricula = LocalDateTime.now();

	public Matricula(Long id, Aluno aluno, LocalDateTime dataDaMatricula) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.dataDaMatricula = dataDaMatricula;
	}

	public Matricula() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public LocalDateTime getDataDaMatricula() {
		return dataDaMatricula;
	}

	public void setDataDaMatricula(LocalDateTime dataDaMatricula) {
		this.dataDaMatricula = dataDaMatricula;
	}

}
