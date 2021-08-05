INSERT INTO RECIPE (CATEGORY, DESCRIPTION, TITLE) VALUES (1, 'Cook it like its hot!', 'Spaghetti med paprika och salladsost');
INSERT INTO INGREDIENT (NAME, UNIT, AMOUNT, OWNER_RECIPE_ID) VALUES ('Salt', 'kryddmått', 1.5, 1);
INSERT INTO INGREDIENT (NAME, UNIT, AMOUNT, OWNER_RECIPE_ID) VALUES ('Peppar', 'kryddmått', 1.5, 1);
INSERT INTO INGREDIENT (NAME, UNIT, AMOUNT, OWNER_RECIPE_ID) VALUES ('Spaghetti', 'gram', 300.0, 1);
INSERT INTO INGREDIENT (NAME, UNIT, AMOUNT, OWNER_RECIPE_ID) VALUES ('Ost', 'gram', 100.0, 1);

INSERT INTO RECIPE (CATEGORY, DESCRIPTION, TITLE) VALUES (1, 'Fyll kycklingen med fjädrar', 'Påskkyckling med äppelcider');
INSERT INTO INGREDIENT (NAME, UNIT, AMOUNT, OWNER_RECIPE_ID) VALUES ('Salt', 'kryddmått', 1.5, 2);
INSERT INTO INGREDIENT (NAME, UNIT, AMOUNT, OWNER_RECIPE_ID) VALUES ('Peppar', 'kryddmått', 1.5, 2);
INSERT INTO INGREDIENT (NAME, UNIT, AMOUNT, OWNER_RECIPE_ID) VALUES ('Kycklingfiléer', 'gram', 500.0, 2);

INSERT INTO RECIPE (CATEGORY, DESCRIPTION, TITLE) VALUES (2, 'Stoppa in i ugnen', 'Rabarberpaj med sås');
INSERT INTO INGREDIENT (NAME, UNIT, AMOUNT, OWNER_RECIPE_ID) VALUES ('Rabarber', 'gram', 150.0, 3);
INSERT INTO INGREDIENT (NAME, UNIT, AMOUNT, OWNER_RECIPE_ID) VALUES ('Mjöl', 'dl', 5.0, 3);
INSERT INTO INGREDIENT (NAME, UNIT, AMOUNT, OWNER_RECIPE_ID) VALUES ('Socker', 'dl', 4.0, 3);
INSERT INTO INGREDIENT (NAME, UNIT, AMOUNT, OWNER_RECIPE_ID) VALUES ('Smör', 'gram', 100.0, 3);

INSERT INTO RECIPE (CATEGORY, DESCRIPTION, TITLE) VALUES (0, 'Koka upp vatten.', 'Nässelsoppa');
INSERT INTO INGREDIENT (NAME, UNIT, AMOUNT, OWNER_RECIPE_ID) VALUES ('Salt', 'kryddmått', 1.5, 4);
INSERT INTO INGREDIENT (NAME, UNIT, AMOUNT, OWNER_RECIPE_ID) VALUES ('Peppar', 'kryddmått', 1.5, 4);
INSERT INTO INGREDIENT (NAME, UNIT, AMOUNT, OWNER_RECIPE_ID) VALUES ('Nässlor', 'gram', 100.0, 4);

INSERT INTO USER (USERNAME, PASSWORD, FIRST_NAME, SUR_NAME, EMAIL, DESCRIPTION, CITY, COUNTY, ZIP_CODE, AGE) VALUES ('MegaMan69', '123', 'Andreas', 'Dogpudel', 'megaman69@lunarstorm.se', 'Very trustworthy guy. ;)', 'Stockholm', 'Stockholm', '114 10', '49');

INSERT INTO RECIPE_COLLECTION (RECIPE_ID, USER_ID) VALUES (1, 1);
INSERT INTO RECIPE_COLLECTION (RECIPE_ID, USER_ID) VALUES (2, 1);
INSERT INTO RECIPE_COLLECTION (RECIPE_ID, USER_ID) VALUES (3, 1);
INSERT INTO RECIPE_COLLECTION (RECIPE_ID, USER_ID) VALUES (4, 1);