package comunicacion;

import java.io.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.BDUsuario;
import modelo.Usuario;

public class ListaCorreosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListaCorreosServlet() {
		
	}
	
	//Método GET
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	//Método POST
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
	
}

