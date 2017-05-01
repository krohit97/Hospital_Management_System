-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2017 at 02:42 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `uname` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`uname`, `password`) VALUES
('mayank', 'macbro'),
('rohit', 'rohit521');

-- --------------------------------------------------------

--
-- Table structure for table `admittedpatient`
--

CREATE TABLE `admittedpatient` (
  `pid` int(30) NOT NULL,
  `roomNo` int(30) NOT NULL,
  `admissionDate` date NOT NULL,
  `dischargeDate` date NOT NULL,
  `advance` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admittedpatient`
--

INSERT INTO `admittedpatient` (`pid`, `roomNo`, `admissionDate`, `dischargeDate`, `advance`) VALUES
(1, 201, '2017-01-09', '2017-01-15', 1000),
(2, 201, '2017-04-26', '2017-04-30', 500),
(3, 303, '2017-03-06', '2017-03-16', 1200),
(4, 401, '2017-03-30', '2017-04-02', 1000),
(5, 303, '2017-03-26', '2017-03-31', 800),
(6, 502, '2017-02-20', '2017-02-24', 1100),
(7, 401, '2017-03-03', '2017-03-11', 2000),
(8, 607, '2017-02-28', '2017-03-04', 500),
(9, 502, '2017-03-31', '2017-04-09', 600),
(10, 111, '2017-03-29', '2017-04-05', 800),
(1, 201, '2017-02-09', '2017-02-20', 5000);

-- --------------------------------------------------------

--
-- Table structure for table `appoint`
--

CREATE TABLE `appoint` (
  `pid` int(30) NOT NULL,
  `doctorId` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appoint`
--

INSERT INTO `appoint` (`pid`, `doctorId`) VALUES
(5, 1),
(9, 1),
(3, 2),
(6, 2),
(8, 3),
(6, 4),
(2, 5),
(1, 6),
(10, 6),
(4, 7),
(7, 7),
(1, 8),
(3, 8);

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `pid` int(30) NOT NULL,
  `billNo` int(30) NOT NULL,
  `patientType` char(30) NOT NULL,
  `doctorCharge` int(100) NOT NULL,
  `medicineCharge` int(100) NOT NULL,
  `roomCharge` int(100) NOT NULL,
  `nursingCharge` int(100) NOT NULL,
  `advance` int(100) NOT NULL,
  `healthCard` int(100) NOT NULL,
  `amount` int(100) NOT NULL,
  `labCharge` int(100) NOT NULL,
  `days` int(100) NOT NULL,
  `operationCharge` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`pid`, `billNo`, `patientType`, `doctorCharge`, `medicineCharge`, `roomCharge`, `nursingCharge`, `advance`, `healthCard`, `amount`, `labCharge`, `days`, `operationCharge`) VALUES
