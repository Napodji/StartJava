package method.naming;

public class BooleanMethods {
    public boolean isProgramRunning() {
        System.out.print(MethodName.current() + "() -> программа выполняется? ");
        return true;
    }

    public boolean hasUniqueDigit() {
        System.out.print(MethodName.current() + "() -> есть уникальная цифра? ");
        return false;
    }

    public boolean isLetter() {
        System.out.print(MethodName.current() + "() -> введена буква? ");
        return true;
    }

    public boolean hasEqualDigits() {
        System.out.print(MethodName.current() + "() -> есть равные цифры? ");
        return false;
    }

    public boolean hasLives() {
        System.out.print(MethodName.current() + "() -> остались попытки? ");
        return true;
    }

    public boolean isBlank() {
        System.out.print(MethodName.current() + "() -> пустая строка? ");
        return false;
    }

    public boolean isEvenDiceRoll() {
        System.out.print(MethodName.current() + "() -> выпало четное число? ");
        return true;
    }

    public boolean isValidPath() {
        System.out.print(MethodName.current() + "() -> путь действительный? ");
        return true;
    }

    public boolean isFileExist() {
        System.out.print(MethodName.current() + "() -> файл существует? ");
        return false;
    }

    public boolean isEmailExist() {
        System.out.print(MethodName.current() + "() -> email существует? ");
        return false;
    }
}
