package methods;

public class nonBm {
    public void findLongestWord() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> поиск самого длинного слова в предложении");
    }

    public void selectMenuOption() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> выбор пункта меню в текстовом редакторе");
    }

    public void calculateAverageGrade() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> вычисление среднего значения оценок");
    }

    public void countUniqueWords() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> подсчет уникальных слов");
    }

    public void showError() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> вывод сообщения об ошибке");
    }

    public void syncData() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> синхронизация данных");
    }

    public void restoreBackup() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> восстановление данных");
    }

    public void pauseDownload() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> приостановка загрузки");
    }

    public void resetSettings() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> сброс настроек");
    }

    public void writeToFile() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> запись в файл");
    }

    public void convertCelsiusToFahrenheit() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> конвертация температуры");
    }

    public void calculateExpression() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> вычисление математического выражения");
    }

    public void findWinner() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> определение победителя");
    }

    public void findBooksByAuthor() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> поиск книг по автору");
    }
}
