package com.arduino.app.entities;

import com.google.gson.Gson;

public class SensorEntity {
    protected int id;
    protected String location;
    protected String unitMeasure;

    public SensorEntity(int id, String location, String unitMeasure) {
        this.id = id;
        this.location = location;
        this.unitMeasure = unitMeasure;
    }

    public int getId() { return id; }

    public String getLocation() { return location; }

    public String getUnitMeasure() { return unitMeasure; }

    public void setId(int id) { this.id = id; }

    public void setLocation(String location) { this.location = location; }

    // Converte o objeto para JSON
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
