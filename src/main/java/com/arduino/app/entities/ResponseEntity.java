package com.arduino.app.entities;

import com.google.gson.Gson;

public class ResponseEntity<T> {
    
    private boolean success;
    private int statusCode;
    private String message;
    private SensorEntity data;

    public ResponseEntity(boolean success, int statusCode, String message) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.data = null;
    }

    public boolean isSuccess() { return success; }

    public int getStatusCode() { return statusCode; }

    public String getMessage() { return message; }

    public SensorEntity getData() { return data; }

    public void setSuccess(boolean success) { this.success = success; }

    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }

    public void setMessage(String message) { this.message = message; }

    public void setData(SensorEntity sensorEntity) { this.data = sensorEntity; }

    // Converte o objeto para JSON
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
