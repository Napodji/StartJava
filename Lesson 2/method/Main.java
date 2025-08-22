package method;

public class Main {
    public static void main(String[] args) {
        System.out.println("Текущий метод: " + MethodName.current());

        doNonBooleanMethods();
        doBooleanMethods();
    }

    private static void doNonBooleanMethods() {
        System.out.println("\nВызов не-boolean методов");

        NonBooleanMethods instance = new NonBooleanMethods();
        instance.findLongestWord();
        instance.selectMenuOption();
        instance.calculateAverageGrade();
        instance.countUniqueWords();
        instance.showError();
        instance.syncData();
        instance.restoreBackup();
        instance.pauseDownload();
        instance.resetSettings();
        instance.writeToFile();
        instance.convertCelsiusToFahrenheit();
        instance.calculateExpression();
        instance.findWinner();
        instance.findBooksByAuthor();
    }

    private static void doBooleanMethods() {
        System.out.println("\nВызов boolean методов");

        BooleanMethods instance = new BooleanMethods();
        System.out.println(instance.isProgramRunning());
        System.out.println(instance.hasUniqueDigit());
        System.out.println(instance.isLetter());
        System.out.println(instance.hasEqualDigits());
        System.out.println(instance.hasLives());
        System.out.println(instance.isLetter());
        System.out.println(instance.isEvenDiceRoll());
        System.out.println(instance.isValidPath());
        System.out.println(instance.isFileExist());
        System.out.println(instance.isEmailExist());
    }
}