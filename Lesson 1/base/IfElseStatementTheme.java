package base;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("\n 1.ПЕРЕВОД ПСЕВДОКОДА НА ЯЗЫК JAVA");
        boolean male = false;
        if (!male) {
            System.out.println("Здорово,Чувак!");
        } else {
            System.out.println("Женщинам вход запрещен!");
        }
        int age = 25;
        if (age > 18) {
            System.out.println("Давай выпьем!");
        } else {
            System.out.println("Иди домой, малец!");
        }
        double height = 1.40;
        if (height < 1.8) {
            System.out.println("Где потерял кольцо, Фродо?");
        } else {
            System.out.println("Баскетболист что ли?:");
        }

        System.out.println("\n 2.ПОИСК БОЛЬШЕГО ЧИСЛА ШАГОВ");
        int yesterdaySteps = 5541;
        int todaySteps = 7537;
        System.out.println("Вчера пройдено " + yesterdaySteps + " шагов");
        System.out.println("Вчера пройдено " + todaySteps + " шагов");
        if (yesterdaySteps > todaySteps) {
            System.out.println("Сегодня пройдено шагов больше чем вчера");
        } else if (yesterdaySteps < todaySteps) {
            System.out.println("Сегодня пройдено шагов меньше чем вчера");
        } else {
            System.out.println("Количество шагов пройденное сегодня и вчера одинаково");
        }
        double averageSteps = (yesterdaySteps + todaySteps) / 2;
        System.out.printf("Среднее количество шагов за день: %.2f", averageSteps);

        System.out.println("\n\n 3.ПРОВЕРКА КОЛИЧЕСТВА ГОСТЕЙ");
        int guestCounter = 7;
        if (guestCounter < 0) {
            System.out.println("Ошибка!");
        } else if (guestCounter == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else {
            if (guestCounter % 2 == 0) {
                System.out.println("Записалось " + guestCounter +
                        " гостей. Можно формировать пары для конкурсов.");
            } else {
                System.out.println("Записалось " + guestCounter + " гостей. Нужны индивидуальные задания.");
            }
        }

        System.out.println("\n 4.ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА");
        System.out.println("первый способ:");
        String name = "Napodji";
        char firstChar = name.charAt(0);
        String baseMessage = "Имя " + name + " начинается с ";
        String result;
        if (firstChar >= 'a' && firstChar <= 'z') {
            result = baseMessage + "маленькой буквы '" + firstChar + "'";
        } else if (firstChar >= 'A' && firstChar <= 'Z') {
            result = baseMessage + "большой буквы '" + firstChar + "'";
        } else if (firstChar >= '0' && firstChar <= '9') {
            result = baseMessage + "цифры '" + firstChar + "'";
        } else {
            result = baseMessage + "символа '" + firstChar + "'";
        }
        System.out.println(result);

        System.out.println("второй способ:");
        String result2;
        if (Character.isLowerCase(firstChar)) {
            result2 = baseMessage + "маленькой буквы '" + firstChar + "'";
        } else if (Character.isUpperCase(firstChar)) {
            result2 = baseMessage + "большой буквы '" + firstChar + "'";
        } else if (Character.isDigit(firstChar)) {
            result2 = baseMessage + "цифры '" + firstChar + "'";
        } else {
            result2 = baseMessage + "символа '" + firstChar + "'";
        }
        System.out.println(result2);

        System.out.println("\n 5.ИНВЕНТАРИЗАЦИЯ");
        int dbNumber = 223;
        int deviceNumber = 123;
        int dbDigit1 = dbNumber / 100;
        int dbDigit2 = (dbNumber / 10) % 10;
        int dbDigit3 = dbNumber % 10;
        int devDigit1 = deviceNumber / 100;
        int devDigit2 = (deviceNumber / 10) % 10;
        int devDigit3 = deviceNumber % 10;
        if (dbDigit1 == devDigit1 && dbDigit2 == devDigit2 && dbDigit3 == devDigit3) {
            System.out.println("№" + deviceNumber +
                    ": компьютер на " + devDigit3 +
                    " этаже в кабинете №" + devDigit2);
        } else if (dbDigit1 == devDigit1 || dbDigit2 == devDigit2 || dbDigit3 == devDigit3) {
            String devStr = "№";
            if (dbDigit1 != devDigit1) devStr += "_";
            else devStr += devDigit1;
            if (dbDigit2 != devDigit2) devStr += "_";
            else devStr += devDigit2;
            if (dbDigit3 != devDigit3) devStr += "_";
            else devStr += devDigit3;
            String dbStr = "№" + dbDigit1 + dbDigit2 + dbDigit3;
            System.out.printf("""
                    Нет полного совпадения:
                    База данных: %s
                    Фактический: %s
                    """, dbStr, devStr);
        } else System.out.println("№" + deviceNumber + ": оборудование не идентифицировано");

        System.out.println("\n 6.ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %");
        float depositAmount = 321123.79f;
        float depositRate = 0.05f;
        if (depositAmount >= 100000) {
            depositRate = 0.07f;
            if (depositAmount > 300000) {
                depositRate = 0.10f;
            }
        }
        float depositRateAmount = depositAmount * depositRate;
        float finalDepositAmount = depositAmount + depositRateAmount;
        System.out.printf("""
                Первый способ:
                Сумма вклада: %.2f руб.
                Сумма начисленного %%: %.2f руб.
                Итоговая сумма: %.2f руб.\n
                """, depositAmount, depositRateAmount, finalDepositAmount);

        BigDecimal depositAmountBd = new BigDecimal("321123.79");
        BigDecimal deposit1 = BigDecimal.valueOf(100000);
        BigDecimal deposit2 = BigDecimal.valueOf(300000);
        BigDecimal depositRateBd = new BigDecimal("0.05");
        if (depositAmountBd.compareTo(deposit1) >= 0) {
            depositRateBd = new BigDecimal("0.07");
            if (depositAmountBd.compareTo(deposit2) > 0) {
                depositRateBd = new BigDecimal("0.10");
            }
        }
        BigDecimal depositRateAmountBd = depositAmountBd
                .multiply(depositRateBd)
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal finalDepositAmountBd = depositAmountBd
                .add(depositRateAmountBd)
                .setScale(2, RoundingMode.HALF_UP);
        System.out.printf("""
                Второй способ:
                Сумма вклада: %.2f руб.
                Сумма начисленного %%: %.2f руб.
                Итоговая сумма: %.2f руб.
                """, depositAmountBd, depositRateAmountBd, finalDepositAmountBd);

        System.out.println("\n 7.ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ");
        int historyPercent = 59;
        int historyGrade = 2;
        if (historyPercent > 91) {
            historyGrade = 5;
        } else if (historyPercent > 73) {
            historyGrade = 4;
        } else if (historyPercent >= 60) {
            historyGrade = 3;
        }
        int csPercent = 92;
        int csGrade = 2;
        if (csPercent > 91) {
            csGrade = 5;
        } else if (csPercent > 73) {
            csGrade = 4;
        } else if (csPercent >= 60) {
            csGrade = 3;
        }
        double averagePoints = (historyPercent + csPercent) / 2.0;
        double averageGrade = (historyGrade + csGrade) / 2.0;
        System.out.printf("""
                История - %d
                Программирование - %d
                Средний балл оценок по предметам - %.2f
                Средний %% по предметам - %.2f
                """, historyGrade, csGrade, averageGrade, averagePoints);

        System.out.println("\n 8.РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ");
        BigDecimal monthlyProfit = new BigDecimal("13025.233");
        BigDecimal rentCost = new BigDecimal("5123.018");
        BigDecimal selfCost = new BigDecimal("9001.729");
        BigDecimal monthlyCost = rentCost.add(selfCost);
        BigDecimal monthlyFinalProfit = monthlyProfit.subtract(monthlyCost);
        BigDecimal yearProfit = monthlyFinalProfit.multiply(BigDecimal.valueOf(12))
                .setScale(3, RoundingMode.HALF_UP);
        String profitSign = yearProfit.compareTo(BigDecimal.ZERO) > 0 ? "+" : "";
        System.out.println("Прибыль за год: " + profitSign + yearProfit);
    }
}
