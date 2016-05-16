-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-05-2016 a las 01:09:57
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prueba`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos`
--

CREATE TABLE `eventos` (
  `id_event` int(11) NOT NULL,
  `autor` text NOT NULL,
  `national` text NOT NULL,
  `date` text NOT NULL,
  `country` text NOT NULL,
  `city` text NOT NULL,
  `address` text NOT NULL,
  `participant` text NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `eventos`
--

INSERT INTO `eventos` (`id_event`, `autor`, `national`, `date`, `country`, `city`, `address`, `participant`, `description`) VALUES
(4, 'luis', 'Mexican', '10/21/2011', 'Spain', 'Seville', 'Santa Maria', '6', 'Tacos'),
(5, 'ant', 'UK', '10/20/2015', 'Spain', 'Seville', 'Santa...', '5', 'fish and chips'),
(6, 'ant', 'Spain', '10/05', 'Spain', 'Murcia', 'plaza...', '5', 'tortilla'),
(7, 'ire', 'Greece', '10/05', 'Spain', 'Seville', 'Santa', '2', 'fsdfsd'),
(8, 'ant', 'turca', '17', 'espa', 'sevilla', 'calle andres segovia', '2', 'kebab');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `participantes`
--

CREATE TABLE `participantes` (
  `id_participantes` int(11) NOT NULL,
  `id_evento` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `participantes`
--

INSERT INTO `participantes` (`id_participantes`, `id_evento`, `id_usuario`) VALUES
(22, 5, 1),
(23, 6, 1),
(31, 7, 3),
(33, 8, 1),
(34, 8, 3),
(55, 4, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `id` text NOT NULL,
  `pass` text NOT NULL,
  `email` text NOT NULL,
  `phone` text NOT NULL,
  `country` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id_user`, `id`, `pass`, `email`, `phone`, `country`) VALUES
(1, 'ant', 'ant', 'ant', '618', 'Spain'),
(2, 'antonio', 'ant', 'ant', '618', 'Spain'),
(3, 'ire', 'ire', 'ire', '543534', 'Spain'),
(4, 'luis', 'luis', 'luis', '48902384238', 'Spain'),
(5, 'david', 'david', 'david', '9409293', 'Spain'),
(6, 'sero', 'sero', 'sero', '78689679', 'UK'),
(7, 'raquel', 'raquel', 'raquel', '5435435943', 'Spain'),
(8, 'liandre', 'liandre', 'liandre', '42394023904932', 'Spain');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`id_event`);

--
-- Indices de la tabla `participantes`
--
ALTER TABLE `participantes`
  ADD PRIMARY KEY (`id_participantes`),
  ADD KEY `id_evento` (`id_evento`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `eventos`
--
ALTER TABLE `eventos`
  MODIFY `id_event` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `participantes`
--
ALTER TABLE `participantes`
  MODIFY `id_participantes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;
--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `participantes`
--
ALTER TABLE `participantes`
  ADD CONSTRAINT `eliminarEvento` FOREIGN KEY (`id_evento`) REFERENCES `eventos` (`id_event`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
