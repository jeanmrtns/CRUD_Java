package crud;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateFile {
    
    RandomAccessFile file;
    Sensor sensor;
    
    public UpdateFile() throws IOException {
        
        try {
            file = new RandomAccessFile("sensor.dat", "rw");
            sensor = new Sensor(0, 0);
            
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Qual ID deseja modificar? ");
                int idProcurado = sc.nextInt();
                
                System.out.println("Informe o novo ID: ");
                int novoID = sc.nextInt();
                
                System.out.println("Informe a nova medida: ");
                double novaMedida = sc.nextDouble();
                
                while (file.getFilePointer() != file.length()) {
                    
                    sensor.setID(file.readInt());
                    sensor.setMedida(file.readDouble());
                    
                    if (sensor.getId() == idProcurado) {
                        file.seek(file.getFilePointer() - 12 );
                        file.writeInt(novoID);
                        file.writeDouble(novaMedida);
                    }
  
                }
                
                file.close();
                sc.close();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UpdateFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
