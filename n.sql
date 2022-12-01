ALTER TABLE corona_ticketsuy.artista DROP FOREIGN KEY artista_ibfk_1;
ALTER TABLE corona_ticketsuy.artista_invitado DROP FOREIGN KEY artista_invitado_ibfk_1;
ALTER TABLE corona_ticketsuy.artista_invitado DROP FOREIGN KEY artista_invitado_ibfk_2;
ALTER TABLE corona_ticketsuy.categoria_espectaculo DROP FOREIGN KEY categoria_espectaculo_ibfk_1;
ALTER TABLE corona_ticketsuy.categoria_espectaculo DROP FOREIGN KEY categoria_espectaculo_ibfk_2;
ALTER TABLE corona_ticketsuy.compra_paquete DROP FOREIGN KEY compra_paquete_ibfk_1;
ALTER TABLE corona_ticketsuy.compra_paquete DROP FOREIGN KEY compra_paquete_ibfk_2;
ALTER TABLE corona_ticketsuy.espectaculo DROP FOREIGN KEY espectaculo_ibfk_1;
ALTER TABLE corona_ticketsuy.espectaculo DROP FOREIGN KEY plataforma_ibfk_1;
ALTER TABLE corona_ticketsuy.espectador DROP FOREIGN KEY espectador_ibfk_1;
ALTER TABLE corona_ticketsuy.funcion DROP FOREIGN KEY funcion_ibfk_1;
ALTER TABLE corona_ticketsuy.paquete_espectaculo DROP FOREIGN KEY paquete_espectaculo_ibfk_1;
ALTER TABLE corona_ticketsuy.paquete_espectaculo DROP FOREIGN KEY paquete_espectaculo_ibfk_2;
ALTER TABLE corona_ticketsuy.registro_funcion DROP FOREIGN KEY registro_funcion_ibfk_1;
ALTER TABLE corona_ticketsuy.registro_funcion DROP FOREIGN KEY registro_funcion_ibfk_2;
ALTER TABLE corona_ticketsuy.seguido DROP FOREIGN KEY seguido_ibfk_1;
ALTER TABLE corona_ticketsuy.seguido DROP FOREIGN KEY seguido_ibfk_2;

DROP TABLE artista;
DROP TABLE artista_invitado;
DROP TABLE categoria;
DROP TABLE categoria_espectaculo;
DROP TABLE compra_paquete;
DROP TABLE espectaculo;
DROP TABLE espectador;
DROP TABLE funcion;
DROP TABLE paquete;
DROP TABLE paquete_espectaculo;
DROP TABLE plataforma;
DROP TABLE registro_funcion;
DROP TABLE seguido;
DROP TABLE usuario;

DELIMITER //
CREATE PROCEDURE limpiar()
BEGIN

END//
DELIMITER ;

--                   asdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd


DELIMITER //
CREATE PROCEDURE limpiar()
BEGIN
ALTER TABLE artista DROP FOREIGN KEY artista_ibfk_1;
ALTER TABLE artista_invitado DROP FOREIGN KEY artista_invitado_ibfk_1;
ALTER TABLE artista_invitado DROP FOREIGN KEY artista_invitado_ibfk_2;
ALTER TABLE categoria_espectaculo DROP FOREIGN KEY categoria_espectaculo_ibfk_1;
ALTER TABLE categoria_espectaculo DROP FOREIGN KEY categoria_espectaculo_ibfk_2;
ALTER TABLE compra_paquete DROP FOREIGN KEY compra_paquete_ibfk_1;
ALTER TABLE compra_paquete DROP FOREIGN KEY compra_paquete_ibfk_2;
ALTER TABLE espectaculo DROP FOREIGN KEY espectaculo_ibfk_1;
ALTER TABLE espectaculo DROP FOREIGN KEY plataforma_ibfk_1;
ALTER TABLE espectador DROP FOREIGN KEY espectador_ibfk_1;
ALTER TABLE funcion DROP FOREIGN KEY funcion_ibfk_1;
ALTER TABLE paquete_espectaculo DROP FOREIGN KEY paquete_espectaculo_ibfk_1;
ALTER TABLE paquete_espectaculo DROP FOREIGN KEY paquete_espectaculo_ibfk_2;
ALTER TABLE registro_funcion DROP FOREIGN KEY registro_funcion_ibfk_1;
ALTER TABLE registro_funcion DROP FOREIGN KEY registro_funcion_ibfk_2;
ALTER TABLE seguido DROP FOREIGN KEY seguido_ibfk_1;
ALTER TABLE seguido DROP FOREIGN KEY seguido_ibfk_2;

DROP TABLE artista;
DROP TABLE artista_invitado;
DROP TABLE categoria;
DROP TABLE categoria_espectaculo;
DROP TABLE compra_paquete;
DROP TABLE espectaculo;
DROP TABLE espectador;
DROP TABLE funcion;
DROP TABLE paquete;
DROP TABLE paquete_espectaculo;
DROP TABLE plataforma;
DROP TABLE registro_funcion;
DROP TABLE seguido;
DROP TABLE usuario;


END//
DELIMITER ;

--        dsssssssssssssssssssssssssssssssss

