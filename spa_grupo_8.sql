-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-10-2025 a las 01:03:54
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
  `codCliente` int(15) NOT NULL,
  `dni` bigint(15) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `telefono` bigint(100) NOT NULL,
  `edad` int(15) NOT NULL,
  `afecciones` varchar(100) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultorio`
--

DROP TABLE IF EXISTS `consultorio`;
CREATE TABLE `consultorio` (
  `nroConsultorio` int(10) NOT NULL,
  `usos` varchar(100) NOT NULL,
  `equipamiento` varchar(60) NOT NULL,
  `apto` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `codSesion` int(15) DEFAULT NULL,
  `monto` double(30,2) DEFAULT NULL,
  `estadoPago` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

DROP TABLE IF EXISTS `sesion`;
CREATE TABLE `sesion` (
  `codSesion` int(15) NOT NULL,
  `fechaHoraInicio` datetime(6) NOT NULL,
  `fechaHoraFin` datetime(6) NOT NULL,
  `codTratamiento` int(15) NOT NULL,
  `nroConsultorio` int(10) NOT NULL,
  `matricula` int(10) NOT NULL,
  `codInstalacion` int(10) NOT NULL,
  `codPack` int(10) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codCliente`);

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
  ADD KEY `fk_dia_de_spa_cliente` (`codCliente`),
  ADD KEY `codSesion` (`codSesion`);

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
  ADD KEY `fk_sesion_instalacion` (`codInstalacion`);

--
-- Indices de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  ADD PRIMARY KEY (`codTratamiento`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dia_de_spa`
--
ALTER TABLE `dia_de_spa`
  ADD CONSTRAINT `dia_de_spa_ibfk_1` FOREIGN KEY (`codSesion`) REFERENCES `sesion` (`codSesion`),
  ADD CONSTRAINT `fk_dia_de_spa_cliente` FOREIGN KEY (`codCliente`) REFERENCES `cliente` (`codCliente`);

--
-- Filtros para la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD CONSTRAINT `fk_sesion_consultorio` FOREIGN KEY (`nroConsultorio`) REFERENCES `consultorio` (`nroConsultorio`),
  ADD CONSTRAINT `fk_sesion_instalacion` FOREIGN KEY (`codInstalacion`) REFERENCES `instalacion` (`codInstalacion`),
  ADD CONSTRAINT `fk_sesion_masajista` FOREIGN KEY (`matricula`) REFERENCES `masajista` (`matricula`),
  ADD CONSTRAINT `fk_sesion_tratamiento` FOREIGN KEY (`codTratamiento`) REFERENCES `tratamiento` (`codTratamiento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
