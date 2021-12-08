insert into categoria(codigo,nombre) values ("100","Electrodomésticos");
insert into categoria(codigo,nombre) values ("101","Deportes");
insert into categoria(codigo,nombre) values ("102","Ferreteria");
insert into categoria(codigo,nombre) values ("103","Ropa");


insert into ciudad values ("1","Armenia");
insert into ciudad values ("2","Pereira");
insert into ciudad values ("3","Manizales");
insert into ciudad values ("4","Bogotá");
insert into ciudad values ("5","Medellín");
-- persona

insert into persona values ("00001","smquinterol@uqvirtual.edu.co", "Sandra Quintero", "123shop","smquinterol@uqvirtual.edu.co");
insert into persona values ("00002","camilo_luz@gmail.com", "Camilo Ortega", "123shop", "camilo_luz@gmail.com");
insert into persona values ("00003","luisaMaria@hotmail.com", "Luisa Castro", "456shop","luisaMaria@hotmail.com");
insert into persona values ("00004","administrador2@unishop.com", "Alvaro Arias", "123shop", "administrador2@unishop.com");
insert into persona values ("00005","bdtabaresv@uqvirtual.edu.co", "Brahiam Tabares", "123shop", "bdtabaresv@uqvirtual.edu.co");
insert into persona values ("00006","carito_quindio@gmail.com", "Carolina Jimenez", "123456","carito_quindio@gmail.com");
insert into persona values ("1","admon@ishop.com", "root", "12345","admon@ishop.com");
insert into persona values ("2","prueba@prueba.com", "prueba", "12345","prueba@prueba.com");

-- administrador

insert into administrador values ("00001");
insert into administrador values ("00004");
insert into administrador values ("00005");
insert into administrador values ("1");
-- usuario

insert into usuario values ("00002","3");
insert into usuario values ("00003","1");
insert into usuario values ("00006","1");
insert into usuario values ("2","2");
-- telefono

insert into telefono values ("00002","1111111");
insert into telefono values ("00002","2222222");
insert into telefono values ("00003","3452132");
insert into telefono values ("00006","2345671");


-- producto

insert into producto values ("1357","Negro plasma HD GEN 5", 7, "2021-10-10", "Televisor LG", 1530000, 10, "2","00002");
insert into producto values ("2468","Juego de Llaves puro plomo", 10, "2021-10-20", "Llaves Inglesas", 52000, 40, "1","00002");
insert into producto values ("1236","Talla M Azul", 20, "2021-05-24", "Camibuso Jeff", 80000, 30, "1","00003");
insert into producto values ("1237","Procesador icore 5, plateado", 5, "2021-08-12", "Computador Dell", 1930000, 5, "3","00006");
insert into producto values ("1238","Azul, para adulto", 5, "2021-10-12", "Raqueta de Tenis Wilson", 130000, 15, "1","00002");

-- ProductoCategoria

insert into producto_categoria(codigo_categoria,codigo_producto) values ("100","1357");
insert into producto_categoria(codigo_categoria,codigo_producto) values ("103","1236");
insert into producto_categoria(codigo_categoria,codigo_producto) values ("102","2468");
insert into producto_categoria(codigo_categoria,codigo_producto) values ("101","1238");