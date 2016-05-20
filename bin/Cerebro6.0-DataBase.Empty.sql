-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2016 at 03:19 AM
-- Server version: 10.1.8-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tutandstud`
--
CREATE DATABASE IF NOT EXISTS `tutandstud` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `tutandstud`;
-- --------------------------------------------------------

--
-- Table structure for table `achievements`
--

CREATE TABLE `achievements` (
  `id` int(255) NOT NULL,
  `profile_id` int(255) NOT NULL,
  `description` text NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `agents`
--

CREATE TABLE `agents` (
  `id` int(255) NOT NULL,
  `agency_name` varchar(255) NOT NULL,
  `contact_person` varchar(255) NOT NULL,
  `contact_number` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `profile_pic` varchar(255) NOT NULL DEFAULT 'default.jpg'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `atutors`
--

CREATE TABLE `atutors` (
  `id` int(255) NOT NULL,
  `profile_id` int(255) NOT NULL,
  `agent_id` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `contracts`
--

CREATE TABLE `contracts` (
  `id` int(255) NOT NULL,
  `profile_id` int(255) NOT NULL,
  `student_id` int(255) NOT NULL,
  `remuneration` double NOT NULL,
  `day_slot` varchar(7) NOT NULL,
  `time_slot` text NOT NULL,
  `location` varchar(255) NOT NULL,
  `batch_size` varchar(255) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `date_opened` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `itutors`
--

CREATE TABLE `itutors` (
  `id` int(255) NOT NULL,
  `profile_id` int(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `id` int(255) NOT NULL,
  `contract_id` int(255) NOT NULL,
  `message` text NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `direction` enum('s-t','t-s') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `profiles`
--

CREATE TABLE `profiles` (
  `id` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `dob` date NOT NULL,
  `gender` enum('male','female') NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `address` text,
  `discipline` varchar(255) NOT NULL,
  `disc_sub` varchar(255) NOT NULL,
  `experience` int(3) NOT NULL,
  `remuneration` double NOT NULL,
  `day_slots` varchar(7) NOT NULL,
  `time_slots` text NOT NULL,
  `location` varchar(255) NOT NULL,
  `batch_strength` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `ratings` int(11) NOT NULL DEFAULT '0',
  `rate_count` int(255) NOT NULL DEFAULT '0',
  `profile_pic` varchar(255) NOT NULL DEFAULT 'default.jpg',
  `fields_show` tinyint(1) NOT NULL DEFAULT '8'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `id` int(255) NOT NULL,
  `profile_id` int(255) NOT NULL,
  `student_id` int(255) NOT NULL,
  `body` text NOT NULL,
  `is_positive` enum('true','false') NOT NULL DEFAULT 'true',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` text NOT NULL,
  `contact_number` varchar(255) NOT NULL,
  `profile_pic` varchar(255) NOT NULL DEFAULT 'default.jpg',
  `fields_show` tinyint(1) NOT NULL DEFAULT '8'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` enum('a','s','t') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `achievements`
--
ALTER TABLE `achievements`
  ADD PRIMARY KEY (`id`),
  ADD KEY `profile_id` (`profile_id`);

--
-- Indexes for table `agents`
--
ALTER TABLE `agents`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `atutors`
--
ALTER TABLE `atutors`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `profile_id` (`profile_id`),
  ADD KEY `agent_id` (`agent_id`);

--
-- Indexes for table `contracts`
--
ALTER TABLE `contracts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `profile_id` (`profile_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `itutors`
--
ALTER TABLE `itutors`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `profile_id` (`profile_id`),
  ADD KEY `email` (`email`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `contract_id` (`contract_id`);

--
-- Indexes for table `profiles`
--
ALTER TABLE `profiles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id`),
  ADD KEY `profile_id` (`profile_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `achievements`
--
ALTER TABLE `achievements`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `agents`
--
ALTER TABLE `agents`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `atutors`
--
ALTER TABLE `atutors`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `contracts`
--
ALTER TABLE `contracts`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `itutors`
--
ALTER TABLE `itutors`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `profiles`
--
ALTER TABLE `profiles`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `achievements`
--
ALTER TABLE `achievements`
  ADD CONSTRAINT `FK_PROF_ACH` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`);

--
-- Constraints for table `agents`
--
ALTER TABLE `agents`
  ADD CONSTRAINT `FK_USER_AGENT` FOREIGN KEY (`email`) REFERENCES `users` (`email`);

--
-- Constraints for table `atutors`
--
ALTER TABLE `atutors`
  ADD CONSTRAINT `FK_AGENT_ATUT` FOREIGN KEY (`agent_id`) REFERENCES `agents` (`id`),
  ADD CONSTRAINT `FK_PROF_ATUT` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`);

--
-- Constraints for table `contracts`
--
ALTER TABLE `contracts`
  ADD CONSTRAINT `FK_PROF_CONT` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`),
  ADD CONSTRAINT `FK_STUD_CONT` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`);

--
-- Constraints for table `itutors`
--
ALTER TABLE `itutors`
  ADD CONSTRAINT `FK_PROF_ITUT` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`),
  ADD CONSTRAINT `FK_USER_ITUT` FOREIGN KEY (`email`) REFERENCES `users` (`email`);

--
-- Constraints for table `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `FK_CONT_MSG` FOREIGN KEY (`contract_id`) REFERENCES `contracts` (`id`);

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `FK_PROF_REVIEW` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`),
  ADD CONSTRAINT `FK_STUD_REVIEW` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`);

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `FK_USER_STUD` FOREIGN KEY (`email`) REFERENCES `users` (`email`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
