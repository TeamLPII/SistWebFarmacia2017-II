<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.EmpleadoDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- <jsp:include page="WEB-INF/validar.jsp"></jsp:include> --%>
<%
	EmpleadoDTO empleado = null;
	if(session.getAttribute("usuario") != null){
		empleado = (EmpleadoDTO) session.getAttribute("usuario");
	}else{
		//response.sendRedirect("index.jsp");
		pageContext.forward("ServletEmpleado?tipo=cerrarSesion");
		//response.sendRedirect("index.jsp");
	}

	List<EmpleadoDTO> lista = (ArrayList<EmpleadoDTO>) request.getAttribute("empleados");
%>

<jsp:include page="WEB-INF/head.jsp">
	<jsp:param value="Empleados" name="title"/>
</jsp:include>
<jsp:include page="WEB-INF/menu-navegacion.jsp">
	<jsp:param value="empleados" name="item"/>
</jsp:include>
   
   <!--MAIN -->
    <main class="container ">
        <div class="row">
            <div class="col-12 bg-info py-2 ">
                <div class="input-group text-white">
                    <span class="oi oi-list " aria-hidden="true"> </span>
                    <h2 class="ml-3"> Empleados</h2>
                </div>
            </div>

	<%if(request.getAttribute("rpta")!=null){
		if(Integer.parseInt( request.getAttribute("rpt").toString()) != 0 ){
			if (request.getAttribute("msg") != null) {	
				
	%>
				<div class="col-md-12 pt mt-2">
					<!-- <div class="alert alert-danger"> -->
					<div class="alert alert-success">
						<strong>Éxito!</strong> ${requestScope.msg}
					</div>
				</div>
	<%		}else{%>
				<div class="col-md-12 pt mt-2">
					<div class="alert alert-danger">
					<!-- <div class="alert alert-success"> -->
						<strong>Error!</strong> ${requestScope.msg}
					</div>
				</div>
		<%	}
		}
	}%>

	<!-- Bloque Agregar/Buscar -->
             <div class="agregar col-12 mt-4">
                <div class="row align-items-center">
                    <div class="col-lg-6">
                        <a href="#" class="btn btn-secondary " data-toggle="modal" data-target="#fm-modal" onclick="getfrmaddemp()"><span class="icono oi oi-plus " aria-hidden="true"></span> Agregar </a>
                    </div>
                    
                    <!-- Formulario modal agregar -->
                    <jsp:include page="agregaremp.jsp"></jsp:include>
                    
                    <div class="col-lg-6 mt-2 mt-sm-2">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Buscar en nombres o apellidos" onkeyup="filtrarEmp()" id="txtfiltraremp">
                            <span class="input-group-btn">
                                <button class="btn btn-secondary" >Buscar</button>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END Bloque Agregar/Buscar -->
                
                <!-- Tabla -->
                <div class="col-12 mt-2">
                <table class="table table-bordered table-hover table-striped table-responsive" id="tblempleados">
                    <caption>Lista de Empleados</caption>
                    <thead>
                        <th>ID</th>
                        <th>NOMBRES</th>
                        <th class="text-center">AP. PATERNO</th>
                        <th class="text-center">AP. MATERNO</th>
                        <th>EDAD</th>
                        <th class="text-center">FECHA INGRESO</th>
                        <th>USUARIO</th>
                        <th>CARGO</th>
                        <th>TELÉFONO</th>
                        <th colspan="2" class="text-center">ACCIONES</th>
                    </thead>

                   <!--  <tr>
                        <td>1</td>
                        <td>Nombre1</td>
                        <td>Ap 2</td>
                        <td>Ap 3</td>
                        <td>35</td>
                        <td>2017-11-10</td>
                        <td>user1</td>
                        <td>vendedor</td>
                        <td>89761532</td>
                        <td class="text-center"><a href="#" data-toggle="modal" data-target="#fm-editar"><span class="oi oi-pencil" aria-hidden="true" title="Editar"></span></a></td>
                        
                        <td class="text-center"><a href="#" data-toggle="modal" data-target="#fm-delete"><span class="oi oi-trash" aria-hidden="true" title="Eliminar"> </span></a></td>
                        
                    </tr> -->
                    <tbody>
			<%
				if (lista != null) {
					for (EmpleadoDTO xEmp : lista) {
						out.println("<tr>");
						out.println("<td>" + xEmp.getIdEmpleado() + "</td>");
						out.println("<td>" + xEmp.getNombre() + "</td>");
						out.println("<td>" + xEmp.getPrimerAp() + "</td>");
						out.println("<td>" + xEmp.getSegundoAp() + "</td>");
						out.println("<td>" + xEmp.getEdad() + "</td>");
						out.println("<td>" + xEmp.getFechaIngreso() + "</td>");
						out.println("<td>" + xEmp.getUsuario() + "</td>");
						out.println("<td>" + xEmp.getCargo().getNombre() + "</td>");
						out.println("<td>" + xEmp.getTelefono() + "</td>");
						//out.println("<td class='text-center'><a href='ServletEmpleado?tipo=buscar&cod=" + xEmp.getIdEmpleado() 
						out.println("<td class='text-center'><a href='#' data-toggle='modal' data-target='#fm-editar' "
								+ "onclick=\"selEmpleado(\'"+xEmp.getIdEmpleado()+"\', \'"+xEmp.getNombre()+"\', \'"+xEmp.getPrimerAp()+"\', \'"+
								xEmp.getSegundoAp()+"\', \'"+xEmp.getFechaNac()+"\', \'"+xEmp.getFechaIngreso()+"\',  \'"+xEmp.getUsuario()+"\', \'"+xEmp.getClave()+"\', \'"+xEmp.getCargo().getIdCargo()+"\', \'"+xEmp.getTelefono()+"\')\""
								+ " id='editar'>"
								+ "<span class='oi oi-pencil' aria-hidden='true' title='Editar'>"
								+ "</span></a></td>");						
						//out.println("<td><a href='ServletEmpleado?tipo=eliminar&cod=" + xEmp.getIdEmpleado() + "' data-toggle='modal' data-target='#fm-delete'>"
						out.println("<td><a href='#' data-toggle='modal' data-target='#fm-delete'"
								+" onclick=\"elimEmpleado(\'"+xEmp.getIdEmpleado()+"\')\">"
								+ "<span class='oi oi-trash' aria-hidden='true' title='Eliminar'>" 
								+ "</span></a></td>");
						out.println("</tr>");
					}
				}
			%>
			
			</tbody>
			
			<jsp:include page="editaremp.jsp"></jsp:include>
			<jsp:include page="eliminaremp.jsp"></jsp:include>
		</table>
            	</div>
                <!-- END Tabla -->

            
         </div>
       </main> 


	
	<%-- <table border="2" align="center" width="75%">
		<tr>
			<th>CODIGO</th>
			<th>NOMBRES</th>
			<th>FECHA INGRESO</th>
			<th>CARGO</th>
			<th>USUARIO</th>
			<th colspan="2">ACCIONES</th>
		</tr>
		<%
			if(lista!=null){
				for(EmpleadoDTO xEmp : lista){
					out.println("<tr>");
					out.println("<td>"+xEmp.getIdEmpleado()+"</td>");
					out.println("<td>"+xEmp.getNombre()+"</td>");
					out.println("<td>"+xEmp.getFechaIngreso()+"</td>");
					out.println("<td>"+xEmp.getCargo().getNombre()+"</td>");
					out.println("<td>"+xEmp.getUsuario()+"</td>");
					out.println("<td><a href='ServletEmpleado?tipo=buscar&cod="+xEmp.getIdEmpleado()+"'>"+"Editar"+"</a></td>");
					out.println("<td><a href='ServletEmpleado?tipo=eliminar&cod="+xEmp.getIdEmpleado()+"'>"+"Eliminar"+"</a></td>");
					out.println("</tr>");
				}
			}
		%>
	</table> --%>


<jsp:include page="WEB-INF/footer.jsp"></jsp:include>