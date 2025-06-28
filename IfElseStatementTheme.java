import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("\n 1.ПЕРЕВОД ПСЕВДОКОДА НА ЯЗЫК JAVA");
        boolean male = false;
        int age = 25;
        double height = 1.40;
        if (!male) {
            System.out.println("Здорово,Чувак!");
        } else {
            System.out.println("Женщинам вход запрещен!");
        }
        if (age > 18) {
            System.out.println("Давай выпьем!");
        } else {
            System.out.println("Иди домой, малец!");
        }
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
        if (firstChar >= 'a' && firstChar <= 'z') {
            System.out.println("Имя " + name + " начинается с маленькой буквы '" + firstChar + "'");
        } else if (firstChar >= 'A' && firstChar <= 'Z') {
            System.out.println("Имя " + name + " начинается с большой буквы '" + firstChar + "'");
        } else if (firstChar >= '0' && firstChar <= '9') {
            System.out.println("Имя " + name + " начинается с цифры '" + firstChar + "'");
        } else {
            System.out.println("Имя " + name + " начинается с символа '" + firstChar + "'");
        }
        System.out.println("второй способ:");
        if (Character.isLowerCase(firstChar)) {
            System.out.println("Имя " + name + " начинается с маленькой буквы '" + firstChar + "'");
        } else if (Character.isUpperCase(firstChar)) {
            System.out.println("Имя " + name + " начинается с большой буквы '" + firstChar + "'");
        } else if (Character.isDigit(firstChar)) {
            System.out.println("Имя " + name + " начинается с цифры '" + firstChar + "'");
        } else {
            System.out.println("Имя " + name + " начинается с символа '" + firstChar + "'");
        }
        System.out.println("\n 5.ИНВЕНТАРИЗАЦИЯ");
        int dataBaseNumber = 223;
        int deviceNumber = 123;
        String dataBaseNumberStr = String.valueOf(dataBaseNumber);
        String deviceNumberStr = String.valueOf(deviceNumber);
        if ((dataBaseNumberStr.charAt(0) == deviceNumberStr.charAt(0)) &&
                (dataBaseNumberStr.charAt(1) == deviceNumberStr.charAt(1)) &&
                (dataBaseNumberStr.charAt(2) == deviceNumberStr.charAt(2))) {
            System.out.println("№" + deviceNumber +
                    ": компьютер на " +
                    deviceNumberStr.charAt(2) +
                    " этаже в кабинете №" +
                    deviceNumberStr.charAt(1));
        } else if ((dataBaseNumberStr.charAt(0) == deviceNumberStr.charAt(0)) ||
                (dataBaseNumberStr.charAt(1) == deviceNumberStr.charAt(1)) ||
                (dataBaseNumberStr.charAt(2) == deviceNumberStr.charAt(2))) {
            System.out.printf("""
                    Нет полного совпадения:
                    База данных: %s
                    Фактический: %s
                    """, dataBaseNumberStr, deviceNumberStr);
        } else {
            System.out.println("№" + deviceNumber + ": оборудование не идентифицировано");
        }
        System.out.println("\n 6.ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %");
        float depositAmount = 321123.79f;
        float depositRate;
        float depositRateAmount;
        float finalDepositAmount;
        if (depositAmount < 100000) {
            depositRate = 0.05f;
        } else if (depositAmount <= 300000) {
            depositRate = 0.07f;
        } else {
            depositRate = 0.10f;
        }
        depositRateAmount = depositAmount * depositRate;
        finalDepositAmount = depositAmount + depositRateAmount;
        System.out.printf("""
                Первый способ:
                Сумма вклада: %.2f руб.
                Сумма начисленного %%: %.2f руб.
                Итоговая сумма: %.2f руб.\n
                """, depositAmount, depositRateAmount, finalDepositAmount);
        BigDecimal depositAmountBd = new BigDecimal("321123.79");
        BigDecimal depositRateBd;
        BigDecimal depositRateAmountBd;
        BigDecimal finalDepositAmountBd;
        if (depositAmountBd.compareTo(new BigDecimal(100000)) < 0) {
            depositRateBd = new BigDecimal("0.05");
        } else if (depositAmountBd.compareTo(new BigDecimal(300000)) <= 0) {
            depositRateBd = new BigDecimal("0.07");
        } else {
            depositRateBd = new BigDecimal("0.10");
        }
        depositRateAmountBd = depositAmountBd.multiply(depositRateBd).setScale(2, RoundingMode.HALF_UP);
        finalDepositAmountBd = depositAmountBd.add(depositRateAmountBd).setScale(2, RoundingMode.HALF_UP);
        System.out.printf("""
                Второй способ:
                Сумма вклада: %.2f руб.
                Сумма начисленного %%: %.2f руб.
                Итоговая сумма: %.2f руб.
                """, depositAmountBd, depositAmountBd, finalDepositAmountBd);
        System.out.println("\n 7.ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ");
        float historyPoints = 59f;
        float itPoints = 92f;
        float historyGrade;
        if (historyPoints > 91) {
            historyGrade = 5f;
        } else if (historyPoints > 73) {
            historyGrade = 4f;
        } else if (historyPoints >= 60) {
            historyGrade = 3f;
        } else {
            historyGrade = 2f;
        }
        float itGrade;
        if (itPoints > 91) {
            itGrade = 5f;
        } else if (itPoints > 73) {
            itGrade = 4f;
        } else if (itPoints >= 60) {
            itGrade = 3f;
        } else {
            itGrade = 2f;
        }
        float averagePoints = (historyPoints + itPoints) / 2;
        float averageGrade = (historyGrade + itGrade) / 2;
        System.out.printf("""
                История - %d
                Программирование - %d
                Средний балл оценок по предметам - %.2f
                Средний %% по предметам - %.2f
                """, (int) historyGrade, (int) itGrade, averageGrade, averagePoints);
        System.out.println("\n 8.РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ");
        BigDecimal monthlyProfit = new BigDecimal("13025.233");
        BigDecimal rentCost = new BigDecimal("5123.018");
        BigDecimal selfCost = new BigDecimal("9001.729");
        BigDecimal monthlyCost;
        BigDecimal monthlyFinalProfit;
        BigDecimal yearProfit;
        monthlyCost = rentCost.add(selfCost);
        monthlyFinalProfit = monthlyProfit.subtract(monthlyCost);
        yearProfit = monthlyFinalProfit.multiply(new BigDecimal("12")).setScale(3, RoundingMode.HALF_UP);
        System.out.println("Прибыль за год: " + yearProfit);
    }
}
