package org.example;

public class MyService {
    ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public void processData(String message) {
        api.sendData(message);
    }

    public void processIntData(int value) {
        api.sendIntData(value);
    }

    public void resetData() {
        api.clearCache();
    }

    public void fetchInfo() {
        api.connect();
        api.getInfo();
        api.disconnect();
    }

}
