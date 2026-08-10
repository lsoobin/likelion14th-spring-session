-- 2주차 세션용 MySQL 실습 계정/DB 생성 스크립트
-- local-root(=root 계정) 세션에서 한 번만 실행합니다.
CREATE DATABASE IF NOT EXISTS likelion_blog
    CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS 'likelion'@'localhost' IDENTIFIED BY 'Likelion2026!';
GRANT ALL PRIVILEGES ON likelion_blog.* TO 'likelion'@'localhost';
FLUSH PRIVILEGES;
