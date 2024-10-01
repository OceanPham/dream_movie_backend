-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 01, 2024 at 06:24 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dreanmovie_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` bigint NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `created_at`, `deleted_at`, `description`, `name`, `updated_at`) VALUES
(1, '2024-09-26 00:33:28.000000', NULL, 'Thể loại phim có nhiều pha hành động kịch tính', 'Phim hành động', '2024-09-26 00:33:28.000000'),
(2, '2024-09-26 00:33:42.000000', NULL, 'Thể loại phim tạo cảm giác sợ hãi và căng thẳng', 'Phim kinh dị', '2024-09-26 00:33:42.000000'),
(3, '2024-09-26 00:33:42.000000', NULL, 'Thể loại phim mang lại tiếng cười, giải trí nhẹ nhàng', 'Phim hài', '2024-09-26 00:33:42.000000'),
(4, '2024-09-26 00:33:42.000000', NULL, 'Thể loại phim sử dụng hình ảnh vẽ tay hoặc đồ họa máy tính', 'Phim hoạt hình', '2024-09-26 00:33:42.000000');

-- --------------------------------------------------------

--
-- Table structure for table `cinemas`
--

CREATE TABLE `cinemas` (
  `id` bigint NOT NULL,
  `address` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `cinemas`
--

INSERT INTO `cinemas` (`id`, `address`, `created_at`, `deleted_at`, `name`, `phone`, `updated_at`) VALUES
(1, '123 Đường Biển, Quận 1, TP.HCM', '2024-10-01 00:12:40.000000', NULL, 'DreamOcean', '0901234567', '2024-10-01 00:12:40.000000'),
(2, '456 Đường Trúc, Quận 5, Hà Nội', '2024-10-01 00:12:40.000000', NULL, 'DreamPanda', '0902345678', '2024-10-01 00:12:40.000000'),
(3, '789 Đường Mây, Quận 3, Đà Nẵng', '2024-10-01 00:12:40.000000', NULL, 'DreamSky', '0903456789', '2024-10-01 00:12:40.000000'),
(4, '101 Đường Sáng, Quận 2, Cần Thơ', '2024-10-01 00:12:40.000000', NULL, 'DreamLight', '0904567890', '2024-10-01 00:12:40.000000'),
(5, '202 Đường Xanh, Quận 7, Hải Phòng', '2024-10-01 00:12:40.000000', NULL, 'DreamGreen', '0905678901', '2024-10-01 00:12:40.000000');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `id` bigint NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `fullname` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `created_at`, `deleted_at`, `fullname`, `updated_at`, `username`) VALUES
(1, '2024-09-27 10:00:00.000000', NULL, 'Nguyen Van A', '2024-09-27 10:00:00.000000', 'nguyenvana'),
(2, '2024-09-27 10:10:00.000000', NULL, 'Tran Thi B', '2024-09-27 10:10:00.000000', 'tranthib'),
(3, '2024-09-27 10:20:00.000000', NULL, 'Le Van C', '2024-09-27 10:20:00.000000', 'levanc'),
(4, '2024-09-27 10:30:00.000000', NULL, 'Pham Thi D', '2024-09-27 10:30:00.000000', 'phamthid'),
(5, '2024-09-27 10:40:00.000000', NULL, 'Hoang Van E', '2024-09-27 10:40:00.000000', 'hoangvane');

-- --------------------------------------------------------

--
-- Table structure for table `food_categories`
--

CREATE TABLE `food_categories` (
  `id` bigint NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `max_stock_quatity` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `food_categories`
--

INSERT INTO `food_categories` (`id`, `created_at`, `deleted_at`, `description`, `max_stock_quatity`, `name`, `updated_at`) VALUES
(1, '2024-10-01 00:00:00.000000', NULL, 'Danh mục rau củ', 100, 'Rau củ', '2024-10-01 00:00:00.000000'),
(2, '2024-10-01 00:00:00.000000', NULL, 'Danh mục trái cây', 150, 'Trái cây', '2024-10-01 00:00:00.000000'),
(3, '2024-10-01 00:00:00.000000', NULL, 'Danh mục sản phẩm từ sữa', 80, 'Sản phẩm từ sữa', '2024-10-01 00:00:00.000000'),
(4, '2024-10-01 00:00:00.000000', NULL, 'Danh mục thịt', 120, 'Thịt', '2024-10-01 00:00:00.000000'),
(5, '2024-10-01 00:00:00.000000', NULL, 'Danh mục hải sản', 90, 'Hải sản', '2024-10-01 00:00:00.000000'),
(6, '2024-10-01 00:00:00.000000', NULL, 'Danh mục ngũ cốc', 200, 'Ngũ cốc', '2024-10-01 00:00:00.000000'),
(7, '2024-10-01 00:00:00.000000', NULL, 'Danh mục đồ uống', 50, 'Đồ uống', '2024-10-01 00:00:00.000000'),
(8, '2024-10-01 00:00:00.000000', NULL, 'Danh mục gia vị', 300, 'Gia vị', '2024-10-01 00:00:00.000000'),
(9, '2024-10-01 00:00:00.000000', NULL, 'Danh mục dầu ăn', 70, 'Dầu ăn', '2024-10-01 00:00:00.000000'),
(10, '2024-10-01 00:00:00.000000', NULL, 'Danh mục bánh', 60, 'Bánh', '2024-10-01 00:00:00.000000'),
(11, '2024-10-01 00:00:00.000000', NULL, 'Danh mục thực phẩm đông lạnh', 100, 'Thực phẩm đông lạnh', '2024-10-01 00:00:00.000000'),
(12, '2024-10-01 00:00:00.000000', NULL, 'Danh mục đồ ăn vặt', 130, 'Đồ ăn vặt', '2024-10-01 00:00:00.000000'),
(13, '2024-10-01 00:00:00.000000', NULL, 'Danh mục thực phẩm đóng hộp', 140, 'Thực phẩm đóng hộp', '2024-10-01 00:00:00.000000'),
(14, '2024-10-01 00:00:00.000000', NULL, 'Danh mục đồ ngọt', 90, 'Đồ ngọt', '2024-10-01 00:00:00.000000'),
(15, '2024-10-01 00:00:00.000000', NULL, 'Danh mục sản phẩm hữu cơ', 110, 'Sản phẩm hữu cơ', '2024-10-01 00:00:00.000000'),
(16, '2024-10-01 00:00:00.000000', NULL, 'Danh mục thực phẩm cho bé', 50, 'Thực phẩm cho bé', '2024-10-01 00:00:00.000000'),
(17, '2024-10-01 00:00:00.000000', NULL, 'Danh mục thức ăn cho thú cưng', 70, 'Thức ăn cho thú cưng', '2024-10-01 00:00:00.000000'),
(18, '2024-10-01 00:00:00.000000', NULL, 'Danh mục nước sốt', 60, 'Nước sốt', '2024-10-01 00:00:00.000000'),
(19, '2024-10-01 00:00:00.000000', NULL, 'Danh mục đồ ăn liền', 40, 'Đồ ăn liền', '2024-10-01 00:00:00.000000'),
(20, '2024-10-01 00:00:00.000000', NULL, 'Danh mục gia vị nấu ăn', 200, 'Gia vị nấu ăn', '2024-10-01 00:00:00.000000');

-- --------------------------------------------------------

--
-- Table structure for table `languages`
--

CREATE TABLE `languages` (
  `id` bigint NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `languages`
--

INSERT INTO `languages` (`id`, `created_at`, `deleted_at`, `description`, `name`, `status`, `updated_at`) VALUES
(1, '2024-09-25 23:25:49.000000', NULL, 'Phim gốc với phụ đề tiếng Việt', 'Phụ đề tiếng Việt', '1', '2024-09-25 23:25:49.000000'),
(2, '2024-09-25 23:25:49.000000', NULL, 'Phim gốc được thuyết minh bằng tiếng Việt', 'Thuyết minh tiếng Việt', '1', '2024-09-25 23:25:49.000000'),
(3, '2024-09-25 23:25:49.000000', NULL, 'Phim gốc với phụ đề tiếng Anh', 'Phụ đề tiếng Anh', '1', '2024-09-25 23:25:49.000000'),
(4, '2024-09-25 23:25:49.000000', NULL, 'Phim gốc được thuyết minh bằng tiếng Anh', 'Thuyết minh tiếng Anh', '1', '2024-09-25 23:25:49.000000');

-- --------------------------------------------------------

--
-- Table structure for table `loai_ghes`
--

CREATE TABLE `loai_ghes` (
  `id` bigint UNSIGNED NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` decimal(38,2) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `seat_count` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `loai_ghes`
--

