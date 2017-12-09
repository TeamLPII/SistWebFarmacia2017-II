//cargarCombos
cargarCombos=function(){
	$.ajax({
		url:'ServletProducto',
		type:'get',
		data:'tipo=listarCategoria',
		datatype:'json',
		success:function(datos){
			if(datos !=''){
				limpiarComboCat();
				for(var i=0; i<=datos.length;i ++){
					var cod_cat = datos[i].cod_cat;
					var nom_cat = datos[i].nom_cat;
					$('#cmbCategoria').append('<option value="'+datos[i].cod_cat+'">'+datos[i].nom_cat+'</option>');
				}
			}
		}
		
	});
	
	$.ajax({
		url:'ServletProducto',
		type:'get',
		data:'tipo=listarLaboratorio',
		datatype:'json',
		success:function(datos2){
			if(datos2 !=''){
				limpiarComboLab();
				for(var i=0; i<=datos2.length;i ++){
					var cod_lab = datos2[i].cod_lab;
					var nom_lab = datos2[i].nom_lab;
					$('#cmbLaboratorio').append('<option value="'+datos2[i].cod_lab+'">'+datos2[i].nom_lab+'</option>');
				}
			}
		}
		
	});
	
	function limpiarComboCat(){
		$('#cmbCategoria option').remove();
	}
	function limpiarComboLab(){
		$('#cmbLaboratorio option').remove();
	}
};
//cargar datos al modal editaProducto
cargarProducto=function(cod,nom,precio,stock,cat,lab){
	$('#txt_cod').val(cod);
	$('#txt_nom').val(nom);
	$('#txt_pre').val(precio);
	$('#txt_stock').val(stock);
	
	$.ajax({
		url:'ServletProducto',
		type:'get',
		data:'tipo=listarCategoria',
		datatype:'json',
		success:function(datos){
			if(datos !=''){
				limpiarComboCat();
				for(var i=0; i<=datos.length;i ++){
					var cod_cat = datos[i].cod_cat;
					var nom_cat = datos[i].nom_cat;
					$('#cmbeditCategoria').append('<option value="'+datos[i].cod_cat+'">'+datos[i].nom_cat+'</option>');
				}
				$('#cmbeditCategoria option[value='+cat+']').attr("selected", true);
			}
		}
		
	});
	
	$.ajax({
		url:'ServletProducto',
		type:'get',
		data:'tipo=listarLaboratorio',
		datatype:'json',
		success:function(datos2){
			if(datos2 !=''){
				limpiarComboLab();
				for(var i=0; i<=datos2.length;i ++){
					var cod_lab = datos2[i].cod_lab;
					var nom_lab = datos2[i].nom_lab;
					$('#cmbeditLaboratorio').append('<option value="'+datos2[i].cod_lab+'">'+datos2[i].nom_lab+'</option>');
				}
				$('#cmbeditLaboratorio option[value='+lab+']').attr("selected", true);
			}
		}
		
	});
	
	function limpiarComboCat(){
		$('#cmbeditCategoria option').remove();
	}
	function limpiarComboLab(){
		$('#cmbeditLaboratorio option').remove();
	}
};
//cargarDatos al modal eliminarProducto
eliminarProducto=function(cod,nombre){
	limpiarNombre();
	$('#txtcodPro').val(cod);
	$('#nomPro').append('<a class="alert-link"> '+nombre+' </a>');
	
	function limpiarNombre(){
		$('#nomPro a').remove();
	}
};