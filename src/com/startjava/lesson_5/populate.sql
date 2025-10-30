-- Установка кодировки для Windows
\! chcp 1251

-- Заполнение таблицы jaegers данными о 10 роботах
INSERT INTO jaegers (model_name, mark, height, weight, status, origin, launch, kaiju_kill)
     VALUES ('Gipsy Danger', 'Mark-3', 79.25, 1980.00, 'Destroyed', 'USA', '2017-07-10', 9),
            ('Striker Eureka', 'Mark-5', 76.20, 1850.00, 'Destroyed', 'Australia', '2019-11-02', 11),
            ('Crimson Typhoon', 'Mark-4', 76.00, 1722.00, 'Destroyed', 'China', '2018-08-22', 7),
            ('Cherno Alpha', 'Mark-1', 85.34, 2412.00, 'Destroyed', 'Russia', '2015-01-15', 6),
            ('Coyote Tango', 'Mark-1', 85.00, 2312.00, 'Destroyed', 'Japan', '2015-12-30', 2),
            ('Tacit Ronin', 'Mark-1', 74.37, 7450.00, 'Destroyed', 'Japan', '2015-03-15', 3),
            ('Romeo Blue', 'Mark-1', 77.72, 7775.00, 'Destroyed', 'USA', '2015-12-15', 2),
            ('Horizon Brave', 'Mark-1', 72.54, 7890.00, 'Destroyed', 'China', '2015-06-22', 2),
            ('Atlas Destroyer', 'Mark-3', 76.50, 2100.00, 'Active', 'USA', '2017-05-10', 5),
            ('Guardian Bravo', 'Mark-6', 73.21, 1975.00, 'Active', 'USA', '2025-01-12', 4);
