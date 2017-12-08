<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="ServletProducto?tipo=actualizar" id="frmactualizar" method="post">   
<div class="modal fade" id="frm-editar-producto" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">  
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">DATOS DEL PRODUCTO</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">  
      		<table align="center">
			<tr>
				<input type="hidden" name="txt_cod" id="txt_cod" form="frmactualizar" >
				<td>Nombre</td>
				<td><input type="text" name="txt_nom" id="txt_nom" class="form-control" ></td>
			</tr>
			<tr>

				<td>Precio</td>
				<td><input type="text" name="txt_pre" id="txt_pre" class="form-control" ></td>
			</tr>
			<tr>
				<td>Stock</td>
				<td><input type="text" name="txt_stock" id="txt_stock" class="form-control"></td>
			</tr>
			<tr>
				<td>Categoria</td>
				<td>
					<select id="cmbeditCategoria" name="cmbCategoria" class="form-control"></select>
				</td>
			</tr>
			<tr>
				<td>Laboratorio</td>
				<td>
					<select id="cmbeditLaboratorio" name="cmbLaboratorio" class="form-control"></select>
				</td>
			</tr>
		</table>
      		
      </div>
      <div class="modal-footer">
        <button id="btn-actualizar" type="submit" class="btn btn-primary" form="frmactualizar">Actualizar</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>        
      </div>
    </div>
  </div>
</div>
</form>