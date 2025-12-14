-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2025 at 07:28 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bingo_feb_2023`
--
CREATE DATABASE IF NOT EXISTS `bingo_feb_2023` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bingo_feb_2023`;

-- --------------------------------------------------------

--
-- Table structure for table `igra`
--

DROP TABLE IF EXISTS `igra`;
CREATE TABLE IF NOT EXISTS `igra` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `kombinacija` varchar(50) DEFAULT NULL,
  `brNaMestu` bigint(20) DEFAULT NULL,
  `brVanMesta` bigint(20) DEFAULT NULL,
  `dobitnaKomb_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dobitnaKomb_id` (`dobitnaKomb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `igra`
--

INSERT INTO `igra` (`id`, `kombinacija`, `brNaMestu`, `brVanMesta`, `dobitnaKomb_id`) VALUES
(3, '0-0-0-0', 1, 0, 13),
(4, '0-0-0-0', 1, 0, 13),
(5, '0-0-0-0', 1, 0, 13),
(6, '0-0-0-0', 1, 0, 13),
(7, '0-0-0-0', 1, 0, 13),
(8, '0-0-0-0', 1, 0, 13),
(9, '0-0-0-0', 0, 0, 14),
(10, '0-0-0-0', 0, 0, 14),
(11, '0-0-0-0', 0, 0, 14),
(12, '0-0-0-0', 0, 0, 14),
(13, '0-0-0-0', 0, 0, 14),
(14, '0-0-0-0', 0, 0, 14),
(15, '0-1-0-0', 0, 1, 15),
(16, '0-1-0-0', 0, 1, 15),
(17, '0-1-0-0', 0, 1, 15),
(18, '0-1-0-0', 0, 1, 15),
(19, '0-1-0-0', 0, 1, 15),
(20, '0-1-0-0', 0, 1, 15),
(21, '0-0-0-0', 1, 0, 16),
(22, '0-0-0-0', 1, 0, 16),
(23, '0-0-0-0', 1, 0, 16),
(24, '0-0-0-0', 1, 0, 16),
(25, '0-0-0-0', 1, 0, 16),
(26, '0-0-0-0', 1, 0, 16),
(27, '0-0-0-0', 1, 0, 17),
(28, '0-0-0-0', 1, 0, 17),
(29, '0-0-3-0', 1, 0, 17),
(30, '0-0-3-0', 1, 0, 17),
(31, '0-0-3-0', 1, 0, 17),
(32, '0-0-3-0', 1, 0, 17),
(33, '0-0-0-0', 0, 0, 21),
(34, '0-0-0-0', 0, 0, 21),
(35, '0-0-0-0', 0, 0, 21),
(36, '0-0-0-0', 0, 0, 21),
(37, '0-0-0-0', 0, 0, 21),
(38, '0-0-0-0', 0, 0, 21),
(39, '0-0-0-0', 0, 0, 22),
(40, '0-0-3-4', 0, 1, 22),
(41, '0-0-3-4', 0, 1, 22),
(42, '0-0-3-4', 0, 1, 22),
(43, '0-0-3-4', 0, 1, 22),
(44, '0-0-3-4', 0, 1, 22),
(45, '0-0-0-0', 0, 0, 24),
(46, '0-0-0-0', 0, 0, 24),
(47, '0-0-0-0', 0, 0, 24),
(48, '0-0-0-0', 0, 0, 24),
(49, '0-0-0-0', 0, 0, 24),
(50, '0-0-0-0', 0, 0, 24);

-- --------------------------------------------------------

--
-- Table structure for table `rezultatiigara`
--

DROP TABLE IF EXISTS `rezultatiigara`;
CREATE TABLE IF NOT EXISTS `rezultatiigara` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `datumVreme` datetime DEFAULT NULL,
  `zadataKombinacija` varchar(50) DEFAULT NULL,
  `brojPokusaja` bigint(20) DEFAULT NULL,
  `rezultat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rezultatiigara`
--

INSERT INTO `rezultatiigara` (`id`, `datumVreme`, `zadataKombinacija`, `brojPokusaja`, `rezultat`) VALUES
(13, '2025-06-17 22:44:39', '0-1-3-1', 6, 'izgubio'),
(14, '2025-06-17 23:09:57', '3-5-5-1', 6, 'izgubio'),
(15, '2025-06-17 23:11:31', '3-3-4-1', 6, 'izgubio'),
(16, '2025-06-17 23:13:03', '2-0-1-3', 6, 'izgubio'),
(17, '2025-06-17 23:15:38', '0-2-1-2', 6, 'izgubio'),
(18, '2025-06-17 23:21:15', '1-1-5-2', 6, 'izgubio'),
(19, '2025-06-17 23:21:19', '1-1-5-2', 6, 'izgubio'),
(20, '2025-06-17 23:21:56', '3-1-4-2', 6, 'izgubio'),
(21, '2025-06-17 23:23:04', '3-1-1-5', 6, 'izgubio'),
(22, '2025-06-17 23:25:26', '5-3-1-5', 6, 'izgubio'),
(23, '2025-06-17 23:26:51', '1-2-0-1', 6, 'izgubio'),
(24, '2025-06-17 23:28:16', '2-2-1-5', 6, 'izgubio');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `igra`
--
ALTER TABLE `igra`
  ADD CONSTRAINT `igra_ibfk_3` FOREIGN KEY (`dobitnaKomb_id`) REFERENCES `rezultatiigara` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
