-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2023 at 02:30 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbbacanovel`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblogin`
--

CREATE TABLE `tblogin` (
  `email` varchar(30) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tblogin`
--

INSERT INTO `tblogin` (`email`, `nama`, `password`) VALUES
('fajari@gmail.com', 'fajari', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `tbnovel`
--

CREATE TABLE `tbnovel` (
  `id` int(1) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `penulis` varchar(50) NOT NULL,
  `genre` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbnovel`
--

INSERT INTO `tbnovel` (`id`, `nama`, `penulis`, `genre`, `status`) VALUES
(19, 'Laskar Pelangi', 'Andrea Hirata', 'Drama', 'Selesai'),
(20, 'Garis Waktu', 'Fiersa Besari', 'Fiksi Ilmiah', 'Selesai'),
(21, 'Negeri 5 Menara', ' Ahmad Fuadi', 'Pendidikan', 'Selesai'),
(22, 'Perahu Kertas', 'Dee Lestari', 'Romansa', 'Selesai'),
(23, 'Dilan: Dia Adalah Dilanku Tahun 1990', 'Pidi Baiq', 'Romansa', 'Selesai'),
(25, 'tes', 'tes', 'tes', 'Belum Selesai');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblogin`
--
ALTER TABLE `tblogin`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `tbnovel`
--
ALTER TABLE `tbnovel`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbnovel`
--
ALTER TABLE `tbnovel`
  MODIFY `id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
