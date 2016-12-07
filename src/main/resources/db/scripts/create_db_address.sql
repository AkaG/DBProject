CREATE SEQUENCE address_id_seq;
CREATE TABLE ADDRESSES(
  id INTEGER NOT NULL DEFAULT nextval('address_id_seq') PRIMARY KEY,
  street VARCHAR(255) NOT NULL,
  streetnumber INTEGER NOT NULL,
  idcity INTEGER REFERENCES CITIES(ID)
);
ALTER SEQUENCE address_id_seq OWNED BY COUNTRIES.ID;