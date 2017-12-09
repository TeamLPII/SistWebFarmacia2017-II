<%@page import="beans.EmpleadoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	EmpleadoDTO empleado = null;
	EmpleadoDTO user = null;
	if(session.getAttribute("usuario") != null){
		empleado = (EmpleadoDTO) session.getAttribute("usuario");
		user = (EmpleadoDTO) request.getAttribute("empleado");
	}
	else{
		//response.sendRedirect("index.jsp");
		pageContext.forward("ServletEmpleado?tipo=cerrarSesion");
	}
%>


<%-- <jsp:include page="WEB-INF/validar.jsp"></jsp:include> --%>

<jsp:include page="WEB-INF/head.jsp">
	<jsp:param value="Usuario" name="title"/>
</jsp:include>
<jsp:include page="WEB-INF/menu-navegacion.jsp">
	<jsp:param value="usuario" name="item"/>
</jsp:include>

    <!--MAIN-->
    <main class="container mb-3" >
        <div class="row bg-info mb-3">
            <div class="col input-group text-white py-3">
                <h2><span class="oi oi-person"></span>
                Datos Usuario</h2>
            </div>
        </div>

        <!--<div class="row" id="contfrmusuario">-->
        <form id="frmuserempleado" action="ServletEmpleado?tipo=actualizarUser" method="post" >
            <div class="form-group row" >
                <div class="col">
                    <input type="hidden" name="txtusercod" id="txtusercod" value="<%=empleado.getIdEmpleado()%>">
                <label class="form-control-label" for="txtusernomb">Nombres:</label>
                <input class="form-control" type="text" name="txtusernomb" id="txtusernomb" placeholder="ingrese su nombre" value="<%=user.getNombre()%>">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-md-6">
                <label class="form-control-label" for="txtuserappat">Primer Apellido:</label>
                <input class="form-control" type="text" name="txtuserappat" id="txtuserappat" placeholder="Ingrese su apellido paterno" value="<%=user.getPrimerAp()%>">
                </div>
            <!--</div>
            <div class="form-group row">-->
                <div class="col-md-6">
                <label class="form-control-label" for="txtuserapmat">Segundo Apellido:</label>
                <input class="form-control" type="text" name="txtuserapmat" id="txtuserapmat" placeholder="Ingrese su apellido materno" value="<%=user.getSegundoAp()%>">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-md-6">
                <label class="form-control-label" for="txtuserfecnac">Fecha Nacimiento:</label>
                <input class="form-control dp-fecha" type="text" name="txtuserfecnac" id="txtuserfecnac" placeholder="yyyy-mm-dd" value="<%=user.getFechaNac()%>">
                </div>
            <!--</div>
            <div class="form-group row">-->
                <div class="col-md-6">
                <label class="form-control-label" for="txtuserfecing">Fecha de Ingreso:</label>
                <input class="form-control" type="text" name="txtuserfecing" id="txtuserfecing" placeholder="yyyy-mm-dd" readonly="readonly" value="<%=user.getFechaIngreso()%>">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-md-6">
                <label class="form-control-label" for="txtuserusuario">Usuario:</label>
                <input class="form-control" type="text" name="txtuserusuario" id="txtuserusuario" placeholder="Su usuario" value="<%=user.getUsuario()%>">
                </div>
            <!--</div>
            <div class="form-group row">-->
                <div class="col-md-6">
                <label class="form-control-label" for="txtuserclave">Clave:</label>
                <input class="form-control" type="password" name="txtuserclave" id="txtuserclave" placeholder="Su contraseña" value="<%=user.getClave()%>">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-md-6">
                <label class="form-control-label" for="txtusercargo">Cargo:</label>
                <input type="hidden" value="<%=user.getCargo().getIdCargo()%>" name="txtuseridcargo" id="txtxuseridcargo">
                <input class="form-control" type="text" name="txtusercargo" id="txtusercargo" value="<%=user.getCargo().getNombre()%>" disabled>
                    <!-- <select class="form-control" name="cmbusercargo" id="cmbusercargo" disabled>
                        <option value="1">Cajero</option>
                        <option value="2">Vendedor</option>
                        <option value="3">Administrador</option>
                        <option value="4">Almacenero</option>
                    </select> -->
                </div>
            <!--</div>
            <div class="form-group row">-->
                <div class="col-md-6">
                <label class="form-control-label" for="txtusertelefono">Teléfono:</label>                
                <input class="form-control" type="text" name="txtusertelefono" id="txtusertelefono" placeholder="Ingrese su número telefónico" value="<%=user.getTelefono()%>">
                </div>
            </div>
        <button type="submit" class="btn btn-success col-sm-12 col-lg-2" form="frmuserempleado">Actualizar Datos</button>
       <!-- </div>-->
       </form>

    </main>
    <!--END MAIN-->
    
    
<jsp:include page="WEB-INF/footer.jsp"></jsp:include>