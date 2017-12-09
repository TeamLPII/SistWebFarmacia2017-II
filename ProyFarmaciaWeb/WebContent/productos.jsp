<%@ page import="beans.ProductoDTO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Encabezado -->
<jsp:include page="WEB-INF/head.jsp">
	<jsp:param value="Productos" name="title" />
</jsp:include>
<!-- Menú -->
<jsp:include page="WEB-INF/menu-navegacion.jsp">
	<jsp:param value="productos" name="item" />
</jsp:include>
	<!--Contenedor-->
	<div class="container">
	<jsp:include page="registrarProducto.jsp"></jsp:include>
	<jsp:include page="editarProducto.jsp"></jsp:include>
	<jsp:include page="eliminarProducto.jsp"></jsp:include>
		<br>
	<main class="container">
	<div class="row">

		<div class="col-12 bg-info py-2 mb-3">
			<!-- <div class="input-group text-white">
				<span class="oi oi-list " aria-hidden="true"> </span>
				<h2 class="ml-3">Productos</h2>
			</div> -->
			<h2 class="titulo text-white " style="text-align: center">LISTADO DE
				PRODUCTOS</h2>
		</div>

		<div class="col-md-2">
			<button type="button" class="btn btn-success" data-toggle="modal"
				data-target="#frm-agregar-producto" onclick="cargarCombos()">
				<img src="svg/si-glyph-plus.svg" width="16px" height="16px">
				Agregar
			</button>
		</div>
		<div class="col-md-10">
			<nav class="navbar navbar-light float-right">
				<form class="form-inline" action="ServletProducto?tipo=buscarPorNombre" method="post">
					<input name="txtnomProducto" class="form-control" type="text" placeholder="Buscar"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Buscar</button>
				</form>
			</nav>
		</div>		
	</div>
		<br>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Stock</th>
					<th>Categoria</th>
					<th>Laboratorio</th>
					<th colspan="2">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList<ProductoDTO> lista = (ArrayList<ProductoDTO>) request.getAttribute("data");

					if (lista != null) {
						for (ProductoDTO xProd : lista) {
							out.println("<tr>");
							out.println("<td>" + xProd.getCod_prod() + "</td>");
							out.println("<td>" + xProd.getNom_prod() + "</td>");
							out.println("<td>S/. " + xProd.getPre_prod() + "</td>");
							out.println("<td>" + xProd.getStk_prod() + "</td>");
							out.println("<td>" + xProd.getNom_cat() + "</td>");
							out.println("<td>" + xProd.getNom_lab()+ "</td>");
							out.println("<td align='center'><a href='#' data-toggle='modal' data-target='#frm-editar-producto'"
										+" onclick=\"cargarProducto(\'"+xProd.getCod_prod()+"\', \'"+xProd.getNom_prod()+"\', \'"+xProd.getPre_prod()+"\', \'"
										+xProd.getStk_prod()+"\', \'"+xProd.getCod_cat()+"\', \'"+xProd.getCod_lab()+"\')\" id='editar'>"
							+ "<img src='img/file.svg' title='Editar'></a></td>");
							out.println("<td align='center'><a href='#' data-toggle='modal' data-target='#frm-eliminar-producto'"
										+"  onclick=\"eliminarProducto(\'"+xProd.getCod_prod()+"\', \'"+xProd.getNom_prod()+"\')\" id='eliminar'>" 
										+ "<img src='img/error2.svg' title='Eliminar'></a></td>");
							out.println("</tr>");
						}
					}
				%>
			</tbody>
		</table>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item disabled"><a class="page-link" href="#"
					tabindex="-1">Anterior</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">Siguiente</a></li>
			</ul>
		</nav>
	</div>
	</main>
<!-- Pie de página -->
<%@include file="WEB-INF/footer.jsp"%>