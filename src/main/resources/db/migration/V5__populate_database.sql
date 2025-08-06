INSERT INTO categories (name)
VALUES ('Fruits'),
       ('Vegetables'),
       ('Dairy'),
       ('Bakery'),
       ('Beverages'),
       ('Snacks'),
       ('Meat'),
       ('Seafood'),
       ('Pantry'),
       ('Frozen');


INSERT INTO products (name, price, description, category_id)
VALUES ('Bananas', 1.30, 'Fresh ripe bananas, sold per kg.', 1),
       ('Broccoli', 2.20, 'Green broccoli heads, approx. 500g each.', 2),
       ('Whole Milk - 1L', 1.10, 'Fresh whole milk, 1 litre bottle.', 3),
       ('Baguette', 1.50, 'Freshly baked French-style baguette.', 4),
       ('Coca-Cola 6x330ml', 4.75, 'Pack of 6 Coca-Cola cans, 330ml each.', 5),
       ('Paprika Crisps 200g', 2.40, 'Crispy paprika-flavoured potato chips, 200g bag.', 6),
       ('Chicken Breast Fillets 1kg', 7.90, 'Boneless, skinless chicken breast fillets, 1kg pack.', 7),
       ('Norwegian Salmon Fillet 300g', 6.50, 'Fresh Norwegian salmon fillet, 300g.', 8),
       ('Organic Brown Rice 1kg', 3.30, 'High-fibre organic brown rice, 1kg bag.', 9),
       ('Frozen Vegetable Mix 750g', 2.10, 'Frozen mix of carrots, peas, and sweetcorn, 750g.', 10);
