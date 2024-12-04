-- Insert default roles
INSERT INTO roles (id, name)
VALUES (0, 'ADMIN');
INSERT INTO roles (id, name)
VALUES (1, 'OPTOMETRIST');
INSERT INTO roles (id, name)
VALUES (2, 'PATIENT');

-- Insert default users
INSERT INTO users (id, email, password)
VALUES (0, 'barbod@gmail.com', '$2a$12$WUuWnz/HVm.vSomnUNSiKekwFcrhXf2f5gJINQyYyg/O2BI7X0t7e');
INSERT INTO users (id, email, password)
VALUES (1, 'kevin@gmail.com', 'password987');

-- Insert default relationships
INSERT INTO users_roles (user_id, role_id)
VALUES (0, 0);
INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1);
