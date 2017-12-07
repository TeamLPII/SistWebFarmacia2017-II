<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- Inicio Modal eliminar Cliente --> 
<form id="deletCliente" action="ServletCliente?tipo=eliminar" method="post">  
<div class="modal fade" id="frm-eliminar-cliente" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">  
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Eliminar</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">  
      		<input type="hidden" name="txteliminarId" id="txteliminarId" form="deletCliente" class="form-control">      		
      		<div class="alert alert-danger" role="alert">
      		Estas por ELIMINAR de forma permanente al cliente:
      		<input type="text" name="txteliminarNom" id="txteliminarNom" form="deletCliente" class="form-control">
      		</div>
      		
      </div>
      <div class="modal-footer">
        <button id="btn-eliminar" type="submit" class="btn btn-success" form="deletCliente">Eliminar</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>        
      </div>
    </div>
  </div>
</div>
</form>

	<!-- Fin Modal eliminar Cliente -->
    
