-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-02-2020 a las 08:08:11
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
-- Base de datos: `jaspersoft_proyecto`
--
CREATE DATABASE IF NOT EXISTS `jaspersoft_proyecto` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `jaspersoft_proyecto`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `telefono` int(11) NOT NULL,
  `sexo` char(1) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `cp` varchar(20) NOT NULL,
  `provincia` varchar(100) NOT NULL,
  `localidad` varchar(100) NOT NULL,
  `recibir_caja` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `nombre`, `apellidos`, `correo`, `telefono`, `sexo`, `direccion`, `cp`, `provincia`, `localidad`, `recibir_caja`) VALUES
(1, 'Carlos', 'Salinas Navarrete', 'carlos20@gmail.com', 665436598, 'H', 'c/ Carrer del Comte d\'Urgell 11 2º B', '06520', 'Cataluña', 'Barcelona', 1),
(2, 'Andrea', 'Lopez Garcia', 'andrea20@gmail.com', 645145254, 'M', 'av/ Granada 6A 1º 1ª', '01540', 'Madrid', 'Madrid', 1),
(3, 'Eric', 'Sanz Moreno', 'eric20@gmail.com', 658324956, 'H', 'c/ Aceuchal 4º 6C', '09870', 'Jaen', 'Huelma', 1),
(4, 'Marc', 'Gutierrez Zamora', 'marc20@gmail.com', 753689541, 'H', 'c/ Arcos 96', '02140', 'Cataluña', 'Martorell', 1),
(5, 'Elsa', 'Puello Suarez', 'elsa20@gmail.com', 745362125, 'M', 'c/ Galicia 45 7A', '08760', 'Cataluña', 'Abrera', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hijos`
--

CREATE TABLE `hijos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `sexo` char(1) NOT NULL,
  `talla_ropa` varchar(100) NOT NULL,
  `talla_pie` varchar(100) NOT NULL,
  `id_padre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hijos`
--

INSERT INTO `hijos` (`id`, `nombre`, `apellidos`, `fecha_nacimiento`, `sexo`, `talla_ropa`, `talla_pie`, `id_padre`) VALUES
(1, 'Maria', 'Salinas Navarrete', '2020-02-11', 'M', '2-3 años', '23-24', 1),
(2, 'Julia', 'Salinas Navarrete', '2020-02-11', 'M', '6-7 años', '25-26', 1),
(3, 'Dana', 'Lopez Garcia', '2020-02-11', 'M', '9-10 años', '27-28', 2),
(4, 'Adrian', 'Lopez Garcia', '2020-02-11', 'H', '3-4 años', '23-24', 2),
(5, 'Fernanda', 'Sanz Moreno', '2020-02-11', 'M', '1-2 años', '21-22', 3),
(6, 'Oscar', 'Gutierrez Zamora', '2020-02-11', 'H', '2-3 años', '22-23', 4),
(7, 'Ariana', 'Puello Suarez', '2020-02-11', 'M', '1-2 años', '20-21', 5),
(8, 'Oriol', 'Puello Suarez', '2020-02-11', 'H', '4-5 años', '23-24', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `precio` float NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `descripcion`, `precio`, `stock`) VALUES
(1, 'Chubasquero marinero azul', 'Chubasquero azul marinero para niño y niña de la conocida marca marinera Batela. Un clásico que no pasa de moda. Ligero y calentito es ideal como prenda de abrigo en otoño y primavera para protegerse del viento y de la lluvia.', 36.89, 37),
(2, 'ZAPATILLAS INVIERNO NIÑOS CON FORRO PELO', 'Te presentamos las zapatillas de moda para esta temporada. Están fabricadas con un bonito material textil tipo gamuza y con un suave y calentito forrito interior de  pelito, estas zapatillas son ideales para equipar a tus hijos para la temporada de frío con un modelo de zapatos de invierno calentito', 70.99, 59),
(3, 'Jersey marinero', 'Jersey marinero para niña y niño. La calidad es muy buena. Es un jersey de los que se hereda y se mantiene nuevo de año en año. Únicamente hay que tener cuidado de no lavarlo en agua caliente ni utilizar secadora porque la lana se apelmaza.', 34.5, 50),
(4, 'Jersey gris greca verde', 'Jersey gris greca verde para niño y niña. Composición: 80% Lana, 20% Poliamida', 27.89, 32),
(5, 'COCHE CON LUCES Y SONIDO PLAYGRO', 'Divertido coche de juguete con luces y sonidos indicado para bebés a partir de 6 meses de edad.', 67.99, 68);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `hijos`
--
ALTER TABLE `hijos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `hijos`
--
ALTER TABLE `hijos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
