public class Calculator {
    public long calculate(long a, char operation, long b) {
        long result = 0;

        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    System.out.println("Деление на ноль запрещено!");
                    return 0;
                }
                result = a / b;
                break;
            case '^':
                if (b >= 0) {
                    result = 1;
                    for (int i = 0; i < b; i++) {
                        result *= a;
                    }
                } else {
                    result = 1;
                    for (int i = 0; i < -b; i++) {
                        result *= a;
                    }
                    result = 1 / result;
                }
                break;
            case '%':
                result = a % b;
                break;
            default:
                System.out.println("Данная " + operation + " невозможна!");
                return 0;
        }
        return result;
    }
}
