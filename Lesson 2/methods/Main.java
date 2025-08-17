package methods;

public class Main {
    public static void main(String[] args) {
        NotBooleanMethods notBoolean = new NotBooleanMethods();
        BooleanMethods booleanMethods = new BooleanMethods();

        callNotBooleanMethods(notBoolean);

        callBooleanMethods(booleanMethods);
    }

    private static void callNotBooleanMethods(NotBooleanMethods instance) {
        System.out.println("\nВызов не-boolean методов");
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

    private static void callBooleanMethods(BooleanMethods instance) {
        System.out.println("\nВызов boolean методов");
        instance.isProgramRunning();
        instance.hasUniqueDigit();
        instance.isLetterInput();
        instance.hasEqualDigits();
        instance.hasMarioLives();
        instance.isEmptyOrWhitespace();
        instance.isEvenDiceRoll();
        instance.isValidFilepath();
        instance.isFileExists();
    }
}
