INSERT INTO RECIPE (CATEGORY, DESCRIPTION, TITLE) VALUES (1, 'Cook it like its hot!', 'Spaghetti med paprika och salladsost');

INSERT INTO INGREDIENT (NAME, UNIT, AMOUNT, OWNER_RECIPE_ID) VALUES ('Salt', 'kryddmått', 1.5, 1);

INSERT INTO USER (USERNAME, PASSWORD, FIRST_NAME, SUR_NAME, EMAIL, DESCRIPTION, CITY, COUNTY, ZIP_CODE, AGE) VALUES ('MegaMan69', '123', 'Andreas', 'Dogpudel', 'megaman69@lunarstorm.se', 'Very trustworthy guy. ;)', 'Stockholm', 'Stockholm', '114 10', '49');

INSERT INTO RECIPE_COLLECTION (RECIPE_ID, USER_ID) VALUES (1, 1);