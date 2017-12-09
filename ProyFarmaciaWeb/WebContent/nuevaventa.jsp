<%@page import="beans.EmpleadoDTO"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/* EmpleadoDTO empleado = null;
	EmpleadoDTO user = null;
	if(session.getAttribute("usuario") != null){
		empleado = (EmpleadoDTO) session.getAttribute("usuario");
		user = (EmpleadoDTO) request.getAttribute("empleado");
	} */
	/* else{
		//response.sendRedirect("index.jsp");
		pageContext.forward("ServletEmpleado?tipo=cerrarSesion");
	} */
%>


<jsp:include page="WEB-INF/head.jsp">
	<jsp:param value="Nueva Venta" name="title"/>
</jsp:include>
<jsp:include page="WEB-INF/menu-navegacion.jsp">
	<jsp:param value="nueva venta" name="item"/>
</jsp:include>
<%
	LocalDate fecha = LocalDate.now();
%>
    <!--MAIN-->
<main class="container" >
    <div class="row mb-2">
        <div class="col bg-info text-white text-center py-1">
            <h2>Registro de nueva venta</h2>
        </div>
    </div>

    <div class="row">

        <div class="col-12 form-group">
            <h3 class="">Venta Nro:</h3>
            <input type="text" class="form-control col-6" name="txtcodventa" id="txtcodventa" placeholder="Nro. Venta">
        </div>

        <div class="col-6 form-group">
            <input type="hidden" name="txtcodempleado" id="txtcodempleado" value="">
            <label class="form-control-label" for="txtempleado">Atendido por:</label>
            <input type="text" class="form-control " placeholder="Empleado" name="txtempleado" id="txtempleado" readonly="readonly" value="">
        </div>
        <div class="col-6 form-group">
            <label class="form-control-label" for="txtfechaventa">Fecha:</label>
            <input type="text" class="form-control " placeholder="yyyy-mm-dd" id="txtfechaventa" name="txtfechaventa" value="">
        </div>

    </div>
    
	<div class=" form-control-label">
		<span>Cliente:</span>
	</div>
	
    <div class="row mb-4">
        <div class="col-4">
            <!--<label class="form-control-label" for="txtcliente">Cliente:</label>-->
            <!-- <div class=" form-control-label">
                <span>Cliente:</span>
            </div> -->

            <div class="input-group">
                <input type="text" class="form-control" placeholder="DNI del Cliente" name="txtdni" id="txtdni">
                <span class="input-group-btn">
                    <input class="btn btn-primary" type="button" value="Buscar" id="btnbuscardni">
                </span>
            </div>
        </div >
        <div class="col-8 form-group ">
        	<!-- <label class="form-control-label" for="txtcliente">Fecha:</label> -->
        	<input type="hidden" name="txtcodcliente" id="txtcodcliente">
            <input type="text" class="form-control " placeholder="Nombre del cliente" id="txtcliente" name="txtcliente" onclick="buscarEmpleado();">
        </div>
    </div>

    <div class="row mb-3">

        <div class="col-6">
            <div class="form-control-label">
                <label>Producto:</label>
            </div>
            <div class=" input-group mb-3">
                <!-- <input type="text" class="form-control" placeholder="Producto" name="txtproducto" id="txtproducto">
                <span class="input-group-btn">
                    <input type="button" value="Buscar producto" class="btn btn-primary ">
                </span> -->
                <div class="input-group ui-widget">
				<select class="form-control chosen-select" name="cmbproductos" id="cmbproductos">
                </select>               
                </div>
            </div>
            <div class=" form-group">
            	<input type="hidden" name="txtcodproducto" id="txtcodproducto">
                <label class="form-control-label" for="txtcantidad">Cantidad:</label>
                <input type="text" class="form-control" placeholder="Ingresa la cantidad a vender" name="txtcantidad" id="txtcantidad">
            </div>

        </div>

        <div class="col-3 form-group">
        	<input type="hidden" name="txtproducto" id="txtproducto">
            <label class="form-control-label" for="txtstock">Stock</label>
            <input type="text" class="form-control" placeholder="Stock" name="txtstock" id="txtstock">
        </div>
        <div class=" col-3 form-group">
            <label class="form-control-label" for="txtprecio">Precio:</label>
            <input type="text" class="form-control" placeholder="Precio" name="txtprecio" id="txtprecio">
        </div>
        <div class="col-12 d-flex justify-content-between">
            <button class="btn btn-primary" id="btnadddetalle" >Agregar el producto</button>
            <button class="btn btn-primary" id='btngenerarordenventa'>Generar Orden de Pago</button>
        </div>

    </div>

    <div class="row mb-3">

            <span>Detalle Venta</span>
            <table class="table-bordered table-hover table-striped table-responsive col-12" id="tbldetalleventa">
                <caption>Lista de detalle de la venta</caption>
                <thead>
                <th>Cod. Prod.</th>
                <th>Descripción</th>
                <th class="text-center">Cantidad</th>
                <th class="text-center">Precio</th>
                <th class="text-center">Importe</th>
                <th>Acción</th>
                </thead>
                <tbody>
                    
                </tbody>
            </table>

            <div class="col-9"></div>
            <div class="col-3 form-group">
                <label class="col-form-label" for="txtsubtotal">Subtotal:</label>
                <input type="text" class="form-control text-right" placeholder="Subtotal" name="txtsubtotal" id="txtsubtotal">
            </div>
            <div class="col-9"></div>
            <div class="col-3 form-group">
                <label class="form-control-label" for="txtigv">I.G.V.:</label>
                <input type="text" class="form-control text-right" placeholder="IGV" name="txtigv" id="txtigv">
            </div>
            <div class="col-9"></div>
            <div class="col-3 form-group">
                <label class="form-control-label" for="txttotal">TOTAL:</label>
                <input type="text" class="form-control text-right" placeholder="Total" name="txttotal" id="txttotal">
            </div>
    </div>


</main>
<!--END MAIN-->


<jsp:include page="WEB-INF/footer.jsp"></jsp:include>