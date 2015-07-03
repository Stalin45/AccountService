CREATE TABLE user (
	id BIGINT,
	first_name VARCHAR(40),
	last_name VARCHAR(40),
	passport_number INT(2),
	CONSTRAINT pk_userid PRIMARY KEY (id),
	CONSTRAINT uk_passportnumber UNIQUE (passport_number)
);

CREATE TABLE account (
	id BIGINT,
	user_id BIGINT,
	balance BIGINT UNSIGNED,
	CONSTRAINT pk_accountid PRIMARY KEY (id), 
	CONSTRAINT fk_accountid_userid FOREIGN KEY (user_id) REFERENCES user(id)
	ON DELETE CASCADE ON UPDATE CASCADE
);