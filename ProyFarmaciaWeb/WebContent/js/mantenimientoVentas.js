/**
 * 
 */
//var availableTags = new Array();
$(document).ready(function () {
	llenarCombo();
	//convertir a Tabla a Json
	$('#btngenerarordenventa').on('click',function(){
		var convertTablaToJson = function() {
			var rows = [];
			$('#tbldetalleventa tbody tr').each(function(i,n) {
				var $row = $(n);
				rows.push({
					idOrdenVenta: $('#txtcodventa').val(),
					idproducto: $row.find('td:eq(0)').text(),
					/*producto: $row.find('td:eq(1)').text(),*/
					cantidad: $row.find('td:eq(2)').text(),
					monto: $row.find('td:eq(4)').text()
				});
			});
			return JSON.stringify(rows);
		};
		/*var jsonVenta = '{"OrdenVenta":['+
				'{"idOrdenVenta": "", "fechaOrden":}'
			}';*/		

		//función venta
		$(function(){
			console.log(convertTablaToJson ());
			$.ajax({
				url: 'ServletOrdenVenta',
				type: 'GET',
				datatype: 'json',
				data: "tipo=insVenta&idcliente="+$('#txtcodcliente').val()+"&fecha="+$('#txtfechaventa').val()+"&idempleado="+$('#txtcodempleado').val(),
				//contentType: 'application/json',
				//mimeType: 'application/json',
				success: function(datos) {
					console.log(datos);
				},
				error:function(data,status,er){
					alert("error: "+data+" status: "+status+" er:"+er);
				}
			});
		});
		
		//Fin función venta
		
		$(function(){
			console.log(convertTablaToJson ());
			$.ajax({
				url: 'ServletOrdenVenta',
				type: 'POST',
				datatype: 'json',
				data: convertTablaToJson(),
				contentType: 'application/json',
				mimeType: 'application/json',
				success: function(datos) {
					console.log(datos);
				},
				error:function(data,status,er){
					alert("error: "+data+" status: "+status+" er:"+er);
				}
			});
		});//Fin función
		
		
	});
	
	$('#btnadddetalle').on('click',function(){
		//limpiarTablaEmp();
		console.log("ene el evnto del voton");
		var importe = parseFloat( $('#txtcantidad').val())*parseFloat( $('#txtprecio').val());
		console.log($('#txtcantidad').val());
		console.log($('#txtprecio').val());
		console.log(importe);
		var accion = "elimnar";
		var cadena = "<tr class='dato'><td>"+$('#txtcodproducto').val()+"</td>";
		cadena = cadena + "<td>"+$('#txtproducto').val()+"</td>";
		cadena = cadena + "<td>"+$('#txtcantidad').val()+"</td>";
		cadena = cadena +"<td>"+$('#txtprecio').val()+"</td>";
		cadena = cadena + "<td>"+importe+"</td>";
		cadena = cadena + "<td><a href= '#' class='elimina'>"+accion+"</a></td></tr>";
		console.log(cadena);
		$('#tbldetalleventa tbody').append(cadena);
		/*$('#tbldetalleventa tbody').append('<tr><td>'+$('#txtcodproducto').val()+'</td>'+
				'<td>'+$('#txtproducto').val()+'</td>'+
				'<td>'+$('#txtcantidad').val()+'</td>'+
				'<td>'+$('#txtprecio').val()+'</td>'+
				'<td>'+importe+'</td>'+
				'<td>'+accion+'</td></tr>');*/
		fn_suma_total();
		/*var subtotal = parseFloat( fn_sumar_subtotal());
		$('#txtsubtotal').val(subtotal);*/
		fn_eliminar_fila();
		
	});
	
	/*$('#cmbproductos').on('change', function() {
		$.ajax({
			url: 'ServletProducto',
			data: 'tipo=buscarProJson&cod='+$('#cmbproductos').val(),
			success: function(datos) {
				if(datos != ''){
					$('#txtstock').val(datos.stk_prod);
					$('#txtprecio').val(datos.pre_prod);
					$('#txtcodproducto').val(datos.cod_prod)
				}
			}
		});
	});*/
	$('#cmbproductos').change(function() {
		alert($('#cmbproductos').val());
	});
	
	$('#btnbuscardni').on('click',function(){
		
		//alert('En la función del botón');
		$.ajax({
			url: 'ServletCliente',
			type: 'get',
			data: "tipo=buscarDNI&dni="+$('#txtdni').val(),
			datatype: 'json',			
			success: function(datos) {			
				if(datos != ''){
					try{
					var id = datos.idCliente;
					var nombre = datos.nombre;
					var apellido1 = datos.primerApellido;
					var apellido2 = datos.segundoApellido;
					/*console.log(id);
					console.log(nombre);
					console.log(apellido1);
					console.log(apellido2);*/
					
					$('#txtcodcliente').val(id);
					$('#txtcliente').val(nombre+' '+apellido1+' '+apellido2);
					
					$.ambiance({
					       message: "Se encontró el cliente",
					       title: "Éxito! ",
					       type: "success"
					});
					}catch (e) {
						console.log(e instanceof TypeError); // true
						  console.log(e.message);              // "null has no properties"
						  console.log(e.name);                 // "TypeError"
						  console.log(e.fileName);             // "Scratchpad/1"
						  console.log(e.lineNumber);           // 2
						  console.log(e.columnNumber);         // 2
						  console.log(e.stack);                // "@Scratchpad/2:2:3\n"
						  $.ambiance({
						       message: "No se encontró el cliente",
						       title: "Error! ",
						       type: "error"
						});
					}
					
				}//fin if
			},
			error: function(XMLHttpRequest, textStatus, errorThrown, request) {
				$.ambiance({
				       message: "No se encontró el cliente",
				       title: "Error! ",
				       type: "error"
				});
			}
		});
	});
	
	//Autocompletado
	
	/*$("#txtproducto").bind("keydown",function(event){
		$.ajax({
			url: 'ServletProducto',
			type: 'get',
			data: "tipo=buscarPorJson&term="+$('#txtproducto').val(),
			datatype: 'json',			
			success: function(datos) {				
				availableTags.length = 0;
				for(var i=0; i<datos.length; i++){
					//var idcargo = datos[i].idCargo;
					//var nombre = datos[i].nombre;
					availableTags = datos[i].nom_prod;
					//$('.cmbaddcargo').append('<option value="'+datos[i].idCargo+'">'+datos[i].nombre+'</option>');
				}
			}
		});*/
		/*var data = {term:$("txtproducto").val()};
		$.getJSON("ServletProducto?tipo=buscarPorJson", data, function(res,est,jqXMR){
			availableTags.length = 0;
			$.each(res, function(i, item) {
				availableTags[i] = item;
			});
		});*/
	//});
	
	
});

