package br.com.restful.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
*Classe responsável por conter os métodos de criar e fechar conexão com o banco de dados.
*
*@author Eduardo Rosario <esr9915@gmail.com>
*@since 18/07/2018
*@version 1.0
*/

public class ConnectionFactory {
 // Caminho do banco de dados.
	
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/webservice";
	private static final String USUARIO = "postgres";
	private static final String SENHA  = "********";
	
	/**
	* Método responsável por criar conexão com o banco de dados.
	*
	*@author Eduardo Rosario <esr9915@gmail.com>
	*@since 18/07/2018
	*@version 1.0
	*/
	
	public Connection criarConexao() {
		Connection conexao = null;
		
		try {
			
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
		}catch(Exception e) {
			System.out.println("Erro ao criar conexão com o banco: " + URL);
			e.printStackTrace();
		}
		
		return conexao;
	}
	
	public void fecharConexao(Connection conexao,PreparedStatement pstmt, ResultSet rs) {
		try {
			if(conexao != null) {
				conexao.close();				
			}
			if(pstmt != null) {
				pstmt.close();				
			}
			if(rs != null) {
				rs.close();				
			}
			}catch(Exception e) {
				System.out.println("Erro ao fechar conexão com o banco: " + URL);
			}		
		
	}
	
}
