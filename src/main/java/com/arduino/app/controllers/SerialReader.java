package com.arduino.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arduino.app.service.SerialReaderService;

@RestController
@RequestMapping("/api")
public class SerialReader {
    private final SerialReaderService serialService;

    public SerialReader() {
        this.serialService = new SerialReaderService();
    }

    @GetMapping("/umidade")
    public String readUmidadeSensor() {
        return serialService.readUmidadeSensor();
    }

    @GetMapping("/temperatura")
    public String readTemperaturaSensor() {
        return serialService.readTemperaturaSensor();
    }

    @GetMapping("/luminosidade")
    public String readLuminosidadeSensor() {
        return serialService.readLuminosidadeSensor();
    }
}
