package Task2;

import java.io.Closeable;
import java.io.IOException;

public class Car implements Closeable{
    String name;

    public Car(final String name) {
        this.name = name;
        validate();
    }

    public void validate() {
        if (name.matches("(.*[\\d\\s]+.*)+"))
            throw new RuntimeException("Exception in name");
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public void close() throws IOException {

    }
}
