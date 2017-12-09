<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form id="deletProducto" action="ServletProducto?tipo=eliminar" method="post">  
<div class="modal fade" id="frm-eliminar-producto" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">  
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Eliminar</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">  
      		<input type="hidden" name="txtcodPro" id="txtcodPro" form="deletProducto">      		
      		<div class="alert alert-danger" role="alert">
      		Desea Eliminar al producto <label id="nomPro"></label> de forma permanente?
      		</div>
      		
      </div>
      <div class="modal-footer">
        <button id="btn-eliminar" type="submit" class="btn btn-danger" form="deletProducto">Eliminar</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>        
      </div>
    </div>
  </div>
</div>
</form>