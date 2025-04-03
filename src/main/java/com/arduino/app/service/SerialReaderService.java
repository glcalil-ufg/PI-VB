package com.arduino.app.service;

import java.util.Map;
import java.util.Scanner;

import org.apache.poi.ss.formula.functions.T;

import com.arduino.app.entities.ResponseEntity;
import com.arduino.app.entities.SensorEntity;
import com.fazecast.jSerialComm.SerialPort;
import com.google.gson.Gson;

public class SerialReaderService {

    private final String PORT_HUMIFITY_SENSOR = "/dev/ttyS1"; // Ajuste para sua porta
    private final String PORT_LIGTH_SENSOR = "/dev/ttyS2"; // Ajuste para sua porta
    private final String PORT_TEMPERATURE_SENSOR = "/dev/ttyS3"; // Ajuste para sua porta
    private final int BAUD_RATE = 9600;

    public String readUmidadeSensor() {
        return this.readSerialData("U");
    }

    public String readTemperaturaSensor() {
        return this.readSerialData("T");
    }

    public String readLuminosidadeSensor() {
        return this.readSerialData("L");
    }

    private String readSerialData(String sensor) {
        String serialResponse = "";
        Boolean test = true; //mude para false quando for conectar a um arduino de verdade
        ResponseEntity<T> response;
        Map<String, Object> dataMap;
        SerialPort port = null;
        Scanner scanner = null;
        SensorEntity sensorEntity;
        long startTime = System.currentTimeMillis();
        Gson gson = new Gson();

        try {

            switch (sensor) {//divisão de sensores em portas diferentes é meramente ilustrativo
                case "U":
                    if(test)serialResponse = "{\"id\":1,\"type\":\"u\",\"value\": 60,\"location\":\"Laboratório 42\"}"; //dados para teste
                    port = SerialPort.getCommPort(PORT_HUMIFITY_SENSOR); //lê apenas o sensor de umidade
                    break;
                case "L":
                    if(test)serialResponse = "{\"id\":1,\"type\":\"l\",\"value\": 1000,\"location\":\"Laboratório 42\"}"; //dados para teste
                    port = SerialPort.getCommPort(PORT_LIGTH_SENSOR); //lê apenas o sensor de luminosidade
                    break;
                case "T":
                    if(test)serialResponse = "{\"id\":1,\"type\":\"t\",\"value\": 31.5,\"unit\":\"C\",\"location\":\"Laboratório 42\"}"; //dados para teste
                    port = SerialPort.getCommPort(PORT_TEMPERATURE_SENSOR); //lê apenas o sensor de temperatura
                    break;
                default:
                    throw new Exception("Sensor não mapeado");
            }
            
            port.setBaudRate(BAUD_RATE);
            scanner = new Scanner(port.getInputStream());
            if (!port.openPort() && !test) throw new Exception("Falha ao conectar na porta serial");

            while (System.currentTimeMillis() - startTime < 2000 && !test) {
                if (scanner.hasNextLine()) {
                    serialResponse = scanner.nextLine().trim();
                    break; //Ler apenas a primeira linha
                }
            }

            if (serialResponse.isEmpty()) throw new Exception("Falha ao ler dados da porta seriall");

            dataMap = gson.fromJson(serialResponse, Map.class);
            
            sensorEntity = new SensorFactory().createSensorFromJson(dataMap);
            response = new ResponseEntity<T>(true, 200, "Dados da Leitura do sensor");
            response.setData(sensorEntity);

        } catch (Exception e) {
            response = new ResponseEntity<T>(false, 500, e.getMessage());
            if(scanner != null)scanner.close();
            if(port != null)port.closePort();
            return response.toString();
        } 

        scanner.close();
        port.closePort();
        return response.toString();

    }

}