package servlets;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
	}

	private void registrarEmpleado(HttpServletRequest request, HttpServletResponse response) {
		int cod;
		String nombre, apPaterno, apMaterno;
		String fecNacimiento, fecIngreso;
		String usuario, clave;
		CargoDTO cargo;
		String telefono;
		
		cod =  Integer.parseInt(request.getParameter("txtcargo"));
		
		nombre = request.getParameter("txtnombre");
		apPaterno = request.getParameter("txtappaterno");
		apMaterno = request.getParameter("txtapmaterno");
		fecNacimiento = request.getParameter("txtfechanac");
		fecIngreso = request.getParameter("txtfecingreso");
		usuario = request.getParameter("txtusuario");
		clave = request.getParameter("txtclave");
		cargo = servCargo.buscarCargo(cod);
		telefono = request.getParameter("txttelefono");
		
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
		int cod;
		String nombre, apPaterno, apMaterno;
		String fecNacimiento, fecIngreso;
		String usuario, clave;
		CargoDTO cargo;
		String telefono;
		
		cod = Integer.parseInt(request.getParameter("txtid"));
		nombre = request.getParameter("txtnombre");
		apPaterno = request.getParameter("txtappaterno");
		apMaterno = request.getParameter("txtapmaterno");
		fecNacimiento = request.getParameter("txtfechanac");
		fecIngreso = request.getParameter("txtfecingreso");
		usuario = request.getParameter("txtusuario");
		clave = request.getParameter("txtclave");
		cargo = servCargo.buscarCargo(Integer.parseInt(request.getParameter("txtcargo")));
		telefono = request.getParameter("txttelefono");
		
		//CargoDTO objCargo = servCargo.buscarCargo(cod)
		
		
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
		listarEmpleados(request, response); 
		
	}

	private void buscarEmpleado(HttpServletRequest request, HttpServletResponse response) {
		int cod = Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Empleado", servEmp.buscarEmpleado(cod));
		try {
			request.getRequestDispatcher("editar-emp.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.setAttribute("msg", "Inicia Sesión");
		try {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) {
		String xuser = request.getParameter("txtusuario");
		String xpass = request.getParameter("txtclave");
		System.out.println("WEB login: " + xuser);
		System.out.println("WEB pass: " + xpass);
		
		EmpleadoDTO objEmp = servEmp.iniciarSesion(xuser, xpass);
		
		if(objEmp!=null){
			try {
				HttpSession sesion = request.getSession();
				sesion.setAttribute("usuario", objEmp);
				request.getRequestDispatcher("holamundo.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
