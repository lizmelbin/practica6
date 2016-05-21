/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  tepcurso03
 * Created: May 21, 2016
 */


    CREATE TABLE etiqueta
    (
       idetiqueta bigINT AUTO_INCREMENT PRIMARY KEY  ,
       etiqueta VARCHAR(255)

    );


CREATE TABLE usuarios
(
   username  varchar(20) PRIMARY KEY,

  nombre  varchar(50),
  password  varchar(25),
 administrador  TINYINT(1),
 autor TINYINT(1)


);


CREATE TABLE articulo
( 
id bigint auto_increment primary key, 
titulo varchar(100), 
cuerpo text, 
autor varchar(20), 
fecha datetime, 
FOREIGN KEY (autor) 
        REFERENCES usuarios(username) 


);


CREATE TABLE comentario 
( 
id bigint auto_increment primary key,
comentario text ,
autor varchar(20),
 articulo bigint,
        FOREIGN KEY (autor)  REFERENCES usuarios(username),
 FOREIGN KEY (articulo)        REFERENCES articulos(id)



);

alter table etiqueta change idetiqueta id long;