INSERT INTO `loai_ghes` (`id`, `name`, `price`, `created_at`, `updated_at`, `deleted_at`, `description`, `seat_count`) VALUES
(25, 'Ghế Thường', '50000.00', '2023-08-30 10:15:30.000000', '2023-08-30 10:15:30.000000', NULL, 'Ghế ngồi thường, phổ biến nhất trong rạp', 100),
(26, 'Ghế Sofa Đơn', '150000.00', '2023-09-05 12:45:50.000000', '2023-09-05 12:45:50.000000', NULL, 'Ghế sofa đơn dành cho một người, thoải mái hơn', 30),
(27, 'Ghế Sofa Đôi', '250000.00', '2023-09-12 14:22:35.000000', '2023-09-12 14:22:35.000000', NULL, 'Ghế sofa đôi dành cho hai người, rộng rãi và êm ái', 20),
(28, 'Ghế VIP', '300000.00', '2023-09-18 16:00:00.000000', '2023-09-18 16:00:00.000000', NULL, 'Ghế VIP dành cho khách hàng đặc biệt', 10),
(29, 'Ghế Đôi Thường', '120000.00', '2023-09-25 09:30:10.000000', '2023-09-25 09:30:10.000000', NULL, 'Ghế đôi thông thường, dành cho 2 người', 40),
(30, 'Ghế Đơn Thường', '60000.00', '2023-10-01 11:50:00.000000', '2023-10-01 11:50:00.000000', NULL, 'Ghế đơn phổ thông', 80),
(31, 'Ghế Đôi Cao Cấp', '180000.00', '2023-10-08 13:45:30.000000', '2023-10-08 13:45:30.000000', NULL, 'Ghế đôi cao cấp với chất liệu êm ái', 25),
(32, 'Ghế Thường Cao Cấp', '80000.00', '2023-10-15 15:22:10.000000', '2023-10-15 15:22:10.000000', NULL, 'Ghế ngồi cao cấp, phổ biến trong các phòng chiếu lớn', 90),
(33, 'Ghế Sofa VIP', '350000.00', '2023-10-20 17:35:45.000000', '2023-10-20 17:35:45.000000', NULL, 'Ghế sofa VIP, rộng rãi và sang trọng', 8),
(34, 'Ghế Đôi VIP', '280000.00', '2023-10-26 19:10:00.000000', '2023-10-26 19:10:00.000000', NULL, 'Ghế đôi VIP cho cặp đôi muốn không gian riêng tư', 15),
(35, 'Ghế Thường Giữa', '70000.00', '2023-11-02 08:55:20.000000', '2023-11-02 08:55:20.000000', NULL, 'Ghế thường ở vị trí giữa rạp', 100),
(36, 'Ghế Thường Cuối', '55000.00', '2023-11-10 10:25:40.000000', '2023-11-10 10:25:40.000000', NULL, 'Ghế thường ở vị trí cuối rạp', 120),
(37, 'Ghế Sofa Đôi Cao Cấp', '220000.00', '2023-11-15 12:40:50.000000', '2023-11-15 12:40:50.000000', NULL, 'Ghế sofa đôi cao cấp cho không gian thoải mái', 20),
(38, 'Ghế Đôi Tiện Ích', '130000.00', '2023-11-22 14:05:25.000000', '2023-11-22 14:05:25.000000', NULL, 'Ghế đôi với tiện ích đính kèm như bàn nhỏ, khay đựng nước', 35),
(39, 'Ghế Đơn Tiện Ích', '70000.00', '2023-11-28 16:30:30.000000', '2023-11-28 16:30:30.000000', NULL, 'Ghế đơn tiện ích với khay đựng đồ uống', 50);

-- --------------------------------------------------------

--
-- Table structure for table `phims`
--

