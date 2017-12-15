<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="ServletProducto?tipo=registrarLaboratorio" method="post" id="addLaboratorio">
<div class="modal fade" id="frm-laboratorio" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Laboratorio</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <label>Nombre Laboratorio</label>
        <input class="form-control" type="text" name="txtLaboratorio" id="txtLaboratorio">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <button type="submit" class="btn btn-primary" form="addLaboratorio">Guardar</button>
      </div>
    </div>
  </div>
</div>
</form>