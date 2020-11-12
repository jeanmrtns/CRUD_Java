package crud;


public class Sensor {
    
    private int id;
    private double medida;
    
    Sensor(int id, double medida) {
        this.id = id;
        this.medida = medida;
    }


    public int getId() {
        return id;
    }

    
    public double getMedida() {
        return medida;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public void setMedida (double medida) {
        this.medida = medida;
    }
    
    
}
