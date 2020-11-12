package crud;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RemoveSensor {

    RandomAccessFile file;
    RandomAccessFile newFile;
    Sensor sensor;

    public RemoveSensor() throws IOException {

        file = new RandomAccessFile("sensor.dat", "rw");
        newFile = new RandomAccessFile("sensor2.dat", "rw");
        sensor = new Sensor(0, 0);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Qual ID deseja excluir? ");
            
            int idProcurado = sc.nextInt();

            while (file.getFilePointer() != file.length()) {

                sensor.setID(file.readInt());
                sensor.setMedida(file.readDouble());

                if (sensor.getId() != idProcurado) {
                    
                    newFile.writeInt(sensor.getId());
                    newFile.writeDouble(sensor.getMedida());
                    

                }
                
                else {
                    System.out.println("Exclusão realizada!");
                }

            }

            file.close();
            newFile.close();
         
            sc.close();
            
            File principal = new File("sensor.dat");
            File temp = new File("sensor2.dat");
            
            principal.delete();
            temp.renameTo(principal);
            
        }

    }

}
