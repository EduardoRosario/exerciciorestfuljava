package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.ClienteDAO;
import br.com.restful.model.Cliente;

public class ClienteController {
	
	/**
	*Método responsável por ser o controlador entre o resource e a camada DAO.
	*
	*@author Eduardo Rosario <esr9915@gmail.com>
	*@since 18/07/2018
	*@version 1.0
	*/
	
	public ArrayList<Cliente> listarTodos(){
		return ClienteDAO.getInstance().listarTodos();
	}
	
}
