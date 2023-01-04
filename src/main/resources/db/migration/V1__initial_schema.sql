CREATE TABLE `t_transaction` (
  `transaction_id` bigint PRIMARY KEY,
  `name` varchar(255),
  `category_type_id` bigint,
  `user_id` bigint,
  `subcategory_type_id` bigint,
  `created_at` datetime,
  `updated_at` datetime
);

CREATE TABLE `t_category_type` (
  `category_type_id` bigint PRIMARY KEY,
  `name` varchar(255),
  `created_at` datetime,
  `updated_at` datetime
);

CREATE TABLE `t_subcategory_type` (
  `subcategory_type_id` bigint PRIMARY KEY,
  `name` varchar(255),
  `created_at` datetime,
  `updated_at` datetime
);

CREATE TABLE `t_user` (
  `user_id` bigint PRIMARY KEY,
  `name` varchar(255),
  `email` varchar(255),
  `password` varchar(255),
  `created_at` datetime,
  `updated_at` datetime
);

ALTER TABLE `t_transaction` ADD FOREIGN KEY (`category_type_id`) REFERENCES `t_category_type` (`category_type_id`);

ALTER TABLE `t_transaction` ADD FOREIGN KEY (`subcategory_type_id`) REFERENCES `t_subcategory_type` (`subcategory_type_id`);

ALTER TABLE `t_transaction` ADD FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`);