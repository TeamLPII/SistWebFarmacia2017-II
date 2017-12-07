<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Inicio Modal Actualizar Cliente-->


<div class="modal fade" id="frm-editar-cliente" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
  <form id="editCliente" action="ServletCliente?tipo=actualizar" method="post">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Datos del Cliente</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">    
      				<input name="txtCodigo" id="txtCodigo" class="form-control" type="hidden" form="editCliente">  
      				<label>Nombres</label>
					<input name="txtNombre" id="txtNombre" class="form-control" type="text"
						placeholder="Nombres" form="editCliente">
					<label>Primer Apellido</label>
					<input name="txtApePaterno" id="txtApePaterno" class="form-control" type="text"
						placeholder="Ape. Paterno" >
					<label>Segundo Apellido</label>
					<input name="txtApeMater" id="txtApeMater" class="form-control" type="text"
						placeholder="Ape. Materno" >
					<label>DNI</label>
					<input name="txtDNI" id="txtDNI" class="form-control" type="text"
						placeholder="N° DNI" >
					<label>Fecha de Registro</label>
					<input name="txtFecRegistro" id="txtFecRegistro" class="dp-fecha form-control" type="text"
						placeholder="Fecha" >
					<label>Sexo</label>
					<input name="txtSexo" id="txtSexo" class="form-control" type="text"
					placeholder="sexo" > 
      </div>
      <div class="modal-footer">
        <button id="btn-actualizar" type="submit" class="btn btn-primary" form="editCliente">Modificar</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>        
      </div>
    </div>
    </form>
  </div>
</div>

	<!-- Fin Modal Actualizar Cliente -->
