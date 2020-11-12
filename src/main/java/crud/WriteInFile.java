package crud;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteInFile {

    RandomAccessFile file;
    Sensor sensor;

    public WriteInFile() throws IOException {

        try {
            file = new RandomAccessFile("sensor.dat", "rw");
            file.seek(file.length());
            
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Informe o ID do sensor: ");
                int newID = sc.nextInt();
                
                System.out.println("Informe a medida do sensor: ");
                double newMedida = sc.nextDouble();
                
                sensor = new Sensor(newID, newMedida);
                
                file.writeInt(sensor.getId());
                file.writeDouble(sensor.getMedida());
                
                System.out.println("Registro adicionado com sucesso!");
                
                file.close();
                sc.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteInFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
