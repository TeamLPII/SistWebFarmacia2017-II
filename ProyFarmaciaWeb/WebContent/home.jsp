<%@page import="beans.EmpleadoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	EmpleadoDTO empleado = null;
	if(session.getAttribute("usuario") != null){
		empleado = (EmpleadoDTO) session.getAttribute("usuario");
	}else{
		//response.sendRedirect("index.jsp");
		pageContext.forward("ServletEmpleado?tipo=cerrarSesion");
		//response.sendRedirect("index.jsp");
	}
%>

<jsp:include page="WEB-INF/head.jsp">
	<jsp:param value="Home" name="title"/>
</jsp:include>
<jsp:include page="WEB-INF/menu-navegacion.jsp">
	<jsp:param value="home" name="item"/>
</jsp:include>

	
    <!--MAIN -->
    <main class="container" >
    	
    <div class="row">
    <%if(request.getAttribute("msg")!=null){
        if(request.getAttribute("alert")==null){ %>
	        <div class="col-md-12 pt mt-2 ">
				<!-- <div class="alert alert-danger"> -->
				<div class="alert alert-success alert-dismissable">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>Éxito!</strong> ${requestScope.msg}
				</div>
			</div>
		<%}else{%>
			<div class="col-md-12 pt mt-2 ">
				<div class="alert alert-danger alert-dismissable">
				<!-- <div class="alert alert-success"> -->
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>Error!</strong> ${requestScope.msg}
				</div>
			</div>
		<%}
        } %>
        </div>    	
    	
        <div class="row text-info">
            <div class="col">
                <h2 class="text-center font-weight-bold"> Bienvenido a <span><img src="img/color/logo.svg"> SysFarma</span></h2>
            </div>           
        </div>
        <!-- <div class="row">
        	 <div class="col d-block d-flex justify-content-center">
            	<img src="img/logoCibertec.png" class="img-fluid" alt="Cibertec" width="170" height="108">
            </div>
        </div> -->
    </main>
    <!--END MAIN -->
    
<jsp:include page="WEB-INF/footer.jsp"></jsp:include>