<%@page import="beans.EmpleadoDTO"%>
<%@page import="beans.RealizarPagoDTO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	EmpleadoDTO empleado = null;
	if (session.getAttribute("usuario") != null) {
		empleado = (EmpleadoDTO) session.getAttribute("usuario");
	} else {
		response.sendRedirect("login.jsp");
	}
%>

<!-- Encabezado -->
<jsp:include page="WEB-INF/head.jsp">
	<jsp:param value="realizarPago" name="title" />
</jsp:include>

<!-- Menú -->
<jsp:include page="WEB-INF/menu-navegacion.jsp">
	<jsp:param value="realizarPago" name="item" />
</jsp:include>

<main class="container"> <!-- Inicio Main -->

	<div class="row">
		<div class="col">
			<h2 style="text-align: center">Realizar Pago</h2>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-md-4">
			<label>Codigo Venta:</label>
			<form action="ServletRealizarPago" method="post" id="frm-mostrar"> 
			<% String id = (String) request.getAttribute("codVenta"); 
			if(id==null)
				id="";
			%>
			<input name="IdOrdenVenta" class="form-control" type="hidden" form="frm-pagar" value="<%= id%>">
					
				<input name="txtIdOrdenVenta" class="form-control" type="text"
					aria-label="Search" placeholder="Codigo Venta" value="<%= id%>">
		</div>
		<div class="col-md-5">
			<br>
			<button class="btn btn-primary" type="submit">
				<img src="svg/si-glyph-magnifier.svg" width="16px" height="16px">Buscar
			</button>
		</div>
		<div class="col-md-3"></div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<label>Nombre Cliente:</label>
			<%
				RealizarPagoDTO obj = (RealizarPagoDTO) request.getAttribute("Cliente");
				if (obj != null) {
			%>
			<input class="form-control" type="text" aria-label="Search"
				value="<%=obj.getNomCliente() + " " + obj.getApeCliente()%>">
			<%
				}
			%>
		</div>
		<div class="col-md-4">
			<label>Fecha Pago:</label> 
				<input type="text" class="form-control dp-fecha" name="txtFecha" form="frm-pagar" 
				<% String fecha = (String) request.getAttribute("Fecha");
					if(fecha==null)
						fecha="";
				%>
				value="<%=fecha%>">
				<input type="hidden" class="form-control dp-fecha" name="txtFechaPago" form="frm-pagar" value="<%=fecha%>">
		</div>

	</div>

	<div class="row">
		<div class="col-md-8">
			<label>Detalle Venta</label>
			<table class="table table-bordered table-hover table-striped">
				<tr>
					<th scope="row">IdProducto</th>
					<th scope="row">Descripción</th>
					<th scope="row">Cantidad</th>
					<th scope="row">PrecioUnitario</th>
					<th scope="row">SubTotal</th>
				</tr>
				<%
					double total = 0;
					ArrayList<RealizarPagoDTO> lista = (ArrayList<RealizarPagoDTO>) request.getAttribute("OrdenVenta");
					if (lista != null) {
						for (RealizarPagoDTO pago : lista) {
							total += pago.getMonto();
							out.println("<tr>");
							out.println("<td>" + pago.getIdProducto() + "</td>");
							out.println("<td>" + pago.getNomProducto() + "</td>");
							out.println("<td>" + pago.getCantidad() + "</td>");
							out.println("<td>" + pago.getPrecioUnitario() + "</td>");
							out.println("<td>" + pago.getMonto() + "</td>");
							out.println("</tr>");
						}

					}
					double montoTotal = total;
				%>
			</table>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-3">
			<h3 style="color: blue;">Gracias por su Coompra!..</h3>
			<button class="btn btn-info" type="submit">
				<img src="svg/si-glyph-print.svg" width="16px" height="16px">
				Imprimir Boleta
			</button>
			<br> <br>
			<button class="btn btn-danger" type="submit">
				<img src="svg/si-glyph-document-pdf.svg" width="16px" height="16px">
				Imprimir en PDF
			</button>
		</div>
	</div>

	<div class="row">
		<div class="col-md-5">
			<label>Cajero:</label> <label><%=empleado.getNombre() + " " + empleado.getPrimerAp() + " " + empleado.getSegundoAp() %></label>
		</div>
		<div class="col-md-3">
			<table class="table table-bordered">
				<tr>
					<th>TOTAL:</th>
					<th><input name="txtTotal" class="form-control" type="text"
						aria-label="Search" placeholder="Valor (S/.)"
						value="<%=montoTotal%>"></th>
				</tr>
				<tr>
					<th>MONTO:</th>
					<th>
					
					<input name="txtMontoEntregado" class="form-control" type="text"
						aria-label="Search" placeholder="Valor (S/.)" onchange="this.form.submit()" 
					<%
						String monto = (String) request.getAttribute("montoEntregado");
					if(monto==null)
						monto="";
					%>
						value="<%= monto%>">
					</th>
				</tr>
				<tr>
					<th>CAMBIO:</th>
					<th>
					<% String vuelto = (String) request.getAttribute("Vuelto");
						if(vuelto!=null){
					%>
					<input name="txtCambio" class="form-control" type="text"
						aria-label="Search" placeholder="Valor (S/.)" value="<%= vuelto%>">
						<%} %>
					</th>
				</tr>
			</table>
		</div>
	</div>
</form>
	<div class="row">
		<div class="col-md-7"></div>
		<div class="col-md-1">
		<form action="ServletRealizarPago" method="get" id="frm-pagar">
			<button class="btn btn-primary" type="submit">
				<img src="svg/si-glyph-wallet.svg" width="16px" height="16px">Pagar
			</button>
			</form>
		</div>
	</div>
	<br>

<!-- Fin Main --> </main>

<!-- Pie de página -->
<%@include file="WEB-INF/footer.jsp"%>