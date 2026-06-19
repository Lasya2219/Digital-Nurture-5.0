public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        boolean isSameInstance = logger1 == logger2;
        System.out.println("Are logger1 and logger2 the same : " + isSameInstance);
    }
}
