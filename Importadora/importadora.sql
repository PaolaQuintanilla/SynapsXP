-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-06-2017 a las 05:00:04
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `importadora`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `ID_CATEGORIA` int(11) NOT NULL,
  `CATEGORIA` varchar(20) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`ID_CATEGORIA`, `CATEGORIA`) VALUES
(1, 'automoviles'),
(2, 'electrodomesticos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `ID_CLIENTE` int(11) NOT NULL,
  `NOMBRE_CLIENTE` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `CI_CLIENTE` varchar(15) COLLATE utf8_bin NOT NULL,
  `DIRECCION_CLIENTE` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `TELEFONO_CLIENTE` int(11) DEFAULT NULL,
  `CELULAR_CLIENTE` int(11) DEFAULT NULL,
  `CORREO_CLIENTE` varchar(50) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`ID_CLIENTE`, `NOMBRE_CLIENTE`, `CI_CLIENTE`, `DIRECCION_CLIENTE`, `TELEFONO_CLIENTE`, `CELULAR_CLIENTE`, `CORREO_CLIENTE`) VALUES
(1, 'PAOLA QUINTANILLA', '1234567', 'panamericana /sin numero', 4545464, 75868364, 'paolita_cat@hotmail.com'),
(2, 'ALLAN QUINTEROS', '2345678', 'vinto', 44958372, 67688587, 'alambrito@hotmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalle` (
  `ID_DET` int(11) NOT NULL,
  `ID_PROVEEDOR` int(11) DEFAULT NULL,
  `ID_PRODUCTO` int(11) DEFAULT NULL,
  `PRECIO` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `detalle`
--

INSERT INTO `detalle` (`ID_DET`, `ID_PROVEEDOR`, `ID_PRODUCTO`, `PRECIO`) VALUES
(1, 1, 1, 500),
(2, 1, 2, 100000),
(3, 2, 3, 30000),
(4, 2, 4, 1000),
(5, 2, 5, 900);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

CREATE TABLE `detalle_pedido` (
  `ID_PEDIDO` int(11) DEFAULT NULL,
  `ID_DET_PRO` int(11) DEFAULT NULL,
  `CANTIDAD` int(11) DEFAULT NULL,
  `PRECIO_PARCIAL` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `ID_PEDIDO` int(11) NOT NULL,
  `ID_CLIENTE` int(11) DEFAULT NULL,
  `FECHA_PEDIDO` date DEFAULT NULL,
  `FECHA_LLEGADA` date DEFAULT NULL,
  `PRECIO_TOTAL` double DEFAULT NULL,
  `ESTADO` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `ID_PRODUCTO` int(11) NOT NULL,
  `ID_SUB_CAT` int(11) DEFAULT NULL,
  `PRODUCTO` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `MARCA` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `MODELO` varchar(20) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`ID_PRODUCTO`, `ID_SUB_CAT`, `PRODUCTO`, `MARCA`, `MODELO`) VALUES
(1, 4, 'telefono movil', 'sony', 'xperia'),
(2, 1, 'trailer', 'volvo', 'FH16'),
(3, 2, 'camioneta', 'toyota', 'tundra'),
(4, 3, 'laptop 15"', 'hp', 'pavilion g4'),
(5, 4, 'smart phone', 'samsung', 'S7');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `ID_PROVEEDOR` int(11) NOT NULL,
  `NOMBREP` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `CIP` varchar(15) COLLATE utf8_bin NOT NULL,
  `PASIP` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `CUENTAP` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `TELEFONOP` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `CORREOP` varchar(30) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`ID_PROVEEDOR`, `NOMBREP`, `CIP`, `PASIP`, `CUENTAP`, `TELEFONOP`, `CORREOP`) VALUES
(1, 'JUAN PEREZ', '5647382', 'ALEMANIA', '2122-232-2332-22', '59382859353', 'juanito@gmail.com'),
(2, 'jhon silvestre', '7564657', 'ESTADOS UNIDOS', '22-3442-215-2466-1', '232453453', 'jhon_silver@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sub_categoria`
--

CREATE TABLE `sub_categoria` (
  `ID_SUB_CAT` int(11) NOT NULL,
  `ID_CATEGORIA` int(11) DEFAULT NULL,
  `SUB_CATEGORIA` varchar(30) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `sub_categoria`
--

INSERT INTO `sub_categoria` (`ID_SUB_CAT`, `ID_CATEGORIA`, `SUB_CATEGORIA`) VALUES
(1, 1, 'pesado'),
(2, 1, 'liviano'),
(3, 2, 'computadora'),
(4, 2, 'telefono');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID_USUARIO` int(11) NOT NULL,
  `NOMBRE_USUARIO` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `CONTRASENIA` varchar(100) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID_USUARIO`, `NOMBRE_USUARIO`, `CONTRASENIA`) VALUES
(1, 'admin', 'admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`ID_CATEGORIA`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID_CLIENTE`);

--
-- Indices de la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`ID_DET`),
  ADD KEY `FK_REFERENCE_6` (`ID_PROVEEDOR`),
  ADD KEY `FK_REFERENCE_7` (`ID_PRODUCTO`);

--
-- Indices de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD KEY `FK_REFERENCE_4` (`ID_PEDIDO`),
  ADD KEY `FK_REFERENCE_8` (`ID_DET_PRO`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`ID_PEDIDO`),
  ADD KEY `FK_REFERENCE_5` (`ID_CLIENTE`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`ID_PRODUCTO`),
  ADD KEY `FK_REFERENCE_2` (`ID_SUB_CAT`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`ID_PROVEEDOR`);

--
-- Indices de la tabla `sub_categoria`
--
ALTER TABLE `sub_categoria`
  ADD PRIMARY KEY (`ID_SUB_CAT`),
  ADD KEY `FK_REFERENCE_1` (`ID_CATEGORIA`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID_USUARIO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `ID_CATEGORIA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `ID_CLIENTE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `detalle`
--
ALTER TABLE `detalle`
  MODIFY `ID_DET` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `ID_PRODUCTO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `ID_PROVEEDOR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `sub_categoria`
--
ALTER TABLE `sub_categoria`
  MODIFY `ID_SUB_CAT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD CONSTRAINT `FK_REFERENCE_6` FOREIGN KEY (`ID_PROVEEDOR`) REFERENCES `proveedor` (`ID_PROVEEDOR`),
  ADD CONSTRAINT `FK_REFERENCE_7` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `producto` (`ID_PRODUCTO`);

--
-- Filtros para la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD CONSTRAINT `FK_REFERENCE_4` FOREIGN KEY (`ID_PEDIDO`) REFERENCES `pedido` (`ID_PEDIDO`),
  ADD CONSTRAINT `FK_REFERENCE_8` FOREIGN KEY (`ID_DET_PRO`) REFERENCES `detalle` (`ID_DET`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK_REFERENCE_5` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID_CLIENTE`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `FK_REFERENCE_2` FOREIGN KEY (`ID_SUB_CAT`) REFERENCES `sub_categoria` (`ID_SUB_CAT`);

--
-- Filtros para la tabla `sub_categoria`
--
ALTER TABLE `sub_categoria`
  ADD CONSTRAINT `FK_REFERENCE_1` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categoria` (`ID_CATEGORIA`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
