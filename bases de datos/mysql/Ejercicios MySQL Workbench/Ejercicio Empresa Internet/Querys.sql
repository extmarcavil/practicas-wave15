-- 1) 
SELECT * FROM cliente;

-- 2) 
SELECT * FROM plan;

-- 3)
SELECT c.nombre, c.provincia, p.id_plan, p.megas FROM cliente c
INNER JOIN plan p ON c.id_plan = p.id_plan;

-- 4)
SELECT p.id_plan, count(c.id_plan) cuenta FROM cliente c 
INNER JOIN plan p ON c.id_plan = p.id_plan
GROUP BY p.id_plan
HAVING cuenta > 2;

-- 5)
SELECT c.*, p.id_plan FROM cliente c 
LEFT JOIN plan p ON c.id_plan = p.id_plan
WHERE c.nombre IN (SELECT nombre FROM cliente WHERE provincia = "Cordoba");

-- 6)
SELECT * FROM cliente c 
WHERE c.id_plan = (SELECT id_plan FROM plan WHERE megas = "50")
order by c.nombre;

-- 7)
SELECT * FROM cliente c 
WHERE c.id_plan = (SELECT id_plan FROM plan WHERE megas = "50")
order by c.nombre;

-- 8)
SELECT nombre, fecha_nacimiento FROM cliente
ORDER BY fecha_nacimiento ASC;

-- 9)
SELECT nombre, apellido FROM cliente
LIMIT 5;

-- 10)
SELECT nombre, apellido FROM cliente
WHERE id_plan = (SELECT id_plan FROM plan WHERE megas = "200")
ORDER BY dni DESC
LIMIT 1;