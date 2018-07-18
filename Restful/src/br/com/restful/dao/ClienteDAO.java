package br.com.restful.dao;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
*Classe responsável por conter os métodos consulta, inserção, alteração e exclusão de dados.
*
*return ArrayList<Cliente> clientes
*@author Eduardo Rosario <esr9915@gmail.com>
*@since 18/07/2018
*@version 1.0
*/

public class ClienteDAO extends ConnectionFactory {
		
	private static ClienteDAO instance;
	
	/**
	*Método responsável por criar uma instância da classe ClienteDAO( Singleton ).
	*
	*@author Eduardo Rosario <esr9915@gmail.com>
	*@since 18/07/2018
	*@version 1.0
	*/
	
	public static ClienteDAO getInstance() {
		if(instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}
	
	/**
	*Método responsável por listar todos clientes do banco.
	*
	*@author Eduardo Rosario <esr9915@gmail.com>
	*@since 18/07/2018
	*@version 1.0
	*/
	
	public ArrayList<Cliente> listarTodos(){
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> clientes = null;
		
		conexao = criarConexao();
		clientes = new ArrayList<Cliente>();
		
		try {
			pstmt = conexao.prepareStatement("select * from cliente order by nome");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));
				
				clientes.add(cliente);
			}
			
		} catch(Exception e) {
			System.out.println("Erro ao tentar listar todos os clientes: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
	
		return clientes;
	}
	
	
}
