-- All passwords are "password"
INSERT INTO users(username, password, enabled)
VALUES ('daniel', '{bcrypt}$2y$10$7pZ0P3OYmahytG5jmedDH..X4Y7a5M50a4.7vTy0XoViM0KR0qVr6', true),
       ('alice', '{bcrypt}$2y$10$b2pljKWQhQEDH7eQxrr/mu728mGU2kJjRa2l.MIDPys92aqLYe92y', true),
       ('bob', '{bcrypt}$2y$10$FLXrNbU589sOlM36DhhKQuNsfQheUW0cuJoaa5htN2tDrJdiFNtGe', true)
ON CONFLICT DO NOTHING;

INSERT INTO authorities(username, authority)
VALUES ('daniel', 'user'),
       ('daniel', 'admin'),
       ('alice', 'user'),
       ('bob', 'user')
ON CONFLICT DO NOTHING;
