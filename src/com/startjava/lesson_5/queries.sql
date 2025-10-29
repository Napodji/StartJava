-- 1. Вывести всю таблицу, отсортировав по именам роботов в алфавитном порядке
\echo '--- 1. All jaegers (alphabetical order) ---'
SELECT *
FROM jaegers
ORDER BY model_name;


-- 2. Вывести только не уничтоженных роботов
\echo '--- 2. Active jaegers only ---'
SELECT *
FROM jaegers
WHERE status != 'Destroyed'
ORDER BY model_name;


-- 3. Вывести только роботов серии Mark-1 и Mark-4
\echo '--- 3. Mark-1 and Mark-4 jaegers ---'
SELECT *
FROM jaegers
WHERE mark IN ('Mark-1', 'Mark-4')
ORDER BY model_name;


-- 4. Вывести всех роботов, кроме Mark-1 и Mark-4, отсортировав по убыванию по столбцу mark
\echo '--- 4. All except Mark-1 and Mark-4 (sorted by mark DESC) ---'
SELECT *
FROM jaegers
WHERE mark NOT IN ('Mark-1', 'Mark-4')
ORDER BY mark DESC;


-- 5. Информация о самых старых роботах
\echo '--- 5. Oldest jaegers ---'
SELECT *
FROM jaegers
WHERE launch = (SELECT MIN(launch) FROM jaegers)
ORDER BY model_name;


-- 6. Инфо из столбцов model_name, mark, launch, kaiju_kill тех роботов, которые уничтожили больше всех kaiju
\echo '--- 6. Jaegers with maximum kaiju kills ---'
SELECT model_name,
       mark,
       launch,
       kaiju_kill
FROM jaegers
WHERE kaiju_kill = (SELECT MAX(kaiju_kill) FROM jaegers)
ORDER BY model_name;


-- 7. Средний вес роботов, округлив его до трех знаков после запятой. Отображать avg_weight вместо round
\echo '--- 7. Average weight ---'
SELECT ROUND(AVG(weight), 3) AS avg_weight
FROM jaegers;


-- 8. Увеличить на единицу количество уничтоженных kaiju у неразрушенных роботов, затем отобразить таблицу
\echo '--- 8. Increment kaiju_kill for active jaegers ---'
UPDATE jaegers
SET kaiju_kill = kaiju_kill + 1
WHERE status != 'Destroyed';

SELECT *
FROM jaegers
ORDER BY model_name;


-- 9. Удалить уничтоженных роботов, затем отобразить оставшихся
\echo '--- 9. Delete destroyed jaegers ---'
DELETE FROM jaegers
WHERE status = 'Destroyed';

SELECT *
FROM jaegers
ORDER BY model_name;
