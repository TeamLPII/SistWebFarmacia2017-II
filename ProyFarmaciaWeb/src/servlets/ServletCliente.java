package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.ClientesDTO;
import service.ClienteService;


@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteService serviCliente = new ClienteService();
  
    public ServletCliente() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xtipo = request.getParameter("tipo");
		if (xtipo.equals("listar")) {
			listar(request,response);
		} else if(xtipo.equals("buscar")){
			buscar(request,response);
		}else if(xtipo.equals("insertar")){
			insertar(request,response);
		}else if(xtipo.equals("actualizar")){
			actualizar(request,response);
		}else if(xtipo.equals("eliminar")){
			eliminar(request,response);
		}else if(xtipo.equals("buscarNombre")){
			listarPorNombre(request,response);
		}else if(xtipo.equalsIgnoreCase("buscarDNI")){
			buscarPorDNI(request,response);
		}
	}

	private void buscarPorDNI(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String dni = request.getParameter("dni");
		System.out.println("En el Servlet Buscar");
		System.out.println("El DNI: "+dni);
		ClientesDTO cliente = serviCliente.buscarPorDNI(dni);
		
		Gson gson = new Gson();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(cliente));
		
	}

	private void listarPorNombre(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("txtBuscar");
		request.setAttribute("dataCliente", serviCliente.buscarPorNombre(nombre));
		RequestDispatcher miDispatcher = request.getRequestDispatcher("clientes.jsp");
		try {
			miDispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		int cod = Integer.parseInt(request.getParameter("txteliminarId"));
		serviCliente.eliminaCliente(cod);
		listar(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		int cod=Integer.parseInt(request.getParameter("txtCodigo"));
		String nombre = request.getParameter("txtNombre");
		String apePater = request.getParameter("txtApePaterno");
		String apeMater = request.getParameter("txtApeMater");
		String DNI = request.getParameter("txtDNI");
		SimpleDateFormat formatoFecha= new SimpleDateFormat("yyyy-MM-dd");
		Date fecha=null;
		try {
			fecha = formatoFecha.parse(request.getParameter("txtFecRegistro"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sexo = request.getParameter("txtSexo");
		ClientesDTO tempCli = new ClientesDTO(cod,nombre,apePater,apeMater,DNI,fecha,sexo);
		serviCliente.actualizaCliente(tempCli);
		listar(request, response);
	}

	private void insertar(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("txtNombre");
		String apellido= request.getParameter("txtApe");
		String apePater =apellido.substring(0,apellido.indexOf(" "));
		String apeMater=apellido.substring(apellido.indexOf(" ")+1);
		System.out.println(apePater);
		System.out.println(" ");
		System.out.println(apeMater);
		String DNI = request.getParameter("txtDNI");
		SimpleDateFormat formatoFecha= new SimpleDateFormat("yyyy-MM-dd");
		Date fecha=null;
		try {
			fecha = formatoFecha.parse(request.getParameter("txtFecRegistro"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		String sexo = request.getParameter("cboSexo");	
		ClientesDTO tempCli = new ClientesDTO(nombre,apePater,apeMater,DNI,fecha,sexo);
		serviCliente.insertaCliente(tempCli);
		listar(request, response);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("objCli", serviCliente.buscaCliente(cod));
	
		RequestDispatcher miDispatcher = request.getRequestDispatcher("");
		try {
			miDispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("dataCliente", serviCliente.listaCliente());
		RequestDispatcher miDispatcher = request.getRequestDispatcher("clientes.jsp");
		try {
			miDispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