llenarCombo=function(){
	$.ajax({
		url: 'ServletProducto',
		type: 'get',
		data: "tipo=listarPorJson",
		datatype: 'json',
		success: function(datos) {
			if(datos != ''){
				limpiarComboCargo();
				
				for(var i=0; i<datos.length; i++){
					var idcargo = datos[i].cod_prod;
					var nombre = datos[i].nom_prod;
					
					$('#cmbproductos').append('<option value="'+datos[i].cod_prod+'">'+datos[i].nom_prod+'</option>');
				}
			}//fin if
		}
	}); //fin Ajax
	
	function limpiarComboCargo(){
		$('.cmbaddcargo option').remove();
	}
};
/*buscarEmpleado=function(){
	$.ambiance({
	       message: "Prueba del mensaje",
	       title: "Éxito! En la función del botón",
	       type: "success"
	});
	alert('En la función del botón');
}*/
function limpiarTablaEmp(){
	$('#tbldetalleventa tbody tr').remove();
}
function fn_eliminar_fila(){
	$("a.elimina").click(function(){
        id = $(this).parents("tr").find("td").eq(0).html();
        respuesta = confirm("Desea eliminar el usuario: " + id);
        if (respuesta){
            $(this).parents("tr").fadeOut("normal", function(){
                $(this).remove();
                alert("Usuario " + id + " eliminado");
                //$('#txtsubtotal').val(parseFloat( fn_sumar_subtotal()));
                fn_suma_total();
                /*
                    aqui puedes enviar un conjunto de datos por ajax
                    $.post("eliminar.php", {ide_usu: id})
                */
            });
        }
    });
	//var subtotal = parseFloat( fn_sumar_subtotal());
	//$('#txtsubtotal').val(subtotal);
}
function fn_sumar_subtotal(){
	var suma = 0;
	$('#tbldetalleventa tr.dato').each(function() {
		suma += parseFloat($(this).find('td').eq(4).text()); 
	});
	return suma;
}
function fn_calculo_igv(){
	/*var igv = 
	return 0;*/
}
function fn_suma_total(){
	var suma = 0;
	$('#tbldetalleventa tr.dato').each(function() {
		suma += parseFloat($(this).find('td').eq(4).text()); 
	});
	//return suma;
	var neto = parseFloat(parseFloat( suma)/parseFloat(1.18)).toFixed(2);
	var igv = parseFloat(parseFloat(suma) - parseFloat(neto)).toFixed(2);
	$('#txtigv').val(igv);
	$('#txtsubtotal').val(neto);
	$('#txttotal').val(suma);
}