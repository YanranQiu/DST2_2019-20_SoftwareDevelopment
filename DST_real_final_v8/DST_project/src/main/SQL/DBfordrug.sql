-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: DBforDrug
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `annovar`
--

DROP TABLE IF EXISTS `annovar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `annovar` (
  `filename` varchar(100) DEFAULT NULL,
  `Uploaded_variation` varchar(100) DEFAULT NULL,
  `Location` varchar(100) DEFAULT NULL,
  `Allele` varchar(10) DEFAULT NULL,
  `Consequence` text,
  `IMPACT` varchar(100) DEFAULT NULL,
  `SYMBOL` varchar(100) NOT NULL,
  `Gene` varchar(100) NOT NULL,
  `Feature_type` text,
  `Feature` text,
  `BIOTYPE` text,
  `EXON` text,
  `INTRON` text,
  `HGVSc` text,
  `HGVSp` text,
  `cDNA_position` text,
  `CDS_position` text,
  `Protein_position` text,
  `Amino_acids` text,
  `Codons` text,
  `Existing_variation` text,
  `DISTANCE` text,
  `STRAND` text,
  `FLAGS` text,
  `SYMBOL_SOURCE` text,
  `HGNC_ID` text,
  `MANE` text,
  `TSL` text,
  `APPRI` text,
  `tSIFT` text,
  `PolyPhen` text,
  `AF` text,
  `CLIN_SIG` text,
  `SOMATIC` text,
  `PHENO` text,
  `PUBMED` text,
  `MOTIF_NAME` text,
  `MOTIF_POS` text,
  `HIGH_INF_POS` text,
  `MOTIF_SCORE_CHANGE` text,
  `OTHER_INFO` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `dosing_guideline`
--

DROP TABLE IF EXISTS `dosing_guideline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dosing_guideline` (
  `id` varchar(100) NOT NULL,
  `obj_cls` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `recommendation` tinyint(1) DEFAULT NULL,
  `drug_id` varchar(100) DEFAULT NULL,
  `source` varchar(100) DEFAULT NULL,
  `summary_markdown` varchar(2000) DEFAULT NULL,
  `text_markdown` text,
  `raw` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dosing_guideline_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `drug`
--

DROP TABLE IF EXISTS `drug`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drug` (
  `id` varchar(100) NOT NULL,
  `name` varchar(500) DEFAULT NULL,
  `obj_cls` varchar(100) DEFAULT NULL,
  `drug_url` varchar(100) DEFAULT NULL,
  `biomarker` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `drug_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `drug_label`
--

DROP TABLE IF EXISTS `drug_label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drug_label` (
  `id` varchar(100) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `obj_cls` varchar(100) DEFAULT NULL,
  `alternate_drug_available` tinyint(1) DEFAULT NULL,
  `dosing_information` tinyint(1) DEFAULT NULL,
  `prescribing_markdown` varchar(2000) DEFAULT NULL,
  `source` varchar(100) DEFAULT NULL,
  `text_markdown` varchar(4000) DEFAULT NULL,
  `summary_markdown` varchar(1000) DEFAULT NULL,
  `raw` text,
  `drug_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `drug_label_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `druggene`
--

DROP TABLE IF EXISTS `druggene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `druggene` (
  `drugid` text NOT NULL,
  `druggene` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `user_history`
--

DROP TABLE IF EXISTS `user_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_history` (
  `user_name` varchar(15) NOT NULL,
  `id` varchar(15) NOT NULL,
  `drug_id` varchar(15) DEFAULT NULL,
  `drug_name` text,
  `summary` text,
  `prescribing` text,
  KEY `index` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `user_name` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_name`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Dumping events for database 'DBforDrug'
--

--
-- Dumping routines for database 'DBforDrug'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-17 10:46:07