(1, 100, '', 0, 0, 0, 0, 0, 0, 5000, 0, 0, 0),
(2, 101, '', 0, 0, 0, 0, 0, 0, 2500, 0, 0, 0),
(3, 102, '', 0, 0, 0, 0, 0, 0, 4000, 0, 0, 0),
(4, 103, '', 0, 0, 0, 0, 0, 0, 10000, 0, 0, 0),
(5, 104, '', 0, 0, 0, 0, 0, 0, 25000, 0, 0, 0),
(6, 105, '', 0, 0, 0, 0, 0, 0, 9000, 0, 0, 0),
(7, 106, '', 0, 0, 0, 0, 0, 0, 12000, 0, 0, 0),
(8, 107, '', 0, 0, 0, 0, 0, 0, 30000, 0, 0, 0),
(9, 108, '', 0, 0, 0, 0, 0, 0, 22000, 0, 0, 0),
(10, 109, '', 0, 0, 0, 0, 0, 0, 18000, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `checks`
--

CREATE TABLE `checks` (
  `doctorId` int(30) NOT NULL,
  `labNo` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `decides`
--

CREATE TABLE `decides` (
  `pid` int(30) NOT NULL,
  `labNo` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `decides`
--

INSERT INTO `decides` (`pid`, `labNo`) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 4),
(3, 5),
(4, 6),
(5, 7),
(6, 8),
(6, 9),
(7, 10),
(8, 11),
(9, 12),
(10, 13);

-- --------------------------------------------------------

--
-- Table structure for table `diseaseinfo`
--

CREATE TABLE `diseaseinfo` (
  `diseaseId` int(100) NOT NULL,
  `pid` int(30) NOT NULL,
  `disease` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diseaseinfo`
--

INSERT INTO `diseaseinfo` (`diseaseId`, `pid`, `disease`) VALUES
(1, 1, 'Viral Fever'),
(2, 1, 'Migrane'),
(3, 2, 'Food Poisoning'),
(4, 3, 'Tape Warm'),
(5, 3, 'Viral Fever'),
(6, 4, 'Fracture'),
(7, 5, 'Cancer'),
(8, 6, 'Tooth Decay'),
(9, 6, 'Skin Rashes'),
(10, 7, 'Fracture'),
(11, 8, 'Heart Attack'),
(12, 9, 'Cancer'),
(13, 10, 'Migrane');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `doctorId` int(30) NOT NULL,
  `first_name` char(20) NOT NULL,
  `last_name` char(20) NOT NULL,
  `dept` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`doctorId`, `first_name`, `last_name`, `dept`) VALUES
(1, 'Roshan', 'Kapoor', 'Radio Theropy'),
(2, 'Dheeraj', 'Tandoon', 'Dermatology'),
(3, 'Vaishali', 'Rawat', 'Cardiologist'),
(4, 'Rakesh', 'Sinha', 'Dentist'),
(5, 'Sonam', 'Kapoor', 'Nutrition'),
(6, 'Sneha', 'Tandon', 'Neurology'),
(7, 'Rajesh', 'Singh', 'Orthopaedics'),
(8, 'Geetanjali', 'Kumari', 'Microbiology'),
(9, 'Deepak', 'Gupta', 'Rheumatologist');

-- --------------------------------------------------------

--
-- Table structure for table `generalopdpatient`
--

CREATE TABLE `generalopdpatient` (
  `pid` int(30) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `generalopdpatient`
--

INSERT INTO `generalopdpatient` (`pid`, `date`) VALUES
(1, '2017-01-15'),
(2, '2017-04-30'),
(3, '2017-03-18'),
(4, '2017-04-03'),
(5, '2017-03-31'),
(6, '2017-02-28'),
(7, '2017-03-11'),
(8, '2017-03-04'),
(9, '2017-04-11'),
(10, '2017-04-05'),
(1, '2017-01-26');

-- --------------------------------------------------------

--
-- Table structure for table `labinfo`
--

CREATE TABLE `labinfo` (
  `id` int(20) NOT NULL,
  `pid` int(30) NOT NULL,
  `labNo` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `labreport`
--

CREATE TABLE `labreport` (
  `labNo` int(30) NOT NULL,
  `pid` int(30) NOT NULL,
  `weight` int(3) NOT NULL,
  `height` float NOT NULL,
  `doctorId` int(30) NOT NULL,
  `date` date NOT NULL,
  `category` char(20) NOT NULL,
  `patientType` char(20) NOT NULL,
  `amount` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `labreport`
--

INSERT INTO `labreport` (`labNo`, `pid`, `weight`, `height`, `doctorId`, `date`, `category`, `patientType`, `amount`) VALUES
(1, 1, 80, 1.6764, 6, '2017-01-10', '', '', 2000),
(2, 1, 80, 1.6764, 8, '2017-01-10', '', '', 1000),
(3, 2, 75, 1.8288, 5, '2017-04-27', '', '', 800),
(4, 3, 50, 1.73736, 2, '2017-03-07', '', '', 1500),
(5, 3, 50, 1.73736, 8, '2017-03-07', '', '', 1000),
(6, 4, 75, 1.524, 7, '2017-04-01', '', '', 5000),
(7, 5, 60, 1.524, 1, '2017-03-27', '', '', 10000),
(8, 6, 55, 1.76784, 2, '2017-02-21', '', '', 1500),
(9, 6, 55, 1.76784, 4, '2017-02-21', '', '', 3000),
(10, 7, 45, 1.55753, 7, '2017-03-05', '', '', 5000),
(11, 8, 74, 1.88976, 3, '2017-03-01', '', '', 10000),
(12, 9, 65, 1.73736, 1, '2017-04-01', '', '', 10000),
(13, 10, 58, 1.76784, 6, '2017-03-30', '', '', 7000);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `pid` int(30) NOT NULL,
  `first_name` char(10) NOT NULL,
  `last_name` char(10) NOT NULL,
  `age` int(5) NOT NULL,
  `weight` int(5) NOT NULL,
  `gender` char(6) NOT NULL,
  `street` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `zip` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='patient info table';

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`pid`, `first_name`, `last_name`, `age`, `weight`, `gender`, `street`, `state`, `zip`) VALUES
(1, 'Rakesh', 'Kumar', 30, 80, 'Male', 'Mayur Vihar Phase 3', 'Delhi', 110096),
(2, 'Mayank', 'Bhoria', 19, 75, 'Male', 'Panipat', 'Haryana', 110010),
(3, 'Akash', 'Gautam', 19, 50, 'Male', 'Mint Street', 'Chennai', 600079),
(4, 'Shyam', 'Aggarwal', 20, 75, 'Male', 'Laxmi Nagar', 'Uttar Pradesh', 141102),
(5, 'Supriya', 'Jain', 30, 60, 'Female', 'Okhla Phase 3', 'Delhi', 110020),
(6, 'Richa', 'Kumari', 25, 55, 'Female', 'Imperial Apartment', 'Gurgaon', 122003),
(7, 'Zyra', 'Khan', 21, 45, 'Female', 'Indirapuram', 'Ghaziabad', 110120),
(8, 'Rahul', 'Saxena', 35, 74, 'Male', 'Mayur Vihar Phase 1', 'Delhi', 110094),
(9, 'Sonakshi', 'Kapoor', 28, 65, 'Female', 'Jaypee Township', 'Greater Noida', 201308),
(10, 'Suman', 'Saxena', 41, 58, 'Female', 'Sector 21C', 'Faridabad', 122001);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `roomNo` int(30) NOT NULL,
  `roomType` char(30) NOT NULL,
  `status` char(30) NOT NULL,
  `cost` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`roomNo`, `roomType`, `status`, `cost`) VALUES
(111, 'Delux', 'Filled', 2500),
(201, 'General', 'Filled', 1000),
(202, 'General', 'Available', 1000),
(222, 'Delux', 'Available', 2500),
(303, 'General', 'Filled', 1000),
(401, 'General', 'Filled', 1000),
(502, 'General', 'Filled', 1000),
(607, 'General', 'Available', 1000);

-- --------------------------------------------------------

--
-- Table structure for table `stayingin`
--

CREATE TABLE `stayingin` (
  `roomNo` int(30) NOT NULL,
  `pid` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`uname`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`billNo`);

--
-- Indexes for table `diseaseinfo`
--
ALTER TABLE `diseaseinfo`
  ADD PRIMARY KEY (`diseaseId`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doctorId`);

--
-- Indexes for table `labinfo`
--
ALTER TABLE `labinfo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `labreport`
--
ALTER TABLE `labreport`
  ADD PRIMARY KEY (`labNo`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`roomNo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `pid` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