CREATE TABLE `phims` (
  `id` bigint UNSIGNED NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `duongdan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hinhanh` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mota` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `thoiluong` time(6) NOT NULL,
  `trangthai` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_theloai` bigint NOT NULL,
  `id_nhacungcap` bigint NOT NULL,
  `ngaycongchieu` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `phims`
--

INSERT INTO `phims` (`id`, `created_at`, `updated_at`, `deleted_at`, `duongdan`, `hinhanh`, `mota`, `name`, `thoiluong`, `trangthai`, `id_theloai`, `id_nhacungcap`, `ngaycongchieu`) VALUES
(13, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_1', 'hinhanh_example_1.jpg', 'Mô tả phim 1', 'Phim 1', '01:30:00.000000', '1', 1, 1, '2024-08-30'),
(14, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_2', 'hinhanh_example_2.jpg', 'Mô tả phim 2', 'Phim 2', '01:30:00.000000', '0', 2, 2, '2024-08-31'),
(15, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_3', 'hinhanh_example_3.jpg', 'Mô tả phim 3', 'Phim 3', '01:30:00.000000', '1', 3, 3, '2024-09-01'),
(16, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_4', 'hinhanh_example_4.jpg', 'Mô tả phim 4', 'Phim 4', '01:30:00.000000', '0', 4, 4, '2024-09-02'),
(17, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_5', 'hinhanh_example_5.jpg', 'Mô tả phim 5', 'Phim 5', '01:30:00.000000', '1', 1, 1, '2024-09-03'),
(18, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_6', 'hinhanh_example_6.jpg', 'Mô tả phim 6', 'Phim 6', '01:30:00.000000', '0', 2, 2, '2024-09-04'),
(19, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_7', 'hinhanh_example_7.jpg', 'Mô tả phim 7', 'Phim 7', '01:30:00.000000', '1', 3, 3, '2024-09-05'),
(20, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_8', 'hinhanh_example_8.jpg', 'Mô tả phim 8', 'Phim 8', '01:30:00.000000', '0', 4, 4, '2024-09-06'),
(21, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_9', 'hinhanh_example_9.jpg', 'Mô tả phim 9', 'Phim 9', '01:30:00.000000', '1', 1, 1, '2024-09-07'),
(22, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_10', 'hinhanh_example_10.jpg', 'Mô tả phim 10', 'Phim 10', '01:30:00.000000', '0', 2, 2, '2024-09-08'),
(23, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_11', 'hinhanh_example_11.jpg', 'Mô tả phim 11', 'Phim 11', '01:30:00.000000', '1', 3, 3, '2024-09-09'),
(24, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_12', 'hinhanh_example_12.jpg', 'Mô tả phim 12', 'Phim 12', '01:30:00.000000', '0', 4, 4, '2024-09-10'),
(25, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_13', 'hinhanh_example_13.jpg', 'Mô tả phim 13', 'Phim 13', '01:30:00.000000', '1', 1, 1, '2024-09-11'),
(26, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_14', 'hinhanh_example_14.jpg', 'Mô tả phim 14', 'Phim 14', '01:30:00.000000', '0', 2, 2, '2024-09-12'),
(27, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_15', 'hinhanh_example_15.jpg', 'Mô tả phim 15', 'Phim 15', '01:30:00.000000', '1', 3, 3, '2024-09-13'),
(28, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_16', 'hinhanh_example_16.jpg', 'Mô tả phim 16', 'Phim 16', '01:30:00.000000', '0', 4, 4, '2024-09-14'),
(29, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_17', 'hinhanh_example_17.jpg', 'Mô tả phim 17', 'Phim 17', '01:30:00.000000', '1', 1, 1, '2024-09-15'),
(30, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_18', 'hinhanh_example_18.jpg', 'Mô tả phim 18', 'Phim 18', '01:30:00.000000', '0', 2, 2, '2024-09-16'),
(31, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_19', 'hinhanh_example_19.jpg', 'Mô tả phim 19', 'Phim 19', '01:30:00.000000', '1', 3, 3, '2024-09-17'),
(32, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_20', 'hinhanh_example_20.jpg', 'Mô tả phim 20', 'Phim 20', '01:30:00.000000', '0', 4, 4, '2024-09-18'),
(33, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_21', 'hinhanh_example_21.jpg', 'Mô tả phim 21', 'Phim 21', '01:30:00.000000', '1', 1, 1, '2024-09-19'),
(34, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_22', 'hinhanh_example_22.jpg', 'Mô tả phim 22', 'Phim 22', '01:30:00.000000', '0', 2, 2, '2024-09-20'),
(35, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_23', 'hinhanh_example_23.jpg', 'Mô tả phim 23', 'Phim 23', '01:30:00.000000', '1', 3, 3, '2024-09-21'),
(36, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_24', 'hinhanh_example_24.jpg', 'Mô tả phim 24', 'Phim 24', '01:30:00.000000', '0', 4, 4, '2024-09-22'),
(37, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_25', 'hinhanh_example_25.jpg', 'Mô tả phim 25', 'Phim 25', '01:30:00.000000', '1', 1, 1, '2024-09-23'),
(38, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_26', 'hinhanh_example_26.jpg', 'Mô tả phim 26', 'Phim 26', '01:30:00.000000', '0', 2, 2, '2024-09-24'),
(39, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_27', 'hinhanh_example_27.jpg', 'Mô tả phim 27', 'Phim 27', '01:30:00.000000', '1', 3, 3, '2024-09-25'),
(40, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_28', 'hinhanh_example_28.jpg', 'Mô tả phim 28', 'Phim 28', '01:30:00.000000', '0', 4, 4, '2024-09-26'),
(41, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_29', 'hinhanh_example_29.jpg', 'Mô tả phim 29', 'Phim 29', '01:30:00.000000', '1', 1, 1, '2024-09-27'),
(42, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_30', 'hinhanh_example_30.jpg', 'Mô tả phim 30', 'Phim 30', '01:30:00.000000', '0', 2, 2, '2024-09-28'),
(43, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_31', 'hinhanh_example_31.jpg', 'Mô tả phim 31', 'Phim 31', '01:30:00.000000', '1', 3, 3, '2024-09-29'),
(44, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_32', 'hinhanh_example_32.jpg', 'Mô tả phim 32', 'Phim 32', '01:30:00.000000', '0', 4, 4, '2024-09-30'),
(45, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_33', 'hinhanh_example_33.jpg', 'Mô tả phim 33', 'Phim 33', '01:30:00.000000', '1', 1, 1, '2024-10-01'),
(46, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_34', 'hinhanh_example_34.jpg', 'Mô tả phim 34', 'Phim 34', '01:30:00.000000', '0', 2, 2, '2024-10-02'),
(47, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_35', 'hinhanh_example_35.jpg', 'Mô tả phim 35', 'Phim 35', '01:30:00.000000', '1', 3, 3, '2024-10-03'),
(48, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_36', 'hinhanh_example_36.jpg', 'Mô tả phim 36', 'Phim 36', '01:30:00.000000', '0', 4, 4, '2024-10-04'),
(49, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_37', 'hinhanh_example_37.jpg', 'Mô tả phim 37', 'Phim 37', '01:30:00.000000', '1', 1, 1, '2024-10-05'),
(50, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_38', 'hinhanh_example_38.jpg', 'Mô tả phim 38', 'Phim 38', '01:30:00.000000', '0', 2, 2, '2024-10-06'),
(51, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_39', 'hinhanh_example_39.jpg', 'Mô tả phim 39', 'Phim 39', '01:30:00.000000', '1', 3, 3, '2024-10-07'),
(52, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_40', 'hinhanh_example_40.jpg', 'Mô tả phim 40', 'Phim 40', '01:30:00.000000', '0', 4, 4, '2024-10-08'),
(53, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_41', 'hinhanh_example_41.jpg', 'Mô tả phim 41', 'Phim 41', '01:30:00.000000', '1', 1, 1, '2024-10-09'),
(54, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_42', 'hinhanh_example_42.jpg', 'Mô tả phim 42', 'Phim 42', '01:30:00.000000', '0', 2, 2, '2024-10-10'),
(55, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_43', 'hinhanh_example_43.jpg', 'Mô tả phim 43', 'Phim 43', '01:30:00.000000', '1', 3, 3, '2024-10-11'),
(56, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_44', 'hinhanh_example_44.jpg', 'Mô tả phim 44', 'Phim 44', '01:30:00.000000', '0', 4, 4, '2024-10-12'),
(57, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_45', 'hinhanh_example_45.jpg', 'Mô tả phim 45', 'Phim 45', '01:30:00.000000', '1', 1, 1, '2024-10-13'),
(58, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_46', 'hinhanh_example_46.jpg', 'Mô tả phim 46', 'Phim 46', '01:30:00.000000', '0', 2, 2, '2024-10-14'),
(59, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_47', 'hinhanh_example_47.jpg', 'Mô tả phim 47', 'Phim 47', '01:30:00.000000', '1', 3, 3, '2024-10-15'),
(60, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_48', 'hinhanh_example_48.jpg', 'Mô tả phim 48', 'Phim 48', '01:30:00.000000', '0', 4, 4, '2024-10-16'),
(61, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_49', 'hinhanh_example_49.jpg', 'Mô tả phim 49', 'Phim 49', '01:30:00.000000', '1', 1, 1, '2024-10-17'),
(62, '2024-09-30 21:16:55.000000', '2024-09-30 21:16:55.000000', NULL, 'duongdan_example_50', 'hinhanh_example_50.jpg', 'Mô tả phim 50', 'Phim 50', '01:30:00.000000', '0', 2, 2, '2024-10-18');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` bigint NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `created_at`, `deleted_at`, `description`, `role_name`, `updated_at`) VALUES
(1, '2024-09-28 22:41:59.000000', NULL, 'Quản trị viên hệ thống', 'Admin', '2024-09-28 22:41:59.000000'),
(2, '2024-09-28 22:41:59.000000', NULL, 'Người dùng phổ thông', 'User', '2024-09-28 22:41:59.000000'),
(3, '2024-09-28 22:41:59.000000', NULL, 'Nhân viên', 'Employee', '2024-09-28 22:41:59.000000');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `id` bigint NOT NULL,
  `capacity` int NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `cinema_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`id`, `capacity`, `created_at`, `deleted_at`, `name`, `updated_at`, `cinema_id`) VALUES
(26, 150, '2024-10-01 00:14:00.000000', NULL, 'DO01', '2024-10-01 00:14:00.000000', 1),
(27, 150, '2024-10-01 00:14:00.000000', NULL, 'DO02', '2024-10-01 00:14:00.000000', 1),
(28, 150, '2024-10-01 00:14:00.000000', NULL, 'DO03', '2024-10-01 00:14:00.000000', 1),
(29, 150, '2024-10-01 00:14:00.000000', NULL, 'DO04', '2024-10-01 00:14:00.000000', 1),
(30, 150, '2024-10-01 00:14:00.000000', NULL, 'DO05', '2024-10-01 00:14:00.000000', 1),
(31, 150, '2024-10-01 00:14:00.000000', NULL, 'DO06', '2024-10-01 00:14:00.000000', 1),
(32, 150, '2024-10-01 00:14:00.000000', NULL, 'DO07', '2024-10-01 00:14:00.000000', 1),
(33, 150, '2024-10-01 00:14:00.000000', NULL, 'DO08', '2024-10-01 00:14:00.000000', 1),
(34, 150, '2024-10-01 00:14:00.000000', NULL, 'DO09', '2024-10-01 00:14:00.000000', 1),
(35, 150, '2024-10-01 00:14:00.000000', NULL, 'DO10', '2024-10-01 00:14:00.000000', 1),
(36, 150, '2024-10-01 00:14:00.000000', NULL, 'DO11', '2024-10-01 00:14:00.000000', 1),
(37, 150, '2024-10-01 00:14:00.000000', NULL, 'DO12', '2024-10-01 00:14:00.000000', 1),
(38, 150, '2024-10-01 00:14:00.000000', NULL, 'DO13', '2024-10-01 00:14:00.000000', 1),
(39, 150, '2024-10-01 00:14:00.000000', NULL, 'DO14', '2024-10-01 00:14:00.000000', 1),
(40, 150, '2024-10-01 00:14:00.000000', NULL, 'DO15', '2024-10-01 00:14:00.000000', 1),
(41, 120, '2024-10-01 00:14:08.000000', NULL, 'DP01', '2024-10-01 00:14:08.000000', 2),
(42, 120, '2024-10-01 00:14:08.000000', NULL, 'DP02', '2024-10-01 00:14:08.000000', 2),
(43, 120, '2024-10-01 00:14:08.000000', NULL, 'DP03', '2024-10-01 00:14:08.000000', 2),
(44, 120, '2024-10-01 00:14:08.000000', NULL, 'DP04', '2024-10-01 00:14:08.000000', 2),
(45, 120, '2024-10-01 00:14:08.000000', NULL, 'DP05', '2024-10-01 00:14:08.000000', 2),
(46, 120, '2024-10-01 00:14:08.000000', NULL, 'DP06', '2024-10-01 00:14:08.000000', 2),
(47, 120, '2024-10-01 00:14:08.000000', NULL, 'DP07', '2024-10-01 00:14:08.000000', 2),
(48, 120, '2024-10-01 00:14:08.000000', NULL, 'DP08', '2024-10-01 00:14:08.000000', 2),
(49, 120, '2024-10-01 00:14:08.000000', NULL, 'DP09', '2024-10-01 00:14:08.000000', 2),
(50, 120, '2024-10-01 00:14:08.000000', NULL, 'DP10', '2024-10-01 00:14:08.000000', 2),
(51, 120, '2024-10-01 00:14:08.000000', NULL, 'DP11', '2024-10-01 00:14:08.000000', 2),
(52, 120, '2024-10-01 00:14:08.000000', NULL, 'DP12', '2024-10-01 00:14:08.000000', 2),
(53, 120, '2024-10-01 00:14:08.000000', NULL, 'DP13', '2024-10-01 00:14:08.000000', 2),
(54, 120, '2024-10-01 00:14:08.000000', NULL, 'DP14', '2024-10-01 00:14:08.000000', 2),
(55, 120, '2024-10-01 00:14:08.000000', NULL, 'DP15', '2024-10-01 00:14:08.000000', 2),
(56, 200, '2024-10-01 00:14:20.000000', NULL, 'DR01', '2024-10-01 00:14:20.000000', 3),
(57, 200, '2024-10-01 00:14:20.000000', NULL, 'DR02', '2024-10-01 00:14:20.000000', 3),
(58, 200, '2024-10-01 00:14:20.000000', NULL, 'DR03', '2024-10-01 00:14:20.000000', 3),
(59, 200, '2024-10-01 00:14:20.000000', NULL, 'DR04', '2024-10-01 00:14:20.000000', 3),
(60, 200, '2024-10-01 00:14:20.000000', NULL, 'DR05', '2024-10-01 00:14:20.000000', 3),
(61, 200, '2024-10-01 00:14:20.000000', NULL, 'DR06', '2024-10-01 00:14:20.000000', 3),
(62, 200, '2024-10-01 00:14:20.000000', NULL, 'DR07', '2024-10-01 00:14:20.000000', 3),
(63, 200, '2024-10-01 00:14:20.000000', NULL, 'DR08', '2024-10-01 00:14:20.000000', 3),
(64, 200, '2024-10-01 00:14:20.000000', NULL, 'DR09', '2024-10-01 00:14:20.000000', 3),
(65, 200, '2024-10-01 00:14:20.000000', NULL, 'DR10', '2024-10-01 00:14:20.000000', 3),
(66, 200, '2024-10-01 00:14:20.000000', NULL, 'DR11', '2024-10-01 00:14:20.000000', 3),
(67, 200, '2024-10-01 00:14:20.000000', NULL, 'DR12', '2024-10-01 00:14:20.000000', 3),
(68, 200, '2024-10-01 00:14:20.000000', NULL, 'DR13', '2024-10-01 00:14:20.000000', 3),
(69, 200, '2024-10-01 00:14:20.000000', NULL, 'DR14', '2024-10-01 00:14:20.000000', 3),
(70, 200, '2024-10-01 00:14:20.000000', NULL, 'DR15', '2024-10-01 00:14:20.000000', 3),
(71, 100, '2024-10-01 00:14:29.000000', NULL, 'DL01', '2024-10-01 00:14:29.000000', 4),
(72, 100, '2024-10-01 00:14:29.000000', NULL, 'DL02', '2024-10-01 00:14:29.000000', 4),
(73, 100, '2024-10-01 00:14:29.000000', NULL, 'DL03', '2024-10-01 00:14:29.000000', 4),
(74, 100, '2024-10-01 00:14:29.000000', NULL, 'DL04', '2024-10-01 00:14:29.000000', 4),
(75, 100, '2024-10-01 00:14:29.000000', NULL, 'DL05', '2024-10-01 00:14:29.000000', 4),
(76, 100, '2024-10-01 00:14:29.000000', NULL, 'DL06', '2024-10-01 00:14:29.000000', 4),
(77, 100, '2024-10-01 00:14:29.000000', NULL, 'DL07', '2024-10-01 00:14:29.000000', 4),
(78, 100, '2024-10-01 00:14:29.000000', NULL, 'DL08', '2024-10-01 00:14:29.000000', 4),
(79, 100, '2024-10-01 00:14:29.000000', NULL, 'DL09', '2024-10-01 00:14:29.000000', 4),
(80, 100, '2024-10-01 00:14:29.000000', NULL, 'DL10', '2024-10-01 00:14:29.000000', 4),
(81, 100, '2024-10-01 00:14:29.000000', NULL, 'DL11', '2024-10-01 00:14:29.000000', 4),
(82, 100, '2024-10-01 00:14:29.000000', NULL, 'DL12', '2024-10-01 00:14:29.000000', 4),
(83, 100, '2024-10-01 00:14:29.000000', NULL, 'DL13', '2024-10-01 00:14:29.000000', 4),
(84, 100, '2024-10-01 00:14:29.000000', NULL, 'DL14', '2024-10-01 00:14:29.000000', 4),
(85, 100, '2024-10-01 00:14:29.000000', NULL, 'DL15', '2024-10-01 00:14:29.000000', 4),
(86, 180, '2024-10-01 00:14:37.000000', NULL, 'DG01', '2024-10-01 00:14:37.000000', 5),
(87, 180, '2024-10-01 00:14:37.000000', NULL, 'DG02', '2024-10-01 00:14:37.000000', 5),
(88, 180, '2024-10-01 00:14:37.000000', NULL, 'DG03', '2024-10-01 00:14:37.000000', 5),
(89, 180, '2024-10-01 00:14:37.000000', NULL, 'DG04', '2024-10-01 00:14:37.000000', 5),
(90, 180, '2024-10-01 00:14:37.000000', NULL, 'DG05', '2024-10-01 00:14:37.000000', 5),
(91, 180, '2024-10-01 00:14:37.000000', NULL, 'DG06', '2024-10-01 00:14:37.000000', 5),
(92, 180, '2024-10-01 00:14:37.000000', NULL, 'DG07', '2024-10-01 00:14:37.000000', 5),
(93, 180, '2024-10-01 00:14:37.000000', NULL, 'DG08', '2024-10-01 00:14:37.000000', 5),
(94, 180, '2024-10-01 00:14:37.000000', NULL, 'DG09', '2024-10-01 00:14:37.000000', 5),
(95, 180, '2024-10-01 00:14:37.000000', NULL, 'DG10', '2024-10-01 00:14:37.000000', 5),
(96, 180, '2024-10-01 00:14:37.000000', NULL, 'DG11', '2024-10-01 00:14:37.000000', 5),
(97, 180, '2024-10-01 00:14:37.000000', NULL, 'DG12', '2024-10-01 00:14:37.000000', 5),
(98, 180, '2024-10-01 00:14:37.000000', NULL, 'DG13', '2024-10-01 00:14:37.000000', 5),
(99, 180, '2024-10-01 00:14:37.000000', NULL, 'DG14', '2024-10-01 00:14:37.000000', 5),
(100, 180, '2024-10-01 00:14:37.000000', NULL, 'DG15', '2024-10-01 00:14:37.000000', 5);

-- --------------------------------------------------------

--
-- Table structure for table `screeningtypes`
--

CREATE TABLE `screeningtypes` (
  `id` bigint NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `screeningtypes`
--

INSERT INTO `screeningtypes` (`id`, `created_at`, `deleted_at`, `description`, `name`, `status`, `updated_at`) VALUES
(1, '2024-09-25 23:37:14.000000', NULL, 'Phim được chiếu trước giờ phát hành chính thức', 'Suất chiếu sớm', '1', '2024-09-25 23:37:14.000000'),
(2, '2024-09-25 23:37:14.000000', NULL, 'Suất chiếu dành cho các sự kiện đặc biệt hoặc dịp lễ', 'Suất chiếu đặc biệt', '1', '2024-09-25 23:37:14.000000'),
(3, '2024-09-25 23:37:14.000000', NULL, 'Dành cho khách hàng VIP hoặc suất chiếu với dịch vụ đặc biệt', 'Suất chiếu VIP', '1', '2024-09-25 23:37:14.000000'),
(4, '2024-09-25 23:37:14.000000', NULL, 'Phim chiếu vào cuối tuần, có thể có giá vé cao hơn', 'Suất chiếu cuối tuần', '1', '2024-09-25 23:37:14.000000'),
(5, '2024-09-25 23:37:14.000000', NULL, 'Phim chiếu muộn vào ban đêm, thường sau 22h', 'Suất chiếu đêm', '1', '2024-09-25 23:37:14.000000');

-- --------------------------------------------------------

--
-- Table structure for table `screening_formats`
--

CREATE TABLE `screening_formats` (
  `id` bigint NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `screening_formats`
--

INSERT INTO `screening_formats` (`id`, `created_at`, `deleted_at`, `description`, `name`, `status`, `updated_at`) VALUES
(1, '2024-09-25 23:03:11.000000', NULL, 'Phim chiếu với định dạng 2D thông thường', '2D', '1', '2024-09-25 23:03:11.000000'),
(2, '2024-09-25 23:03:11.000000', NULL, 'Phim chiếu với hiệu ứng 3D sử dụng kính chuyên dụng', '3D', '1', '2024-09-25 23:03:11.000000'),
(3, '2024-09-25 23:03:11.000000', NULL, 'Định dạng IMAX với màn hình siêu lớn và âm thanh sống động', 'IMAX', '1', '2024-09-25 23:03:11.000000'),
(4, '2024-09-25 23:03:12.000000', NULL, 'Định dạng 4DX với các hiệu ứng đặc biệt như rung lắc, phun nước', '4DX', '1', '2024-09-25 23:03:12.000000'),
(5, '2024-09-25 23:03:12.000000', NULL, 'Định dạng Dolby Cinema với âm thanh và hình ảnh chất lượng cao', 'Dolby Cinema', '1', '2024-09-25 23:03:12.000000');

-- --------------------------------------------------------

--
-- Table structure for table `show_times`
--

CREATE TABLE `show_times` (
  `id` bigint NOT NULL,
  `start_time` datetime(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `cinema_id` bigint NOT NULL,
  `film_id` bigint NOT NULL,
  `language_id` bigint NOT NULL,
  `room_id` bigint NOT NULL,
  `screening_format_id` bigint NOT NULL,
  `screening_type_id` bigint NOT NULL,
  `voucher_id` bigint DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `show_times`
--

INSERT INTO `show_times` (`id`, `start_time`, `status`, `cinema_id`, `film_id`, `language_id`, `room_id`, `screening_format_id`, `screening_type_id`, `voucher_id`, `created_at`, `deleted_at`, `updated_at`) VALUES
(45, '2024-07-10 14:00:00.000000', 'Hoạt động', 1, 15, 1, 26, 1, 2, 12, '2024-07-01 10:15:30.000000', NULL, '2024-07-01 10:15:30.000000'),
(46, '2024-07-11 16:30:00.000000', 'Đã chiếu', 1, 20, 2, 27, 3, 1, NULL, '2024-07-02 11:20:45.000000', NULL, '2024-07-02 11:20:45.000000'),
(47, '2024-07-12 18:00:00.000000', 'Đã chiếu', 1, 22, 3, 28, 2, 4, 16, '2024-07-03 09:35:20.000000', NULL, '2024-07-03 09:35:20.000000'),
(48, '2024-07-13 20:15:00.000000', 'Hoạt động', 1, 18, 4, 29, 4, 3, NULL, '2024-07-04 14:45:10.000000', NULL, '2024-07-04 14:45:10.000000'),
(49, '2024-07-14 12:45:00.000000', 'Tạm hoãn', 1, 17, 1, 30, 5, 2, 20, '2024-07-05 16:00:00.000000', NULL, '2024-07-05 16:00:00.000000'),
(50, '2024-07-15 10:30:00.000000', 'Hoạt động', 2, 25, 2, 31, 1, 3, NULL, '2024-07-06 08:30:25.000000', NULL, '2024-07-06 08:30:25.000000'),
(51, '2024-07-16 14:45:00.000000', 'Đã chiếu', 2, 30, 3, 32, 3, 2, 22, '2024-07-07 12:20:30.000000', NULL, '2024-07-07 12:20:30.000000'),
(52, '2024-07-17 17:00:00.000000', 'Đã chiếu', 2, 32, 4, 33, 2, 1, 25, '2024-07-08 15:50:45.000000', NULL, '2024-07-08 15:50:45.000000'),
(53, '2024-07-18 19:30:00.000000', 'Hoạt động', 2, 28, 1, 34, 4, 5, NULL, '2024-07-09 14:25:50.000000', NULL, '2024-07-09 14:25:50.000000'),
(54, '2024-07-19 13:15:00.000000', 'Đã hủy', 2, 26, 2, 35, 5, 4, 18, '2024-07-10 11:10:35.000000', NULL, '2024-07-10 11:10:35.000000'),
(55, '2024-07-20 16:30:00.000000', 'Hoạt động', 3, 35, 3, 36, 3, 2, NULL, '2024-07-11 13:45:20.000000', NULL, '2024-07-11 13:45:20.000000'),
(56, '2024-07-21 18:45:00.000000', 'Đã chiếu', 3, 40, 4, 37, 1, 1, 15, '2024-07-12 17:20:15.000000', NULL, '2024-07-12 17:20:15.000000'),
(57, '2024-07-22 20:00:00.000000', 'Đã chiếu', 3, 42, 1, 38, 2, 3, 19, '2024-07-13 16:00:10.000000', NULL, '2024-07-13 16:00:10.000000'),
(58, '2024-07-23 12:00:00.000000', 'Hoạt động', 3, 38, 2, 39, 4, 4, 13, '2024-07-14 09:10:55.000000', NULL, '2024-07-14 09:10:55.000000'),
(59, '2024-07-24 14:30:00.000000', 'Đã hủy', 3, 37, 3, 40, 5, 5, NULL, '2024-07-15 12:50:35.000000', NULL, '2024-07-15 12:50:35.000000'),
(60, '2024-07-25 15:00:00.000000', 'Hoạt động', 4, 45, 4, 41, 2, 2, 14, '2024-07-16 11:05:25.000000', NULL, '2024-07-16 11:05:25.000000'),
(61, '2024-07-26 17:15:00.000000', 'Hoạt động', 4, 50, 1, 42, 4, 1, 26, '2024-07-17 14:20:10.000000', NULL, '2024-07-17 14:20:10.000000'),
(62, '2024-07-27 19:45:00.000000', 'Đã chiếu', 4, 52, 2, 43, 5, 3, NULL, '2024-07-18 16:35:45.000000', NULL, '2024-07-18 16:35:45.000000'),
(63, '2024-07-28 21:30:00.000000', 'Đã chiếu', 4, 55, 3, 44, 1, 5, 28, '2024-07-19 18:45:20.000000', NULL, '2024-07-19 18:45:20.000000'),
(64, '2024-07-29 12:15:00.000000', 'Đã chiếu', 4, 58, 4, 45, 3, 4, NULL, '2024-07-20 10:10:30.000000', NULL, '2024-07-20 10:10:30.000000'),
(65, '2024-06-02 14:00:00.000000', 'Hoạt động', 1, 16, 1, 46, 1, 2, 11, '2024-06-01 10:15:30.000000', NULL, '2024-06-01 10:15:30.000000'),
(66, '2024-06-05 16:30:00.000000', 'Đã chiếu', 1, 21, 2, 47, 3, 1, NULL, '2024-06-02 11:20:45.000000', NULL, '2024-06-02 11:20:45.000000'),
(67, '2024-06-10 18:00:00.000000', 'Đã chiếu', 1, 23, 3, 48, 2, 4, 17, '2024-06-03 09:35:20.000000', NULL, '2024-06-03 09:35:20.000000'),
(68, '2024-06-12 20:15:00.000000', 'Hoạt động', 1, 19, 4, 49, 4, 3, NULL, '2024-06-05 14:45:10.000000', NULL, '2024-06-05 14:45:10.000000'),
(69, '2024-06-14 12:45:00.000000', 'Tạm hoãn', 1, 18, 1, 50, 5, 2, 21, '2024-06-08 16:00:00.000000', NULL, '2024-06-08 16:00:00.000000'),
(70, '2024-06-15 10:30:00.000000', 'Hoạt động', 2, 27, 2, 51, 1, 3, NULL, '2024-06-10 08:30:25.000000', NULL, '2024-06-10 08:30:25.000000'),
(71, '2024-06-20 14:45:00.000000', 'Đã chiếu', 2, 33, 3, 52, 3, 2, 23, '2024-06-12 12:20:30.000000', NULL, '2024-06-12 12:20:30.000000'),
(72, '2024-07-01 17:00:00.000000', 'Đã chiếu', 2, 34, 4, 53, 2, 1, 24, '2024-06-15 15:50:45.000000', NULL, '2024-06-15 15:50:45.000000'),
(73, '2024-07-05 19:30:00.000000', 'Hoạt động', 2, 29, 1, 54, 4, 5, NULL, '2024-06-17 14:25:50.000000', NULL, '2024-06-17 14:25:50.000000'),
(74, '2024-07-12 13:15:00.000000', 'Đã hủy', 2, 31, 2, 55, 5, 4, 27, '2024-06-22 11:10:35.000000', NULL, '2024-06-22 11:10:35.000000'),
(75, '2024-08-01 16:30:00.000000', 'Hoạt động', 3, 36, 3, 56, 3, 2, NULL, '2024-07-01 13:45:20.000000', NULL, '2024-07-01 13:45:20.000000'),
(76, '2024-08-05 18:45:00.000000', 'Đã chiếu', 3, 41, 4, 57, 1, 1, 14, '2024-07-05 17:20:15.000000', NULL, '2024-07-05 17:20:15.000000'),
(77, '2024-08-10 20:00:00.000000', 'Đã chiếu', 3, 43, 1, 58, 2, 3, 18, '2024-07-10 16:00:10.000000', NULL, '2024-07-10 16:00:10.000000'),
(78, '2024-08-12 12:00:00.000000', 'Hoạt động', 3, 39, 2, 59, 4, 4, 13, '2024-07-12 09:10:55.000000', NULL, '2024-07-12 09:10:55.000000'),
(79, '2024-08-18 14:30:00.000000', 'Đã hủy', 3, 38, 3, 60, 5, 5, NULL, '2024-07-14 12:50:35.000000', NULL, '2024-07-14 12:50:35.000000'),
(80, '2024-09-01 15:00:00.000000', 'Hoạt động', 4, 46, 4, 61, 2, 2, 19, '2024-07-20 11:05:25.000000', NULL, '2024-07-20 11:05:25.000000'),
(81, '2024-09-05 17:15:00.000000', 'Hoạt động', 4, 51, 1, 62, 4, 1, 29, '2024-07-22 14:20:10.000000', NULL, '2024-07-22 14:20:10.000000'),
(82, '2024-09-10 19:45:00.000000', 'Đã chiếu', 4, 53, 2, 63, 5, 3, NULL, '2024-07-25 16:35:45.000000', NULL, '2024-07-25 16:35:45.000000'),
(83, '2024-09-15 21:30:00.000000', 'Đã chiếu', 4, 56, 3, 64, 1, 5, 28, '2024-07-28 18:45:20.000000', NULL, '2024-07-28 18:45:20.000000'),
(84, '2024-10-01 12:15:00.000000', 'Đã chiếu', 4, 59, 4, 65, 3, 4, NULL, '2024-07-30 10:10:30.000000', NULL, '2024-07-30 10:10:30.000000');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `id` bigint NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`id`, `created_at`, `deleted_at`, `description`, `name`, `updated_at`) VALUES
(1, '2024-09-26 00:34:36.000000', NULL, 'Nhà cung cấp phim hành động chất lượng cao', 'Công ty Phim Alpha', '2024-09-26 00:34:36.000000'),
(2, '2024-09-26 00:34:36.000000', NULL, 'Nhà cung cấp phim kinh dị nổi tiếng', 'Công ty Phim Beta', '2024-09-26 00:34:36.000000'),
(3, '2024-09-26 00:34:36.000000', NULL, 'Nhà cung cấp phim hài và hoạt hình', 'Công ty Phim Gamma', '2024-09-26 00:34:36.000000'),
(4, '2024-09-26 00:34:36.000000', NULL, 'Chuyên cung cấp các bộ phim đặc biệt và cao cấp', 'Công ty Phim Delta', '2024-09-26 00:34:36.000000');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `birth_day` datetime(6) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `home_town` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `role_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `birth_day`, `created_at`, `deleted_at`, `email`, `full_name`, `gender`, `home_town`, `password`, `phone`, `updated_at`, `role_id`) VALUES
(5, '1990-05-15 00:00:00.000000', '2023-08-31 09:15:30.000000', NULL, 'nguyenvana@example.com', 'Nguyễn Văn A', 'Male', 'Hà Nội', 'password123', '0912345678', '2023-08-31 09:15:30.000000', 2),
(6, '1992-07-20 00:00:00.000000', '2023-09-05 12:45:50.000000', NULL, 'tranthib@example.com', 'Trần Thị B', 'Female', 'Hồ Chí Minh', 'password123', '0923456789', '2023-09-05 12:45:50.000000', 2),
(7, '1995-02-10 00:00:00.000000', '2023-09-10 14:22:35.000000', NULL, 'lehoangc@example.com', 'Lê Hoàng C', 'Male', 'Đà Nẵng', 'password123', '0934567890', '2023-09-10 14:22:35.000000', 2),
(8, '1993-09-25 00:00:00.000000', '2023-09-15 10:30:15.000000', NULL, 'phamvand@example.com', 'Phạm Văn D', 'Male', 'Hải Phòng', 'password123', '0945678901', '2023-09-15 10:30:15.000000', 3),
(9, '1994-11-15 00:00:00.000000', '2023-09-18 16:00:00.000000', NULL, 'buithie@example.com', 'Bùi Thị E', 'Female', 'Cần Thơ', 'password123', '0956789012', '2023-09-18 16:00:00.000000', 3),
(10, '1991-12-30 00:00:00.000000', '2023-09-25 09:30:10.000000', NULL, 'hoangvanf@example.com', 'Hoàng Văn F', 'Male', 'Nghệ An', 'password123', '0967890123', '2023-09-25 09:30:10.000000', 2),
(11, '1988-03-25 00:00:00.000000', '2023-10-01 11:50:00.000000', NULL, 'dothig@example.com', 'Đỗ Thị G', 'Female', 'Bình Dương', 'password123', '0978901234', '2023-10-01 11:50:00.000000', 3),
(12, '1989-06-15 00:00:00.000000', '2023-10-05 13:45:30.000000', NULL, 'nguyenvanh@example.com', 'Nguyễn Văn H', 'Male', 'Quảng Ninh', 'password123', '0989012345', '2023-10-05 13:45:30.000000', 2),
(13, '1996-08-10 00:00:00.000000', '2023-10-08 16:22:10.000000', NULL, 'phanthii@example.com', 'Phan Thị I', 'Female', 'Đà Lạt', 'password123', '0910123456', '2023-10-08 16:22:10.000000', 2),
(14, '1993-04-20 00:00:00.000000', '2023-10-10 18:30:45.000000', NULL, 'trinhvanj@example.com', 'Trịnh Văn J', 'Male', 'Huế', 'password123', '0911234567', '2023-10-10 18:30:45.000000', 3),
(15, '1994-07-05 00:00:00.000000', '2023-10-15 08:40:50.000000', NULL, 'nguyenthik@example.com', 'Nguyễn Thị K', 'Female', 'Bắc Ninh', 'password123', '0912345678', '2023-10-15 08:40:50.000000', 3),
(16, '1992-01-20 00:00:00.000000', '2023-10-20 09:50:30.000000', NULL, 'tranvanl@example.com', 'Trần Văn L', 'Male', 'Vũng Tàu', 'password123', '0913456789', '2023-10-20 09:50:30.000000', 2),
(17, '1995-03-25 00:00:00.000000', '2023-10-25 14:10:10.000000', NULL, 'phamthim@example.com', 'Phạm Thị M', 'Female', 'Biên Hòa', 'password123', '0914567890', '2023-10-25 14:10:10.000000', 2),
(18, '1991-05-30 00:00:00.000000', '2023-11-01 12:30:45.000000', NULL, 'vuvann@example.com', 'Vũ Văn N', 'Male', 'Lạng Sơn', 'password123', '0915678901', '2023-11-01 12:30:45.000000', 3),
(19, '1994-10-15 00:00:00.000000', '2023-11-05 10:45:30.000000', NULL, 'lethio@example.com', 'Lê Thị O', 'Female', 'Quảng Ngãi', 'password123', '0916789012', '2023-11-05 10:45:30.000000', 3),
(20, '1993-09-16 00:00:00.000000', '2023-11-15 14:23:50.000000', NULL, 'nguyenthik@example.com', 'Nguyễn Thị P', 'Female', 'Hà Nội', 'password123', '0916789345', '2023-11-15 14:23:50.000000', 2),
(21, '1992-02-24 00:00:00.000000', '2023-11-20 17:34:11.000000', NULL, 'buithiq@example.com', 'Bùi Thị Q', 'Female', 'Hồ Chí Minh', 'password123', '0918456789', '2023-11-20 17:34:11.000000', 3),
(22, '1991-03-12 00:00:00.000000', '2023-11-24 11:20:00.000000', NULL, 'tranvanr@example.com', 'Trần Văn R', 'Male', 'Đà Nẵng', 'password123', '0912345674', '2023-11-24 11:20:00.000000', 2),
(23, '1995-05-11 00:00:00.000000', '2023-11-29 09:40:22.000000', NULL, 'phamthis@example.com', 'Phạm Thị S', 'Female', 'Hải Phòng', 'password123', '0912567895', '2023-11-29 09:40:22.000000', 3),
(24, '1996-06-30 00:00:00.000000', '2023-12-01 14:50:15.000000', NULL, 'nguyenvant@example.com', 'Nguyễn Văn T', 'Male', 'Hà Nội', 'password123', '0911456789', '2023-12-01 14:50:15.000000', 2),
(25, '1990-04-02 00:00:00.000000', '2023-12-05 18:25:30.000000', NULL, 'lethiu@example.com', 'Lê Thị U', 'Female', 'Cần Thơ', 'password123', '0913456987', '2023-12-05 18:25:30.000000', 3),
(26, '1991-08-18 00:00:00.000000', '2023-12-10 12:10:20.000000', NULL, 'vovanv@example.com', 'Võ Văn V', 'Male', 'Bình Dương', 'password123', '0911345672', '2023-12-10 12:10:20.000000', 2),
(27, '1994-01-09 00:00:00.000000', '2023-12-15 15:30:40.000000', NULL, 'tranthiw@example.com', 'Trần Thị W', 'Female', 'Hồ Chí Minh', 'password123', '0919234678', '2023-12-15 15:30:40.000000', 3),
(28, '1993-09-21 00:00:00.000000', '2023-12-20 10:35:50.000000', NULL, 'nguyenvanx@example.com', 'Nguyễn Văn X', 'Male', 'Đà Nẵng', 'password123', '0912456789', '2023-12-20 10:35:50.000000', 2),
(29, '1992-12-16 00:00:00.000000', '2023-12-25 17:55:12.000000', NULL, 'phanthiy@example.com', 'Phan Thị Y', 'Female', 'Quảng Ninh', 'password123', '0911342567', '2023-12-25 17:55:12.000000', 3),
(30, '1991-11-01 00:00:00.000000', '2023-12-28 11:45:33.000000', NULL, 'levanz@example.com', 'Lê Văn Z', 'Male', 'Nghệ An', 'password123', '0918765432', '2023-12-28 11:45:33.000000', 2),
(31, '1990-01-15 00:00:00.000000', '2023-09-01 08:35:20.000000', NULL, 'dangvanaa@example.com', 'Đặng Văn AA', 'Male', 'Hà Nội', 'password123', '0913456781', '2023-09-01 08:35:20.000000', 2),
(32, '1992-03-12 00:00:00.000000', '2023-09-05 09:12:34.000000', NULL, 'nguyenthibb@example.com', 'Nguyễn Thị BB', 'Female', 'Hồ Chí Minh', 'password123', '0914567892', '2023-09-05 09:12:34.000000', 3),
(33, '1988-04-20 00:00:00.000000', '2023-09-08 11:25:55.000000', NULL, 'levancc@example.com', 'Lê Văn CC', 'Male', 'Đà Nẵng', 'password123', '0915678903', '2023-09-08 11:25:55.000000', 2),
(34, '1991-06-30 00:00:00.000000', '2023-09-12 12:10:05.000000', NULL, 'phamthidd@example.com', 'Phạm Thị DD', 'Female', 'Hải Phòng', 'password123', '0916789014', '2023-09-12 12:10:05.000000', 3),
(35, '1995-08-25 00:00:00.000000', '2023-09-15 10:45:20.000000', NULL, 'tranvanee@example.com', 'Trần Văn EE', 'Male', 'Nghệ An', 'password123', '0917890125', '2023-09-15 10:45:20.000000', 2),
(36, '1992-10-10 00:00:00.000000', '2023-09-18 14:35:45.000000', NULL, 'vuthiff@example.com', 'Vũ Thị FF', 'Female', 'Bình Dương', 'password123', '0918901236', '2023-09-18 14:35:45.000000', 2),
(37, '1990-11-12 00:00:00.000000', '2023-09-22 09:20:30.000000', NULL, 'buivangg@example.com', 'Bùi Văn GG', 'Male', 'Hồ Chí Minh', 'password123', '0919012347', '2023-09-22 09:20:30.000000', 3),
(38, '1993-05-22 00:00:00.000000', '2023-09-25 16:45:10.000000', NULL, 'nguyenthihh@example.com', 'Nguyễn Thị HH', 'Female', 'Cần Thơ', 'password123', '0912345671', '2023-09-25 16:45:10.000000', 2),
(39, '1994-02-28 00:00:00.000000', '2023-09-28 11:15:00.000000', NULL, 'levanii@example.com', 'Lê Văn II', 'Male', 'Hà Nội', 'password123', '0913456782', '2023-09-28 11:15:00.000000', 3),
(40, '1992-07-05 00:00:00.000000', '2023-10-01 09:45:25.000000', NULL, 'phamthijj@example.com', 'Phạm Thị JJ', 'Female', 'Đà Nẵng', 'password123', '0914567893', '2023-10-01 09:45:25.000000', 2),
(41, '1989-11-30 00:00:00.000000', '2023-10-05 15:25:35.000000', NULL, 'nguyenvankk@example.com', 'Nguyễn Văn KK', 'Male', 'Hồ Chí Minh', 'password123', '0915678904', '2023-10-05 15:25:35.000000', 3),
(42, '1991-09-20 00:00:00.000000', '2023-10-08 17:50:45.000000', NULL, 'lethill@example.com', 'Lê Thị LL', 'Female', 'Huế', 'password123', '0916789015', '2023-10-08 17:50:45.000000', 2),
(43, '1988-06-15 00:00:00.000000', '2023-10-12 10:30:50.000000', NULL, 'tranvanmm@example.com', 'Trần Văn MM', 'Male', 'Đồng Nai', 'password123', '0917890126', '2023-10-12 10:30:50.000000', 3),
(44, '1990-12-05 00:00:00.000000', '2023-10-16 12:45:30.000000', NULL, 'nguyenthin@example.com', 'Nguyễn Thị NN', 'Female', 'Hải Phòng', 'password123', '0918901237', '2023-10-16 12:45:30.000000', 2),
(45, '1994-03-17 00:00:00.000000', '2023-10-20 16:20:40.000000', NULL, 'dangvanoo@example.com', 'Đặng Văn OO', 'Male', 'Quảng Ninh', 'password123', '0912345679', '2023-10-20 16:20:40.000000', 3),
(46, '1991-08-25 00:00:00.000000', '2023-10-25 14:10:35.000000', NULL, 'levanpp@example.com', 'Lê Văn PP', 'Male', 'Hà Nội', 'password123', '0913456783', '2023-10-25 14:10:35.000000', 2),
(47, '1993-12-10 00:00:00.000000', '2023-10-28 09:55:45.000000', NULL, 'phamthiq@example.com', 'Phạm Thị QQ', 'Female', 'Đà Lạt', 'password123', '0914567894', '2023-10-28 09:55:45.000000', 3),
(48, '1995-11-23 00:00:00.000000', '2023-11-01 11:35:00.000000', NULL, 'tranvanrr@example.com', 'Trần Văn RR', 'Male', 'Cần Thơ', 'password123', '0915678905', '2023-11-01 11:35:00.000000', 2),
(49, '1991-06-30 00:00:00.000000', '2023-11-05 15:20:20.000000', NULL, 'vuthiss@example.com', 'Vũ Thị SS', 'Female', 'Nghệ An', 'password123', '0916789016', '2023-11-05 15:20:20.000000', 3),
(50, '1990-01-11 00:00:00.000000', '2023-11-09 09:10:05.000000', NULL, 'buivantt@example.com', 'Bùi Văn TT', 'Male', 'Bình Dương', 'password123', '0917890127', '2023-11-09 09:10:05.000000', 2),
(51, '1992-09-30 00:00:00.000000', '2023-11-12 14:35:55.000000', NULL, 'nguyenthitu@example.com', 'Nguyễn Thị UU', 'Female', 'Hà Nội', 'password123', '0918901238', '2023-11-12 14:35:55.000000', 3),
(52, '1993-02-25 00:00:00.000000', '2023-11-16 12:40:50.000000', NULL, 'levanvv@example.com', 'Lê Văn VV', 'Male', 'Hồ Chí Minh', 'password123', '0912345672', '2023-11-16 12:40:50.000000', 2),
(53, '1990-11-18 00:00:00.000000', '2023-11-20 17:55:20.000000', NULL, 'phamthiww@example.com', 'Phạm Thị WW', 'Female', 'Đà Nẵng', 'password123', '0913456784', '2023-11-20 17:55:20.000000', 3),
(54, '1995-01-15 00:00:00.000000', '2023-11-25 09:30:10.000000', NULL, 'nguyenvanxx@example.com', 'Nguyễn Văn XX', 'Male', 'Quảng Ninh', 'password123', '0914567895', '2023-11-25 09:30:10.000000', 2),
(55, '1993-04-18 00:00:00.000000', '2023-11-29 10:10:00.000000', NULL, 'lethiyy@example.com', 'Lê Thị YY', 'Female', 'Hải Phòng', 'password123', '0915678906', '2023-11-29 10:10:00.000000', 2),
(56, '1988-09-12 00:00:00.000000', '2023-12-02 11:25:35.000000', NULL, 'tranvanzz@example.com', 'Trần Văn ZZ', 'Male', 'Nghệ An', 'password123', '0916789017', '2023-12-02 11:25:35.000000', 3),
(57, '1991-05-21 00:00:00.000000', '2023-12-06 13:50:10.000000', NULL, 'vuthiaaa@example.com', 'Vũ Thị AAA', 'Female', 'Hồ Chí Minh', 'password123', '0917890128', '2023-12-06 13:50:10.000000', 2),
(58, '1994-08-05 00:00:00.000000', '2023-12-10 15:20:40.000000', NULL, 'nguyenvanbbb@example.com', 'Nguyễn Văn BBB', 'Male', 'Bình Dương', 'password123', '0918901239', '2023-12-10 15:20:40.000000', 2),
(59, '1990-07-16 00:00:00.000000', '2023-12-15 14:15:25.000000', NULL, 'buithiccc@example.com', 'Bùi Thị CCC', 'Female', 'Huế', 'password123', '0912345673', '2023-12-15 14:15:25.000000', 3),
(60, '1989-06-10 00:00:00.000000', '2023-12-20 09:45:50.000000', NULL, 'nguyenvanddd@example.com', 'Nguyễn Văn DDD', 'Male', 'Hà Nội', 'password123', '0913456785', '2023-12-20 09:45:50.000000', 2),
(61, '1992-03-20 00:00:00.000000', '2023-12-25 12:30:20.000000', NULL, 'phamthieee@example.com', 'Phạm Thị EEE', 'Female', 'Đồng Nai', 'password123', '0914567896', '2023-12-25 12:30:20.000000', 3),
(62, '1991-10-15 00:00:00.000000', '2023-12-28 11:50:40.000000', NULL, 'tranvanfff@example.com', 'Trần Văn FFF', 'Male', 'Đà Nẵng', 'password123', '0915678907', '2023-12-28 11:50:40.000000', 2);

-- --------------------------------------------------------

--
-- Table structure for table `vouchers`
--

CREATE TABLE `vouchers` (
  `id` bigint NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `han_dung` datetime(6) NOT NULL,
  `han_muc` decimal(38,2) NOT NULL,
  `ngay_tao` datetime(6) NOT NULL,
  `ti_le_chiet_khau` decimal(38,2) NOT NULL,
  `tinh_trang` bit(1) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `employee_id` bigint NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `vouchers`
--

INSERT INTO `vouchers` (`id`, `created_at`, `deleted_at`, `han_dung`, `han_muc`, `ngay_tao`, `ti_le_chiet_khau`, `tinh_trang`, `updated_at`, `employee_id`, `name`) VALUES
(10, '2023-08-30 08:34:12.000000', NULL, '2023-09-15 23:59:59.000000', '1000000.00', '2023-08-30 08:34:12.000000', '10.00', b'0', '2023-09-02 09:12:34.000000', 1, 'Mừng Xuân'),
(11, '2023-08-31 09:45:23.000000', NULL, '2023-09-20 23:59:59.000000', '2000000.00', '2023-08-31 09:45:23.000000', '12.50', b'0', '2023-09-04 10:15:20.000000', 2, 'Đầu tháng vui vẻ'),
(12, '2023-09-01 11:23:45.000000', NULL, '2023-09-25 23:59:59.000000', '1500000.00', '2023-09-01 11:23:45.000000', '8.00', b'1', '2023-09-06 11:16:45.000000', 3, 'Khuyến mãi cuối tháng'),
(13, '2023-09-02 10:10:20.000000', NULL, '2023-09-30 23:59:59.000000', '1200000.00', '2023-09-02 10:10:20.000000', '15.00', b'1', '2023-09-05 12:22:10.000000', 4, 'Giảm giá sốc mùa hè'),
(14, '2023-09-03 14:20:30.000000', NULL, '2023-09-29 23:59:59.000000', '1800000.00', '2023-09-03 14:20:30.000000', '20.00', b'1', '2023-09-07 14:30:10.000000', 5, 'Ưu đãi đặc biệt mùa hè'),
(15, '2023-09-04 08:14:55.000000', NULL, '2023-09-28 23:59:59.000000', '2500000.00', '2023-09-04 08:14:55.000000', '11.50', b'1', '2023-09-09 10:12:15.000000', 1, 'Siêu khuyến mãi đầu tháng'),
(16, '2023-09-05 15:45:12.000000', NULL, '2023-09-25 23:59:59.000000', '1300000.00', '2023-09-05 15:45:12.000000', '7.00', b'1', '2023-09-08 16:12:50.000000', 2, 'Giảm giá ngày lễ'),
(17, '2023-09-06 13:23:32.000000', NULL, '2023-09-27 23:59:59.000000', '3000000.00', '2023-09-06 13:23:32.000000', '10.50', b'0', '2023-09-10 09:15:45.000000', 3, 'Chào đón năm mới'),
(18, '2023-09-07 10:35:45.000000', NULL, '2023-09-26 23:59:59.000000', '1000000.00', '2023-09-07 10:35:45.000000', '12.00', b'0', '2023-09-12 12:34:10.000000', 4, 'Tháng mới khuyến mãi lớn'),
(19, '2023-09-08 08:22:55.000000', NULL, '2023-09-24 23:59:59.000000', '2200000.00', '2023-09-08 08:22:55.000000', '9.50', b'1', '2023-09-11 11:14:10.000000', 5, 'Mùa mua sắm giảm giá'),
(20, '2023-09-09 11:54:10.000000', NULL, '2023-09-28 23:59:59.000000', '500000.00', '2023-09-09 11:54:10.000000', '5.50', b'1', '2023-09-12 10:10:10.000000', 1, 'Khuyến mãi đặc biệt cuối tuần'),
(21, '2023-09-10 14:32:20.000000', NULL, '2023-09-29 23:59:59.000000', '1500000.00', '2023-09-10 14:32:20.000000', '8.50', b'1', '2023-09-14 11:20:30.000000', 2, 'Giảm giá cuối tháng'),
(22, '2023-09-11 12:44:32.000000', NULL, '2023-09-27 23:59:59.000000', '1700000.00', '2023-09-11 12:44:32.000000', '6.00', b'0', '2023-09-16 09:10:50.000000', 3, 'Khuyến mãi mùa thu'),
(23, '2023-09-12 10:11:40.000000', NULL, '2023-09-30 23:59:59.000000', '1100000.00', '2023-09-12 10:11:40.000000', '13.50', b'1', '2023-09-17 12:12:12.000000', 4, 'Ưu đãi lớn tháng 9'),
(24, '2023-09-13 09:23:25.000000', NULL, '2023-09-29 23:59:59.000000', '2000000.00', '2023-09-13 09:23:25.000000', '14.00', b'0', '2023-09-19 14:15:40.000000', 5, 'Siêu khuyến mãi tháng 9'),
(25, '2023-09-14 08:32:45.000000', NULL, '2023-09-25 23:59:59.000000', '900000.00', '2023-09-14 08:32:45.000000', '10.50', b'1', '2023-09-18 12:14:50.000000', 1, 'Chào tháng mới khuyến mãi'),
(26, '2023-09-15 16:54:22.000000', NULL, '2023-09-30 23:59:59.000000', '2500000.00', '2023-09-15 16:54:22.000000', '18.00', b'1', '2023-09-20 09:35:15.000000', 2, 'Ưu đãi đặc biệt tháng 9'),
(27, '2023-09-16 12:10:15.000000', NULL, '2023-09-28 23:59:59.000000', '1200000.00', '2023-09-16 12:10:15.000000', '9.00', b'1', '2023-09-21 10:11:40.000000', 3, 'Tháng 9 khuyến mãi'),
(28, '2023-09-17 09:15:10.000000', NULL, '2023-09-27 23:59:59.000000', '1600000.00', '2023-09-17 09:15:10.000000', '11.00', b'1', '2023-09-22 11:14:50.000000', 4, 'Ưu đãi cuối tháng'),
(29, '2023-09-18 11:12:55.000000', NULL, '2023-09-29 23:59:59.000000', '2000000.00', '2023-09-18 11:12:55.000000', '7.50', b'0', '2023-09-23 08:32:10.000000', 5, 'Khuyến mãi mùa đông'),
(30, '2023-09-19 08:23:20.000000', NULL, '2023-09-30 23:59:59.000000', '1400000.00', '2023-09-19 08:23:20.000000', '8.00', b'1', '2023-09-24 14:10:30.000000', 1, 'Siêu giảm giá mùa đông'),
(31, '2023-09-20 10:15:45.000000', NULL, '2023-09-29 23:59:59.000000', '1200000.00', '2023-09-20 10:15:45.000000', '13.50', b'1', '2023-09-25 09:15:10.000000', 2, 'Ưu đãi cuối năm'),
(32, '2023-09-21 11:25:50.000000', NULL, '2023-09-30 23:59:59.000000', '1800000.00', '2023-09-21 11:25:50.000000', '16.00', b'1', '2023-09-26 10:12:45.000000', 3, 'Giảm giá tháng 12'),
(33, '2023-09-22 08:45:12.000000', NULL, '2023-09-28 23:59:59.000000', '1000000.00', '2023-09-22 08:45:12.000000', '12.50', b'0', '2023-09-27 14:22:15.000000', 4, 'Ưu đãi cuối năm'),
(34, '2023-09-23 12:23:55.000000', NULL, '2023-09-29 23:59:59.000000', '2500000.00', '2023-09-23 12:23:55.000000', '16.00', b'1', '2023-09-28 10:15:50.000000', 5, 'Siêu khuyến mãi mùa lễ'),
(35, '2023-09-24 15:34:12.000000', NULL, '2023-09-30 23:59:59.000000', '1700000.00', '2023-09-24 15:34:12.000000', '9.50', b'1', '2023-09-29 08:45:20.000000', 1, 'Giảm giá cuối năm'),
(36, '2023-09-25 09:15:32.000000', NULL, '2023-09-30 23:59:59.000000', '1500000.00', '2023-09-25 09:15:32.000000', '12.00', b'1', '2023-09-30 11:20:40.000000', 2, 'Ưu đãi mùa lễ hội');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cinemas`
--
ALTER TABLE `cinemas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `food_categories`
--
ALTER TABLE `food_categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `languages`
--
ALTER TABLE `languages`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loai_ghes`
--
ALTER TABLE `loai_ghes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `phims`
--
ALTER TABLE `phims`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKxc6d00efbj4p4vuxp1hnhhxk` (`id_theloai`),
  ADD KEY `FKpxltd7krs1tm7hjh8894sy1si` (`id_nhacungcap`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjp9bjtvlojbw581bpq23cpw4j` (`cinema_id`);

--
-- Indexes for table `screeningtypes`
--
ALTER TABLE `screeningtypes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `screening_formats`
--
ALTER TABLE `screening_formats`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `show_times`
--
ALTER TABLE `show_times`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK612r43u3qh528mg0gs8y7u9c9` (`cinema_id`),
  ADD KEY `FK6noaxhyjlarlg4wsivb5gq216` (`language_id`),
  ADD KEY `FKs2pkrbkkpijqwvtc9reivcvbt` (`room_id`),
  ADD KEY `FK7fwhf9i321upe78ruxqd18u0c` (`screening_format_id`),
  ADD KEY `FKkujm0f7vt5da8yf0i1khgiwsa` (`screening_type_id`),
  ADD KEY `FK739f2tbl4ueewtou9ik2va79a` (`voucher_id`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`);

--
-- Indexes for table `vouchers`
--
ALTER TABLE `vouchers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhnnk2wokdo16tbluqa8xkixwu` (`employee_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `cinemas`
--
ALTER TABLE `cinemas`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `food_categories`
--
ALTER TABLE `food_categories`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `languages`
--
ALTER TABLE `languages`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `loai_ghes`
--
ALTER TABLE `loai_ghes`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `phims`
--
ALTER TABLE `phims`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT for table `screeningtypes`
--
ALTER TABLE `screeningtypes`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `screening_formats`
--
ALTER TABLE `screening_formats`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `show_times`
--
ALTER TABLE `show_times`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `vouchers`
--
ALTER TABLE `vouchers`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `phims`
--
ALTER TABLE `phims`
  ADD CONSTRAINT `FKpxltd7krs1tm7hjh8894sy1si` FOREIGN KEY (`id_nhacungcap`) REFERENCES `suppliers` (`id`),
  ADD CONSTRAINT `FKxc6d00efbj4p4vuxp1hnhhxk` FOREIGN KEY (`id_theloai`) REFERENCES `categories` (`id`);

--
-- Constraints for table `rooms`
--
ALTER TABLE `rooms`
  ADD CONSTRAINT `FKjp9bjtvlojbw581bpq23cpw4j` FOREIGN KEY (`cinema_id`) REFERENCES `cinemas` (`id`);

--
-- Constraints for table `show_times`
--
ALTER TABLE `show_times`
  ADD CONSTRAINT `FK612r43u3qh528mg0gs8y7u9c9` FOREIGN KEY (`cinema_id`) REFERENCES `cinemas` (`id`),
  ADD CONSTRAINT `FK6noaxhyjlarlg4wsivb5gq216` FOREIGN KEY (`language_id`) REFERENCES `languages` (`id`),
  ADD CONSTRAINT `FK739f2tbl4ueewtou9ik2va79a` FOREIGN KEY (`voucher_id`) REFERENCES `vouchers` (`id`),
  ADD CONSTRAINT `FK7fwhf9i321upe78ruxqd18u0c` FOREIGN KEY (`screening_format_id`) REFERENCES `screening_formats` (`id`),
  ADD CONSTRAINT `FKkujm0f7vt5da8yf0i1khgiwsa` FOREIGN KEY (`screening_type_id`) REFERENCES `screeningtypes` (`id`),
  ADD CONSTRAINT `FKs2pkrbkkpijqwvtc9reivcvbt` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

--
-- Constraints for table `vouchers`
--
ALTER TABLE `vouchers`
  ADD CONSTRAINT `FKhnnk2wokdo16tbluqa8xkixwu` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
