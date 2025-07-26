To access H2 database http://localhost:8080/h2-ui

SELECT * FROM TBL_SHOPPING_LIST_ITEMS

INSERT INTO TBL_SHOPPING_LIST_ITEMS (ID,CATEGORY,DESCRIPTION,NAME,PURCHASED) VALUES (1,2, 'FRESH CUSUMBERS', 'CUCUMBERS',FALSE);

In Spring Boot 2 data.sql was not working with me as in spring boot 1.5

    import.sql

In addition, a file named import.sql in the root of the classpath is executed on startup if Hibernate creates the schema from scratch (that is, if the ddl-auto property is set to create or create-drop).

Note: Inserts will not happen if you set 'spring.jpa.hibernate.ddl-auto= update'