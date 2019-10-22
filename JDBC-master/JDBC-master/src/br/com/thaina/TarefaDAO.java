package br.com.thaina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TarefaDAO extends BaseDAO{
	

	
	public void insert(Tarefa tarefa,  Usuario user) {

		String sql = " insert into tarefa(Nome_tarefa, Tarefa_status, nivel_prioridade, FK_usuario) "
				+ "values(?,?,?,?)";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setString(1, tarefa.getNomeTarefa() );
			statement.setString(2, tarefa.getTarefaStatus());
			statement.setInt(3, tarefa.getPrioridade());
			statement.setInt(4, user.getId());
			
			
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void delete(int tarefa) {
		
		
		
		String sql = " delete from tarefa  where id_tar = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, tarefa);
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void update(Tarefa tarefa, Usuario user) {
		String sql = "update Tarefa set Nome_tarefa = ?, FK_usuario = (select id_usu from usuario where"
				+ " Nome = ? and Sobrenome = ?), Tarefa_status = ? where id_tar = ?";
		try {
			try (Connection conn = getConnection();
					PreparedStatement p = conn.prepareStatement(sql)){
				p.setString(1, tarefa.getNomeTarefa());
				p.setString(2, user.getNome());
				p.setString(3, user.getSobrenome());
				p.setString(4, tarefa.getTarefaStatus());
				p.setInt(5, tarefa.getId());
				
				p.execute();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public Tarefa getById(int idtar) {
		String sql = "select tarefa.id_tar, tarefa.Nome_tarefa, tarefa.tarefa_status,"
				+ "tarefa.nivel_prioridade "
				+ "concat(usuario.Nome, concat(' ', usuario.Sobrenome)) as Usuario "
				+ "from tarefa "
				+ "inner join usuario"
				+ "on tarefa.FK_usuario = usuario.id_usu "
				+ "where tarefa.id_tar = ?";		
		Tarefa tarefa = null;
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, idtar);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				tarefa = new Tarefa();
				tarefa.setId(resultSet.getInt(1));
				tarefa.setNomeTarefa(resultSet.getString(2));
				tarefa.setTarefaStatus(resultSet.getString(3));
				tarefa.setPrioridade(resultSet.getInt(4));
				tarefa.setUsuario(resultSet.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tarefa;
	}
	

	public List<Tarefa> getAllByUser(int userId){
		List<Tarefa> list = new ArrayList<>();
		String sql = "select tar.id_tar, tar.Nome_tarefa, tar.tarefa_status,"
				+ "tar.nivel_prioridade, "
				+ "concat(usu.Nome, concat(' ', usu.Sobrenome)) as Usuario "
				+ "from Tarefa as tar "
				+ "inner join Usuario as usu "
				+ "on tar.FK_usuario = usu.Id_usu "
				+ "where tar.FK_usuario = ?";	
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(resultSet.getInt(1));
				tarefa.setNomeTarefa(resultSet.getString(2));
				tarefa.setTarefaStatus(resultSet.getString(3));
				tarefa.setPrioridade(resultSet.getInt(4));
				tarefa.setUsuario(resultSet.getString(5));
				list.add(tarefa);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	public Usuario getByEmailUsuario(String email ) {
		String sql = "Select Id_usu, nome, sobrenome, email "
				+ "from Usuario "
				+ "where email = ? ";
		Usuario usuario = null;
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				usuario = new Usuario();
				usuario.setId(resultSet.getInt(1));	
				usuario.setNome(resultSet.getString(2));
				usuario.setSobrenome(resultSet.getString(3));
				usuario.setEmail(resultSet.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	
}
