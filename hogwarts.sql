-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 07, 2023 at 12:58 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hogwarts`
--

-- --------------------------------------------------------

--
-- Table structure for table `house`
--

CREATE TABLE `house` (
  `house_id` int(11) NOT NULL,
  `position` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `house`
--

INSERT INTO `house` (`house_id`, `position`, `score`, `name`) VALUES
(8, 1, 80, 'Griffindor'),
(9, 3, 80, 'Slytherin'),
(10, 3, 80, 'kkkkk');

-- --------------------------------------------------------

--
-- Table structure for table `house_wizards`
--

CREATE TABLE `house_wizards` (
  `house_house_id` int(11) NOT NULL,
  `wizards_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `house_wizards`
--

INSERT INTO `house_wizards` (`house_house_id`, `wizards_id`) VALUES
(8, 8),
(9, 9);

-- --------------------------------------------------------

--
-- Table structure for table `wizards`
--

CREATE TABLE `wizards` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `wizards`
--

INSERT INTO `wizards` (`id`, `name`) VALUES
(8, 'Ron'),
(9, 'Harry Potter');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `house`
--
ALTER TABLE `house`
  ADD PRIMARY KEY (`house_id`);

--
-- Indexes for table `house_wizards`
--
ALTER TABLE `house_wizards`
  ADD UNIQUE KEY `UK_ovqcampgu5t5jqws9lebssyua` (`wizards_id`),
  ADD KEY `FK5d2msehnd6sksgdi800tsyv4e` (`house_house_id`);

--
-- Indexes for table `wizards`
--
ALTER TABLE `wizards`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `house`
--
ALTER TABLE `house`
  MODIFY `house_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `wizards`
--
ALTER TABLE `wizards`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `house_wizards`
--
ALTER TABLE `house_wizards`
  ADD CONSTRAINT `FK2wbbon88cf0mwn2w4urru4h34` FOREIGN KEY (`wizards_id`) REFERENCES `wizards` (`id`),
  ADD CONSTRAINT `FK5d2msehnd6sksgdi800tsyv4e` FOREIGN KEY (`house_house_id`) REFERENCES `house` (`house_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
