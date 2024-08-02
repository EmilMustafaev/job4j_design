SELECT * FROM customers
	WHERE age = (SELECT MIN(age) FROM customers);
