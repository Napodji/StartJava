package methods;

public class bm {
    public boolean isProgramRunning() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> программа выполняется? ");
        return true;
    }

    public boolean hasUniqueDigit() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> есть уникальная цифра? ");
        return false;
    }

    public boolean isLetterInput() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> введена буква? ");
        return true;
    }

    public boolean hasEqualDigits() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> есть равные цифры? ");
        return false;
    }

    public boolean hasMarioLives() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> остались попытки? ");
        return true;
    }

    public boolean isEmptyOrWhitespace() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> пустая строка? ");
        return false;
    }

    public boolean isEvenDiceRoll() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> выпало четное число? ");
        return true;
    }

    public boolean isValidFilepath() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> путь действительный? ");
        return true;
    }

    public boolean isFileExists() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> файл существует? ");
        return false;
    }

    public boolean isExistEmail() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> email существует? ");
        return false;
    }
}
