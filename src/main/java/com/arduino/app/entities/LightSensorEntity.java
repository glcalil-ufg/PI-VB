package com.arduino.app.entities;

public class LightSensorEntity extends SensorEntity {
    private double luminosity;
    
    public LightSensorEntity(int id, String location, double luminosity){
        super(id, location, "lux");
        this.luminosity = luminosity;
    }

    public double getluminosity() { return luminosity; }

    public void setluminosity(double luminosity) { this.luminosity = luminosity; }

}
