create TABLE person (
	person_id SERIAL NOT NULL,
	firstName VARCHAR(255),
	lastName VARCHAR(255),
	age INT,
	date_of_birth TIMESTAMP WITH TIME ZONE NOT NULL,
	primary key (person_id) 
)

