import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class VariablesTheme {
    public static void main(String[] args) {
        final LocalTime startedTime = LocalTime.now();
        final long startTime = System.nanoTime();

        System.out.println("                     /\\ " +
                         "\n   J    a  v     v  /  \\ " +
                         "\n   J   a a  v   v  /_( )\\ " +
                         "\nJ  J  aaaaa  V V  /      \\ " +
                         "\n JJ  a     a  V  /___/\\___\\ ");
        System.out.println("\n");
        String picture = """
                       /\\            
                 J    /  \\  v     v  a
                 J   /_( )\\  v   v  a a
              J  J  /      \\  V V  aaaaa
               JJ  /___/\\___\\  V  a     a
                """;
        System.out.println(picture);

        System.out.println("\n2.РАСЧЕТ СТОИМОСТИ ТОВАРА");
        float penPrice = 105.5f;
        float bookPrice = 235.23f;
        float discount = 0.89f;
        float price = penPrice + bookPrice;
        float finalPrice = price * discount;
        float discountAmount = price - finalPrice;
        System.out.println(price + " стоимость товаров без скидки");
        System.out.println(discountAmount + " сумма скидки");
        System.out.println(finalPrice + " стоимость товаров со скидкой");
        System.out.println("\n");
        BigDecimal penPriceBd = new BigDecimal("105.5");
        BigDecimal bookPriceBd = new BigDecimal("235.23");
        BigDecimal discountBd = new BigDecimal("0.89");
        BigDecimal priceBd = penPriceBd.add(bookPriceBd).setScale(2, BigDecimal.ROUND_CEILING);
        BigDecimal finalPriceBd = priceBd.multiply(discountBd).setScale(2, BigDecimal.ROUND_CEILING);
        BigDecimal discountAmountBd = priceBd.subtract(finalPriceBd).setScale(2, BigDecimal.ROUND_CEILING);
        System.out.println(priceBd + " стоимость товаров без скидки");
        System.out.println(discountAmountBd + " сумма скидки");
        System.out.println(finalPriceBd + " стоимость товаров со скидкой");

        System.out.println("\n3.ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ");
        int a = 2;
        int b = 5;
        System.out.println("исходное значение переменной а = " + a);
        System.out.println("исходное значение переменной b = " + b);
        int swap = a;
        a = b;
        b = swap;
        System.out.println("\nМетод: третья переменная");
        System.out.println("Результат: a1 = " + a);
        System.out.print("           b1 = " + b);
        a += b;
        b = a - b;
        a -= b;
        System.out.println("\nМетод: арифметические операции");
        System.out.println("Результат: a2 = " + a);
        System.out.print("           b2 = " + b);
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("\nМетод: побитовая операция");
        System.out.println("Результат: a3 = " + a);
        System.out.print("           b3 = " + b);

        System.out.println("\n\n4. ДЕКОДИРОВАНИЕ СООБЩЕНИЯ");
        int asciiA = 1055;
        int asciiB = 1088;
        int asciiC = 1080;
        int asciiD = 1074;
        int asciiE = 1077;
        int asciiF = 1090;
        System.out.printf("%6d %6d %6d %6d %6d %6d\n",
                asciiA, asciiB, asciiC, asciiD, asciiE, asciiF);
        System.out.printf("%4c %6c %6c %6c %6c %6c\n",
                (char) asciiA, (char) asciiB, (char) asciiC,
                (char) asciiD, (char) asciiE, (char) asciiF);

        System.out.println("\n\n 5.АНАЛИЗ КОДА ТОВАРА");
        int num = 123;
        int productCategory = num / 100;
        int subCategory = (num / 10) % 10;
        int packageType = num % 10;
        int controlSum = productCategory + subCategory + packageType;
        int verificationCode = productCategory * subCategory * packageType;
        String result = """
                Категория товара: %d
                Подкатегория: %d
                Упаковка: %d
                Контрольная сумма: %d
                Проверочный код: %d
                """.formatted(productCategory, subCategory, packageType, controlSum, verificationCode);

        System.out.println(result);

        System.out.println("\n 6.ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ");
        byte temp = Byte.MAX_VALUE; // 127
        String tempBlock = """
                [Температура, °C]:
                Исходное: %d
                +1: %d
                -1: %d
                """.formatted(temp, ++temp, --temp);
        System.out.println(tempBlock);
        short pressure = Short.MAX_VALUE;
        String pressureBlock = """
                [Давление, Bar]:
                Исходное: %d
                +1: %d
                -1: %d
                """.formatted(pressure, ++pressure, --pressure);
        System.out.println(pressureBlock);
        char code = Character.MAX_VALUE;
        int[] digit = {code, ++code, --code};
        String codeBlock = """
                [ Код состояния системы]:
                Исходное: %d
                +1: %d
                -1: %d
                """.formatted(digit[0], digit[1], digit[2]);
        System.out.println(codeBlock);
        int distance = Integer.MAX_VALUE;
        String distanceBlock = """
                [Расстояние, м]:
                Исходное: %d
                +1: %d
                -1: %d
                """.formatted(distance, ++distance, --distance);
        System.out.println(distanceBlock);
        long time = Long.MAX_VALUE;
        String timeBlock = """
                [Время с момента старта, сек]:
                Исходное: %d
                +1: %d
                -1: %d
                """.formatted(time, ++time, --time);
        System.out.println(timeBlock);

        System.out.println("\n 7.ВЫВОД ПАРАМЕТРОВ JVM И ОС");
        Runtime runtime = Runtime.getRuntime();
        int processors = runtime.availableProcessors();
        long mb = 1024L * 1024L;
        long total = runtime.totalMemory() / mb;
        long free = runtime.freeMemory() / mb;
        long used = (runtime.totalMemory() - runtime.freeMemory()) / mb;
        long max = runtime.maxMemory() / mb;
        String memoryBlock = """
                [Тип памяти, Мб]:
                Выделенная память: %d
                Свободная память: %d
                Используемая память: %d
                Общий объем памяти: %d
                """.formatted(total, free, used, max);
        System.out.println(memoryBlock);
        String systemDisk = System.getenv("SystemDrive");
        String osName = System.getProperty("os.name");
        String javaVersion = System.getProperty("java.version");
        String fileSeparator = System.getProperty("file.separator");
        String systemBlock = """
                [Параметры системы]:
                Системный диск: %s
                Версия ОС: %s
                Версия Java : %s
                Символ разделения пути: %s
                Доступное число ядер : %d
                """.formatted(systemDisk, osName, javaVersion, fileSeparator, processors);
        System.out.println(systemBlock);

        System.out.println("\n 8.ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА");
        long endTime = System.nanoTime();
        LocalTime finishTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        String timeStringStart = startedTime.format(formatter);
        String timeStringFinish = finishTime.format(formatter);
        long elapsedTime = (endTime - startTime);
        double elapsedTimeInSec = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) / 1000.0;
        String workingTimeBlock = """
                Старт проверки: %s
                Финиш проверки: %s
                Время работы: %.3f sec
                """.formatted(timeStringStart, timeStringFinish, elapsedTimeInSec);
        System.out.println(workingTimeBlock);
    }
}

