package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.RealizarPagoDTO;
import service.RealizarPagoService;

@WebServlet("/ServletRealizarPago")
public class ServletRealizarPago extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RealizarPagoService serviPago = new RealizarPagoService();
       
    public ServletRealizarPago() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int IdordenVenta=Integer.parseInt(request.getParameter("IdOrdenVenta"));
		String fechaPago=request.getParameter("txtFechaPago");
		int estado =2;
		System.out.println(estado);
		RealizarPagoDTO obj = new RealizarPagoDTO();
		obj.setEstado(estado);
		obj.setFechaPago(fechaPago);
		obj.setIdOrdenVenta(IdordenVenta);
		serviPago.actualizarEstado(obj);
		request.getRequestDispatcher("realizarPago.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String idOrden = request.getParameter("txtIdOrdenVenta");
		request.setAttribute("codVenta", idOrden);
		if(idOrden!=null){
			if(!idOrden.equals("")){
				int codVenta =Integer.parseInt(idOrden);
				request.setAttribute("OrdenVenta", serviPago.listarOrdenVenta(codVenta));
				request.setAttribute("Cliente", serviPago.buscarCliente(codVenta));
			}
		}
		try {
			String monto = request.getParameter("txtMontoEntregado");
			double total = Double.parseDouble(request.getParameter("txtTotal"));
			String fecha = request.getParameter("txtFecha");
			if(monto!=null){
				if(!monto.equals("")){
					double montoEnt = Double.parseDouble(monto);
					double Cambio = montoEnt-total;
					String vuelt = Cambio+"";
					request.setAttribute("Vuelto",vuelt);
					String mont = montoEnt+"";
					request.setAttribute("montoEntregado", mont);
					request.setAttribute("Fecha", fecha);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("realizarPago.jsp").forward(request, response);
	}

}
