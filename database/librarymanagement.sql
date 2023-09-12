-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 12 sep. 2023 à 11:45
-- Version du serveur : 10.4.25-MariaDB
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `librarymanagement`
--

-- --------------------------------------------------------

--
-- Structure de la table `adherent`
--

CREATE TABLE `adherent` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `numero_membre` varchar(255) DEFAULT NULL,
  `Numero_telephone` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `adherent`
--

INSERT INTO `adherent` (`id`, `nom`, `prenom`, `numero_membre`, `Numero_telephone`) VALUES
(1, 'moundir', 'anas', '12421231', '0681220938'),
(2, 'hicham', 'arifi', '12421231', '0653821883'),
(3, 'microfin', 'dotroim', '12421231', '0683211233'),
(4, 'kamka', 'hichan', '12421231', '0782391237'),
(5, 'insan', 'tablaoui', '12421231', '0589819387'),
(6, 'hicham', 'arifi', '12421232', '078247243');

--
-- Déclencheurs `adherent`
--
DELIMITER $$
CREATE TRIGGER `auto_increment` BEFORE INSERT ON `adherent` FOR EACH ROW BEGIN
    DECLARE last_numero_membre INT;

    SELECT MAX(numero_membre) INTO last_numero_membre FROM Adherent;
    IF last_numero_membre IS NULL THEN
        SET NEW.numero_membre = 1;
    ELSE
        SET NEW.numero_membre = last_numero_membre + 1;
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `auteur`
--

CREATE TABLE `auteur` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `auteur`
--

INSERT INTO `auteur` (`id`, `nom`, `address`) VALUES
(1, 'BoB', '2074 Margarita Square'),
(2, 'sam', 'Jeppesen Plads 328, st.'),
(3, 'chris', '	821 Janse van Rensburg Meadows Suite 205'),
(4, 'nabil ', 'ct 12843 rue labael 242 rio'),
(5, 'pauolo choello', 'youe 34234 district 12 kingslanding\r\n');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `id` int(11) NOT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `annee_publication` int(11) DEFAULT NULL,
  `quantiy` int(11) DEFAULT NULL,
  `auteur_id` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `ISBN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`id`, `titre`, `annee_publication`, `quantiy`, `auteur_id`, `status`, `ISBN`) VALUES
(1, 'the fault in our stars', 2008, 12, 1, NULL, 0),
(3, 'happy creation', 2004, 12, 1, NULL, 0),
(4, '12 creatip life', 2003, 0, 2, NULL, 0),
(5, '12 rules life', 1990, 89, 2, 1, 0),
(9, 'qwoirmoirw', 1990, 90, 1, NULL, 0),
(10, 'the fantastic four', 1990, 9, 1, NULL, 0),
(11, 'other book in the row', 1999, 19, 1, NULL, 0),
(12, 'book`', 1990, 10, 1, 1, 11432325);

-- --------------------------------------------------------

--
-- Structure de la table `livrecopy`
--

CREATE TABLE `livrecopy` (
  `id` int(11) NOT NULL,
  `livre_id` int(11) DEFAULT NULL,
  `etat` tinyint(1) DEFAULT NULL,
  `Nbr_emprunt` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `livrecopy`
--

INSERT INTO `livrecopy` (`id`, `livre_id`, `etat`, `Nbr_emprunt`) VALUES
(3, 5, 1, 9),
(12, 12, 1, 23),
(13, 3, 1, 4);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `livre_copy_id` int(11) DEFAULT NULL,
  `adherent_id` int(11) DEFAULT NULL,
  `date_reservation` date DEFAULT NULL,
  `date_limit` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id`, `livre_copy_id`, `adherent_id`, `date_reservation`, `date_limit`) VALUES
(1, 2, 3, '2001-01-03', '2002-01-03'),
(2, 1, 4, '2001-01-03', '2006-01-03'),
(3, 3, 3, '2001-03-03', '2023-09-11'),
(4, 1, 3, '2001-12-03', '2003-01-03'),
(5, 1, 3, '2001-02-03', '2004-01-03'),
(6, 3, 3, '2001-11-03', '2023-09-11'),
(7, 3, 1, '2023-09-10', '2023-09-11'),
(8, 3, 1, '2023-09-10', '2023-09-11'),
(9, 3, 1, '2023-09-10', '2023-09-11'),
(10, 3, 1, '2023-09-11', '2023-09-11'),
(11, 3, 1, '2023-09-11', '2023-09-11'),
(12, 3, 1, '2023-09-11', '2023-09-11'),
(13, 3, 1, '2023-09-11', '2023-09-11'),
(14, 3, 1, '2023-09-11', '2023-09-11'),
(15, 3, 1, '2023-09-11', '2023-09-11'),
(16, 3, 1, '2023-09-11', '2023-09-11'),
(17, 3, 1, '2023-09-11', '2023-09-11');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adherent`
--
ALTER TABLE `adherent`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `auteur`
--
ALTER TABLE `auteur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `auteur_id` (`auteur_id`);

--
-- Index pour la table `livrecopy`
--
ALTER TABLE `livrecopy`
  ADD PRIMARY KEY (`id`),
  ADD KEY `livre_id` (`livre_id`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `livre_copy_id` (`livre_copy_id`),
  ADD KEY `adherent_id` (`adherent_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adherent`
--
ALTER TABLE `adherent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `auteur`
--
ALTER TABLE `auteur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `livre`
--
ALTER TABLE `livre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `livrecopy`
--
ALTER TABLE `livrecopy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `livre`
--
ALTER TABLE `livre`
  ADD CONSTRAINT `livre_ibfk_1` FOREIGN KEY (`auteur_id`) REFERENCES `auteur` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Contraintes pour la table `livrecopy`
--
ALTER TABLE `livrecopy`
  ADD CONSTRAINT `livrecopy_ibfk_3` FOREIGN KEY (`livre_id`) REFERENCES `livre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`adherent_id`) REFERENCES `adherent` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
