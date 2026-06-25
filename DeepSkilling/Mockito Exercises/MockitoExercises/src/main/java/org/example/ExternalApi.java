package org.example;

public interface ExternalApi {
    String getData();
    void sendData(String data);
    void sendIntData(int data);
    void clearCache();

    void connect();
    void getInfo();
    void disconnect();
}
