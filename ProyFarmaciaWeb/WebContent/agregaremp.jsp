<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Cuadro MODAL -->
                        <div class="modal fade" id="fm-modal" tabindex="-1" role="dialog" aria-labelledby="fm-modal" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                            <form action="ServletEmpleado?tipo=registrar" id="mfrmaddempleado" method="post" >
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Agregar Empleado</h5>
                                        <button class="close" data-dismiss="modal" aria-label="Cerrar"><span aria-hidden="true">&times;</span></button>
                                    </div>
                                    <!--Modal Body-->
                                    <div class="modal-body">
                                        

                                            <div class="form-group row align-items-center">
                                                <label class="form-control-label col-lg-2 text-lg-right" for="txtaddnombres">Nombres:</label>
                                                <div class="col-lg-10">
                                                    <input type="text" class="form-control" placeholder="Nombres" name="txtaddnombres" id="txtaddnombres">
                                                </div>
                                            </div>

                                            <div class="form-group row align-items-center">
                                                <label class="form-control-label col-lg-2 text-lg-right" for="txtaddappaterno">Ap. Paterno:</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" placeholder="Ap. Paterno" name="txtaddappaterno" id="txtaddappaterno">
                                                </div>

                                                <label class="form-control-label col-lg-2 text-lg-right" for="txtaddapmaterno">Ap. Materno:</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" placeholder="Ap. Materno" name="txtaddapmaterno" id="txtaddapmaterno">
                                                </div>
                                            </div>

                                            <div class="form-group row align-items-center">
                                                <label class="form-control-label col-lg-2  text-lg-right" for="txtaddfechanac">Fecha de Nac.:</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control dp-fecha" placeholder="yyyy-mm-dd" name="txtaddfechanac" id="txtaddfechanac">
                                                </div>

                                                <label class="form-control-label col-lg-2 t text-lg-right" for="txtaddfechaing">Fecha de Ing.:</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control dp-fecha" placeholder="yyyy-mm-dd" name="txtaddfechaing" id="txtaddfechaing">
                                                </div>
                                            </div>

                                            <div class="form-group row align-items-center align-items-center">
                                                <label class="form-control-label col-lg-2 text-lg-right" for="txtaddusuario">Usuario:</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" placeholder="Usuario" name="txtaddusuario" id="txtaddusuario">
                                                </div>

                                                <label class="form-control-label col-lg-2 t text-lg-right" for="txtaddclave">Clave:</label>
                                                <div class="col-lg-4">
                                                    <input type="password" class="form-control" placeholder="Clave" name="txtaddclave" id="txtaddclave">
                                                </div>
                                            </div>

                                            <div class="form-group row align-items-center">
                                                <label class="form-control-label col-lg-2 text-lg-right" for="cmbaddcargo">Cargo:</label>
                                                <div class="col-lg-4">
                                                    <!--<input type="text" class="form-control " placeholder="Cargo" name="txtcargo" id="txtcargo">-->
                                                    <select id="cmbaddcargo" name="cmbaddcargo" class="form-control cmbaddcargo">
                                                        <option value="administrador">Administrador</option>
                                                        <option value="vendedor">Vendedor</option>

                                                    </select>
                                                </div>

                                                <label class="form-control-label col-lg-2 text-lg-right" for="txtaddtelefono">Teléfono:</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" placeholder="Teléfono" name="txtaddtelefono" id="txtaddtelefono">
                                                </div>
                                            </div>

                                        
                                    </div>
                                    <!--END Modal Body-->
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                        <input type="submit" class="btn btn-success guardaremp" id="saveemp" form="mfrmaddempleado" value="Guardar">
                                    </div>
                                    

                                </div>
                                </form>
                            </div>

                        </div>
                        <!-- END Cuadro MODAL -->