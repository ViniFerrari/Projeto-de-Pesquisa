-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 13-Nov-2017 às 17:38
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdsenso`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbpesquisa`
--

CREATE TABLE `tbpesquisa` (
  `idp` int(11) NOT NULL,
  `nomep` varchar(80) NOT NULL,
  `sexop` varchar(10) NOT NULL,
  `idadep` int(3) NOT NULL,
  `grauip` varchar(80) NOT NULL,
  `contap` int(3) NOT NULL,
  `salariop` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbpesquisa`
--

INSERT INTO `tbpesquisa` (`idp`, `nomep`, `sexop`, `idadep`, `grauip`, `contap`, `salariop`) VALUES
(17, '', 'Feminino', 14, 'Ens. Fundamental (Incompleto)', 1, 'R$0,00 - R$1000,00'),
(18, 'AAA', 'Feminino', 14, 'Ens. Fundamental (Incompleto)', 0, 'R$0,00 - R$1000,00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbpesquisa`
--
ALTER TABLE `tbpesquisa`
  ADD PRIMARY KEY (`idp`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbpesquisa`
--
ALTER TABLE `tbpesquisa`
  MODIFY `idp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
