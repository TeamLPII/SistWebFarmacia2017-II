  -- trigger de actualizacion
	create trigger tg_actualizar_stock
	after insert on detalleventa
	for each row
		update producto set producto.Stock = producto.Stock - new.Cantidad
        where producto.IdProducto=new.IdProducto;