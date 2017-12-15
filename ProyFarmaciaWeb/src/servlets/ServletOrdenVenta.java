package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import beans.DetalleVentaDTO;
import beans.OrdenVentaDTO;
import service.OrdenVentaService;

/**
 * Servlet implementation class ServletOrdenVenta
 */
@WebServlet("/ServletOrdenVenta")
public class ServletOrdenVenta extends HttpServlet {
	OrdenVentaService servVenta = new OrdenVentaService();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOrdenVenta() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		//https://stackoverflow.com/questions/5338943/read-json-string-in-servlet
		String xtipo = request.getParameter("tipo");
		if(xtipo.equalsIgnoreCase("insVenta"))
			insertarVenta(request, response);
		else
			insertarDetalle(request, response);
		
		
		/*System.out.println("En el servlet");
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		//int idventa = Integer.parseInt(request.getParameter("idventa"));
		String detalle;
		while((detalle = br.readLine())!=null){
			sb.append(detalle);
			System.out.println(detalle);
		}
		System.out.println("String builder: "+sb.toString());
		//System.out.println(""+idventa);
		
		Gson gson = new Gson();
		//String listaDetalle = gson.toJson(detalle);
		Type tipoListaDetalles = new TypeToken<List<DetalleVentaDTO>>(){}.getType();
		List<DetalleVentaDTO> detalles = gson.fromJson(sb.toString(), tipoListaDetalles);
		for (DetalleVentaDTO detalleVentaDTO : detalles) {
			System.out.println("Idventa: "+detalleVentaDTO.getIdOrdenVenta());
			System.out.println("Producto: "+detalleVentaDTO.getIdProducto());
			System.out.println("Cantidad: "+detalleVentaDTO.getMonto());
			System.out.println("Producto: "+detalleVentaDTO.getCantidad());
		}*/
		
	}


	private void insertarDetalle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		String detalle;
		while((detalle = br.readLine())!=null) {
			sb.append(detalle);
		}
		Gson gson = new Gson();
		Type tipoListaDetalles = new TypeToken<List<DetalleVentaDTO>>(){}.getType();
		List<DetalleVentaDTO> detalles = gson.fromJson(sb.toString(), tipoListaDetalles);
		for (DetalleVentaDTO detalleVentaDTO : detalles) {
			System.out.println("Idventa: "+detalleVentaDTO.getIdOrdenVenta());
			System.out.println("Producto: "+detalleVentaDTO.getIdProducto());
			System.out.println("Cantidad: "+detalleVentaDTO.getMonto());
			System.out.println("Producto: "+detalleVentaDTO.getCantidad());
		}
	}


	private void insertarVenta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//int codventa = Integer.parseInt( request.getParameter("venta"));
		System.out.println("En el insertar venta");
		int codVenta = Integer.parseInt(request.getParameter("idventa"));
		String fecha = request.getParameter("fecha");
		int  idCliente = Integer.parseInt( request.getParameter("idcliente"));
		int  idEmpleado = Integer.parseInt(request.getParameter("idempleado"));
		System.out.println("===================");
		System.out.println("Venta: "+codVenta);
		System.out.println("Fecha: "+fecha);
		System.out.println("Cliente: "+idCliente);
		System.out.println("Empleado: "+idEmpleado);
		//servVenta.insertarOrdenVenta(fecha, 2, 1);
		int rpta = servVenta.insertarOrdenVenta(fecha, idCliente, idEmpleado);
		/*OrdenVentaDTO objOV = servVenta.buscarOrdenVenta(codVenta);*/
		
		//Gson gson = new Gson();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		JsonObject objJson = new JsonObject();
		if(rpta != 0) {
			//String mensaje = "{\"tipo\":\"1\",\"msg\":\"Orden de venta generado con éxito\"}";
			objJson.addProperty("tipo", "1");
			objJson.addProperty("msg", "Orden de venta generado con éxito");
			String mensaje = objJson.toString();
			response.getWriter().write(mensaje);
		}else {
			//String mensaje = "{\"tipo\":\"0\",\"msg\":\"Orden de venta generado no generado\"}";
			objJson.addProperty("tipo", "0");
			objJson.addProperty("msg", "Orden de venta no generado");
			String mensaje = objJson.toString();
			response.getWriter().write(mensaje);
		}
		
		//response.getWriter().write(gson.toJson(objOV));
		
		//Probando el detalle
		/*Gson gson = new Gson();
		Type tipoListaDetalles = new TypeToken<List<DetalleVentaDTO>>() {}.getType();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		
		String detalle;
		while((detalle = br.readLine())!=null){
			sb.append(detalle);
			System.out.println(detalle);
		}
		List<DetalleVentaDTO> detalles = gson.fromJson(sb.toString(), tipoListaDetalles);*/
		// Fin detalle
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
