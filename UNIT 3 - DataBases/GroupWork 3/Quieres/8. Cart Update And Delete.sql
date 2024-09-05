--------------------------------- UPDATE -------------------------------
UPDATE cart SET 
product_price = (SELECT product_price FROM products WHERE id = 1) * 2,
product_quantity = 2,
product_id = 5
WHERE cart_id = 2;

--------------------------------- DELETE ------------------------------
DELETE FROM cart as c
WHERE c.cart_id = 10
