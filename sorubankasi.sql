-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 13 Nis 2019, 23:56:11
-- Sunucu sürümü: 10.1.38-MariaDB
-- PHP Sürümü: 7.2.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `sorubankasi`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `soruislemleri`
--

CREATE TABLE `soruislemleri` (
  `id` int(11) NOT NULL,
  `SoruTipi` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `DersAdi` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `Soru` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `Sik1` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `Sik2` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `Sik3` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `Sik4` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `Cevap` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `Puan` int(11) NOT NULL,
  `ZorlukDerecesi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `soruislemleri`
--

INSERT INTO `soruislemleri` (`id`, `SoruTipi`, `DersAdi`, `Soru`, `Sik1`, `Sik2`, `Sik3`, `Sik4`, `Cevap`, `Puan`, `ZorlukDerecesi`) VALUES
(1, 'Çoktan Seçmeli', 'Matematik', '2+2=?', '4', '2', '3', '5', '4', 2, 1),
(2, 'Doğru/Yanlış', 'Fen Bilgisi', 'Su 100 derecede kaynar.', 'Doğru', 'Yanlış', '-', '-', 'Doğru', 2, 2),
(3, 'Klasik', 'Genel Kültür', 'Türkiye\'nin başkenti neresidir?', 'Kütahya', '-', '-', '-', 'Ankara', 2, 1),
(4, 'Doğru/Yanlış', 'Tarih', 'Osmanlı\'nın ilk başkenti Bursa\'dır.', 'Doğru', 'Yanlış', '-', '-', 'Doğru', 5, 2),
(5, 'Klasik', 'Genel Kültür', 'Kütahya ili hangi bölgede yer almaktadır?', 'Ege', '-', '-', '-', 'Ege', 5, 2),
(7, 'Doğru / Yanlış', 'Matematik', '5-2=3', 'Doğru', 'Yanlış', '', '', 'Doğru', 2, 2),
(9, 'Klasik', 'Matematik', '2+5?', '6', '', '', '', '7', 5, 2),
(10, 'Klasik', 'Tarih', 'İstanbul\'un fethin kaç yılında gerçekleşmiştir?', '1450', '', '', '', '1453', 5, 3),
(11, 'Klasik', 'Tarih', 'İstanbul\'u kim feth etmiştir?', 'Recep Tayyip Erdoğan', '', '', '', 'Fatih Sultan Mehmet', 9, 3),
(12, 'Doğru / Yanlış', 'Matematik', '5-6=-1', 'Doğru', 'Yanlış', '', '', 'Doğru', 4, 3),
(13, 'Çoktan Seçmeli', 'Türkçe', '\'\' Çok sık, düşünce ya da konu değiştirmek \'\' anlamına gelen deyim aşağıdakilerden hangisidir ?', 'Dal budak salmak', 'Daldan dala konmak', 'Dallanıp budaklanmak', 'Danışıklı dövüş', 'Dal budak salmak', 4, 2),
(14, 'Çoktan Seçmeli', 'Türkçe', '\" Annem her zaman yemeği göz açıp  kapayıncaya kadar hazır ederdi. \" Yukarıda verilen cümlede annenin hangi özelliği belirtilmektedir ?', 'İşini severek yapması', 'Çalışkan olması', 'Elinin çabuk olması', 'Telaşlı olması', 'Elinin çabuk olması', 5, 3),
(15, 'Çoktan Seçmeli', 'Türkçe', '\" Öyle bir şey yaptı ki adeta defteri dürüldü. \'\' Yukarıda verilen cümlede altı çizili deyimin anlamı aşağıdakilerden hangisine uygundur ?', 'İşine son verilmesi', 'İstediği gibi davranması', 'Yerli yersiz konuşması', 'Bildiklerini tekrarlaması', 'İşine son verilmesi', 3, 2),
(16, 'Çoktan Seçmeli', 'Türkçe', '\" Hapse girmek, Aldatılmak \" anlamına gelen deyim hangisidir ?', 'Hesaba kalmak', 'Kafese girmek', 'Hesabını bilmek', 'Kafese koymak', 'Kafese koymak', 2, 1),
(17, 'Çoktan Seçmeli', 'Türkçe', '\' Boşver, rahatına bak, sen mi düzelteceksin dünyayı. \'\' Yukarıda verilen cümlede \" rahatına bakmak \" deyiminin anlamı aşağıdakilerden hangisidir ?', 'Rahatını sağlamaya çalışmak', 'Rahatlamak', 'Dümdüz etmek', 'Karmakarışık etmek', 'Rahatını sağlamaya çalışmak', 3, 2),
(18, 'Çoktan Seçmeli', 'Genel Kültür', '2017 yılında ilk kez sigortalı çalışmaya başlayan 25 yaşında bir erkek, Türkiye\'de kaç yıl daha çalışırsa emekli olur?', '', '', '', '', '35-40 arası', 3, 3),
(19, 'Çoktan Seçmeli', 'Genel Kültür', '2017 yılında Türkiye\'de asgari ücret yaklaşık olarak kaç liradır?', '1480', '1400', '1620', '19999', '1400', 6, 3),
(20, 'Çoktan Seçmeli', 'Matematik', '4 ün karekökü nedir?', '2', '3', '4', '5', '2', 3, 2),
(21, 'Çoktan Seçmeli', 'Matematik', '125*3=?', '125', '150', '365', '375', '375', 4, 3);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `sınavislemleri`
--

CREATE TABLE `sınavislemleri` (
  `id` int(11) NOT NULL,
  `SoruTipi` text COLLATE utf8_turkish_ci NOT NULL,
  `DersAdi` text COLLATE utf8_turkish_ci NOT NULL,
  `Soru` text COLLATE utf8_turkish_ci NOT NULL,
  `Sik1` text COLLATE utf8_turkish_ci NOT NULL,
  `Sik2` text COLLATE utf8_turkish_ci NOT NULL,
  `Sik3` text COLLATE utf8_turkish_ci NOT NULL,
  `Sik4` text COLLATE utf8_turkish_ci NOT NULL,
  `Cevap` text COLLATE utf8_turkish_ci NOT NULL,
  `Puan` int(11) NOT NULL,
  `ZorlukDerecesi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `sınavislemleri`
--

INSERT INTO `sınavislemleri` (`id`, `SoruTipi`, `DersAdi`, `Soru`, `Sik1`, `Sik2`, `Sik3`, `Sik4`, `Cevap`, `Puan`, `ZorlukDerecesi`) VALUES
(7, 'Doğru / Yanlış', 'Matematik', '5-2=3', 'Doğru', 'Yanlış', '', '', 'Doğru', 2, 2),
(9, 'Klasik', 'Matematik', '2+5?', '6', '', '', '', '7', 5, 2),
(20, 'Çoktan Seçmeli', 'Matematik', '4 ün karekökü nedir?', '2', '3', '4', '5', '2', 3, 2),
(21, 'Çoktan Seçmeli', 'Tarih', 'Osmanlı\'nın ilk başkenti Bursa\'dır.', 'Doğru', 'Yanlış', '-', '-', 'Doğru', 5, 2),
(22, 'Doğru / Yanlış', 'Matematik', '5-2=3', 'Doğru', 'Yanlış', '', '', 'Doğru', 2, 2),
(23, 'Klasik', 'Genel Kültür', 'Türkiye\'nin başkenti neresidir?', 'Kütahya', '-', '-', '-', 'Ankara', 2, 1),
(24, 'Doğru / Yanlış', 'Matematik', '5-2=3', 'Doğru', 'Yanlış', '', '', 'Doğru', 2, 2);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `soruislemleri`
--
ALTER TABLE `soruislemleri`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `sınavislemleri`
--
ALTER TABLE `sınavislemleri`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `soruislemleri`
--
ALTER TABLE `soruislemleri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Tablo için AUTO_INCREMENT değeri `sınavislemleri`
--
ALTER TABLE `sınavislemleri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
