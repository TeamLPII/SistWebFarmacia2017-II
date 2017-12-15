package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.CategoriaDTO;
import beans.LaboratorioDTO;
import beans.ProductoDTO;
import service.CategoriaService;
import service.LaboratorioService;
import service.ProductoService;


@WebServlet("/ServletProducto")
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductoService serviProducto = new ProductoService();
	CategoriaService serviCat = new CategoriaService();
	LaboratorioService serviLab = new LaboratorioService();
	
  
    public ServletProducto() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xtipo = request.getParameter("tipo");
		if (xtipo.equals("listar"))
			listar(request, response);
		else if (xtipo.equals("buscar"))
			buscar(request, response);
		else if (xtipo.equals("registrar"))
			registrar(request, response);
		else if (xtipo.equals("actualizar"))
			actualizar(request, response);
		else if (xtipo.equals("eliminar"))
			eliminar(request, response);
		else if (xtipo.equals("listarCategoria"))
			listarCategoria(request, response);
		else if (xtipo.equals("listarLaboratorio"))
			listarLaboratorio(request, response);
		else if (xtipo.equals("buscarPorNombre"))
			buscarPorNombre(request, response);
		else if(xtipo.equalsIgnoreCase("listarPorJson"))
			listarPorJson(request, response);
		else if(xtipo.equalsIgnoreCase("buscarProJson"))
			buscarProJson(request, response);
		else if (xtipo.equals("registrarLaboratorio"))
			registrarLaboratorio(request, response);
		else if (xtipo.equals("registrarCategoria"))
			registrarCategoria(request, response);
		
	}
	
	private void registrarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("txtCategoria");
		CategoriaDTO obj = new CategoriaDTO();
		obj.setNom_cat(nom);
		
		//serviCat.registrarCategoria(obj);
		listar(request, response);
	}

	private void registrarLaboratorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("txtLaboratorio");
		LaboratorioDTO obj = new LaboratorioDTO();
		obj.setNom_lab(nombre);
		
		serviLab.registrarLaboratorio(obj);
		listar(request, response);
	}

	private void buscarProJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		ProductoDTO producto = serviProducto.buscaProducto(cod);
		Gson gson = new Gson();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(producto));
	}

	private void listarPorJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String term = request.getParameter("term");
		List<ProductoDTO> listadoPro = serviProducto.listaProducto();
		//System.out.println("term");
		for (ProductoDTO productoDTO : listadoPro) {
			System.out.println("Producto: "+productoDTO.getNom_prod());
			System.out.println("Producto: "+productoDTO.getCod_prod());
		}
		Gson gson = new Gson();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(listadoPro));
	}

	private void buscarPorNombre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("txtnomProducto");
		request.setAttribute("data",serviProducto.buscaProductoNombre(nombre));
		request.getRequestDispatcher("productos.jsp").forward(request, response);
	}

	private void listarLaboratorio(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<LaboratorioDTO> listarLab = serviLab.listarLaboratorio(); 
		Gson gson = new Gson();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(listarLab));
	}

	private void listarCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<CategoriaDTO> listarCat = serviCat.listarCategoria(); 
		Gson gson = new Gson();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(listarCat));
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviProducto.listaProducto());
		request.getRequestDispatcher("productos.jsp").forward(request, response);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Producto", serviProducto.buscaProducto(cod));
		request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int stock, codCat, codLab;
		stock = Integer.parseInt(request.getParameter("txt_stock"));
		codCat = Integer.parseInt(request.getParameter("cmbCategoria"));
		codLab = Integer.parseInt(request.getParameter("cmbLaboratorio"));
		String nom = request.getParameter("txt_nom");
		double pre = Double.parseDouble(request.getParameter("txt_pre"));

		ProductoDTO obj = new ProductoDTO();
		obj.setNom_prod(nom);
		obj.setPre_prod(pre);
		obj.setStk_prod(stock);
		obj.setCod_cat(codCat);
		obj.setCod_lab(codLab);

		serviProducto.registraProducto(obj);
		listar(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codPro, stock, codCat, codLab;
		codPro =Integer.parseInt(request.getParameter("txt_cod"));
		stock = Integer.parseInt(request.getParameter("txt_stock"));
		codCat = Integer.parseInt(request.getParameter("cmbCategoria"));
		codLab = Integer.parseInt(request.getParameter("cmbLaboratorio"));
		String nom = request.getParameter("txt_nom");
		double pre = Double.parseDouble(request.getParameter("txt_pre"));

		ProductoDTO obj = new ProductoDTO();
		obj.setCod_prod(codPro);
		obj.setNom_prod(nom);
		obj.setPre_prod(pre);
		obj.setStk_prod(stock);
		obj.setCod_cat(codCat);
		obj.setCod_lab(codLab);

		serviProducto.actualizaProducto(obj);
		listar(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("txtcodPro"));
		serviProducto.EliminaProducto(cod);
		listar(request, response);
	}

}
