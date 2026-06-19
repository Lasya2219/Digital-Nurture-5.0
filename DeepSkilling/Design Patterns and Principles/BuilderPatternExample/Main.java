package BuilderPatternExample;

public class Main {
    public static void main(String[] args) {
        Computer.Builder builder = new Computer.Builder();
        builder.setcpu("Intel i7");
        builder.setram("16GB");
        builder.setstorage("512GB SSD");

        Computer computer = builder.build();
        System.out.println(computer);
    }
}
