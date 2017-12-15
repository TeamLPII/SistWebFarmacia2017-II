/**
 * 
 */

//Función para los parámetros en el modal EDITAR EMP


	$(document).ready(function () {
		$('#cmbusercargo option[value="<%=empleado.getCargo().getIdCargo()%>"]').attr('selected', true);
		//Cuando se cierre el modal
		/*$("#fm-delete").on('hidden.bs.modal',function(){
			$.ambiance({
			       message: "Prueba del mensaje",
			       title: "Éxito! Borrado correctamente",
			       type: "success"
			    });
		});*/
		$('#btneliminaremp').on('click',function(){
			$.ambiance({
			       message: "Prueba del mensaje",
			       title: "Éxito! Borrado correctamente",
			       type: "success"
			    });
		});
	});


selEmpleado=function(id, nombre, appaterno, apmaterno, fecnac, fecing, usuario, pass, cargo, telefono){
	$('#txteditcod').val(id);
	$('#txteditnombres').val(nombre);
	$('#txteditappaterno').val(appaterno);
	$('#txteditapmaterno').val(apmaterno);
	$('#txteditfechanac').val(fecnac);
	$('#txteditfechaing').val(fecing);
	$('#txteditusuario').val(usuario);
	$('#txteditclave').val(pass);
	//$('#txteditcargo').val(cargo);
	$('#txtedittelefono').val(telefono);
	
	console.log(id);
	
	$.ajax({
		url: 'ServletEmpleado',
		type: 'get',
		data: "tipo=listarCargo",
		datatype: 'json',
		success: function(datos) {
			if(datos != ''){
				limpiarComboCargo();
				
				for(var i=0; i<datos.length; i++){
					var idcargo = datos[i].idCargo;
					var nombre = datos[i].nombre;
					
					$('#cmbeditcargo').append('<option value="'+datos[i].idCargo+'">'+datos[i].nombre+'</option>');
				}
				
				$('#cmbeditcargo option[value='+cargo+']').attr("selected", true);
			}//fin if
		}
	}); //fin Ajax
	
	function limpiarComboCargo(){
		$('#cmbeditcargo option').remove();
	}
	
};
var codigoE;

elimEmpleado=function(id){
	codigoE = id
	console.log(codigoE);
	
	$('#txtelimcod').val(id);
	
	$("#fm-delete").modal("show");
	
	$("#btneliminaremp").click(function() {
		$("#fm-delete").modal("hide");
		
		
	});
	
	
	
	/*
	$("#fm-delete").on('hidden.bs.modal',function(){
		alert("se va eliminar");
		$.ajax({
			url: 'ServletEmpleado',
			type: "GET",
			data: "tipo=eliminar&cod="+codigoE,
			datatype: "json",
			success: function(datos){
				
				if(datos != ''){
					limpiarTabla();
					for(var i=0; i<datos.length; i++){
						$('#tblempleados').append('<tr>'
								+'<td>'+datos[i].idEmpleado+'</td>'
								+'<td>'+datos[i].nombre+'</td>'
								+'<td>'+datos[i].primerAp+'</td>'
								+'</tr>');						
					}
				}//fin if
			}
			
		});
		
		function limpiarTabla(){
			$('#tblempleados tr').remove();
		}
	});
	*/
};

getfrmaddemp = function() {
	$.ajax({
		url: 'ServletEmpleado',
		type: 'get',
		data: "tipo=listarCargo",
		datatype: 'json',
		success: function(datos) {
			if(datos != ''){
				limpiarComboCargo();
				
				for(var i=0; i<datos.length; i++){
					var idcargo = datos[i].idCargo;
					var nombre = datos[i].nombre;
					
					$('.cmbaddcargo').append('<option value="'+datos[i].idCargo+'">'+datos[i].nombre+'</option>');
				}
			}//fin if
		}
	}); //fin Ajax
	
	function limpiarComboCargo(){
		$('.cmbaddcargo option').remove();
	}
};


filtrarEmp = function() {
	var filtro = $('#txtfiltraremp').val();
	
	$.ajax({
		url: 'ServletEmpleado',
		type: 'get',
		data: 'tipo=filtrar&filtro='+filtro,
		success:function(datos){
			if(datos != ''){
				limpiarTablaEmp();
				$('#tblempleados tbody').append(datos);
			}
		}
	}); //Fin ajax
	
	function limpiarTablaEmp(){
		$('#tblempleados tbody tr').remove();
	}
}


/*$(document).ready(function () {

	$('#mfrmeditaremp').on('submit', function(e) {
	e.preventDefault();
	$.ajax({
		url: $(this).attr('action'),
		type: $(this).attr('method'),
		data: {data:$(this).serializeArray()}
	})
	.done(function(response) {
		if(response.status == "OK"){
			$('.modal').modal('hide');
		}else{
			console.log('Error de actrualización');
		}
	});
});
});*/

$('.dp-fecha').datetimepicker({
	language: "es",
	todayBtn: 1,
	autoclose: 1,
	format: 'yyyy-mm-dd',
	startView: 2,
	minView: 2,
	todayHighlight: true
});

/*document.getElementsByClassName('.dp-fecha').datepicker({
	language: "es",
	autoclose: true
});*/
