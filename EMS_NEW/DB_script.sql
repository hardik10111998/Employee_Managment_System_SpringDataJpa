-- spring_hibernate.employee;

CREATE TABLE `employee` (
  `id` int NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `age` int NOT NULL,
  `date_of_joining` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `salary` double NOT NULL,
  `username` varchar(255) NOT NULL,
  `working_days_of_this_month` double NOT NULL,
  `department_dept_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK73iqbdohd6qwfdaij2bxc3vxx` (`department_dept_id`),
  CONSTRAINT `FK73iqbdohd6qwfdaij2bxc3vxx` FOREIGN KEY (`department_dept_id`) REFERENCES `department` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

---------------------------------------------------------------------------------------------------------

-- spring_hibernate.department

 CREATE TABLE `department` (
  `dept_id` int NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

----------------------------------------------------------------------------------------------------------
-- spring_hibernate.leave_table;

CREATE TABLE `leave_table` (
  `leave_id` int NOT NULL AUTO_INCREMENT,
  `leave_from` date DEFAULT NULL,
  `leave_message` varchar(255) DEFAULT NULL,
  `leave_subject` varchar(255) DEFAULT NULL,
  `leave_to` date DEFAULT NULL,
  `status` int NOT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`leave_id`),
  KEY `FKk7bnv3k5dh5lpwy2uml62258s` (`employee_id`),
  CONSTRAINT `FKk7bnv3k5dh5lpwy2uml62258s` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

------------------------------------------------------------------------------------------------
-- spring_hibernate.employee_leave;

CREATE TABLE `employee_leave` (
  `employee_id` int NOT NULL,
  `leave_leave_id` int NOT NULL,
  UNIQUE KEY `UK_kkcd3knvnxjnooxi5cjsrxhoj` (`leave_leave_id`),
  KEY `FKqat82qeb4igyj2vrh07tif37w` (`employee_id`),
  CONSTRAINT `FKoeeq59b5sw7de1e3gcvf3kbs1` FOREIGN KEY (`leave_leave_id`) REFERENCES `leave_table` (`leave_id`),
  CONSTRAINT `FKqat82qeb4igyj2vrh07tif37w` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--------------------------------------------------------------------------------------------------------

