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
	
	//Método GET
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	//Método POST
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String accion = request.getParameter("action");
		
		if (accion == null) {	
			response.setContentType("text/html");		
			
			
			PrintWriter writer = response.getWriter();	
			//tabla
			writer.println("<h1>Listado de usuarios</h1>");
			writer.println("<table>");
			writer.println("<thead>");
			writer.println("<tr><th>Nombre</th><th>Apellidos</th><th>Email</th>");
			writer.println("</tr>");
			writer.println("</thead>");
			writer.println("<tbody>");
			for (Usuario user: BDUsuario.listarUsuarios()) {
				writer.println("<tr><td>" + user.getNombre() + "</td>");
				writer.println("<td>" + user.getApellido() + "</td>");
				writer.println("<td>" + user.getEmail() + "</td>");
				writer.println("</tr>");
			}
			writer.println("</tbody>");
			writer.println("</table>");
		} else {	
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String email = request.getParameter("email");
			
			ObjectOutputStream oos = new ObjectOutputStream(response.getOutputStream()); // obtiene ObjectOutputStream donde se informará del resultado
			
			switch (accion) {
			case "aniadirUsuario":
				if (BDUsuario.existeEmail(email)) {
					oos.writeInt(1);
					oos.writeObject("Existe un usuario registrado con ese email.");
				} else {
					Usuario usuario = new Usuario();
					usuario.setNombre(nombre);
					usuario.setApellido(apellido);
					usuario.setEmail(email);
					BDUsuario.insertar(usuario);
					oos.writeInt(0);
					oos.writeObject("Ha insertado bien el usuario.");
				}
				break;
			case "eliminarUsuario":
				if (!BDUsuario.existeEmail(email)) {
					oos.writeInt(1);
					oos.writeObject("No existe el usuario.");
				} else {
					Usuario usuario = BDUsuario.seleccionarUsuario(email);
					BDUsuario.eliminar(usuario);
					oos.writeInt(0);
					oos.writeObject("Eliminado correctamente.");
				}
				break;
			case "listarUsuarios":
				List<Usuario> usuarios = BDUsuario.listarUsuarios();
	  			oos.writeObject(usuarios);
	  			break;
			case "actualizarUsuario":
				if (!BDUsuario.existeEmail(email)) {
					oos.writeInt(1);
					oos.writeObject("No existe ese email.");
				} else {
					Usuario usuario = BDUsuario.seleccionarUsuario(email);
					usuario.setNombre(nombre);
					usuario.setApellido(apellido);
					BDUsuario.actualizar(usuario);
					oos.writeInt(0);
					oos.writeObject("Actualizado correctamente.");					
				}
				break;	  			
			}			
			oos.flush();
			oos.close();
		} 		
	}	
}

