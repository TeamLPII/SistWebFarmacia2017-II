package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.ReportesDTO;
import service.ReportesService;


@WebServlet("/ServletReportes")
public class ServletReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ReportesService serviRepor = new ReportesService();

    public ServletReportes() {
        super();
      
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xtipo = request.getParameter("tipo");
		if (xtipo.equals("listarVendedor"))
			listarVendedor(request, response);
		else if (xtipo.equals("ventaGeneral"))
			ventaGeneral(request, response);
		else if (xtipo.equals("ventaPorCliente"))
			ventaPorCliente(request, response);
	}
	private void listarVendedor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setAttribute("Vendedor", serviRepor.listarVendedor());
		request.getRequestDispatcher("reportes.jsp").forward(request, response);
//		List<ReportesDTO> listarVend =serviRepor.listarVendedor(); 
//		Gson gson = new Gson();
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().write(gson.toJson(listarVend));
		
	}
	private void ventaGeneral(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Estamos en el servlet");
		String fInicio = request.getParameter("txtFechaInicio");
		String fFin = request.getParameter("txtFechaFin");
		System.out.println("FechaInicio: "+fInicio);
		System.out.println(fFin);
		request.setAttribute("VentaGeneral", serviRepor.ventaGeneral(fInicio, fFin));
		request.getRequestDispatcher("reportes.jsp").forward(request, response);
		
	}
	private void ventaPorCliente(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
