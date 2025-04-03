package com.arduino.app.entities;

public class TempSensorEntity extends SensorEntity{
    private double temperature;
    
    public TempSensorEntity(int id, String location, double temperature, String unitMeasure){
        super(id, location, unitMeasure);
        setUnitMeasure(unitMeasure); // Validação ao definir
        this.temperature = temperature;
    }

    public double getTemperature() { return temperature; }

    public void setTemperature(double temperature) { this.temperature = temperature; }

    public void setUnitMeasure(String unitMeasure) {
        if (unitMeasure.equalsIgnoreCase("C") || 
            unitMeasure.equalsIgnoreCase("F") || 
            unitMeasure.equalsIgnoreCase("K")) {
            this.unitMeasure = unitMeasure.toUpperCase();
        } else {
            throw new IllegalArgumentException("Invalid unitMeasure. Use 'C', 'F' or 'K'.");
        }
    }

}
