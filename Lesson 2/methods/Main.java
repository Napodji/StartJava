package methods;

public class Main {
    public static void main(String[] args) {
        MethodName methodInfo = new MethodName();
        System.out.println("Текущий метод: " + methodInfo.getCurrent());

        doNonBooleanMethods();
        doBooleanMethods();
    }

    private static void doNonBooleanMethods() {
        System.out.println("\nВызов не-boolean методов");

        nonBm instance = new nonBm();
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

        bm instance = new bm();

        System.out.println(instance.isProgramRunning());
        System.out.println(instance.hasUniqueDigit());
        System.out.println(instance.isLetterInput());
        System.out.println(instance.hasEqualDigits());
        System.out.println(instance.hasMarioLives());
        System.out.println(instance.isEmptyOrWhitespace());
        System.out.println(instance.isEvenDiceRoll());
        System.out.println(instance.isValidFilepath());
        System.out.println(instance.isFileExists());
        System.out.println(instance.isExistEmail());
    }
}