DELIMITER //
CREATE PROCEDURE repoblar()
BEGIN
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
  `descripcion` varchar(1400) NOT NULL,
  `biografia` varchar(1400) NOT NULL,
  `sitio_web` varchar(1400) NOT NULL,
  `id` int(11) NOT NULL
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
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `nombre` varchar(200) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria_espectaculo`
--

CREATE TABLE `categoria_espectaculo` (
  `id_categoria` int(11) NOT NULL,
  `id_espectaculo` int(11) NOT NULL
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
  `nombre` varchar(200) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `duracion` int(11) NOT NULL,
  `min_espectador` int(11) NOT NULL,
  `max_espectador` int(11) NOT NULL,
  `url` varchar(200) NOT NULL,
  `costo` int(11) NOT NULL,
  `fecha_registro` date NOT NULL,
  `id` int(11) NOT NULL,
  `id_artista` int(11) NOT NULL,
  `id_plataforma` int(11) NOT NULL,
  `estado` varchar(200) NOT NULL,
  `imagen` longblob DEFAULT NULL
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
  `hora_inicio` int(11) NOT NULL,
  `fecha_registro` date NOT NULL,
  `id` int(11) NOT NULL,
  `id_espectaculo` int(11) NOT NULL,
  `imagen` longblob DEFAULT NULL
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
  `id` int(11) NOT NULL,
  `imagen` longblob DEFAULT NULL
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
-- Estructura de tabla para la tabla `plataforma`
--

CREATE TABLE `plataforma` (
  `nombre` varchar(200) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `url` varchar(200) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_funcion`
--

CREATE TABLE `registro_funcion` (
  `fecha_registro` date NOT NULL,
  `costo` int(11) NOT NULL,
  `id_funcion` int(11) NOT NULL,
  `id_espectador` int(11) NOT NULL,
  `canjeado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguido`
--

CREATE TABLE `seguido` (
  `id_seguidor` int(11) NOT NULL,
  `id_seguido` int(11) NOT NULL
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
  `id` int(11) NOT NULL,
  `contrasenia` varchar(200) NOT NULL,
  `imagen` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `artista`
--
ALTER TABLE `artista`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indices de la tabla `artista_invitado`
--
ALTER TABLE `artista_invitado`
  ADD PRIMARY KEY (`id_artista`,`id_funcion`),
  ADD KEY `id_artista` (`id_artista`),
  ADD KEY `id_funcion` (`id_funcion`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `categoria_espectaculo`
--
ALTER TABLE `categoria_espectaculo`
  ADD PRIMARY KEY (`id_categoria`,`id_espectaculo`),
  ADD KEY `id_categoria_2` (`id_categoria`),
  ADD KEY `id_espectaculo_2` (`id_espectaculo`);

--
-- Indices de la tabla `compra_paquete`
--
ALTER TABLE `compra_paquete`
  ADD PRIMARY KEY (`id_espectador`,`id_paquete`),
  ADD UNIQUE KEY `id_espectador` (`id_espectador`,`id_paquete`),
  ADD KEY `id_paquete` (`id_paquete`);

--
-- Indices de la tabla `espectaculo`
--
ALTER TABLE `espectaculo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_artista` (`id_artista`),
  ADD KEY `plataforma_ibfk_1` (`id_plataforma`);

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
  ADD PRIMARY KEY (`id_espectaculo`,`id_paquete`),
  ADD KEY `id_espectaculo` (`id_espectaculo`),
  ADD KEY `id_paquete` (`id_paquete`);

--
-- Indices de la tabla `plataforma`
--
ALTER TABLE `plataforma`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `registro_funcion`
--
ALTER TABLE `registro_funcion`
  ADD PRIMARY KEY (`id_funcion`,`id_espectador`),
  ADD KEY `id_funcion` (`id_funcion`),
  ADD KEY `id_espectador` (`id_espectador`) USING BTREE;

--
-- Indices de la tabla `seguido`
--
ALTER TABLE `seguido`
  ADD PRIMARY KEY (`id_seguido`,`id_seguidor`),
  ADD UNIQUE KEY `id_seguidor` (`id_seguidor`,`id_seguido`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `paquete`
--
ALTER TABLE `paquete`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `plataforma`
--
ALTER TABLE `plataforma`
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
-- Filtros para la tabla `categoria_espectaculo`
--
ALTER TABLE `categoria_espectaculo`
  ADD CONSTRAINT `categoria_espectaculo_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`),
  ADD CONSTRAINT `categoria_espectaculo_ibfk_2` FOREIGN KEY (`id_espectaculo`) REFERENCES `espectaculo` (`id`);

--
-- Filtros para la tabla `compra_paquete`
--
ALTER TABLE `compra_paquete`
  ADD CONSTRAINT `compra_paquete_ibfk_1` FOREIGN KEY (`id_espectador`) REFERENCES `espectador` (`id`),
  ADD CONSTRAINT `compra_paquete_ibfk_2` FOREIGN KEY (`id_paquete`) REFERENCES `paquete` (`id`);

--
-- Filtros para la tabla `espectaculo`
--
ALTER TABLE `espectaculo`
  ADD CONSTRAINT `espectaculo_ibfk_1` FOREIGN KEY (`id_artista`) REFERENCES `artista` (`id`),
  ADD CONSTRAINT `plataforma_ibfk_1` FOREIGN KEY (`id_plataforma`) REFERENCES `plataforma` (`id`);

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

--
-- Filtros para la tabla `seguido`
--
ALTER TABLE `seguido`
  ADD CONSTRAINT `seguido_ibfk_1` FOREIGN KEY (`id_seguidor`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `seguido_ibfk_2` FOREIGN KEY (`id_seguido`) REFERENCES `usuario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

END//
DELIMITER ;
