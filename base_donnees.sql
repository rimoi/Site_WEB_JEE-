-- phpMyAdmin SQL Dump
-- version 4.4.13.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 29, 2016 at 11:13 AM
-- Server version: 5.6.28-0ubuntu0.15.10.1
-- PHP Version: 5.6.11-1ubuntu3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `master`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `login` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`login`, `pass`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `annonce`
--

CREATE TABLE IF NOT EXISTS `annonce` (
  `id` int(11) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `intitule` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `annonce`
--

INSERT INTO `annonce` (`id`, `titre`, `intitule`) VALUES
(29, 'Soirée pour les étudiants', 'Une soirée où les étudiants de l''université dévoilent leurs talents d''artistes. Au programme : des performances artistiques en tout genre.'),
(30, 'Appel à candidatures 2016 - Bourses de la Fondation Palladio', 'La Fondation Palladio, ses fondateurs et ses mécènes, accompagnent les jeunes générations depuis 2008 en leur donnant les moyens de mener à bien leurs projets de formation ou de recherche dans les domaines liés à l''industrie immobilière et à la construction de la ville et des territoires...'),
(31, 'Concours "Filmer sa recherche"', 'Organisé dans le cadre du Festival du Film de Chercheur de Nancy qui se tiendra du 31 mai au 5 juin 2016, le concours "Filmer sa recherche" s''adresse à tout personnel rattaché administrativement à un laboratoire...'),
(32, 'Stage Pré-embauche Développeur Logiciel Web PHP JS DATA - AlumnForce', 'http://www.recrutdiploma.com/consult.php?offre=8aa90affw5whmywp4i&ref=967 ');

-- --------------------------------------------------------

--
-- Table structure for table `emploi_temps`
--

CREATE TABLE IF NOT EXISTS `emploi_temps` (
  `id` int(11) NOT NULL,
  `emploi` varchar(50) NOT NULL,
  `semestre` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emploi_temps`
--

INSERT INTO `emploi_temps` (`id`, `emploi`, `semestre`) VALUES
(8, 's1.jpg', 's1'),
(11, 's2.jpg', 's2'),
(12, 's3.jpg', 's3'),
(13, 's3.jpg', 's3');

-- --------------------------------------------------------

--
-- Table structure for table `enseignant`
--

CREATE TABLE IF NOT EXISTS `enseignant` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tele` varchar(50) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `ProfilsCours` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enseignant`
--

INSERT INTO `enseignant` (`id`, `nom`, `prenom`, `email`, `tele`, `ville`, `ProfilsCours`) VALUES
(1, 'AMANTON', 'Laurent', 'laurent@univ-lehavre.fr', '0212312312', 'Le Havre', 'Bases de données avancées, Système temps réel et ordonnancement'),
(2, 'DUVALLET', 'Claude', 'duvallet@univ-lehavre.fr', '0212312312', 'Le Havre', 'Administration systèmes et serveurs, Réseaux, Administration système et serveur'),
(3, 'PIGNE', 'Yoann', 'pigne@univ-lehavre.fr', '0212312312', 'Le Havre', 'Developpement web IDOD'),
(4, 'Alaoui', 'A.', 'aloui@univ-lehavre.fr', '067755443322', 'Le Havre', 'mathematique informatique'),
(5, 'Sadeg', 'M.', 'sadeg@univ-lehavre.fr', '0666778899', 'Le Havre', 'TAMD'),
(8, 'CHARRIER', 'Rodolphe', 'rodolphe.charrier@univ-lehavre.fr', '0212312312', 'Caen', 'Modélisation et programmation'),
(9, 'SANLAVILLE', 'Eric', 'eric.sanlaville@univ-lehavre.fr', '02', 'Bolbec', 'Optimisation combinatoire et métaheuristique appliquées à l’ingénierie, Modèles probabilistes pour\r\nl’informatique');

-- --------------------------------------------------------

--
-- Table structure for table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `id_promo` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`id`, `nom`, `prenom`, `email`, `id_promo`) VALUES
(7, 'asna', 'abderahman', 'asnaabderahman@gmail.com', 5),
(8, 'kacimi', 'Youssef', 'ucf@gmail.com', 5),
(9, 'slassi', 'soukina', 'slassi@gmail.com', 5),
(12, 'boudad', 'ayoub', 'boudad@gmail.com', 5),
(32, 'AL-AGEL', 'Mohammed', 'mohammed_alagel@yahoo.com', 2),
(33, 'MAQRANE', 'Zakaria', 'zak.maq@gmail.com', 1),
(34, 'KORCHAID', 'Radwane', 'kradwane@gmail.com', 4),
(35, 'KOARAICHI', 'El Mehdi', 'mehdi@gmail.com', 4);

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `message` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`id`, `nom`, `email`, `message`) VALUES
(3, 'mohd', 'mohammed_alagel@yahoo.com', 'kdsfkjhsjkdfhksjdf'),
(13, 'asna', 'asnaabderahman@gmail.com', 'etudiant en MATIS'),
(14, 'AL-AGEL', 'mohammed_alagel@yahoo.com', 'dfgdfgdfg'),
(15, 'AL-AGEL', 'mohammed_alagel@yahoo.com', 'dfgdfgdfg'),
(16, 'AL-AGEL', 'mohammed_alagel@yahoo.com', 'dfgdfgdfg'),
(17, 'AL-AGEL', 'mohammed_alagel@yahoo.com', 'dfgdfgdfg'),
(18, 'AL-AGEL', 'mohammed_alagel@yahoo.com', 'dfgdfgdfg'),
(19, 'AL-AGEL', 'mohammed_alagel@yahoo.com', 'dfgdfgdfg'),
(20, 'AL-AGEL', 'mohammed_alagel@yahoo.com', 'kjhgjkhfdjk gdfkgjkldflgjkd gdkfjlkjgldfklgjdf gdklfjglkdjfkglfd g;ldfkjg;ldfkl;gdf gdfl;gk;ldfkg;ldf gfdlgk;ldfkg;ldfg dflkgl;dfkgl;dfg l;dfkg;ldfkgl;df dl;fkgl;dfkgl; gdfl;gkl;dfkgfdg df;gk;ldfkg;lfdg');

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

CREATE TABLE IF NOT EXISTS `module` (
  `id` int(11) NOT NULL,
  `intitule` varchar(100) NOT NULL,
  `volume_hor` varchar(50) NOT NULL,
  `semestre` varchar(50) NOT NULL,
  `id_ens` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`id`, `intitule`, `volume_hor`, `semestre`, `id_ens`) VALUES
(3, 'Application et MÃ©thodologie des SI', '90h', 's1', 1),
(5, 'infrastructure et framework internet', '85h', 's1', 3),
(7, 'base de donnees avance et xml', '90h', 's2', 3),
(8, 'reseau locaux', '90h', 's2', 1),
(11, 'securite informatique', '90h', 's2', 2),
(12, 'm4', '90h', 's4', 4),
(13, 'Technologie web avancéé', '100h', 's3', 3),
(16, 'Systeme de gestion de base de donnees en temps reel (avance)', '100h', 's3', 5),
(17, 'OCM1', '50h', 's3', 9),
(19, 'CAW', '50h', 's4', 2),
(20, 'STR', '50h', 's1', 5),
(21, 'IDOD', '50h', 's4', 3);

-- --------------------------------------------------------

--
-- Table structure for table `preinscription`
--

CREATE TABLE IF NOT EXISTS `preinscription` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `cin` varchar(50) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `pays` varchar(50) NOT NULL,
  `adresse` varchar(500) NOT NULL,
  `tel` int(20) NOT NULL,
  `dernierDiplome` varchar(500) NOT NULL,
  `universiteObtention` varchar(500) NOT NULL,
  `mention` varchar(50) NOT NULL,
  `AnneObtention` date NOT NULL,
  `AutreDiplome` varchar(1000) NOT NULL,
  `confirmer` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `preinscription`
--

INSERT INTO `preinscription` (`id`, `nom`, `prenom`, `email`, `cin`, `ville`, `pays`, `adresse`, `tel`, `dernierDiplome`, `universiteObtention`, `mention`, `AnneObtention`, `AutreDiplome`, `confirmer`) VALUES
(1, 'asna', 'abderahman', 'asna_01@live.fr', 'ia156823', 'zaouia', 'maroc', '37 rue des chrageurs reunis', 666101523, 'm1', 'USMS', 'bien', '2015-01-01', 'bts', 1),
(2, 'AL-AGEL', 'Mohammed', 'mohammed_alagel@yahoo.com', '0000000000', 'Le Havre', 'Yemen', '8, Rue du Cdt. Chef d''HÃ´tel', 660053575, 'ajksdhjka', 'hjkahdkjsa', 'sjdkhfksjd', '2016-02-23', 'jkdsfhkjsdf', 1),
(3, 'AL-AGEL', 'Mohammed', 'mohammed_alagel@yahoo.com', '0000000000', 'Le Havre', 'Yemen', '8, Rue du Cdt. Chef d''HÃ?Â´tel', 660053575, 'ajksdhjka', 'hjkahdkjsa', 'sjdkhfksjd', '2016-02-23', 'jkdsfhkjsdf', NULL),
(4, 'AL-AGEL', 'Mohammed', 'mohammed_alagel@yahoo.com', '0000000000', 'Le Havre', 'Yemen', '8, Rue du Cdt. Chef d''HÃ?Â?Ã?Â´tel', 660053575, 'ajksdhjka', 'hjkahdkjsa', 'sjdkhfksjd', '2016-02-23', 'jkdsfhkjsdf', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

CREATE TABLE IF NOT EXISTS `promotion` (
  `id` int(11) NOT NULL,
  `annee` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`id`, `annee`) VALUES
(1, '2011-2013'),
(2, '2012-2014'),
(4, '2013-2015'),
(5, '2014-2016');

-- --------------------------------------------------------

--
-- Table structure for table `rapport`
--

CREATE TABLE IF NOT EXISTS `rapport` (
  `id` int(11) NOT NULL,
  `intitule` varchar(50) NOT NULL,
  `Rapp` varchar(50) NOT NULL,
  `id_etud` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rapport`
--

INSERT INTO `rapport` (`id`, `intitule`, `Rapp`, `id_etud`) VALUES
(9, 'site Master ISI', '7.pdf', 7),
(11, 'inscription license', '8.pdf', 8),
(14, 'gestion bibliothéque', '12.pdf', 12),
(16, 'Middlle ware', '9.pdf', 9);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`login`);

--
-- Indexes for table `annonce`
--
ALTER TABLE `annonce`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `emploi_temps`
--
ALTER TABLE `emploi_temps`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_promo` (`id_promo`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ens` (`id_ens`);

--
-- Indexes for table `preinscription`
--
ALTER TABLE `preinscription`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rapport`
--
ALTER TABLE `rapport`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_et` (`id_etud`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `annonce`
--
ALTER TABLE `annonce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `emploi_temps`
--
ALTER TABLE `emploi_temps`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `enseignant`
--
ALTER TABLE `enseignant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `module`
--
ALTER TABLE `module`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `preinscription`
--
ALTER TABLE `preinscription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `promotion`
--
ALTER TABLE `promotion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `rapport`
--
ALTER TABLE `rapport`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`id_promo`) REFERENCES `promotion` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `module_ibfk_1` FOREIGN KEY (`id_ens`) REFERENCES `enseignant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rapport`
--
ALTER TABLE `rapport`
  ADD CONSTRAINT `fk_et` FOREIGN KEY (`id_etud`) REFERENCES `etudiant` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
