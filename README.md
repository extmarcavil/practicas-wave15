
# be_java_hisp_w15_g06
​
Objetivo: Aplicar los contenidos dados hasta el momento durante el BOOTCAMP MeLi (Git, Java y Spring), con la finalidad de poder implementar una API REST a partir de un enunciado propuesto, una especificación de requisitos y documentación anexada.
​

​

## Requerimientos: 


- US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
- US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
- US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
- US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
- US 0005: Dar de alta una nueva publicación
- US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
- US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
- US 0008: Ordenamiento alfabético ascendente y descendente
- US 0009: Ordenamiento por fecha ascendente y descendente

 https://docs.google.com/document/d/1Q-xGaOMPij-qk_gMvcN0Sk0isbCPqjJS/edit

## Miembros

- Alvarez, Matias;
- Leonetti, Julieta;
- Bazzano, Silvia;
- Pichetti, Gonzalo;
- Vilte, Ali;
- Vitale, Nicolás;


## Consideraciones

- El código se ha definido que se escriba en inglés para mantener su coherencia; 
- Se decidió que los usuarios tendrán dos listas (Followed and Followers) 
- Se decidió que los POST serán valores de User
- Utilizamos @DefaultValue por delante de @RequestParam 
- Distincion de paquetes dentro de DTO para response y request 
- Utilizamos SuccessDTO para enviar los mensajes de éxito
- Por convención, se decidió utilizar DTO en mayúscula en todos los casos.
- Hicimos el mapper de manera manual.
- Creamos un bean nuevo para poder adaptar el formato dd-MM-yyyy custom
- Realizamos 5 excepciones para tratar algunas validaciones

## 🔗 Github Links
- https://github.com/extmarcavil/practicas-wave15/tree/leonetti_julieta/
- https://github.com/extmarcavil/practicas-wave15/tree/vilte_ali/
- https://github.com/extmarcavil/practicas-wave15/tree/bazzano_silvia/
- https://github.com/extmarcavil/practicas-wave15/tree/pichetti_gonzalo/
- https://github.com/extmarcavil/practicas-wave15/tree/alvarez_matias/
- https://github.com/extmarcavil/practicas-wave15/tree/vitale_nicolas



