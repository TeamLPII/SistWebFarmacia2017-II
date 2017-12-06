-- Edad
select IdEmpleado, Nombre, PrimerApellido, SegundoApellido, 
	floor(timestampdiff(day, FechaNacimiento, curdate())/365) as Edad,
	FechaIngreso, Usuario, Clave, IdCargo, Telefono
from empleado;

-- Filtro por nombr ey apellido EMPLEADO

select *
from empleado
where Nombre like 'algo%' or 
PrimerApellido like'ro%' or 
SegundoApellido like 'd%';

-- Alterando el campo de clave para el md5
ALTER TABLE bd_farmacia2017.empleado MODIFY COLUMN Clave varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ;
