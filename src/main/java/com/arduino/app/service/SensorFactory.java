package com.arduino.app.service;


import com.arduino.app.entities.HumiditySensorEntity;
import com.arduino.app.entities.LightSensorEntity;
import com.arduino.app.entities.SensorEntity;
import com.arduino.app.entities.TempSensorEntity;
import java.util.Map;

public class SensorFactory {

    public SensorEntity createSensorFromJson(Map<String, Object> dataMap) {

        String type = (String) dataMap.get("type");
        int id = ((Number) dataMap.get("id")).intValue();
        String location = (String) dataMap.get("location");
        double value = ((Number) dataMap.get("value")).doubleValue();
        String unit = (String) dataMap.get("unit");

        switch (type.toLowerCase()) {
            case "t": // Temperatura
                return new TempSensorEntity(id, location, value, unit);
            case "u": // Umidade
                return new HumiditySensorEntity(id, location, value);
            case "l": // Luminosidade
                return new LightSensorEntity(id, location, value);
            default:
                throw new IllegalArgumentException("Unknown sensor type: " + type);
        }
    }
}