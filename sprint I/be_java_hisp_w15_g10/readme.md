# Documentation
1. Init the project
2. Enter the page http://localhost:8080/swagger-ui.html#/

# Considerations
the application init whith the next data:
1. users:
```
   User user1 = new User(1, "Alejandro");
   User user2 = new User(2, "Camilo");
   User user3 = new User(3, "Luis");
```
2. Categories:
```
Category category1 = new Category(1, "Hogar");
Category category2 = new Category(2, "Ropa");
Category category3 = new Category(3, "Accesorios");
```
3. Posts
```
Post post1 = new Post(index++, productList.get(0), LocalDate.of(2022, 04, 25), categoryList.get(0), 1.09, false, 0);
Post post2 = new Post(index++, productList.get(1), LocalDate.now(), categoryList.get(1), 2.10, true, 0.5);
Post post3 = new Post(index++, productList.get(2), LocalDate.now(), categoryList.get(2), 1.99, false, 0);
Post post4 = new Post(index++, productList.get(3), LocalDate.now(), categoryList.get(0), 3.00, true, 0.4);
Post post5 = new Post(index++, productList.get(4), LocalDate.now(), categoryList.get(2), 2.98, true, 0.1);
```
4. 
```
Product product1 = new Product(  1, "Saco", "Mujer", "Koaj", "Rosado","notas");
Product product2 = new Product(  2, "Botella", "Vidrio", "Meli", "Azul","botella");
Product product3 = new Product(  3, "Silla", "Gamer", "Lenovo", "Amarillo","silla gamer");
Product product4 = new Product(  4, "Ventilador", "Pequeño", "Russ", "Verde","ventilador peque");
Product product5 = new Product(  5, "Equipo", "casa", "Huawei", "Negro","ultimos productos");
   ```



