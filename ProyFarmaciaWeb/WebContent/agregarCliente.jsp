<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<!-- Inicio Ventana Modal Nuevo Cliente-->
<form action="ServletCliente?tipo=insertar" method="post">
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Cliente Nuevo</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">      
      				<label>Nombres</label>
					<input name="txtNombre" class="form-control" type="text"
						placeholder="Nombres" >
					<label>Apellidos</label>
					<input name="txtApe" class="form-control" type="text"
						placeholder="Apellidos" >
					<label>DNI</label>
					<input name="txtDNI" class="form-control" type="text"
						placeholder="N° DNI">
					<label>Fecha de Registro</label>
					<input name="txtFecRegistro" class="dp-fecha form-control" type="text"
						placeholder="fecha">
					<label>Sexo</label>
					<select name="cboSexo" class="col">
						<option value="M">Masculino</option>
						<option value="F">Femenino</option>
					</select>
      </div>
      <div class="modal-footer">
        <button id="btn-agregar" type="submit" class="btn btn-primary">Guardar</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>        
      </div>
    </div>
  </div>
</div>
</form>
	<!-- Fin Ventana Modal Nuevo Cliente-->