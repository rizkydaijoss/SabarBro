-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: 19 Jul 2017 pada 23.49
-- Versi Server: 10.0.31-MariaDB-cll-lve
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `amranswandy_sabarbro`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `username` varchar(123) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `password` varchar(123) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(123) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`username`, `password`, `email`) VALUES
('admin', 'admin', 'admin'),
('', 'sd', 'qwea'),
('ddd', 'ddd', 'ddd'),
('eee', 'ree', 'ttt'),
('ttti', 'uuu', 'yyy'),
('ppp', 'ppp', 'ppp'),
('Ky.Jak.Dzik', 'Ky.Jak.Dzik@gmail.com', 'Bersama'),
('dollyshaka', 'dollyshaka@gmail.com', '123456'),
('shaka', '123', 'shakadolly@gmail.com'),
('Riezal06', 'Riezal06', 'fransco48@gmail.com'),
('skom', 'skom', 'skom@gaming.com');

-- --------------------------------------------------------

--
-- Struktur dari tabel `restoran`
--

CREATE TABLE `restoran` (
  `id_restoran` int(123) NOT NULL,
  `namarestoran` varchar(123) COLLATE utf8_unicode_ci NOT NULL,
  `alamat` text COLLATE utf8_unicode_ci NOT NULL,
  `menu` varchar(123) COLLATE utf8_unicode_ci NOT NULL,
  `harga` varchar(123) COLLATE utf8_unicode_ci NOT NULL,
  `fasilitas` varchar(123) COLLATE utf8_unicode_ci NOT NULL,
  `hp` varchar(123) COLLATE utf8_unicode_ci NOT NULL,
  `latitude` varchar(123) COLLATE utf8_unicode_ci NOT NULL,
  `longitude` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data untuk tabel `restoran`
--

INSERT INTO `restoran` (`id_restoran`, `namarestoran`, `alamat`, `menu`, `harga`, `fasilitas`, `hp`, `latitude`, `longitude`) VALUES
(1, 'Meet Up Cafe', 'Jalan Hos Cokroaminoto, Kreo, Kota Tangerang, Banten', 'Indomie Custom', '30.000', 'Bawa Pulang Tersedia', '0812-8383-8870', '-6.235064', '106.740530'),
(2, 'What\'s Up Cafe', 'Jl. Meruya Selatan No.19, RT.3/RW.2, Meruya Selatan, Kembangan, Kota Jakarta Barat, Daerah Khusus Ibukota Jakarta 11650', 'Street Food, Desserts, Indonesia', '30.000', 'Bawa Pulang Tersedia, Wifi Tersedia', '021 22542642', '-6.211752', '106.737470'),
(3, 'Kafe Ten', 'Jl. Haji Adam Malik, Kav. Deplu No.150, Ciledug, Tangerang', 'Makanan Cepat Saji', '40.000', 'Tempat duduk di luar, Bawa Pulang Tersedia, Wifi Tersedia', '-', '-6.247322', '106.745107'),
(4, 'Kedai Kopi Thai', 'Jl. Ciledug Raya No.18, Kreo Selatan, Larangan, Kota Tangerang', 'Makanan Cepat Saji Thailand', '40.000', 'Tempat duduk di luar', '021 73881818', '-6.236485', '106.745920'),
(5, 'Martabak Orins Ciledug', 'Jl. Ciledug Raya No.7, RT.1, Kreo Selatan, Larangan, Kota Tangerang', 'Desserts', '40.000', 'Pesan Antar', '0857-1026-2525', '-6.236491', '106.743747'),
(6, 'Tenda Ngemil', 'Jl. Hos Cokroaminoto No.6 Larangan, Kota Tangerang', 'Desserts and Bakes', '25.000', 'Bawa Pulang Tersedia', '0812-9835-0043', '-6.231444', '106.727873'),
(7, 'Tamarin Cafe', 'Jl. H Adam Malik Kav Deplu #161, Cipadu Jaya, Kota Tangerang', 'Main Course and Desserts', '24.000', 'Tempat Lesehan di alam terbuka', '-', '-6.248135', '106.746459'),
(8, 'Somay Bang Yono', 'Jl. Ciledug Raya No.1C, RT.10/RW.2, Petukangan Utara, Kota Jakarta Selatan', 'Nasi Goreng, Kwetiau, Mie, Nasi, Siomay', '10.000', 'Tersedia Tempat Luas', '(021) 99845370', '-6.236214', '106.747037'),
(9, 'Food Updated', 'Jl. Ciledug Raya No.6A, RT.10/RW.2, Petukangan Utara, Kota Jakarta Selatan', 'Street Food, Desserts', '30.000', 'Bawa Pulang Tersedia, Desserts and Bakes', '0813-8065-0123', '-6.236203', '106.748308'),
(10, 'Roti Bakar 88', 'Jl. Ciledug Raya No.27-29, Kreo, Kota Jakarta Selatan', 'Street Food, Roti Bakar', '35.000', 'Bawa Pulang Tersedia, Wifi Tersedia', '0878-7829-1585', '-6.236700', '106.749754'),
(11, 'Port Steak n Fish', 'Jl. Ciledug Raya No.2, RT.1/RW.1, Petukangan Utara, Kota Jakarta Selatan', 'Fish and Steak', '39.000', 'Wifi Tersedia', '0812-8865-5690', '-6.236243', '106.746082'),
(12, 'Warteg Bu Darti', 'Gg. H. Yamin, RT.1/RW.1, Petukangan Utara, Pesanggrahan, Kota Jakarta Selatan', 'Makanan Warteg', '10.000', '-', '-', '-6.235076', '106.746221');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tambah_restoran`
--

CREATE TABLE `tambah_restoran` (
  `namarestoran` varchar(123) COLLATE utf8_unicode_ci NOT NULL,
  `alamat` varchar(123) COLLATE utf8_unicode_ci NOT NULL,
  `menu` varchar(123) COLLATE utf8_unicode_ci NOT NULL,
  `harga` varchar(123) COLLATE utf8_unicode_ci NOT NULL,
  `fasilitas` varchar(123) COLLATE utf8_unicode_ci NOT NULL,
  `hp` varchar(123) COLLATE utf8_unicode_ci NOT NULL,
  `latitude` varchar(123) COLLATE utf8_unicode_ci NOT NULL,
  `longitude` varchar(123) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `restoran`
--
ALTER TABLE `restoran`
  ADD PRIMARY KEY (`id_restoran`);

--
-- Indexes for table `tambah_restoran`
--
ALTER TABLE `tambah_restoran`
  ADD PRIMARY KEY (`namarestoran`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `restoran`
--
ALTER TABLE `restoran`
  MODIFY `id_restoran` int(123) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
