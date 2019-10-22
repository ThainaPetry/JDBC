package br.com.thaina;

public class Main {

	public static void main(String[] args) {
		UsuarioDAO usudao = new UsuarioDAO();
		TarefaDAO tardao = new TarefaDAO();
		
		
		Usuario usuario1 = new Usuario();
		usuario1.setNome("Lowgan");
		usuario1.setSobrenome("Luan Flores");
		usuario1.setEmail("lowgan.flores@univille.com");		

		usudao.Insert(usuario1);
		
		Usuario usuarioEmail = tardao.getByEmailUsuario("lowgan.flores@univille.com");
		
		usuario1.setId(usuarioEmail.getId());
		System.out.println("\n      Tabela de Usuários");
		System.out.println(" _____________________");
		System.out.println("|"+"      Usuários       "+"|");
		System.out.println("|_____________________|");
		for(Usuario usuario : usudao.getAll()) {
		
			System.out.println("  " + usuario.getNome() + " " + usuario.getSobrenome());
		}
		System.out.println("|_____________________|");
		
		
		
		Tarefa tarefa1 = new Tarefa();
		tarefa1.setNomeTarefa("Desenvolver ponto");
		tarefa1.setPrioridade(3);
		tarefa1.setTarefaStatus("Hold");	
		tardao.insert(tarefa1, usuario1);
		System.out.println("\n\n                 Tabela de Tarefas");
			System.out.println(" _________________________________________________________");
			System.out.println("|" + "Id" + "|" + "     Tarefa      "+ "|"+"Prioridade"+"|"+"Status"+"|"+"      Usuário     "+"|");
		for(Tarefa tarefa : tardao.getAllByUser(1)) {
			System.out.println("|" + tarefa.getId() + " |" + tarefa.getNomeTarefa() + "|    " + tarefa.getPrioridade() + "     | " + tarefa.getTarefaStatus() + " |"  + tarefa.getUsuario() + "|");
		}
		System.out.println("|_________________________________________________________|");
		
		
		

		Tarefa tarefa2 = new Tarefa();
		tarefa2.setNomeTarefa("Desenvolver ponto");
		tarefa2.setPrioridade(3);
		tarefa2.setTarefaStatus("Em andamento");	
		tarefa2.setId(1);
		tardao.update(tarefa2,usuario1);
		
		
		System.out.println("\n\n                 Tabela de Tarefas apos o Update");
		System.out.println(" _________________________________________________________");
		System.out.println("|" + "Id" + "|" + "     Tarefa      "+ "|"+"Prioridade"+"|"+"Status"+" |"+"      Usuário     "+"|");
	for(Tarefa tarefa : tardao.getAllByUser(1)) {
		System.out.println("|" + tarefa.getId() + " |" + tarefa.getNomeTarefa() + "|    " + tarefa.getPrioridade() + "     | " + tarefa.getTarefaStatus() + "  |"  + tarefa.getUsuario() + "|");
	}
	System.out.println("|_________________________________________________________|");
		
		
		tardao.delete(1);
		
		System.out.println("\n\n                 Tabela de Tarefas apos o Delete");
		System.out.println(" _________________________________________________________");
		System.out.println("|" + "Id" + "|" + "     Tarefa      "+ "|"+"Prioridade"+"|"+"Status"+"|"+"      Usuário     "+"|");
	for(Tarefa tarefa : tardao.getAllByUser(1)) {
		System.out.println("|" + tarefa.getId() + " |" + tarefa.getNomeTarefa() + "|    " + tarefa.getPrioridade() + "     | " + tarefa.getTarefaStatus() + " |"  + tarefa.getUsuario() + "|");
	}
	System.out.println("|_________________________________________________________|");
	
	
	
	
	
	
	
	}
	
	
}
