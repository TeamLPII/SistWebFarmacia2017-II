<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!-- Cuadro MODAL -->
                        <div class="modal fade" id="fm-editar" tabindex="-1" role="dialog" aria-labelledby="fm-modal" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <form id="mfrmeditaremp" action="ServletEmpleado?tipo=actualizar" method="post" accept-charset="UTF-8" >
                                <div class="modal-content">
                                
                                	
                                	
                                    <div class="modal-header">
                                        <h5 class="modal-title">Editar</h5>
                                        <button class="close" data-dismiss="modal" aria-label="Cerrar"><span aria-hidden="true">&times;</span></button>
                                    </div>
                                    <!--Modal Body-->
                                    
                                    <div class="modal-body">
                                        
                                        	
                                        		<input type="hidden" name="txteditcod" id="txteditcod" form="mfrmeditaremp" >
                                        	

                                            <div class="form-group row align-items-center">
                                                <label class="form-control-label col-lg-2 text-lg-right" for="txteditnombres">Nombres:</label>
                                                <div class="col-lg-10">
                                                    <input type="text" class="form-control" placeholder="Nombres" name="txteditnombres" id="txteditnombres" form="mfrmeditaremp">
                                                </div>
                                            </div>

                                            <div class="form-group row align-items-center">
                                                <label class="form-control-label col-lg-2 text-lg-right" for="txteditappaterno">Ap. Paterno:</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" placeholder="Ap. Paterno" name="txteditappaterno" id="txteditappaterno">
                                                </div>

                                                <label class="form-control-label col-lg-2 text-lg-right" for="txteditapmaterno">Ap. Materno:</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" placeholder="Ap. Materno" name="txteditapmaterno" id="txteditapmaterno">
                                                </div>
                                            </div>

                                            <div class="form-group row align-items-center">
                                                <label class="form-control-label col-lg-2  text-lg-right" for="txteditfechanac">Fecha de Nac.:</label>
                                                <div class="col-lg-4 ">
                                                    <input type="text" class="form-control dp-fecha" placeholder="yyyy/mm/dd" name="txteditfechanac" id="txteditfechanac">
                                                </div>

                                                <label class="form-control-label col-lg-2 t text-lg-right" for="txteditfechaing">Fecha de Ing.:</label>
                                                <div class="col-lg-4 ">
                                                    <input type="text" class="form-control dp-fecha" placeholder="yyyy/mm/dd" name="txteditfechaing" id="txteditfechaing">
                                                </div>
                                            </div>

                                            <div class="form-group row align-items-center align-items-center">
                                                <label class="form-control-label col-lg-2 text-lg-right" for="txteditusuario">Usuario:</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" placeholder="Usuario" name="txteditusuario" id="txteditusuario">
                                                </div>

                                                <label class="form-control-label col-lg-2 t text-lg-right" for="txteditclave">Clave:</label>
                                                <div class="col-lg-4">
                                                    <input type="password" class="form-control" placeholder="Clave" name="txteditclave" id="txteditclave">
                                                </div>
                                            </div>

                                            <div class="form-group row align-items-center">
                                                <label class="form-control-label col-lg-2 text-lg-right" for="txteditcargo">Cargo:</label>
                                                <div class="col-lg-4">
                                                    <!-- <input type="text" class="form-control " placeholder="Cargo" name="txteditcargo" id="txteditcargo"> -->
                                                    <select class="form-control" name="cmbeditcargo" id="cmbeditcargo">
                                                    </select>
                                                </div>

                                                <label class="form-control-label col-lg-2 text-lg-right" for="txtedittelefono">Teléfono:</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" placeholder="Teléfono" name="txtedittelefono" id="txtedittelefono">
                                                </div>
                                            </div>

                                        
                                    </div>
                                    
                                    <!--END Modal Body-->

                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                        <!-- <input type="submit" class="btn btn-success" value="Aceptar" onclick="$('#mfrmeditaremp').submit();"> -->
                                        <input type="submit" class="btn btn-success" value="Aceptar" form="mfrmeditaremp" >
                                    </div>
                                    
                                    

                                </div>
                                </form>
                            </div>

                        </div>
                        <!-- END Cuadro MODAL -->