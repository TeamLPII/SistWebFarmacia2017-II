package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthScrollPaneUI;

import com.google.gson.Gson;

import beans.CargoDTO;
import beans.EmpleadoDTO;
import service.CargoService;
import service.EmpleadoService;

/**
 * Servlet implementation class ServletEmpleado
 */
@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmpleadoService servEmp = new EmpleadoService();
	CargoService servCargo = new CargoService();
       
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String xtipo = request.getParameter("tipo");
    	if(xtipo.equals("login"))
    		iniciarSesion(request, response);
    	else if(xtipo.equals("cerrarSesion"))
    		cerrarSesion(request,response);
    	else if(xtipo.equals("listar"))
    		listarEmpleados(request, response);
    	else if(xtipo.equals("buscar"))
    		buscarEmpleado(request, response);
    	else if(xtipo.equals("actualizar"))
    		actualizarEmpleado(request, response);
    	else if(xtipo.equals("registrar"))
    		registrarEmpleado(request, response);
    	else if(xtipo.equals("eliminar"))
    		eliminarEmpleado(request, response);
    	else if(xtipo.equalsIgnoreCase("listarCargo")){
    		listarCargo(request, response);
    	}else if(xtipo.equalsIgnoreCase("filtrar")){
    		filtrarEmpleado(request, response);
    	}else if(xtipo.equalsIgnoreCase("actualizarUser")){
    		actualizarUsuario(request, response);
    	}else if(xtipo.equalsIgnoreCase("buscaruser")){
    		buscarUsuario(request, response);
    	}
		
	}

	private void buscarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		EmpleadoDTO obj = servEmp.buscarEmpleado(cod);
		if(obj != null){
			request.setAttribute("empleado", obj);			
			request.getRequestDispatcher("usuarioemp.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "Error al buscar.");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dentro del servlet actualizarUsuario");
		//response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int cod;
		String nombre, apPaterno, apMaterno;
		String fecNacimiento, fecIngreso;
		String usuario, clave;
		CargoDTO cargo;
		String telefono;
		
		/*System.out.println(""+request.getParameter("txtusercod"));
		System.out.println(""+request.getParameter("txtusernomb"));
		System.out.println(""+request.getParameter("txtuserappat"));*/
		
		cod = Integer.parseInt(request.getParameter("txtusercod"));
		nombre = request.getParameter("txtusernomb");
		apPaterno = request.getParameter("txtuserappat");
		apMaterno = request.getParameter("txtuserapmat");
		fecNacimiento = request.getParameter("txtuserfecnac");
		fecIngreso = request.getParameter("txtuserfecing");
		usuario = request.getParameter("txtuserusuario");
		clave = request.getParameter("txtuserclave");
		cargo = servCargo.buscarCargo(Integer.parseInt(request.getParameter("txtuseridcargo")));
		telefono = request.getParameter("txtusertelefono");
		
		//CargoDTO objCargo = servCargo.buscarCargo(cod)
		
		/*System.out.println("Fecha Nac::"+fecNacimiento);
		System.out.println("Fecha Ingreso:"+fecIngreso);
		System.out.println("Cargo:"+cargo.getNombre());*/
		
		EmpleadoDTO obj = new EmpleadoDTO();
		obj.setIdEmpleado(cod);
		obj.setNombre(nombre);
		obj.setPrimerAp(apPaterno);
		obj.setSegundoAp(apMaterno);
		obj.setFechaNac(LocalDate.parse(fecNacimiento));
		obj.setFechaIngreso(LocalDate.parse(fecIngreso));
		obj.setUsuario(usuario);
		obj.setClave(clave);
		obj.setCargo(cargo);
		obj.setTelefono(telefono);
		
		int respuesta = servEmp.actualizarEmpleado(obj);
		System.out.println(""+respuesta);
		response.setCharacterEncoding("UTF-8");
		if(respuesta != 0){
			request.setAttribute("msg", "Actualizado correctamente");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}else{
			request.setAttribute("alert", "0");
			request.setAttribute("msg", "Error al actualizar");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
		
		//listarEmpleados(request, response);
		//request.getRequestDispatcher("empleado.jsp").forward(request, response);
	}

	private void filtrarEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String filtro = request.getParameter("filtro");
		
		
		List<EmpleadoDTO> filtroEmp = servEmp.filtrarEmpleado(filtro);
		
		/*for (EmpleadoDTO empleadoDTO : filtroEmp) {
			System.out.println(empleadoDTO.getNombre());
			System.out.println(empleadoDTO.getPrimerAp());
			System.out.println(empleadoDTO.getSegundoAp());
			System.out.println("=========================");
		}*/
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		for (EmpleadoDTO xEmp : filtroEmp) {
			out.println("<tr>");
			out.println("<td>" + xEmp.getIdEmpleado() + "</td>");
			out.println("<td>" + xEmp.getNombre() + "</td>");
			out.println("<td>" + xEmp.getPrimerAp() + "</td>");
			out.println("<td>" + xEmp.getSegundoAp() + "</td>");
			out.println("<td>" + xEmp.getEdad() + "</td>");
			out.println("<td>" + xEmp.getFechaIngreso() + "</td>");
			out.println("<td>" + xEmp.getUsuario() + "</td>");
			out.println("<td>" + xEmp.getCargo().getNombre() + "</td>");
			out.println("<td>" + xEmp.getTelefono() + "</td>");
			//out.println("<td class='text-center'><a href='ServletEmpleado?tipo=buscar&cod=" + xEmp.getIdEmpleado() 
			out.println("<td class='text-center'><a href='#' data-toggle='modal' data-target='#fm-editar' "
					+ "onclick=\"selEmpleado(\'"+xEmp.getIdEmpleado()+"\', \'"+xEmp.getNombre()+"\', \'"+xEmp.getPrimerAp()+"\', \'"+
					xEmp.getSegundoAp()+"\', \'"+xEmp.getFechaNac()+"\', \'"+xEmp.getFechaIngreso()+"\',  \'"+xEmp.getUsuario()+"\', \'"+xEmp.getClave()+"\', \'"+xEmp.getCargo().getIdCargo()+"\', \'"+xEmp.getTelefono()+"\')\""
					+ " id='editar'>"
					+ "<span class='oi oi-pencil' aria-hidden='true' title='Editar'>"
					+ "</span></a></td>");						
			//out.println("<td><a href='ServletEmpleado?tipo=eliminar&cod=" + xEmp.getIdEmpleado() + "' data-toggle='modal' data-target='#fm-delete'>"
			out.println("<td><a href='#' data-toggle='modal' data-target='#fm-delete'"
					+" onclick=\"elimEmpleado(\'"+xEmp.getIdEmpleado()+"\')\">"
					+ "<span class='oi oi-trash' aria-hidden='true' title='Eliminar'>" 
					+ "</span></a></td>");
			out.println("</tr>");
		}
	}

	private void listarCargo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<CargoDTO> listCargo = servCargo.listarCargos();
		for (CargoDTO cargoDTO : listCargo) {
			System.out.println(""+cargoDTO.getIdCargo()+" - "+cargoDTO.getNombre());
		}
		//Ajax
		Gson gson = new Gson();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(listCargo));
		//Fin Ajax
	}

	private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response) {
		int cod = Integer.parseInt(request.getParameter("txtelimcod"));
		System.out.println("Codigo: "+cod);
		
		servEmp.eliminarEmpleado(cod);
		listarEmpleados(request, response);
		
		//Ajax and Json
		/*try {
			//Ajax and Json
			List<EmpleadoDTO> lista = servEmp.listarEmpleados();
			Gson gson = new Gson();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(lista));
			//Fin Ajax and Json
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
	}

	private void registrarEmpleado(HttpServletRequest request, HttpServletResponse response) {
		int cod;
		String nombre, apPaterno, apMaterno;
		String fecNacimiento, fecIngreso;
		String usuario, clave;
		CargoDTO cargo;
		String telefono;
		
		cod =  Integer.parseInt(request.getParameter("cmbaddcargo"));
		
		nombre = request.getParameter("txtaddnombres");
		apPaterno = request.getParameter("txtaddappaterno");
		apMaterno = request.getParameter("txtaddapmaterno");
		fecNacimiento = request.getParameter("txtaddfechanac");
		fecIngreso = request.getParameter("txtaddfechaing");
		usuario = request.getParameter("txtaddusuario");
		clave = request.getParameter("txtaddclave");
		cargo = servCargo.buscarCargo(cod);
		telefono = request.getParameter("txtaddtelefono");
		
		System.out.println(nombre);
		System.out.println(apPaterno);
		System.out.println(apMaterno);
		System.out.println(fecNacimiento);
		System.out.println(fecIngreso);
		System.out.println(usuario);
		System.out.println(clave);
		System.out.println(cargo);
		System.out.println(telefono);
		
		
		EmpleadoDTO obj = new EmpleadoDTO();
		obj.setNombre(nombre);
		obj.setPrimerAp(apPaterno);
		obj.setSegundoAp(apMaterno);
		obj.setFechaNac(LocalDate.parse(fecNacimiento));
		obj.setFechaIngreso(LocalDate.parse(fecIngreso));
		obj.setUsuario(usuario);
		obj.setClave(clave);
		obj.setCargo(cargo);
		obj.setTelefono(telefono);
		
		int respuesta = servEmp.registrarEmpleado(obj);
		System.out.println("Rpta.: "+respuesta);
		
		listarEmpleados(request, response);
		
	}

	private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Dentro del servlet actualizarEmpleado");
		int cod;
		String nombre, apPaterno, apMaterno;
		String fecNacimiento, fecIngreso;
		String usuario, clave;
		CargoDTO cargo;
		String telefono;
		
		System.out.println(""+request.getParameter("txteditcod"));
		System.out.println(""+request.getParameter("txteditnombres"));
		System.out.println(""+request.getParameter("txteditappaterno"));
		
		cod = Integer.parseInt(request.getParameter("txteditcod"));
		nombre = request.getParameter("txteditnombres");
		apPaterno = request.getParameter("txteditappaterno");
		apMaterno = request.getParameter("txteditapmaterno");
		fecNacimiento = request.getParameter("txteditfechanac");
		fecIngreso = request.getParameter("txteditfechaing");
		usuario = request.getParameter("txteditusuario");
		clave = request.getParameter("txteditclave");
		cargo = servCargo.buscarCargo(Integer.parseInt(request.getParameter("cmbeditcargo")));
		telefono = request.getParameter("txtedittelefono");
		
		//CargoDTO objCargo = servCargo.buscarCargo(cod)
		
		/*System.out.println("Codigo:"+cod);
		System.out.println("Codigo:"+nombre);
		System.out.println("Codigo:"+apPaterno);*/
		
		EmpleadoDTO obj = new EmpleadoDTO();
		obj.setIdEmpleado(cod);
		obj.setNombre(nombre);
		obj.setPrimerAp(apPaterno);
		obj.setSegundoAp(apMaterno);
		obj.setFechaNac(LocalDate.parse(fecNacimiento));
		obj.setFechaIngreso(LocalDate.parse(fecIngreso));
		obj.setUsuario(usuario);
		obj.setClave(clave);
		obj.setCargo(cargo);
		obj.setTelefono(telefono);
		
		int respuesta = servEmp.actualizarEmpleado(obj);
		if(respuesta == 1){
			System.out.println(""+respuesta);
			response.setCharacterEncoding("UTF-8");
			request.setAttribute("rpt", "1");			
			request.setAttribute("msg", "Empleado editado correctamente.");
			listarEmpleados(request, response);
		}else{
			System.out.println(""+respuesta);
			response.setCharacterEncoding("UTF-8");
			request.setAttribute("rpt", "-1");
			request.setAttribute("msg", "Error al editar empleado.");
			listarEmpleados(request, response);
		}
		/*System.out.println(""+respuesta);
		response.setCharacterEncoding("UTF-8");
		listarEmpleados(request, response);*/ 
		
	}

	private void buscarEmpleado(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		
		int cod = Integer.parseInt(request.getParameter("cod"));
		//request.setAttribute("Empleado", servEmp.buscarEmpleado(cod));
		try {
			//request.getRequestDispatcher("editar-emp.jsp").forward(request, response);
			
			//Ajax
			EmpleadoDTO emp = servEmp.buscarEmpleado(cod);
			String objJson = new Gson().toJson(emp);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(objJson);
			//Fin Ajax
			
		//} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private void listarEmpleados(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("empleados", servEmp.listarEmpleados());
		
		
		try {
			request.getRequestDispatcher("empleado.jsp").forward(request, response);
			
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) {
		/*System.out.println("En el Servlet CErrarSesion "+request.getSession());*/
		try {
			HttpSession sesion = request.getSession();
			//sesion.invalidate();
			sesion.removeAttribute("usuario");
			//sesion.invalidate();
			request.setAttribute("msg", "Inicia Sesión");		
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String xuser = request.getParameter("txtusuario");
		String xpass = request.getParameter("txtclave");
		System.out.println("WEB login: " + xuser);
		System.out.println("WEB pass: " + xpass);
		
		EmpleadoDTO objEmp = servEmp.iniciarSesion(xuser, xpass);
		
		if(objEmp!=null){
			try {
				HttpSession sesion = request.getSession();
				sesion.setAttribute("usuario", objEmp);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				//response.sendRedirect("holamundo.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				request.setAttribute("msg", "Usuario y/o contraseña incorrectos...");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
