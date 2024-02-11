CREATE TABLE `role`
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    created_date datetime NULL,
    updated_date datetime NULL,
    role_name    VARCHAR(255) NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE token
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_date    datetime NULL,
    updated_date    datetime NULL,
    value           VARCHAR(255) NULL,
    user_id         BIGINT NULL,
    expiration_date datetime NULL,
    deleted_status  BIT(1) NOT NULL,
    CONSTRAINT pk_token PRIMARY KEY (id)
);

CREATE TABLE user
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NULL,
    updated_date  datetime NULL,
    user_name     VARCHAR(255) NULL,
    email         VARCHAR(255) NULL,
    hash_password VARCHAR(255) NULL,
    is_verified   BIT(1) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE user_roles
(
    user_id  BIGINT NOT NULL,
    roles_id BIGINT NOT NULL
);

ALTER TABLE token
    ADD CONSTRAINT FK_TOKEN_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (roles_id) REFERENCES `role` (id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (user_id) REFERENCES user (id);