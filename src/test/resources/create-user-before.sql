delete from user_role;
delete from usr;

insert into usr(id, username, password, active) values
(1, 'admin', '$2a$08$bEgQ7UK2Llbnv4N1jQv39u/P4CrYvIiayoDprONb2FaXYX/nVUw9e', true),
(2, 'ww', '$$2a$08$K8CPmf6PetR.5JA1yLzLCOQHaFKwkTs5ZZVNLw1Jk3UJx9U01vUZ.', true);

insert into user_role(user_id, roles) values
(1, 'ADMIN'), (1, 'USER'),
(2, 'USER');