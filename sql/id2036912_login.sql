-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 23, 2017 at 09:09 AM
-- Server version: 10.1.20-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id2036912_login`
--
CREATE DATABASE IF NOT EXISTS `id2036912_login` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id2036912_login`;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(100) NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nama` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `nama`, `password`) VALUES
(1, 'rizky65', 'gandos12', 'joss46');

-- --------------------------------------------------------

--
-- Table structure for table `volley`
--

CREATE TABLE `volley` (
  `id` int(123) NOT NULL,
  `username` varchar(123) CHARACTER SET latin1 NOT NULL,
  `password` varchar(123) CHARACTER SET latin1 NOT NULL,
  `email` varchar(123) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `volley`
--

INSERT INTO `volley` (`id`, `username`, `password`, `email`) VALUES
(1, 'gandos', 'qwert123', 'gandos@gmail.com'),
(2, 'asdf', 'qwerty', 'qwerty'),
(3, 'Gandos', 'rizkydaijoss@gmail.com', 'makananenak'),
(4, 'Bijak', 'bijak@gmail.com', 'qwerty'),
(5, 'ngono', 'ngono', 'ngono'),
(6, 'ngono', 'ngono', 'ngono'),
(7, 'ngono', 'ngono', 'ngono');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `volley`
--
ALTER TABLE `volley`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `volley`
--
ALTER TABLE `volley`
  MODIFY `id` int(123) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;--
-- Database: `id2036912_login`
--
CREATE DATABASE IF NOT EXISTS `id2036912_login` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id2036912_login`;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(100) NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nama` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `nama`, `password`) VALUES
(1, 'rizky65', 'gandos12', 'joss46');

-- --------------------------------------------------------

--
-- Table structure for table `volley`
--

CREATE TABLE `volley` (
  `id` int(123) NOT NULL,
  `username` varchar(123) CHARACTER SET latin1 NOT NULL,
  `password` varchar(123) CHARACTER SET latin1 NOT NULL,
  `email` varchar(123) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `volley`
--

INSERT INTO `volley` (`id`, `username`, `password`, `email`) VALUES
(1, 'gandos', 'qwert123', 'gandos@gmail.com'),
(2, 'asdf', 'qwerty', 'qwerty'),
(3, 'Gandos', 'rizkydaijoss@gmail.com', 'makananenak'),
(4, 'Bijak', 'bijak@gmail.com', 'qwerty'),
(5, 'ngono', 'ngono', 'ngono'),
(6, 'ngono', 'ngono', 'ngono'),
(7, 'ngono', 'ngono', 'ngono');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `volley`
--
ALTER TABLE `volley`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `volley`
--
ALTER TABLE `volley`
  MODIFY `id` int(123) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;--
-- Database: `id2036912_login`
--
CREATE DATABASE IF NOT EXISTS `id2036912_login` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id2036912_login`;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(100) NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nama` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `nama`, `password`) VALUES
(1, 'rizky65', 'gandos12', 'joss46');

-- --------------------------------------------------------

--
-- Table structure for table `volley`
--

CREATE TABLE `volley` (
  `id` int(123) NOT NULL,
  `username` varchar(123) CHARACTER SET latin1 NOT NULL,
  `password` varchar(123) CHARACTER SET latin1 NOT NULL,
  `email` varchar(123) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `volley`
--

INSERT INTO `volley` (`id`, `username`, `password`, `email`) VALUES
(1, 'gandos', 'qwert123', 'gandos@gmail.com'),
(2, 'asdf', 'qwerty', 'qwerty'),
(3, 'Gandos', 'rizkydaijoss@gmail.com', 'makananenak'),
(4, 'Bijak', 'bijak@gmail.com', 'qwerty'),
(5, 'ngono', 'ngono', 'ngono'),
(6, 'ngono', 'ngono', 'ngono'),
(7, 'ngono', 'ngono', 'ngono');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `volley`
--
ALTER TABLE `volley`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `volley`
--
ALTER TABLE `volley`
  MODIFY `id` int(123) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;--
-- Database: `id2036912_login`
--
CREATE DATABASE IF NOT EXISTS `id2036912_login` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id2036912_login`;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(100) NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nama` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `nama`, `password`) VALUES
(1, 'rizky65', 'gandos12', 'joss46');

-- --------------------------------------------------------

--
-- Table structure for table `volley`
--

CREATE TABLE `volley` (
  `id` int(123) NOT NULL,
  `username` varchar(123) CHARACTER SET latin1 NOT NULL,
  `password` varchar(123) CHARACTER SET latin1 NOT NULL,
  `email` varchar(123) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `volley`
--

INSERT INTO `volley` (`id`, `username`, `password`, `email`) VALUES
(1, 'gandos', 'qwert123', 'gandos@gmail.com'),
(2, 'asdf', 'qwerty', 'qwerty'),
(3, 'Gandos', 'rizkydaijoss@gmail.com', 'makananenak'),
(4, 'Bijak', 'bijak@gmail.com', 'qwerty'),
(5, 'ngono', 'ngono', 'ngono'),
(6, 'ngono', 'ngono', 'ngono'),
(7, 'ngono', 'ngono', 'ngono');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `volley`
--
ALTER TABLE `volley`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `volley`
--
ALTER TABLE `volley`
  MODIFY `id` int(123) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;--
-- Database: `id2036912_login`
--
CREATE DATABASE IF NOT EXISTS `id2036912_login` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id2036912_login`;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(100) NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nama` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `nama`, `password`) VALUES
(1, 'rizky65', 'gandos12', 'joss46');

-- --------------------------------------------------------

--
-- Table structure for table `volley`
--

CREATE TABLE `volley` (
  `id` int(123) NOT NULL,
  `username` varchar(123) CHARACTER SET latin1 NOT NULL,
  `password` varchar(123) CHARACTER SET latin1 NOT NULL,
  `email` varchar(123) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `volley`
--

INSERT INTO `volley` (`id`, `username`, `password`, `email`) VALUES
(1, 'gandos', 'qwert123', 'gandos@gmail.com'),
(2, 'asdf', 'qwerty', 'qwerty'),
(3, 'Gandos', 'rizkydaijoss@gmail.com', 'makananenak'),
(4, 'Bijak', 'bijak@gmail.com', 'qwerty'),
(5, 'ngono', 'ngono', 'ngono'),
(6, 'ngono', 'ngono', 'ngono'),
(7, 'ngono', 'ngono', 'ngono');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `volley`
--
ALTER TABLE `volley`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `volley`
--
ALTER TABLE `volley`
  MODIFY `id` int(123) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;--
-- Database: `id2036912_login`
--
CREATE DATABASE IF NOT EXISTS `id2036912_login` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id2036912_login`;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(100) NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nama` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `nama`, `password`) VALUES
(1, 'rizky65', 'gandos12', 'joss46');

-- --------------------------------------------------------

--
-- Table structure for table `volley`
--

CREATE TABLE `volley` (
  `id` int(123) NOT NULL,
  `username` varchar(123) CHARACTER SET latin1 NOT NULL,
  `password` varchar(123) CHARACTER SET latin1 NOT NULL,
  `email` varchar(123) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `volley`
--

INSERT INTO `volley` (`id`, `username`, `password`, `email`) VALUES
(1, 'gandos', 'qwert123', 'gandos@gmail.com'),
(2, 'asdf', 'qwerty', 'qwerty'),
(3, 'Gandos', 'rizkydaijoss@gmail.com', 'makananenak'),
(4, 'Bijak', 'bijak@gmail.com', 'qwerty'),
(5, 'ngono', 'ngono', 'ngono'),
(6, 'ngono', 'ngono', 'ngono'),
(7, 'ngono', 'ngono', 'ngono');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `volley`
--
ALTER TABLE `volley`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `volley`
--
ALTER TABLE `volley`
  MODIFY `id` int(123) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
