-- Установка кодировки UTF-8
\encoding UTF8

-- Подключение к базе данных robots (должна быть создана заранее)
\connect robots

-- Удаление таблицы jaegers, если она существует
DROP TABLE IF EXISTS jaegers;

-- Создание таблицы jaegers
CREATE TABLE jaegers (
                         id            SERIAL PRIMARY KEY,
                         model_name    VARCHAR(100) NOT NULL,
                         mark          VARCHAR(20) NOT NULL,
                         height        DECIMAL(5, 2),
                         weight        DECIMAL(8, 2),
                         status        VARCHAR(50),
                         origin        VARCHAR(100),
                         launch        DATE,
                         kaiju_kill    INT DEFAULT 0
);

-- Запуск файла для заполнения таблицы (относительный путь)
\ir populate.sql

-- Запуск файла с запросами (относительный путь)
\ir queries.sql
