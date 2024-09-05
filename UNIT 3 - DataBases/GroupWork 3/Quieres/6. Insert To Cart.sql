INSERT INTO cart(product_price, product_quantity, user_id, product_id) VALUES
((SELECT product_price FROM products WHERE id = 1) * 1, 1, 1, 1),
((SELECT product_price FROM products WHERE id = 2) * 1, 1, 1, 2),
((SELECT product_price FROM products WHERE id = 3) * 2, 2, 2, 3),
((SELECT product_price FROM products WHERE id = 4) * 3, 3, 3, 4),
((SELECT product_price FROM products WHERE id = 6) * 2, 2, 4, 6);

SELECT * FROM cart
