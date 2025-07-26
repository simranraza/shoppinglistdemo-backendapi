-- INSERT INTO TBL_SHOPPING_LIST_ITEMS (ID,CATEGORY,DESCRIPTION,ITEM_NAME,PURCHASED) VALUES (1,'FRUITS_VEGTABLES', 'FRESH CUSUMBERS', 'CUCUMBERS',FALSE);
-- INSERT INTO TBL_SHOPPING_LIST_ITEMS (ID,CATEGORY,DESCRIPTION,ITEM_NAME,PURCHASED) VALUES (2,'FRUITS_VEGTABLES', 'ONIONS', 'BROWN ONIONS',FALSE);
-- Insert dummy data into tbl_SuperMarket
INSERT INTO tbl_SuperMarket (id, name) VALUES (1, 'FreshMart');
INSERT INTO tbl_SuperMarket (id, name) VALUES (2, 'GreenGrocer');
INSERT INTO tbl_SuperMarket (id, name) VALUES (3, 'BudgetFoods');
INSERT INTO tbl_SuperMarket (id, name) VALUES (4, 'SuperSaver');
INSERT INTO tbl_SuperMarket (id, name) VALUES (5, 'UrbanMarket');

-- Insert dummy data into tbl_SuperMarketDetails
INSERT INTO tbl_SuperMarketDetails (id, address, phoneNumber, super_market_id) VALUES (1,'123 Main Street, Springfield', '555-1234', 1);
INSERT INTO tbl_SuperMarketDetails (id, address, phoneNumber, super_market_id) VALUES (2,'456 Oak Avenue, Shelbyville', '555-5678', 2);
INSERT INTO tbl_SuperMarketDetails (id, address, phoneNumber, super_market_id) VALUES (3,'789 Pine Road, Capital City', '555-9012', 3);
INSERT INTO tbl_SuperMarketDetails (id, address, phoneNumber, super_market_id) VALUES (4,'321 Elm Boulevard, Ogdenville', '555-3456', 4);
INSERT INTO tbl_SuperMarketDetails (id, address, phoneNumber, super_market_id) VALUES (5, '654 Cedar Lane, North Haverbrook', '555-7890', 5);

INSERT INTO tbl_ProdcutCategory (id, category_name, is_perishable) VALUES (1, 'Fruits & Vegetables', true);
INSERT INTO tbl_ProdcutCategory (id, category_name, is_perishable) VALUES (2, 'Beverages', false);
INSERT INTO tbl_ProdcutCategory (id, category_name, is_perishable) VALUES (3, 'Dairy Products', true);

INSERT INTO tbl_ShoppingEvent (id, shopping_date, description, super_market_detail_id) VALUES (1, '2024-06-01T10:30:00', 'Weekly grocery run at Coles', 1);
INSERT INTO tbl_ShoppingEvent (id, shopping_date, description, super_market_detail_id) VALUES (2, '2024-07-09T10:30:00', 'Weekly grocery run at Coles', 1);
INSERT INTO tbl_ShoppingEvent (id, shopping_date, description, super_market_detail_id) VALUES (3, '2024-08-12T10:30:00', 'Weekly grocery run at Coles', 2);
INSERT INTO tbl_ShoppingEvent (id, shopping_date, description, super_market_detail_id) VALUES (4, '2024-09-17T10:30:00', 'Weekly grocery run at Coles', 2);

INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (1,'Milk', 'Full cream 1L','Dairy Products',true, 2);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (1, 'Bread', 'Whole grain loaf', 'Bakery', false, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (1, 'Bread', 'Whole grain loaf', 'Bakery', false, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (1, 'Milk', 'Full cream 1L', 'Dairy', true, 2);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (1, 'Eggs', 'Free range 12 pack', 'Dairy', false, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (1, 'Cereal', 'Whole grain oats', 'Pantry', true, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (2, 'Butter', 'Unsalted block', 'Dairy', false, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (2, 'Apples', 'Granny Smith', 'Fruits', true, 6);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (2, 'Bananas', 'Cavendish bananas', 'Fruits', false, 5);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (2, 'Orange Juice', '1L, no pulp', 'Beverages', true, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (3, 'Toothpaste', 'Whitening gel 120g', 'Toiletries', false, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (3, 'Shampoo', 'Anti-dandruff', 'Toiletries', false, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (3, 'Dish Soap', 'Lemon scent', 'Cleaning Supplies', true, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (3, 'Laundry Detergent', 'Front loader 2L', 'Cleaning Supplies', false, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (4, 'Chicken Breast', 'Skinless, 500g', 'Meat', false, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (4, 'Mince Beef', 'Lean 500g', 'Meat', false, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (4, 'Frozen Peas', '1kg pack', 'Frozen', true, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (4, 'Ice Cream', 'Vanilla tub 2L', 'Frozen', false, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (4, 'Pasta', 'Spaghetti 500g', 'Pantry', true, 2);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (4, 'Tomato Sauce', 'Basil flavored', 'Pantry', true, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (4, 'Coffee', 'Ground, 250g', 'Beverages', false, 1);
INSERT INTO tbl_ShoppingListItems (shopping_event_id, item_name, description, category, purchased, quantity) VALUES (4, 'Tea Bags', 'Green tea 100 pack', 'Beverages', false, 1);





        