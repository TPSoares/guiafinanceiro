CREATE TABLE `t_transaction` (
    `transaction_id` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `transaction_value` decimal (10,2) NOT NULL,
    `transaction_date` datetime NOT NULL,
    `category_type_id` bigint NOT NULL,
    `user_id` bigint NOT NULL,
    `transaction_type_id` bigint NOT NULL,
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL,
    `enabled` tinyint NOT NULL
);

CREATE TABLE `t_transaction_type` (
    `transaction_type_id` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `description` varchar(255) NOT NULL,
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL,
    `enabled` tinyint NOT NULL
);

CREATE TABLE `t_category_type` (
    `category_type_id` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `description` varchar(255) NOT NULL,
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL,
    `enabled` tinyint NOT NULL
);

CREATE TABLE `t_user` (
    `user_id` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL,
    `enabled` tinyint NOT NULL
);

CREATE TABLE `t_budget_category` (
    `budget_category_id` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `user_id` bigint NOT NULL,
    `category_type_id` bigint NOT NULL,
    `value` varchar(100) NOT NULL,
    `percentage` varchar(10) NOT NULL,
    `created_at` date NOT NULL,
    `updated_at` date NOT NULL,
    `enabled` boolean NOT NULL
);

ALTER TABLE `t_transaction` ADD FOREIGN KEY (`category_type_id`) REFERENCES `t_category_type` (`category_type_id`);

ALTER TABLE `t_transaction` ADD FOREIGN KEY (`transaction_type_id`) REFERENCES `t_transaction_type` (`transaction_type_id`);

ALTER TABLE `t_transaction` ADD FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`);

ALTER TABLE `t_budget_category` ADD FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`);

ALTER TABLE `t_budget_category` ADD FOREIGN KEY (`category_type_id`) REFERENCES `t_category_type` (`category_type_id`);

INSERT INTO `t_transaction_type` (`transaction_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (1, "RECEITA", "Receita", now(), now(), 1);
INSERT INTO `t_transaction_type` (`transaction_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (2, "DESPESA", "Despesa", now(), now(), 1);

INSERT INTO `t_category_type` (`category_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (1, "GASTOS_FIXOS", "Gastos Fixos", now(), now(), 1);
INSERT INTO `t_category_type` (`category_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (2, "ALIMENTACAO", "Alimentação", now(), now(), 1);
INSERT INTO `t_category_type` (`category_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (3, "LAZER", "Lazer", now(), now(), 1);
INSERT INTO `t_category_type` (`category_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (4, "TRANSPORTE", "Transporte", now(), now(), 1);
INSERT INTO `t_category_type` (`category_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (5, "SAUDE", "Saúde", now(), now(), 1);
INSERT INTO `t_category_type` (`category_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (6, "EDUCACAO_CONHECIMENTO", "Educação e Conhecimento", now(), now(), 1);
INSERT INTO `t_category_type` (`category_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (7, "ECONOMIA_E_INVESTIMENTOS", "Economias e Investimentos", now(), now(), 1);
INSERT INTO `t_category_type` (`category_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (8, "VIAGEM", "Viagens", now(), now(), 1);
INSERT INTO `t_category_type` (`category_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (9, "SALARIO", "Salário", now(), now(), 1);
INSERT INTO `t_category_type` (`category_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (10, "DIVIDENDOS", "Proventos (Dividendos)", now(), now(), 1);
INSERT INTO `t_category_type` (`category_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (11, "OUTRASRENDAS", "Outras Rendas", now(), now(), 1);
INSERT INTO `t_category_type` (`category_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (12, "OUTROS", "Outros", now(), now(), 1);

INSERT INTO `t_user` (`user_id`, `name`, `email`, `password`, `created_at`, `updated_at`, `enabled`) VALUES (1, "thiago", "thiagopina.soares@gmail.com", "dota", now(), now(), 1);

INSERT INTO `t_transaction` (`transaction_id`, `name`, `transaction_value`, `transaction_type_id`, `user_id`, `category_type_id`, `created_at`, `updated_at`, `enabled`, `transaction_date`) VALUES (1, "conta de luz", "150.47", 2, 1, 2, now(), now(), 1, now());
INSERT INTO `t_transaction` (`transaction_id`, `name`, `transaction_value`, `transaction_type_id`, `user_id`, `category_type_id`, `created_at`, `updated_at`, `enabled`, `transaction_date`) VALUES (2, "aluguel", "50.8", 2, 1, 2, now(), now(), 1, now());
