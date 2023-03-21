package me.dio.academia.digital.entity.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class MatriculaForm {
	@NotBlank(message = "Preencha o campo corretamente.")
	@Positive(message = "O Id do aluno precisa ser positivo.")
	private Long alunoId;

	public MatriculaForm() {
		super();
	}

	public MatriculaForm(Long alunoId) {
		super();
		this.alunoId = alunoId;
	}

	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

}
