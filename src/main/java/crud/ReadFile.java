package crud;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadFile {

    RandomAccessFile file;
    Sensor sensor;

    public ReadFile() throws IOException {

        try {

            file = new RandomAccessFile("sensor.dat", "r");
            sensor = new Sensor(0, 0);

            while (file.getFilePointer() != file.length()) {
                int id = file.readInt();
                double medida = file.readDouble();
                System.out.print("ID: " + id);
                System.out.println(" / Medida: " + medida);
            }
            file.close();
        } catch (IOException e) {

        }

    }

}
