INSERT INTO app_user(username, password)
VALUES ('daniel', '{bcrypt}$2y$10$7pZ0P3OYmahytG5jmedDH..X4Y7a5M50a4.7vTy0XoViM0KR0qVr6')
ON CONFLICT DO NOTHING;