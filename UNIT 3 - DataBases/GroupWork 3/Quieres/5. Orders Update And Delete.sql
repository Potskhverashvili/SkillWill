--------------------------------- UPDATE -------------------------------
UPDATE orders SET 
paid_price = (SELECT product_price FROM products WHERE id = 1) * 1,
product_quantity = 1,
product_id = 9
WHERE orders.order_id = 30;

--------------------------------- DELETE ------------------------------
DELETE FROM orders as o
WHERE o.order_id = 33

-----------------------------------------------------------------------
	