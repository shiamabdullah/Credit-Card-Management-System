-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 08, 2019 at 08:17 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rfid`
--

-- --------------------------------------------------------

--
-- Table structure for table `add_document_user`
--

CREATE TABLE `add_document_user` (
  `Card_Type` varchar(100) DEFAULT NULL,
  `Card_ID` int(255) DEFAULT NULL,
  `ccv` int(3) DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `pin` int(4) DEFAULT NULL,
  `u_id_fn` int(11) NOT NULL,
  `c_id` int(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `add_document_user`
--

INSERT INTO `add_document_user` (`Card_Type`, `Card_ID`, `ccv`, `expiry_date`, `pin`, `u_id_fn`, `c_id`) VALUES
('Starting', 43012, 0, '2019-11-12', 1, 0, 1),
('EBL Visa Gold Credit Card', 43013, 884, '1997-11-08', 1234, 9, 2),
('Mastercard World Credit', 43014, NULL, NULL, NULL, 10, 3),
('Mastercard Titanium Credit', 43015, NULL, NULL, NULL, 10, 4),
('EBL Diners Club ', 43016, NULL, NULL, NULL, 10, 5),
('Mastercard Titanium Credit', 43017, NULL, NULL, NULL, 10, 6),
('EBL Visa Gold Credit Card', 43018, NULL, NULL, NULL, 10, 7),
('Mastercard Titanium Credit', 43019, NULL, NULL, NULL, 10, 8),
('EBL Visa Platinum Credit', 43020, NULL, NULL, NULL, 10, 9);

-- --------------------------------------------------------

--
-- Table structure for table `admininfo`
--

CREATE TABLE `admininfo` (
  `userName` varchar(50) NOT NULL,
  `fatherName` varchar(50) NOT NULL,
  `motherName` varchar(50) NOT NULL,
  `id` int(11) NOT NULL,
  `dob` date NOT NULL,
  `BG` varchar(3) NOT NULL,
  `pass` varchar(1000) NOT NULL,
  `a_id` int(11) UNSIGNED NOT NULL,
  `type` tinyint(20) UNSIGNED NOT NULL DEFAULT 2,
  `valid` tinyint(4) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admininfo`
--

INSERT INTO `admininfo` (`userName`, `fatherName`, `motherName`, `id`, `dob`, `BG`, `pass`, `a_id`, `type`, `valid`) VALUES
('Shiam', 'FShiam', 'MAdmin', 123, '1999-10-27', 'AB+', 'pass', 2, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `superadmininfo`
--

CREATE TABLE `superadmininfo` (
  `userInput` int(20) NOT NULL,
  `passwordInput` varchar(1000) NOT NULL,
  `s_id` int(20) UNSIGNED NOT NULL,
  `type` tinyint(20) NOT NULL DEFAULT 3,
  `valid` tinyint(4) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `superadmininfo`
--

INSERT INTO `superadmininfo` (`userInput`, `passwordInput`, `s_id`, `type`, `valid`) VALUES
(12, 'pass', 2, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE `userinfo` (
  `userName` varchar(50) NOT NULL,
  `fatherName` varchar(50) NOT NULL,
  `motherName` varchar(50) NOT NULL,
  `id` int(11) NOT NULL,
  `dob` date NOT NULL,
  `BG` varchar(3) NOT NULL,
  `pass` varchar(1000) NOT NULL,
  `u_id` int(11) UNSIGNED NOT NULL,
  `type` int(20) UNSIGNED NOT NULL DEFAULT 3,
  `valid` tinyint(4) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`userName`, `fatherName`, `motherName`, `id`, `dob`, `BG`, `pass`, `u_id`, `type`, `valid`) VALUES
('User', 'FUser', 'MUser', 1234, '1999-10-27', 'AB+', 'pass', 10, 3, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `add_document_user`
--
ALTER TABLE `add_document_user`
  ADD PRIMARY KEY (`c_id`),
  ADD UNIQUE KEY `Card_ID` (`Card_ID`),
  ADD KEY `u_id_fn` (`u_id_fn`);

--
-- Indexes for table `admininfo`
--
ALTER TABLE `admininfo`
  ADD PRIMARY KEY (`a_id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `superadmininfo`
--
ALTER TABLE `superadmininfo`
  ADD PRIMARY KEY (`s_id`),
  ADD UNIQUE KEY `userInput` (`userInput`);

--
-- Indexes for table `userinfo`
--
ALTER TABLE `userinfo`
  ADD PRIMARY KEY (`u_id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `add_document_user`
--
ALTER TABLE `add_document_user`
  MODIFY `c_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `admininfo`
--
ALTER TABLE `admininfo`
  MODIFY `a_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `superadmininfo`
--
ALTER TABLE `superadmininfo`
  MODIFY `s_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `userinfo`
--
ALTER TABLE `userinfo`
  MODIFY `u_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
