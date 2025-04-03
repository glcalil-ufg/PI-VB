package com.arduino.app.entities;

public class HumiditySensorEntity extends SensorEntity {
    private double humidity;

    public HumiditySensorEntity (int id, String location, double humidity){
        super(id, location, "%");
        this.humidity = humidity;
    }
    public double gethumidity() { return humidity; }

    public void sethumidity(double humidity) { this.humidity = humidity; }

}
