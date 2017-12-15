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

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import beans.DetalleVentaDTO;
import service.OrdenVentaService;

/**
 * Servlet implementation class ServletDetalleVenta
 */
@WebServlet("/ServletDetalleVenta")
public class ServletDetalleVenta extends HttpServlet {
	OrdenVentaService servVenta = new OrdenVentaService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalleVenta() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		String detalle;
		while((detalle = br.readLine())!=null) {
			sb.append(detalle);
		}
		Gson gson = new Gson();
		Type tipoListaDetalles = new TypeToken<List<DetalleVentaDTO>>(){}.getType();
		List<DetalleVentaDTO> detalles = gson.fromJson(sb.toString(), tipoListaDetalles);
		System.out.println("Los detalles de la venta");
		System.out.println("========================");
		for (DetalleVentaDTO detalleVentaDTO : detalles) {
			System.out.println("Idventa: "+detalleVentaDTO.getIdOrdenVenta());
			System.out.println("Producto: "+detalleVentaDTO.getIdProducto());
			System.out.println("Monto: "+detalleVentaDTO.getMonto());
			System.out.println("Cantidad: "+detalleVentaDTO.getCantidad());
		}
		
		//Guardando en la Base de Datos
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		JsonObject objJson = new JsonObject();
		try {
			for (DetalleVentaDTO detalleVentaDTO : detalles) {
				servVenta.insertarDetalle(detalleVentaDTO.getIdOrdenVenta(), 
						detalleVentaDTO.getIdProducto(), 
						detalleVentaDTO.getCantidad(), 
						detalleVentaDTO.getMonto());
			}
			objJson.addProperty("tipo", "1");
			objJson.addProperty("msg", "Se le redirigirá a la Página Principal dentro de poco.");
			String mensaje = objJson.toString();
			response.getWriter().write(mensaje);
			
		} catch (Exception e) {
			objJson.addProperty("tipo", "0");
			objJson.addProperty("msg", "Hubo un error interno");
			String mensaje = objJson.toString();
			response.getWriter().write(mensaje);
		}
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
