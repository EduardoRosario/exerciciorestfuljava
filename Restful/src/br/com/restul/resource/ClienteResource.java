package br.com.restul.resource;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import br.com.restful.model.Cliente;
import br.com.restful.controller.ClienteController;

/**
*Classe responsável por conter os métodos REST de acesso ao webservice.
*
*@author Eduardo Rosario <esr9915@gmail.com>
*@since 18/07/2018
*@version 1.0
*/
@Path("/cliente")
public class ClienteResource {
	
	/**
	*Método responsável por fazer chamada ao controller.
	*
	*return ArrayList<Cliente>
	*@author Eduardo Rosario <esr9915@gmail.com>
	*@since 18/07/2018
	*@version 1.0
	*/
	@GET
	@Path("/listartodos")
	@Produces("application/json")
	public ArrayList<Cliente> listarTodos(){
		return new ClienteController().listarTodos();
	}
}
