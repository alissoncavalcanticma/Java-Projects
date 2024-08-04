-- --------------------------------------------------------
-- Servidor:                     localhost
-- Versão do servidor:           5.7.42 - MySQL Community Server (GPL)
-- OS do Servidor:               Linux
-- HeidiSQL Versão:              12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para coursejdbc
CREATE DATABASE IF NOT EXISTS `coursejdbc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `coursejdbc`;

-- Copiando estrutura para tabela coursejdbc.department
CREATE TABLE IF NOT EXISTS `department` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela coursejdbc.department: ~6 rows (aproximadamente)
INSERT INTO `department` (`Id`, `Name`) VALUES
	(1, 'Computers'),
	(2, 'Electronics'),
	(3, 'Fashion'),
	(4, 'Books'),
	(6, 'Teste1'),
	(7, 'Teste2');

-- Copiando estrutura para tabela coursejdbc.seller
CREATE TABLE IF NOT EXISTS `seller` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(60) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `BirthDate` datetime NOT NULL,
  `BaseSalary` double NOT NULL,
  `DepartmentId` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `DepartmentId` (`DepartmentId`),
  CONSTRAINT `seller_ibfk_1` FOREIGN KEY (`DepartmentId`) REFERENCES `department` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela coursejdbc.seller: ~7 rows (aproximadamente)
INSERT INTO `seller` (`Id`, `Name`, `Email`, `BirthDate`, `BaseSalary`, `DepartmentId`) VALUES
	(1, 'Bob Brown', 'bob@gmail.com', '1998-04-21 00:00:00', 1000, 1),
	(2, 'Maria Green', 'maria@gmail.com', '1979-12-31 00:00:00', 4100, 2),
	(3, 'Alex Grey', 'alex@gmail.com', '1988-01-15 00:00:00', 2200, 1),
	(4, 'Martha Red', 'martha@gmail.com', '1993-11-30 00:00:00', 3000, 4),
	(5, 'Donald Blue', 'donald@gmail.com', '2000-01-09 00:00:00', 4000, 3),
	(6, 'Alex Pink', 'bob@gmail.com', '1997-03-04 00:00:00', 3600, 2),
	(14, 'Alisson', 'alisson@alisson.com', '2024-07-25 00:00:00', 4300, 4);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
