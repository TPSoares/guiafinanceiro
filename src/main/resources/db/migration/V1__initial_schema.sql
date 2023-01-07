CREATE TABLE `t_transaction` (
  `transaction_id` bigint PRIMARY KEY,
  `name` varchar(255),
  `transaction_value` decimal (6,2),
  `category_type_id` bigint,
  `user_id` bigint,
  `subcategory_type_id` bigint,
  `created_at` datetime,
  `updated_at` datetime,
  `enabled` tinyint
);

CREATE TABLE `t_category_type` (
  `category_type_id` bigint PRIMARY KEY,
  `name` varchar(255),
  `description` varchar(255),
  `created_at` datetime,
  `updated_at` datetime,
  `enabled` tinyint
);

CREATE TABLE `t_subcategory_type` (
  `subcategory_type_id` bigint PRIMARY KEY,
  `name` varchar(255),
  `description` varchar(255),
  `created_at` datetime,
  `updated_at` datetime,
  `enabled` tinyint
);

CREATE TABLE `t_user` (
  `user_id` bigint PRIMARY KEY,
  `name` varchar(255),
  `email` varchar(255),
  `password` varchar(255),
  `created_at` datetime,
  `updated_at` datetime,
  `enabled` tinyint
);

ALTER TABLE `t_transaction` ADD FOREIGN KEY (`category_type_id`) REFERENCES `t_category_type` (`category_type_id`);

ALTER TABLE `t_transaction` ADD FOREIGN KEY (`subcategory_type_id`) REFERENCES `t_subcategory_type` (`subcategory_type_id`);

ALTER TABLE `t_transaction` ADD FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`);

INSERT INTO `t_category_type` (`category_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (1, "RECEITA", "Receita", now(), now(), 1);
INSERT INTO `t_category_type` (`category_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (2, "DESPESA", "Despesa", now(), now(), 1);

INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (1, "ALUGUEL", "Aluguel", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (2, "LUZ", "Conta de luz", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (3, "INTERNET", "Conta de Internet", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (4, "GAS", "Conta de gás", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (5, "AGUA", "Conta de água", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (6, "CONDOMINIO", "Conta de condomínio", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (7, "IPTU", "IPTU", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (8, "FINANCIAMENTO", "Financiamento", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (9, "EMPRESTIMO", "Emprestimo", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (10, "CELULAR", "Plano de celular", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (11, "CARTAOCREDITO", "Cartão de crédito", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (12, "CARTAODEBITO", "Cartão de débito", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (13, "ESCOLA", "Escola/Creche", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (14, "PET", "Gastos com animais", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (15, "TV", "TV por assinatura", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (16, "STREAMING", "Serviços de streaming", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (17, "ROUPA", "Vestuário", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (18, "MEDICO", "Despesas médicas", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (19, "BELEZA", "Produtos/Serviços de beleza", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (20, "MERCADO", "Mercado", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (21, "ALIMENTACAO", "Restaurantes e Bares", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (99, "OUTROS", "Outros", now(), now(), 1);

INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (101, "SALARIO", "Salário", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (102, "DIVIDENDOS", "Proventos (Dividendos)", now(), now(), 1);
INSERT INTO `t_subcategory_type` (`subcategory_type_id`, `name`, `description`, `created_at`, `updated_at`, `enabled`) VALUES (999, "OUTRASRENDAS", "Outras Rendas", now(), now(), 1);

INSERT INTO `t_user` (`user_id`, `name`, `email`, `password`, `created_at`, `updated_at`, `enabled`) VALUES (1, "thiago", "thiagopina.soares@gmail.com", "dota", now(), now(), 1);

INSERT INTO `t_transaction` (`transaction_id`, `name`, `transaction_value`, `category_type_id`, `user_id`, `subcategory_type_id`, `created_at`, `updated_at`, `enabled`) VALUES (1, "conta de luz", "150.47", 2, 1, 2, now(), now(), 1);
INSERT INTO `t_transaction` (`transaction_id`, `name`, `transaction_value`, `category_type_id`, `user_id`, `subcategory_type_id`, `created_at`, `updated_at`, `enabled`) VALUES (2, "aluguel", "50.8", 2, 1, 2, now(), now(), 1);