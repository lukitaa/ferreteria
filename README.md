Ferreteria
==========

Software para la administración y compra de artículos de una ferretería.  
Sistema desarrollado con Java Servlets.

#Requisítos

 - Java: *JDK 1.7 or higher*
 - Server: *Apache Tomcat 7*
 - DB: *MySQL 5.5 or higher*

#Instalación

**Aún no completada**, pero los pasos por el momento son los siguientes.

 0. Ejecuta el archivo `./ferreteria/db/install.sql` sobre MySQL
 1. Añade las dependencias al proyecto:
   1. MySQL driver
 2. Ingresa el usuario y la contraseña de MySQL en el archivo `./Ferreteria/src/java/DAO/database.java`
 3. Deberás ingresar manualmente datos pre-cargados, como usuarios y productos.

#Autores

Luca Giordano y Lucio Martínez.

#Licencia

Copyright (C) 2014 Luca Giordano, Lucio Martínez.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
