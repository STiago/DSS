package comunicacion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.BDUsuario;
import modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ListaCorreosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String EXPR_REG_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	//Método GET
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }
	
	//Método POST
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {	
			String accion = request.getParameter("action");
			
			if (accion == null) {	
				
				response.setContentType("text/html");		
							
				PrintWriter writer = response.getWriter();	
				//Tabla
				writer.println("<h1>Listado de usuarios</h1>");
				writer.println("<table>");
				writer.println("<tr><th> Nombre </th><th> Apellidos </th><th> Email </th>");
				writer.println("</tr>");
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
				
				ObjectOutputStream oos = new ObjectOutputStream(response.getOutputStream()); 
				//hacerlo aqui para no tener que repetirlo dentro de cada opción del switch
				String nombre = request.getParameter("nombre");
				String apellido = request.getParameter("apellido");
				String email = request.getParameter("email");
							
				//Menu de acciones posibles a realizar
				switch (accion) {
				case "aniadirUsuario":
					//final Pattern pat = Pattern.compile(EXPR_REG_EMAIL);
					
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
		   catch(Exception e) {
				response.setContentType("text/html");
				PrintWriter miwriter = response.getWriter();
				miwriter.println("<h1>" + "Listado de usuarios" + "</h1>");
				miwriter.println("<table>");
				miwriter.println("<thead>");
				miwriter.println("<tr><th> Nombre </th><th> Apellidos </th><th> Email </th>");
				miwriter.println("</tr>");
				miwriter.println("</thead>");
				miwriter.println("<tbody>");
				if (BDUsuario.listarUsuarios() != null){
					for(Usuario user : BDUsuario.listarUsuarios()) {	
						miwriter.println("<tr><td>" + user.getNombre() + "</td>");
						miwriter.println("<td>" + user.getApellido() + "</td>");
						miwriter.println("<td>" + user.getEmail() + "</td></tr>");
					}
				}
				miwriter.println("</table>");
			}
		}
}

