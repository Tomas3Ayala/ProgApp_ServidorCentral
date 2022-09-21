-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-08-2022 a las 02:56:17
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `corona_ticketsuy`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artista`
--

CREATE TABLE `artista` (
  `descripcion` varchar(200) NOT NULL,
  `biografia` varchar(200) NOT NULL,
  `sitio_web` varchar(200) NOT NULL,
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artista_invitado`
--

CREATE TABLE `artista_invitado` (
  `id_artista` int(11) NOT NULL,
  `id_funcion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra_paquete`
--

CREATE TABLE `compra_paquete` (
  `id_espectador` int(11) NOT NULL,
  `id_paquete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `espectaculo`
--

CREATE TABLE `espectaculo` (
  `plataforma` varchar(200) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `duracion` int(11) NOT NULL,
  `min_espectador` int(11) NOT NULL,
  `max_espectador` int(11) NOT NULL,
  `url` varchar(200) NOT NULL,
  `costo` int(11) NOT NULL,
  `fecha_registro` date NOT NULL,
  `id` int(11) NOT NULL,
  `id_artista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `espectador`
--

CREATE TABLE `espectador` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcion`
--

CREATE TABLE `funcion` (
  `nombre` varchar(200) NOT NULL,
  `fecha` date NOT NULL,
  `hora_inicio` int NOT NULL,
  `fecha_registro` date NOT NULL,
  `id` int(11) NOT NULL,
  `id_espectaculo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete`
--

CREATE TABLE `paquete` (
  `nombre` varchar(200) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `descuento` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete_espectaculo`
--

CREATE TABLE `paquete_espectaculo` (
  `id_espectaculo` int(11) NOT NULL,
  `id_paquete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_funcion`
--

CREATE TABLE `registro_funcion` (
  `fecha_registro` date NOT NULL,
  `fecha_compra` date NOT NULL,
  `costo` int NOT NULL,
  `id_funcion` int(11) DEFAULT NULL,
  `id_espectador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `nickname` varchar(200) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `apellido` varchar(200) NOT NULL,
  `correo` varchar(200) NOT NULL,
  `nacimiento` date NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `artista`
--
ALTER TABLE `artista`
  ADD KEY `id` (`id`);

--
-- Indices de la tabla `artista_invitado`
--
ALTER TABLE `artista_invitado`
  ADD KEY `id_artista` (`id_artista`),
  ADD KEY `id_funcion` (`id_funcion`);

--
-- Indices de la tabla `compra_paquete`
--
ALTER TABLE `compra_paquete`
  ADD KEY `id_espectador` (`id_espectador`),
  ADD KEY `id_paquete` (`id_paquete`);

--
-- Indices de la tabla `espectaculo`
--
ALTER TABLE `espectaculo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_artista` (`id_artista`);

--
-- Indices de la tabla `espectador`
--
ALTER TABLE `espectador`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_espectaculo` (`id_espectaculo`);

--
-- Indices de la tabla `paquete`
--
ALTER TABLE `paquete`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `paquete_espectaculo`
--
ALTER TABLE `paquete_espectaculo`
  ADD KEY `id_espectaculo` (`id_espectaculo`),
  ADD KEY `id_paquete` (`id_paquete`);

--
-- Indices de la tabla `registro_funcion`
--
ALTER TABLE `registro_funcion`
  ADD PRIMARY KEY (`id_espectador`),
  ADD KEY `id_funcion` (`id_funcion`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `espectaculo`
--
ALTER TABLE `espectaculo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `espectador`
--
ALTER TABLE `espectador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `funcion`
--
ALTER TABLE `funcion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `paquete`
--
ALTER TABLE `paquete`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `artista`
--
ALTER TABLE `artista`
  ADD CONSTRAINT `artista_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `artista_invitado`
--
ALTER TABLE `artista_invitado`
  ADD CONSTRAINT `artista_invitado_ibfk_1` FOREIGN KEY (`id_artista`) REFERENCES `artista` (`id`),
  ADD CONSTRAINT `artista_invitado_ibfk_2` FOREIGN KEY (`id_funcion`) REFERENCES `funcion` (`id`);

--
-- Filtros para la tabla `compra_paquete`
--
ALTER TABLE `compra_paquete`
  ADD CONSTRAINT `compra_paquete_ibfk_1` FOREIGN KEY (`id_espectador`) REFERENCES `espectador` (`id`),
  ADD CONSTRAINT `compra_paquete_ibfk_4` FOREIGN KEY (`id_paquete`) REFERENCES `paquete` (`id`);

--
-- Filtros para la tabla `espectaculo`
--
ALTER TABLE `espectaculo`
  ADD CONSTRAINT `espectaculo_ibfk_1` FOREIGN KEY (`id_artista`) REFERENCES `artista` (`id`);

--
-- Filtros para la tabla `espectador`
--
ALTER TABLE `espectador`
  ADD CONSTRAINT `espectador_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD CONSTRAINT `funcion_ibfk_1` FOREIGN KEY (`id_espectaculo`) REFERENCES `espectaculo` (`id`);

--
-- Filtros para la tabla `paquete_espectaculo`
--
ALTER TABLE `paquete_espectaculo`
  ADD CONSTRAINT `paquete_espectaculo_ibfk_1` FOREIGN KEY (`id_espectaculo`) REFERENCES `espectaculo` (`id`),
  ADD CONSTRAINT `paquete_espectaculo_ibfk_2` FOREIGN KEY (`id_paquete`) REFERENCES `paquete` (`id`);

--
-- Filtros para la tabla `registro_funcion`
--
ALTER TABLE `registro_funcion`
  ADD CONSTRAINT `registro_funcion_ibfk_1` FOREIGN KEY (`id_funcion`) REFERENCES `funcion` (`id`),
  ADD CONSTRAINT `registro_funcion_ibfk_2` FOREIGN KEY (`id_espectador`) REFERENCES `espectador` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
