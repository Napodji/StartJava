package methods;

class MethodName {
    public String getCurrent() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
