-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 09, 2022 at 02:44 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlbv`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `ID` int(11) NOT NULL,
  `ACCOUNT_NAME` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `PASS` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `PERMISSION` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `CREATEDAY` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`ID`, `ACCOUNT_NAME`, `PASS`, `PERMISSION`, `CREATEDAY`) VALUES
(1, 'admin', 'admin123', 'Admin', '10/11/2022'),
(2, 'bacsi', 'bacsi123', 'Bác sĩ', '15/11/2022'),
(3, 'nhanvien', 'nhanvien123', 'Nhân viên', '15/11/2022');

-- --------------------------------------------------------

--
-- Table structure for table `bacsi`
--

CREATE TABLE `bacsi` (
  `MABS` int(11) NOT NULL,
  `TENBS` varchar(50) NOT NULL,
  `DIENTHOAI` varchar(12) NOT NULL,
  `DIACHI` varchar(200) NOT NULL,
  `GIOITINH` varchar(10) NOT NULL,
  `NGAYSINH` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bacsi`
--

INSERT INTO `bacsi` (`MABS`, `TENBS`, `DIENTHOAI`, `DIACHI`, `GIOITINH`, `NGAYSINH`) VALUES
(1, 'Huỳnh Minh Hiếu', '0799345612', 'Quận 2, TP Hồ Chí Minh', 'Nam', '23/11/1980'),
(2, 'Trần Thúc Tiến', '0971239087', 'Quận 3, TP Hồ Chí Minh', 'Nam', '01/09/1976'),
(3, 'Nguyễn Trường Thọ', '0369874561', 'Huyện Nhà Bè, TP Hồ Chí Minh', 'Nam', '17/11/1975'),
(4, 'Lê Thị Minh Nguyệt', '0378906758', 'Quận 5, TP Hồ Chí Minh', 'Nữ', '12/10/1980'),
(5, 'Hồ Vính Thi', '0878907651', 'Phường 5, quận 11, TP Hồ Chí Minh', 'Nữ', '23/10/1982'),
(6, 'Trần Cao Minh', '0378899123', 'Huyện Cần Giờ, TP Hồ Chí Minh', 'Nam', '02/11/1970'),
(7, 'Nguyễn Thị Huyền Trang', '0909872341', 'xã Phú Hoà Đông, huyện Củ Chi', 'Nữ', '03/09/1982'),
(8, 'Trần Minh Chính', '0908764578', 'Quận 1, TP Hồ Chí Minh', 'Nam', '11/08/1987');

-- --------------------------------------------------------

--
-- Table structure for table `bang_thong_ke`
--

