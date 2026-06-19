package BuilderPatternExample;

public class Computer {
    private String cpu;
    private String ram;
    private String storage;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    static class Builder {
        private String cpu;
        private String ram;
        private String storage;

        public void setcpu(String cpu) {
            this.cpu = cpu;
        }

        public void setram(String ram) {
            this.ram = ram;
        }

        public void setstorage(String storage) {
            this.storage = storage;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [cpu=" + cpu +
            ", ram=" + ram +
            ", storage=" + storage + "]";
    }
}
