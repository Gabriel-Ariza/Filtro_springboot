DROP DATABASE IF EXISTS inmobiliaria;
CREATE DATABASE IF NOT EXISTS inmobiliaria;
USE inmobiliaria;


/*  ----* LLENANDO LA TABLA CLIENTE *----  */
INSERT INTO cliente (id_cliente, nombre, apellido, telefono, correo) VALUES
(1, 'Juan', 'Perez', '3162694149', 'Juan.Perez@gmail.com'),
(2, 'emily', 'cortes', '3212693781', 'emily.cortes@gmail.com'),
(3, 'carlos', 'pedraza', '3162698297', 'carlos.pedraza@gmail.com'),
(4, 'ruth', 'victoria', '3162694124', 'ruth.victoria@gmail.com'),
(5, 'brayan', 'rey', '3153694169', 'brayan.rey@gmail.com'),
(6, 'mariana', 'bayondo', '3162694915', 'mariana.bayondo@gmail.com'),
(7, 'nicolas', 'cardona', '3185894168', 'nicolas.cardona@gmail.com');

INSERT INTO cliente (id_cliente, nombre, apellido, telefono, correo) VALUES
(8, 'njibeg', 'cardona', '3185894168', 'nicolas.cardona@gmail.com');


/*  ----? LLENANDO LA TABLA ESTANCIA ?----  */
INSERT INTO estancia (id_estancia, nombre) VALUES
(1, 'habitaciones'),
(2, 'baños'),
(3, 'cocinas'),
(4, 'aseos'),
(5, 'jacuzzi'),
(6, 'balcon'),
(7, 'parqueadero');


/*  ----* LLENANDO LA TABLA INMUEBLE *----  */
INSERT INTO inmueble (id_inmueble, codigo, nuevo, superficie, urbanizacion, direccion, caracteristicas, nom_propietario, tel_propietario, precio, ofrecido_como) VALUES
(1, 'JUN765', FALSE, 92, 'cabecera', 'cra 32 110-40', 'cerca al colegio la presentacion', 'Juan Velasquez', '3165708084', 240000000, 0),
(2, 'NEQ039', TRUE, 80, 'provenza', 'cra 19 90-17', 'cerca al colegio inem', 'Maria Martinez', '3162698297', 190000000, 0),
(3, 'UWU999', TRUE, 150, 'lagos del cacique', 'calle 28 80-16', 'cerca al centro comercial', 'Diego neiva', '3162694915', 460000000, 0),
(4, 'JUN765', FALSE, 70, 'naranjos', 'cale 24 90-14', 'cerca al colegio la presentacion', 'Carlos Pedraza', '3185894168', 900000, 1),
(5, 'NEQ039', TRUE, 86, 'provenza', 'cra 31 20-8', 'cerca a la 105', 'Ruth Victoria', '3162694149', 1200000, 1),
(6, 'UWU999', TRUE, 120, 'mutis', 'calle 29 118-16', 'cerca al colegio la salle', 'Nicolas Cardona', '3153694169', 2100000, 1);


/*  ----? LLENANDO LA TABLA ESTANCIA_INMUEBLE ?----  */
INSERT INTO estancia_inmueble (id_inmueble, id_estancia) VALUES
(1, 1),
(1, 1),
(1, 1),
(1, 1),
(1, 1),
(1, 1),
(1, 1);

INSERT INTO estancia_inmueble (id_inmueble, id_estancia) VALUES
(1, 2),
(1, 3);

/*  ----? LLENANDO LA TABLA VISITA ?=----  */
INSERT INTO visita (id_visita, fecha, comentario, id_cliente) VALUES
(1, '2023-03-20', 'visita de cortesia', 1),
(2, '2023-03-21', 'visita de cortesia', 2),
(3, '2023-03-22', 'visita de cortesia', 3),
(4, '2023-03-23', 'visita de cortesia', 4),
(5, '2023-03-24', 'visita de cortesia', 5),
(6, '2023-03-25', 'visita de cortesia', 6),
(7, '2023-03-26', 'visita de cortesia', 7);


/*  ----* LLENANDO LA TABLA INMUEBLE *----  */
INSERT INTO oficina (id_oficina, direccion, urbanizacion) VALUES
(1, 'cra 32 110-40', 'cabecera'),
(2, 'cra 19 90-17', 'provenza'),
(3, 'calle 28 80-16', 'lagos del cacique'),
(4, 'cale 24 90-14', 'naranjos'),
(5, 'cra 31 20-8', 'provenza'),
(6, 'calle 29 118-16', 'mutis');


/*  ----? LLENANDO LA TABLA USUARIOS ?----  */
INSERT INTO usuario (id, email, pwd) VALUES
(1, 'juan.perez@example.com', 'juan'),
(2, 'maria.rodriguez@example.com', 'maria'),
(3, 'carlos.garcia@example.com', 'carlos'),
(4, 'ana.martinez@example.com', 'ana'),
(5, 'root@administrator.com', 'jose');


/*  ----* LLENANDO LA TABLA ROLES *----  */
INSERT INTO roles (role_name, description) VALUES 
('ROLE_ADMIN', 'permiso en todo el sistema'),
('ROLE_AUXILIAR', 'permiso de consulta de datos'),
('ROLE_DIRECTOR', 'gestionar clientes y visitas');


/*  ----? LLENANDO LA TABLA USUARIOS_ROLES ?----  */
INSERT INTO usuario_roles (roles_id, usuario_id) VALUES
(2, 1),
(3, 2),
(1, 5);

SELECT COUNT(*) as cantidad FROM estancia_inmueble WHERE id_inmueble = 1;
SELECT DISTINCT e.nombre FROM estancia e JOIN estancia_inmueble ei ON e.id_estancia = ei.id_estancia JOIN inmueble i ON ei.id_inmueble = i.id_inmueble WHERE i.id_inmueble = 1;


SELECT COUNT(*) AS cantidad, e.nombre AS nombre FROM estancia e JOIN estancia_inmueble ei ON e.id_estancia = ei.id_estancia JOIN inmueble i ON ei.id_inmueble = i.id_inmueble WHERE i.id_inmueble = 1 GROUP BY e.nombre;