INSERT INTO users(username, password, enabled)
VALUES ('daniel', '{bcrypt}$2y$10$7pZ0P3OYmahytG5jmedDH..X4Y7a5M50a4.7vTy0XoViM0KR0qVr6', true)
ON CONFLICT DO NOTHING;

TRUNCATE TABLE authorities;

INSERT INTO authorities(username, authority)
VALUES ('daniel', 'user');
