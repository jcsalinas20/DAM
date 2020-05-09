-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-01-2020 a las 17:56:33
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `forhonor`
--
CREATE DATABASE IF NOT EXISTS `forhonor` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `forhonor`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `faccion`
--

CREATE TABLE `faccion` (
  `faccion_id` int(11) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `lore` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `faccion`
--

INSERT INTO `faccion` (`faccion_id`, `nombre`, `lore`) VALUES
(1, 'Caballeros', 'Originalmente los caballeros pertenecían a familias nobles o poseían títulos especiales que ensalzaban su noble comportamiento.'),
(2, 'Vikingos', 'Los vikingos fueron guerreros escandinavos que entre el siglo VIII y XI realizaron múltiples incursiones en el continente europeo para perpetrar ataques y saqueos.'),
(3, 'Samurais', 'Los samuráis eran militares que vivieron en la época del Japón feudal y su función principal era defender a los nobles.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personaje`
--

CREATE TABLE `personaje` (
  `personaje_id` int(11) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `ataque` int(11) NOT NULL,
  `defensa` int(11) NOT NULL,
  `faccion_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `personaje`
--

INSERT INTO `personaje` (`personaje_id`, `nombre`, `ataque`, `defensa`, `faccion_id`) VALUES
(1, 'Pacificadora', 90, 70, 1),
(2, 'Conquistador', 140, 100, 1),
(3, 'Justiciero', 110, 80, 1),
(4, 'Huscarle', 125, 100, 2),
(5, 'Invasor', 130, 70, 2),
(6, 'Nobushi', 80, 120, 3),
(7, 'Kensei', 70, 150, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `faccion`
--
ALTER TABLE `faccion`
  ADD PRIMARY KEY (`faccion_id`);

--
-- Indices de la tabla `personaje`
--
ALTER TABLE `personaje`
  ADD PRIMARY KEY (`personaje_id`),
  ADD KEY `faccion_id` (`faccion_id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `personaje`
--
ALTER TABLE `personaje`
  ADD CONSTRAINT `personaje_ibfk_1` FOREIGN KEY (`faccion_id`) REFERENCES `faccion` (`faccion_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
