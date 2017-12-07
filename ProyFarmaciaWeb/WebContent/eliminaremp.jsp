<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

                            <!-- Cuadro MODAL -->
                        <div class="modal fade" id="fm-delete" tabindex="-1" role="dialog" aria-labelledby="fm-modal" aria-hidden="true">
                        	
                            <div class="modal-dialog ">
                            <form action="ServletEmpleado?tipo=eliminar" id="mfrmeliminaremp" method="post">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Eliminar</h5>
                                        <button class="close" data-dismiss="modal" aria-label="Cerrar"><span aria-hidden="true">&times;</span></button>
                                    </div>
                                    <!--Modal Body-->
                                    <div class="modal-body">
                                        <div class="row" >
                                            <div class="col align-items-center ">
                                                <p> ¿Está seguro de eliminar al empleado con código
                                                	<input data-dismiss="modal" type="text" name="txtelimcod" id="txtelimcod" form="mfrmeliminaremp" size="1" readonly="readonly">
                                                ?</p>
                                            </div>
                                        </div>
                                    </div>
                                    <!--END Modal Body-->

                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                        <input type="submit" class="btn btn-success" id="btneliminaremp" form="mfrmeliminaremp" value="Eliminar" onclick="accionEliminarEmp()">
                                    </div>

                                </div>
                                </form>
                            </div>
                            

                        </div>
                        <!-- END Cuadro MODAL -->