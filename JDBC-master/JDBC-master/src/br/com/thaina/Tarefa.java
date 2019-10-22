package br.com.thaina;



public class Tarefa {
	
	private int id_tar;
	private String nomeTarefa;
	private String tarefaStatus;
	private int prioridade;
	private String usuario;
	
	
	public int getId() {
		return id_tar;
	}
	public void setId(int id) {
		this.id_tar = id;
	}
	public String getNomeTarefa() {
		return nomeTarefa;
	}
	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public String getTarefaStatus() {
		return tarefaStatus;
	}
	public void setTarefaStatus(String tarefaStatus) {
		this.tarefaStatus = tarefaStatus;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
