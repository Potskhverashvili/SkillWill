SELECT o.order_id,
	   o.paid_price,
       (SELECT SUM(o2.paid_price) FROM orders o2 WHERE o2.user_id = u.id) AS total_paid_price,
	   o.product_quantity,
	   p.product_name AS product_name, p.id AS product_id, p.product_price AS original_price,  -- Additional product information
       u.id, u.user_name AS user_name -- Additional user information
FROM orders o
JOIN users u ON o.user_id = u.id  -- Join orders with users on user ID
JOIN products p ON o.product_id = p.id -- Join orders with products on product ID
WHERE u.id = 4
AND o.paid_price BETWEEN 1.000 AND 100.000 


