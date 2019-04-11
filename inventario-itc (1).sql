-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-04-2019 a las 17:55:16
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inventario-itc`
--
CREATE DATABASE IF NOT EXISTS `inventario-itc` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `inventario-itc`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `area`
--

CREATE TABLE `area` (
  `id` int(10) UNSIGNED NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `area`
--

INSERT INTO `area` (`id`, `descripcion`) VALUES
(1, 'Sistemas'),
(2, 'Direccion'),
(3, 'aula  101');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encargado`
--

CREATE TABLE `encargado` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido_p` varchar(50) NOT NULL,
  `apellido_m` varchar(50) NOT NULL,
  `puesto` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `encargado`
--

INSERT INTO `encargado` (`id`, `nombre`, `apellido_p`, `apellido_m`, `puesto`) VALUES
(1, 'Oliver', 'Vilchis', 'Vasuqez', 'Sistemas'),
(2, 'Jose', 'Ruiz', 'Cornejo', 'Contador'),
(3, 'Isaac', 'Vilchis', 'Tapia', 'Sistemas'),
(5, 'Sehili', '', '', 'Profesora');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `id` varchar(50) NOT NULL,
  `id_tipo` int(11) UNSIGNED DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `e_fisico` tinyint(11) DEFAULT NULL,
  `id_area` int(11) UNSIGNED DEFAULT NULL,
  `id_nombre` int(11) UNSIGNED DEFAULT NULL,
  `detalle` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`id`, `id_tipo`, `descripcion`, `marca`, `modelo`, `e_fisico`, `id_area`, `id_nombre`, `detalle`) VALUES
('001', 3, 'silla', 'sn', 'sn', -1, 1, 1, ''),
('002', 4, 'computadora', 'sn', 'sn', 0, 2, 1, ''),
('003', 4, 'cañon', 'sn', 'sn', 1, 2, 2, ''),
('004', 3, 'mesa', 'np', 'np', 0, 1, 1, 'np'),
('005', 3, 'camputadora', 'SN', 'SN', -1, 1, 1, 'SN');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `inventariovista`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `inventariovista` (
`id` varchar(50)
,`categoria` varchar(50)
,`descripcion` varchar(100)
,`marca` varchar(50)
,`modelo` varchar(50)
,`e_fisico` tinyint(11)
,`area` varchar(100)
,`encargado` varchar(101)
,`detalle` text
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

CREATE TABLE `tipo` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo`
--

INSERT INTO `tipo` (`id`, `nombre`, `descripcion`) VALUES
(3, 'mobiliario', 'oficina'),
(4, 'computo', 'electronica'),
(5, 'oio', 'oio');

-- --------------------------------------------------------

--
-- Estructura para la vista `inventariovista`
--
DROP TABLE IF EXISTS `inventariovista`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `inventariovista`  AS  select `a`.`id` AS `id`,`b`.`nombre` AS `categoria`,`a`.`descripcion` AS `descripcion`,`a`.`marca` AS `marca`,`a`.`modelo` AS `modelo`,`a`.`e_fisico` AS `e_fisico`,`c`.`descripcion` AS `area`,concat(`d`.`nombre`,' ',`d`.`apellido_p`) AS `encargado`,`a`.`detalle` AS `detalle` from (((`inventario` `a` join `tipo` `b`) join `area` `c`) join `encargado` `d`) where ((`a`.`id_tipo` = `b`.`id`) and (`a`.`id_area` = `c`.`id`) and (`a`.`id_nombre` = `d`.`id`)) order by `a`.`id` ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `encargado`
--
ALTER TABLE `encargado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tipo` (`id_tipo`),
  ADD KEY `id_nombre` (`id_nombre`),
  ADD KEY `id_area` (`id_area`);

--
-- Indices de la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `area`
--
ALTER TABLE `area`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `encargado`
--
ALTER TABLE `encargado`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tipo`
--
ALTER TABLE `tipo`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `inventario_ibfk_3` FOREIGN KEY (`id_tipo`) REFERENCES `tipo` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `inventario_ibfk_4` FOREIGN KEY (`id_nombre`) REFERENCES `encargado` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `inventario_ibfk_5` FOREIGN KEY (`id_area`) REFERENCES `area` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
