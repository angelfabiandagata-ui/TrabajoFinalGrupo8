-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-11-2025 a las 17:04:09
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `spa_grupo_8`
--
CREATE DATABASE IF NOT EXISTS `spa_grupo_8` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `spa_grupo_8`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `CodCliente` int(11) NOT NULL,
  `dni` bigint(15) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `telefono` bigint(100) NOT NULL,
  `edad` int(15) NOT NULL,
  `afecciones` varchar(100) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`CodCliente`, `dni`, `nombre`, `apellido`, `telefono`, `edad`, `afecciones`, `estado`) VALUES
(1, 36881187, 'Fabian DAgata', '', 2664759571, 33, 'Alergico', 1),
(2, 36333333, 'Guillermo', 'Lopez', 2665000111, 35, 'Ninguna', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultorio`
--

DROP TABLE IF EXISTS `consultorio`;
CREATE TABLE `consultorio` (
  `nroConsultorio` int(11) NOT NULL,
  `usos` varchar(100) NOT NULL,
  `equipamiento` varchar(60) NOT NULL,
  `apto` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `consultorio`
--

INSERT INTO `consultorio` (`nroConsultorio`, `usos`, `equipamiento`, `apto`) VALUES
(1, '1', 'Masajes', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dia_de_spa`
--

DROP TABLE IF EXISTS `dia_de_spa`;
CREATE TABLE `dia_de_spa` (
  `codPack` int(10) NOT NULL,
  `fechaYHora` datetime DEFAULT NULL,
  `preferencias` varchar(60) DEFAULT NULL,
  `codCliente` int(15) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `estadoPago` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dia_de_spa`
--

INSERT INTO `dia_de_spa` (`codPack`, `fechaYHora`, `preferencias`, `codCliente`, `estado`, `estadoPago`) VALUES
(0, '2025-11-17 19:29:48', 'Sin Preferencia', 1, 1, 0),
(2, '2025-11-24 19:43:11', 'Sin Preferencia', 1, 1, 0),
(3, '2025-11-18 19:44:21', 'Sin Preferencia', 1, 1, 0),
(4, '2025-11-27 09:58:23', 'Sin Preferencia', 2, 1, 0),
(10, '2025-11-19 11:12:32', 'Sin Preferencia', 2, 1, 0),
(11, '2025-11-18 11:21:01', 'Sin Preferencia', 1, 1, 0),
(15, '2025-11-19 11:23:26', 'Sin Preferencia', 1, 1, 0),
(16, '2025-11-19 11:23:26', 'Sin Preferencia', 2, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instalacion`
--

DROP TABLE IF EXISTS `instalacion`;
CREATE TABLE `instalacion` (
  `codInstalacion` int(10) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `detalle_uso` varchar(60) DEFAULT NULL,
  `precio30m` double(30,2) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `instalacion`
--

INSERT INTO `instalacion` (`codInstalacion`, `nombre`, `detalle_uso`, `precio30m`, `estado`) VALUES
(1, 'Espacio para el Relax', 'Amplio Espacio con Jacuzzi', 10000.00, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `masajista`
--

DROP TABLE IF EXISTS `masajista`;
CREATE TABLE `masajista` (
  `matricula` int(10) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `telefono` bigint(100) NOT NULL,
  `especialidad` varchar(60) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `masajista`
--

INSERT INTO `masajista` (`matricula`, `nombre`, `apellido`, `telefono`, `especialidad`, `estado`) VALUES
(1, 'Eduardo', 'Lopez', 2664000000, 'Facial', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

DROP TABLE IF EXISTS `sesion`;
CREATE TABLE `sesion` (
  `codSesion` int(15) NOT NULL,
  `fechaHoraInicio` datetime(6) NOT NULL,
  `fechaHoraFin` datetime(6) NOT NULL,
  `codTratamiento` int(15) DEFAULT NULL,
  `nroConsultorio` int(11) DEFAULT NULL,
  `matricula` int(10) DEFAULT NULL,
  `codInstalacion` int(10) DEFAULT NULL,
  `codPack` int(10) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `monto` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sesion`
--

INSERT INTO `sesion` (`codSesion`, `fechaHoraInicio`, `fechaHoraFin`, `codTratamiento`, `nroConsultorio`, `matricula`, `codInstalacion`, `codPack`, `estado`, `monto`) VALUES
(1, '2025-11-17 12:00:00.000000', '2025-11-17 13:00:00.000000', 1, 1, 1, NULL, 0, 1, 5000),
(2, '2025-11-17 12:00:00.000000', '2025-11-17 13:00:00.000000', NULL, NULL, NULL, 1, 0, 1, 5000),
(4, '2025-11-27 12:00:00.000000', '2025-11-27 14:00:00.000000', 1, 1, 1, NULL, 4, 1, 2000),
(10, '2025-11-19 12:00:00.000000', '2025-11-19 14:00:00.000000', 2, 1, 1, NULL, 10, 1, 10000),
(11, '2025-11-18 12:00:00.000000', '2025-11-18 14:00:00.000000', 1, 1, 1, NULL, 11, 1, 2000),
(15, '2025-11-19 15:00:00.000000', '2025-11-19 16:00:00.000000', 2, 1, 1, NULL, 15, 1, 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamiento`
--

DROP TABLE IF EXISTS `tratamiento`;
CREATE TABLE `tratamiento` (
  `codTratamiento` int(10) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `detalle` varchar(60) DEFAULT NULL,
  `productos` varchar(60) DEFAULT NULL,
  `duracion` time(6) DEFAULT NULL,
  `costo` double(30,2) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tratamiento`
--

INSERT INTO `tratamiento` (`codTratamiento`, `nombre`, `detalle`, `productos`, `duracion`, `costo`, `estado`) VALUES
(1, 'Masaje Facial', 'Masaje facial antiarrugas', '', '01:00:00.000000', 1000.00, 1),
(2, 'Masaje cuerpo', 'Masaje Completo', '', '01:00:00.000000', 5000.00, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`CodCliente`);

--
-- Indices de la tabla `consultorio`
--
ALTER TABLE `consultorio`
  ADD PRIMARY KEY (`nroConsultorio`);

--
-- Indices de la tabla `dia_de_spa`
--
ALTER TABLE `dia_de_spa`
  ADD PRIMARY KEY (`codPack`),
  ADD KEY `fk_dia_de_spa_cliente` (`codCliente`);

--
-- Indices de la tabla `instalacion`
--
ALTER TABLE `instalacion`
  ADD PRIMARY KEY (`codInstalacion`);

--
-- Indices de la tabla `masajista`
--
ALTER TABLE `masajista`
  ADD PRIMARY KEY (`matricula`);

--
-- Indices de la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD PRIMARY KEY (`codSesion`),
  ADD KEY `fk_sesion_consultorio` (`nroConsultorio`),
  ADD KEY `fk_sesion_masajista` (`matricula`),
  ADD KEY `fk_sesion_tratamiento` (`codTratamiento`),
  ADD KEY `fk_sesion_instalacion` (`codInstalacion`),
  ADD KEY `codPack` (`codPack`);

--
-- Indices de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  ADD PRIMARY KEY (`codTratamiento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `CodCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `consultorio`
--
ALTER TABLE `consultorio`
  MODIFY `nroConsultorio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dia_de_spa`
--
ALTER TABLE `dia_de_spa`
  ADD CONSTRAINT `fk_dia_de_spa_cliente` FOREIGN KEY (`codCliente`) REFERENCES `cliente` (`codCliente`);

--
-- Filtros para la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD CONSTRAINT `codPack` FOREIGN KEY (`codPack`) REFERENCES `dia_de_spa` (`codPack`),
  ADD CONSTRAINT `fk_sesion_consultorio` FOREIGN KEY (`nroConsultorio`) REFERENCES `consultorio` (`nroConsultorio`),
  ADD CONSTRAINT `fk_sesion_instalacion` FOREIGN KEY (`codInstalacion`) REFERENCES `instalacion` (`codInstalacion`),
  ADD CONSTRAINT `fk_sesion_masajista` FOREIGN KEY (`matricula`) REFERENCES `masajista` (`matricula`),
  ADD CONSTRAINT `fk_sesion_tratamiento` FOREIGN KEY (`codTratamiento`) REFERENCES `tratamiento` (`codTratamiento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
