package FactoryMethodPatternExample;

public class Main {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordFactory();
        Document wordDoc = wordFactory.createDocument();

    }
}