CREATE TABLE `bang_thong_ke` (
  `MABN` int(100) DEFAULT NULL,
  `MADV` int(10) NOT NULL,
  `TenDV` varchar(100) DEFAULT NULL,
  `Ngay` date NOT NULL,
  `DonGia` int(50) NOT NULL,
  `SoLan` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bang_thong_ke`
--

INSERT INTO `bang_thong_ke` (`MABN`, `MADV`, `TenDV`, `Ngay`, `DonGia`, `SoLan`) VALUES
(0, 0, 'Siêu âm', '2021-05-01', 150000, 1),
(0, 0, 'Sieu am 3D', '2021-05-03', 300000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `benh`
--

CREATE TABLE `benh` (
  `MA_BENH` int(11) NOT NULL,
  `TEN_BENH` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `benh`
--

INSERT INTO `benh` (`MA_BENH`, `TEN_BENH`) VALUES
(1, 'Cảm cúm'),
(2, 'Sốt'),
(3, 'Gãy tay'),
(4, 'Gãy chân'),
(5, 'Viêm đường ruột'),
(6, 'Sỏi thận'),
(7, 'Hở van tim'),
(8, 'Viêm phổi'),
(9, 'Viêm tai giữa'),
(10, 'Viêm xoang');

-- --------------------------------------------------------

--
-- Table structure for table `benhnhan`
--

CREATE TABLE `benhnhan` (
  `MABN` int(10) NOT NULL,
  `TENBN` varchar(100) NOT NULL,
  `NGAYSINH` varchar(20) NOT NULL,
  `DIACHI` varchar(100) NOT NULL,
  `SDT` varchar(12) NOT NULL,
  `GIOITINH` varchar(10) NOT NULL,
  `SOGIUONG` varchar(10) NOT NULL,
  `SOPHONG` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `benhnhan`
--

INSERT INTO `benhnhan` (`MABN`, `TENBN`, `NGAYSINH`, `DIACHI`, `SDT`, `GIOITINH`, `SOGIUONG`, `SOPHONG`) VALUES
(1, 'Huỳnh Minh Hậu', '04/12/2001', 'xã Trung An, huyện Củ Chi', 'Nam', '0375593662', '2', '1'),
(2, 'Nguyễn Trường Công Vinh', '07/09/2001', 'Quận 5, TP Hồ Chí Minh', 'Nam', '0375537664', '2', '1'),
(3, 'Tiêu Hoàng Tuấn', '10/11/2000', 'Huyện Hóc Môn, TP Hồ Chí Minh', 'Nam', '0365077842', '3', '2'),
(4, 'Trần Duy Khang', '01/11/1987', 'Quận 1, TP Hồ Chí Minh', 'Nam', '0379873775', '1', '3'),
(5, 'Nguyễn Tuyết Ngân', '11/11/2011', 'Quận Phú Nhuận, TP Hồ Chí Minh', 'Nữ', '0976781634', '1', '5'),
(6, 'Trần Đình Toàn', '01/11/2008', 'Trà Vinh', 'Nam', '0790763451', '2', '5'),
(7, 'Nguyễn Minh Tài', '13/11/2003', 'Vĩnh Long', 'Nam', '0368906511', '1', '6'),
(8, 'Trần Thị Như Hảo', '09/11/2005', 'Huyện Nhà Bè, Tp Hồ Chí Minh', 'Nữ', '0379871321', '2', '4');

-- --------------------------------------------------------

--
-- Table structure for table `benhnhan_dichvu`
--

CREATE TABLE `benhnhan_dichvu` (
  `SOPHIEU_SD` int(11) NOT NULL,
  `MA_BN` int(11) DEFAULT NULL,
  `NGAY_SD` varchar(50) DEFAULT NULL,
  `SOLUONGDV` int(11) DEFAULT NULL,
  `MADV` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `benhnhan_dichvu`
--

INSERT INTO `benhnhan_dichvu` (`SOPHIEU_SD`, `MA_BN`, `NGAY_SD`, `SOLUONGDV`, `MADV`) VALUES
(1, 1, '2/12/2022', 1, 1),
(2, 2, '3/10/2022', 1, 2),
(3, 3, '1/1/2011', 1, 3),
(4, 4, '2/1/2012', 1, 4),
(5, 5, '2/3/2018', 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `bienlai`
--

CREATE TABLE `bienlai` (
  `SO_BL` int(11) NOT NULL,
  `NGAY_THANH_TOAN` varchar(100) NOT NULL,
  `TONG_TIEN` int(11) NOT NULL,
  `tenBenhNhan` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bienlai`
--

INSERT INTO `bienlai` (`SO_BL`, `NGAY_THANH_TOAN`, `TONG_TIEN`, `tenBenhNhan`) VALUES
(1, '10/08/2018', 300000, 'Nguyễn Tuyết Ngân'),
(2, '05/01/2021', 100000, 'Huỳnh Minh Hậu'),
(3, '08/05/2021', 900000, 'Trần Duy Khang'),
(4, '30/01/2021', 350000, 'Tiêu Hoàng Tuấn'),
(5, '09/12/2022', 350000, 'Tiêu Hoàng Tuấn');

-- --------------------------------------------------------

--
-- Table structure for table `dichvu`
--

CREATE TABLE `dichvu` (
  `MADV` int(4) NOT NULL,
  `TENDV` varchar(100) NOT NULL,
  `GIA` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dichvu`
--

INSERT INTO `dichvu` (`MADV`, `TENDV`, `GIA`) VALUES
(1, 'Chụp X Quang', 1500000),
(2, 'Chụp City', 1000000),
(3, 'Nội soi tai, mũi, họng', 350000),
(4, 'Nội soi tổng quát', 550000),
(5, 'Siêu âm', 200000),
(6, 'Siêu âm máu', 300000),
(7, 'Xét nghiệm máu', 650000),
(8, 'Đo nhịp tim', 200000),
(9, 'Không dịch vụ', 0);

-- --------------------------------------------------------

--
-- Table structure for table `ho_so_benh_an`
--

CREATE TABLE `ho_so_benh_an` (
  `MAHS` int(4) NOT NULL,
  `NGAYBD` varchar(20) NOT NULL,
  `NGAYKT` varchar(20) NOT NULL,
  `KETQUA` varchar(100) NOT NULL,
  `MABS` varchar(100) DEFAULT NULL,
  `MABN` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ho_so_benh_an`
--

INSERT INTO `ho_so_benh_an` (`MAHS`, `NGAYBD`, `NGAYKT`, `KETQUA`, `MABS`, `MABN`) VALUES
(1, '22/12/2022', '23/12/2022', 'Chữa khỏi', '1', '1'),
(2, '1/12/2021', '1/12/2022', 'Chữa khỏi', '2', '2'),
(3, '1/12/2022', '22/12/2022', 'Chữa khỏi', '3', '3'),
(4, '3/12/2022', '6/12/2022', 'Chữa khỏi', '4', '4');

-- --------------------------------------------------------

--
-- Table structure for table `khambenh`
--

CREATE TABLE `khambenh` (
  `SOPHIEUKHAM` int(11) NOT NULL,
  `NGAYKHAM` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MABS` int(11) NOT NULL,
  `MABN` int(11) NOT NULL,
  `TENBENH` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MADV` int(11) NOT NULL,
  `TRIEUTRUNG` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `THANHTOAN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `khambenh`
--

INSERT INTO `khambenh` (`SOPHIEUKHAM`, `NGAYKHAM`, `MABS`, `MABN`, `TENBENH`, `MADV`, `TRIEUTRUNG`, `THANHTOAN`) VALUES
(1, '08/12/2022', 1, 1, 'cam cum', 1, 'ho', 1),
(2, '03/01/2022', 7, 2, 'zz', 2, 'zz', 1),
(3, '04/01/2022', 4, 3, 'Cảm', 3, 'Mệt', 1),
(4, '19/01/2022', 3, 4, 'đau dạ dày', 4, 'đau bụng', 1),
(6, '08/01/2022', 4, 5, 'hh', 5, 'ggg', 0);

-- --------------------------------------------------------

--
-- Table structure for table `khoa`
--

CREATE TABLE `khoa` (
  `MA_KHOA` int(11) NOT NULL,
  `TEN_KHOA` varchar(200) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `khoa`
--

INSERT INTO `khoa` (`MA_KHOA`, `TEN_KHOA`) VALUES
(1, 'Khoa tai mũi họng'),
(2, 'Khoa chấn thương chỉnh hình'),
(3, 'Khoa Nội'),
(4, 'Khoa ngoại');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` int(11) NOT NULL,
  `TENNV` varchar(100) NOT NULL,
  `NGAYSINH` varchar(20) NOT NULL,
  `DIACHI` varchar(100) NOT NULL,
  `GIOITINH` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MANV`, `TENNV`, `NGAYSINH`, `DIACHI`, `GIOITINH`) VALUES
(2, 'Trần Minh Thạnh', '05/01/1994', 'Quận 5, TP Hồ Chí Minh', 'Nam'),
(3, 'Lê Minh Thiện', '13/09/1987', 'An Giang', 'Nam'),
(4, 'Cao Thị Tiền', '13/09/1980', 'Đồng Tháp', 'Nữ '),
(5, 'Lý Văn Tài', '03/11/1990', 'Cà Mau', 'Nam'),
(6, 'Huỳnh Tấn Đạt', '23/11/1980', 'Củ Chi', 'Nam'),
(7, 'Thái Thành Danh', '11/11/1999', 'Quận 3, TP Hồ Chí Minh', 'Nam'),
(8, 'Nguyễn Hữu Tài', '05/05/1992', 'quận 2, TP Hồ Chí Minh', 'Nam'),
(9, 'Trần Thị Ngân', '02/07/1986', 'Quận 6, TP Hồ Chí Minh', 'Nữ ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `bacsi`
--
ALTER TABLE `bacsi`
  ADD PRIMARY KEY (`MABS`);

--
-- Indexes for table `benh`
--
ALTER TABLE `benh`
  ADD PRIMARY KEY (`MA_BENH`);

--
-- Indexes for table `benhnhan`
--
ALTER TABLE `benhnhan`
  ADD PRIMARY KEY (`MABN`);

--
-- Indexes for table `benhnhan_dichvu`
--
ALTER TABLE `benhnhan_dichvu`
  ADD PRIMARY KEY (`SOPHIEU_SD`);

--
-- Indexes for table `bienlai`
--
ALTER TABLE `bienlai`
  ADD PRIMARY KEY (`SO_BL`);

--
-- Indexes for table `dichvu`
--
ALTER TABLE `dichvu`
  ADD PRIMARY KEY (`MADV`);

--
-- Indexes for table `ho_so_benh_an`
--
ALTER TABLE `ho_so_benh_an`
  ADD PRIMARY KEY (`MAHS`);

--
-- Indexes for table `khambenh`
--
ALTER TABLE `khambenh`
  ADD PRIMARY KEY (`SOPHIEUKHAM`);

--
-- Indexes for table `khoa`
--
ALTER TABLE `khoa`
  ADD PRIMARY KEY (`MA_KHOA`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
