-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2016 at 01:36 PM
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

--
-- Dumping data for table `achievements`
--

INSERT INTO `achievements` (`id`, `profile_id`, `description`, `date`) VALUES
(14, 11, 'All my students are shining bright!!', '2016-05-05 08:17:27'),
(15, 19, 'My students are the toppers!!', '2016-05-05 08:21:57');

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

--
-- Dumping data for table `agents`
--

INSERT INTO `agents` (`id`, `agency_name`, `contact_person`, `contact_number`, `email`, `profile_pic`) VALUES
(4, 'ABC', 'XYZ', '9812345678', 'pqr@efg.com', 'default.jpg'),
(5, 'PQR', 'Abhirup', '9415748620', 'abc@gmail.com', 'default.jpg'),
(6, 'Abc', 'XYZ', '9852147963', 'abc@hotmail.com', 'default.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `atutors`
--

CREATE TABLE `atutors` (
  `id` int(255) NOT NULL,
  `profile_id` int(255) NOT NULL,
  `agent_id` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atutors`
--

INSERT INTO `atutors` (`id`, `profile_id`, `agent_id`) VALUES
(1, 19, 4),
(3, 22, 4),
(4, 23, 4),
(5, 24, 4),
(6, 26, 4);

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

--
-- Dumping data for table `contracts`
--

INSERT INTO `contracts` (`id`, `profile_id`, `student_id`, `remuneration`, `day_slot`, `time_slot`, `location`, `batch_size`, `status`, `date_opened`, `last_modified`) VALUES
(31, 11, 7, 500, '0010000', '18:00-19:30', '25,Kudghat Road', 'Single', 4, '2016-05-05 09:19:25', '2016-05-05 09:27:51'),
(33, 19, 7, 500, '0010000', '18:00-19:00', '25, Kudghat Road', 'Single', 2, '2016-05-05 09:37:22', '2016-05-05 11:18:47');

-- --------------------------------------------------------

--
-- Table structure for table `itutors`
--

CREATE TABLE `itutors` (
  `id` int(255) NOT NULL,
  `profile_id` int(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itutors`
--

INSERT INTO `itutors` (`id`, `profile_id`, `email`) VALUES
(1, 11, 'samirsen@gmail.com'),
(2, 12, 'abirsen@gmail.com'),
(3, 14, 'achow77@gmail.com'),
(4, 15, 'shamik13@gmail.com'),
(5, 16, 'abasu9876@gmail.com'),
(6, 17, 'pghosh65@gmail.com'),
(7, 18, '10dev01@gmail.com');

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

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`id`, `contract_id`, `message`, `date`, `direction`) VALUES
(1, 31, 'remuneration of 500, Tuesday slot at 6 p.m. location at 25,Kudghat Road, Batch preference as Alone.', '2016-05-05 09:26:08', 's-t'),
(5, 33, 'Remuneration 500, Tuesday @ 6 Pm, Alone at 25 kudghat road', '2016-05-05 09:38:51', 's-t');

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

--
-- Dumping data for table `profiles`
--

INSERT INTO `profiles` (`id`, `name`, `dob`, `gender`, `email`, `contact_number`, `address`, `discipline`, `disc_sub`, `experience`, `remuneration`, `day_slots`, `time_slots`, `location`, `batch_strength`, `description`, `ratings`, `rate_count`, `profile_pic`, `fields_show`) VALUES
(11, 'Samir Sen', '1980-03-10', 'male', 'samirsen@gmail.com', '9874125630', '12 Lake Road, Kolkata-700019', 'Academics', 'English', 10, 550, '1111111', '00:00-23:30', 'Any Location', 'Upto 10', 'Teaching', 0, 0, 'default.jpg', 8),
(12, 'Abir Sen', '1975-12-09', 'male', 'abirsen@gmail.com', 'N/A', 'N/A', 'Academics', 'Mathematics', 10, 550, '1111111', '00:00-23:30', 'Any Location', 'Upto 10', 'Teaching is my first love.', 0, 0, 'default.jpg', 8),
(14, 'Ashish Chowdhury', '1977-08-25', 'male', 'achow77@gmail.com', '9479425012', '26 Southern Avenue, Kolkata-700026', 'Acting', 'null', 10, 550, '1111111', '00:00-23:30', 'Any Location', 'Upto 10', 'Teaching is my first love.', 0, 0, 'default.jpg', 8),
(15, 'Shamik Kundu', '1995-04-13', 'male', 'shamik13@gmail.com', '8625741398', '55 Salt Lake, Kolkata-700091', 'Instruments', 'Guitar', 5, 750, '1111111', '00:00-23:30', 'Any Location', 'Upto 10', 'Teaching is my passion.', 0, 0, 'default.jpg', 8),
(16, 'Archana Basu', '1982-07-11', 'female', 'abasu9876@gmail.com', '8659741220', '56 Upen Banerjee Road, Kolkata-700053', 'Academics', 'English', 10, 550, '0110110', '00:00-23:30', 'Any Location', 'Upto 10', 'Teaching is my first love.', 0, 0, 'default.jpg', 8),
(17, 'Pritikona Ghosh', '1965-11-29', 'female', 'pghosh65@gmail.com', '9991127890', '25 Ballygunge Place, Kolkata-700019', 'Academics', 'Bengali', 10, 550, '1111111', '00:00-23:30', 'Any Location', 'Upto 10', 'Teaching is my first love.', 0, 0, 'default.jpg', 8),
(18, 'Devanjan Banerjee', '1993-12-20', 'male', '10dev01@gmail.com', '9875021436', 'Burdwan', 'Dance', 'Western', 0, 1500, '1111111', '08:00-10:00,11:00-13:00,15:00-17:00,18:00-20:00,20:30-22:30', 'Any Location', 'Any', 'MICHAEL JACKSON FAN!!', 0, 0, 'default.jpg', 8),
(19, 'Anirban Guha', '1980-03-10', 'male', 'ag007@gmail.com', '9857412300', '12 Lake Road, Kolkata-700019', 'Academics', 'English', 10, 550, '1111111', '00:00-23:30', 'Any Location', 'Upto 10', 'Teaching is my first love.', 5, 1, 'default.jpg', 8),
(22, 'Sagar Agarwal', '1980-03-10', 'male', 'sagarwal@gmail.com', '9857412368', '12 Lake Road, Kolkata-700019', 'Academics', 'English', 15, 550, '1111111', '00:00-23:30', 'Any Location', 'Upto 10', 'Acting is my passion.', 0, 0, 'default.jpg', 8),
(23, 'Ananya Banerjee', '1985-09-05', 'female', 'aban1234@gmail.com', '8596741230', 'Barasat', 'Academics', 'Physics', 5, 1250, '0110110', '09:00-21:00', 'Any Location', 'Upto 10', 'Physics is my strength.', 0, 0, 'default.jpg', 8),
(24, 'Rhea Saha', '1989-11-04', 'female', 'rsaha@gmail.com', '9857400123', '5 Behala Road, Kolkata-700053', 'Singing', 'Eastern Classical', 0, 900, '1111111', '10:00-22:00', 'Any Location', 'Any', 'Music is everything to me!!', 0, 0, 'default.jpg', 8),
(26, 'Ajay Dhar', '1960-04-09', 'male', 'ajaydhar@gmail.com', 'N/A', 'N/A', 'Academics', 'English', 10, 550, '1111111', '00:00-23:30', 'Any Location', 'Upto 10', 'teaching is my first love', 0, 0, 'default.jpg', 8);

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

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`id`, `profile_id`, `student_id`, `body`, `is_positive`, `date`) VALUES
(1, 19, 7, 'Very Good!!', 'true', '2016-05-05 08:29:02');

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

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `name`, `email`, `address`, `contact_number`, `profile_pic`, `fields_show`) VALUES
(7, 'Bhaskar Ghosh', 'bgd@gmail.com', '25 Kudghat Road, Kolkata-700093', '9632014587', 'default.jpg', 8),
(8, 'Neha Chatterjee', 'nehachat@gmail.com', 'N/A', 'N/A', 'default.jpg', 8);

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
-- Dumping data for table `users`
--

INSERT INTO `users` (`email`, `password`, `type`) VALUES
('10dev01@gmail.com', 'aeiou02468', 't'),
('abasu9876@gmail.com', 'aeiou02468', 't'),
('abc@gmail.com', 'abcd123', 'a'),
('abc@hotmail.com', 'abcd123', 'a'),
('abirsen@gmail.com', 'aeiou02468', 't'),
('achow77@gmail.com', 'aeiou02468', 't'),
('bgd@gmail.com', 'qwerty007', 's'),
('nehachat@gmail.com', 'qwerty007', 's'),
('pghosh65@gmail.com', 'aeiou02468', 't'),
('pqr@efg.com', 'abcd123', 'a'),
('samirsen@gmail.com', 'aeiou02468', 't'),
('shamik13@gmail.com', 'aeiou02468', 't');

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
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `agents`
--
ALTER TABLE `agents`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `atutors`
--
ALTER TABLE `atutors`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `contracts`
--
ALTER TABLE `contracts`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `itutors`
--
ALTER TABLE `itutors`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `profiles`
--
ALTER TABLE `profiles`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
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
