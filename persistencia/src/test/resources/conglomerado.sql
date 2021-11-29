

-- Ciudad

insert into Ciudad values ("1","Armenia");
insert into Ciudad values ("2","Pereira");
insert into Ciudad values ("3","Manizales");
insert into Ciudad values ("4","Bogotá");
insert into Ciudad values ("5","Medellín");

-- Persona

insert into Persona values ("00001","administrador@unishop.com", "Sandra Quintero", "123shop","sandris");
insert into Persona values ("00002","camilo_luz@gmail.com", "Camilo Ortega", "123shop", "camilin");
insert into Persona values ("00003","luisaMaria@hotmail.com", "Luisa Castro", "456shop","luisita");
insert into Persona values ("00004","administrador2@unishop.com", "Alvaro Arias", "123shop", "alvarin");
insert into Persona values ("00005","administrador3@unishop.com", "Brahiam Tabares", "123shop", "brahims");
insert into Persona values ("00006","carito_quindio@gmail.com", "Carolina Jimenez", "123456","carolis");

-- Administrador

insert into Administrador values ("00001");
insert into Administrador values ("00004");
insert into Administrador values ("00005");

-- Usuario

insert into Usuario values ("00002","3");
insert into Usuario values ("00003","1");
insert into Usuario values ("00006","1");

-- telefono

insert into Telefono values ("00002","1111111");
insert into Telefono values ("00002","2222222");
insert into Telefono values ("00003","3452132");
insert into Telefono values ("00006","2345671");

-- compra

insert into Compra values ("001","2020-06-03", "TARJETA_CREDITO","00002" );
insert into Compra values ("002","2020-07-13", "TARJETA_DEBITO","00002" );
insert into Compra values ("003","2020-12-09", "NEQUI","00003" );
insert into Compra values ("004","2021-02-07", "TARJETA_CREDITO","00002" );
insert into Compra values ("005","2021-04-03", "TARJETA_CREDITO","00006" );

-- categoria

insert into Categoria values ("100","Electrodomésticos");
insert into Categoria values ("101","Deportes");
insert into Categoria values ("102","Ferreteria");
insert into Categoria values ("103","Ropa");

-- producto

insert into Producto values ("1357","Negro plasma HD GEN 5", 7, "2021-10-10", "Televisor LG", 1530000, 10, "2","00002");
insert into Producto values ("2468","Juego de Llaves puro plomo", 10, "2021-10-20", "Llaves Inglesas", 52000, 40, "1","00002");
insert into Producto values ("1236","Talla M Azul", 20, "2021-05-24", "Camibuso Jeff", 80000, 30, "1","00003");
insert into Producto values ("1237","Procesador icore 5, plateado", 5, "2021-08-12", "Computador Dell", 1930000, 5, "3","00006");
insert into Producto values ("1238","Azul, para adulto", 5, "2021-10-12", "Raqueta de Tenis Wilson", 130000, 15, "1","00002");

-- DetalleCompra

insert into Detalle_Compra values ("1",1600000,1, "001", "1357");
insert into Detalle_Compra values ("2",60000,2, "001", "2468");
insert into Detalle_Compra values ("3",95000,4, "002", "1236");
insert into Detalle_Compra values ("4",10000,3, "003", "1236");
insert into Detalle_Compra values ("5",160000,1, "004", "1238");
insert into Detalle_Compra values ("6",60000,2, "005", "2468");

-- Favorito

insert into Favorito values ("1357","00002");
insert into Favorito values ("2468","00002");
insert into Favorito values ("1236","00003");
insert into Favorito values ("1357","00003");
insert into Favorito values ("1238","00003");

-- Comentario

insert into Comentario values ("1",4,"2021-10-29","Tardó en llegar el pedido a Pereira", null ,"1357","00002");
insert into Comentario values ("2",5,"2021-10-29","Llegò a tiempo", "Estamos para servirle","2468","00002");
insert into Comentario values ("3",5,"2021-09-20","Tienen el producto en color rojo", "Si claro, tenemos ese color","1238","00003");
insert into Comentario values ("4",5,"2021-10-25","Excelente el producto", "Nos alegra que le haya gustado","1357","00006");

-- subasta

insert into Subasta values ("10","2021-10-20","1236");
insert into Subasta values ("20","2021-09-13","1238");
insert into Subasta values ("30","2021-10-23","1237");
insert into Subasta values ("40","2021-09-13","1238");

-- subastaUsuario

insert into Subasta_Usuario values ("1","2021-10-10",150000,"10","00006");
insert into Subasta_Usuario values ("2","2021-09-02",50000,"20","00003");
insert into Subasta_Usuario values ("3","2021-10-04",150000,"30","00006");

-- imagen

insert into Imagen values ("1357","ruta1");
insert into Imagen values ("2468","ruta2");
insert into Imagen values ("1236","ruta3");
insert into Imagen values ("1237","ruta4");
insert into Imagen values ("1238","ruta5");

-- ProductoCategoria

insert into producto_categoria values ("100","1357");
insert into producto_categoria values ("103","1236");
insert into producto_categoria values ("102","2468");
insert into producto_categoria values ("100","1237");
insert into producto_categoria values ("101","1238");

-- chat

insert into Chat values ("1","00002");
insert into Chat values ("2","00003");
insert into Chat values ("3","00006");

-- Mensaje

insert into Mensaje values ("1","David","2021-02-05", "Hola, tienen ipods","1");
insert into Mensaje values ("2","Milena","2021-05-14", "Me pueden ayudar con disponiblidad","2");
insert into Mensaje values ("3","Juan","2021-08-25", "Buenas noches","3");

-- Envio
insert into Envio(codigo,fecha_envio,nombre_empra_transporta,direccion_origen,direccion_destino,compra_codigo) values ("12","2021-12-01","cordinadora","Medellin calle 16 local 1","Cali barrio esperanza mz 2 casa 1","004");
insert into Envio(codigo,fecha_envio,nombre_empra_transporta,direccion_origen,direccion_destino,compra_codigo) values ("22","2021-11-30","Envia","Pereira  crr  25  local 6","Armenia  barrio la virginia mz b casa 12","003");
insert into Envio(codigo,fecha_envio,nombre_empra_transporta,direccion_origen,direccion_destino,compra_codigo) values ("54","2021-12-25","servientrega","Bogota  calle 4 local 10"," Medellin  mz c casa 15","005");

