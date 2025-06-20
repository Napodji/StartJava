import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.concurrent.TimeUnit;

public class VariablesTheme {
    public static void main(String[] args) {
        final LocalTime startedTime = LocalTime.now();
        final long startTime = System.nanoTime();
        System.out.println("\n1. ВЫВОД ASCII-ГРАФИКИ");
        System.out.println("                     /\\ " + "\n   J    a  v     v  /  \\ " + 
                "\n   J   a a  v   v  /_( )\\ " + "\nJ  J  aaaaa  V V  /      \\ " + 
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
        BigDecimal priceBd = penPriceBd.add(bookPriceBd);
        priceBd = priceBd.setScale(2, BigDecimal.ROUND_CEILING);
        BigDecimal finalPriceBd = priceBd.multiply(discountBd);
        finalPriceBd = finalPriceBd.setScale(2, BigDecimal.ROUND_CEILING);
        BigDecimal discountAmountBd = priceBd.subtract(finalPriceBd);
        discountAmountBd = discountAmountBd.setScale(2, BigDecimal.ROUND_CEILING);
        System.out.println(priceBd + " стоимость товаров без скидки");
        System.out.println(discountAmountBd + " сумма скидки"); 
        System.out.println(finalPriceBd + " стоимость товаров со скидкой");
        System.out.println("\n3.ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ");
        int a = 2;
        int b = 5;
        System.out.println("исходное значение переменной а = " + a);
        System.out.println("исходное значение переменной b = " + b);
        int x = a;
        a = b;
        b = x;
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
        System.out.println("\n\n4.ДЕКОДИРОВАНИЕ СООБЩЕНИЯ");
        int g = 1055;
        int h = 1088;
        int c = 1080;
        int d = 1074;
        int e = 1077;
        int f = 1090;
        System.out.printf("%6d%6d%6d%6d%6d%6d", g, h, c, d, e, f);
        System.out.printf("\n%4s%6s%6s%6s%6s%6s", Character.toString(g), Character.toString(h),
                         Character.toString(c), Character.toString(d), Character.toString(e), 
                         Character.toString(f));
        System.out.println("\n\n 5.АНАЛИЗ КОДА ТОВАРА");
        int num = 123;
        int productCategory = num / 100;
        System.out.println("\nкатегория товара - " + productCategory);
        int subCategory = (num % 100) / 10;
        System.out.println("подкатегория - " + subCategory);
        int packageType = num % 10;
        System.out.println("упаковка - " + packageType);
        int controlSum = productCategory + subCategory + packageType;
        System.out.println("Контрольная сумма - " + controlSum);
        int verificationCode = productCategory * subCategory * packageType;
        System.out.println("Проверочный код - " + verificationCode);
        System.out.println("\n 6.ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ");
        byte temp = Byte.MAX_VALUE;
        byte overFlowTemp = ++temp;
        byte recoveryTemp = --temp;
        String tempBlock = """
        [Температура, °C]:
        Исходное: %d
        +1: %d
        -1: %d
                """.formatted(temp, overFlowTemp, recoveryTemp);
        System.out.println(tempBlock);
        short pressure = Short.MAX_VALUE;
        short overPressure = ++pressure;
        short recoveryPressure = --pressure;
        String pressureBlock = """
        [Давление, Bar]:
        Исходное: %d
        +1: %d
        -1: %d
                """.formatted(pressure, overPressure, recoveryPressure);
        System.out.println(pressureBlock);
        char code = Character.MAX_VALUE;
        System.out.println(code);
        char overCode = ++code;
        char recoveryCode = --code;
        System.out.println(overCode);
        int codeDigit = (int) code;
        int overCodeDigit = (int) overCode;
        int recoveryCodeDigit = (int) recoveryCode;
        String codeBlock = """
        [Давление, Bar]:
        Исходное: %d
        +1: %d
        -1: %d
                """.formatted(codeDigit, overCodeDigit, recoveryCodeDigit);
        System.out.println(codeBlock);
        int distance = Integer.MAX_VALUE;
        int overDistance = ++distance;
        int recoveryDistance = --distance;
        String distanceBlock = """
        [Расстояние, м]:
        Исходное: %d
        +1: %d
        -1: %d
                """.formatted(distance, overDistance, overDistance);
        System.out.println(distanceBlock);
        long time = Long.MAX_VALUE;
        long overTime = ++time;
        long recoveryTime = --time;
        String timeBlock = """
        [Время с момента старта, сек]:
        Исходное: %d
        +1: %d
        -1: %d
                """.formatted(time, overTime, recoveryTime);
        System.out.println(timeBlock);
        System.out.println("\n 7.ВЫВОД ПАРАМЕТРОВ JVM И ОС");
        Runtime runtime = Runtime.getRuntime();
        int processors = runtime.availableProcessors();
        long totalMemory = runtime.totalMemory();
        long totalMemoryMb = totalMemory / (1024 * 1024);
        long freeMemory = runtime.freeMemory();
        long freeMemoryMb = freeMemory / (1024 * 1024);
        long usedMemory = totalMemory - freeMemory;
        long usedMemoryMb = usedMemory / (1024 * 1024);
        long maxMemory = runtime.maxMemory();
        long maxMemoryMb = maxMemory / (1024 * 1024);
        String memoryBlock = """
        [Тип памяти, Мб]:
        Выделенная память: %d
        Свободная память: %d
        Используемая память: %d
        Общий объем памяти: %d
                """.formatted(totalMemoryMb, freeMemoryMb, usedMemoryMb, maxMemoryMb);
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