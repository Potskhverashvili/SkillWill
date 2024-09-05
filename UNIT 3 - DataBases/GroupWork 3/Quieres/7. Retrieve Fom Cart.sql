SELECT c.cart_id,
	   c.product_price,
       --(SELECT SUM(o2.paid_price) FROM orders o2 WHERE o2.user_id = u.id) AS total_paid_price,
	   c.product_quantity,
	   p.product_name AS product_name, p.id AS product_id, p.product_price AS original_price,  -- Additional product information
       u.id AS user_id, u.user_name AS user_name -- Additional user information
FROM cart c
JOIN users u ON c.user_id = u.id  -- Join orders with users on user ID
JOIN products p ON c.product_id = p.id
WHERE u.id = 4