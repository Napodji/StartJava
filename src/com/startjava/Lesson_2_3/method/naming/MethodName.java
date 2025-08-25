package method.naming;

public class MethodName {
    public static String current() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
