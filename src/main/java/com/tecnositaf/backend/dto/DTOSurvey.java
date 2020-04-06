package com.tecnositaf.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tecnositaf.backend.model.Survey;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class DTOSurvey {
    @Id
    private String idSurvey;

    private String idDeviceFk;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private Integer storageYears;
    private Double cpu;
    private Double ram;
    private Double deviceTemperature;
    private Double ambientTemperature;
    private Double ambientPressure;

    public DTOSurvey(String idSurvey, String idDeviceFk, LocalDateTime timestamp, Integer storageYears, Double cpu, Double ram, Double deviceTemperature, Double ambientTemperature, Double ambientPressure) {
        this.idSurvey = idSurvey;
        this.idDeviceFk = idDeviceFk;
        this.timestamp = timestamp;
        this.storageYears = storageYears;
        this.cpu = cpu;
        this.ram = ram;
        this.deviceTemperature = deviceTemperature;
        this.ambientTemperature = ambientTemperature;
        this.ambientPressure = ambientPressure;
    }

    public DTOSurvey(){}

    public String getIdSurvey() {
        return idSurvey;
    }

    public void setIdSurvey(String idSurvey) {
        this.idSurvey = idSurvey;
    }

    public String getIdDeviceFk() {
        return idDeviceFk;
    }

    public void setIdDeviceFk(String idDeviceFk) {
        this.idDeviceFk = idDeviceFk;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStorageYears() {
        return storageYears;
    }

    public void setStorageYears(Integer storageYears) {
        this.storageYears = storageYears;
    }

    public Double getCpu() {
        return cpu;
    }

    public void setCpu(Double cpu) {
        this.cpu = cpu;
    }

    public Double getRam() {
        return ram;
    }

    public void setRam(Double ram) {
        this.ram = ram;
    }

    public Double getDeviceTemperature() {
        return deviceTemperature;
    }

    public void setDeviceTemperature(Double deviceTemperature) {
        this.deviceTemperature = deviceTemperature;
    }

    public Double getAmbientTemperature() {
        return ambientTemperature;
    }

    public void setAmbientTemperature(Double ambientTemperature) {
        this.ambientTemperature = ambientTemperature;
    }

    public Double getAmbientPressure() {
        return ambientPressure;
    }

    public void setAmbientPressure(Double ambientPressure) {
        this.ambientPressure = ambientPressure;
    }

    public Survey toSurvey(){
        Survey output = new Survey();
        BeanUtils.copyProperties(this,output);
        return output;
    }
}
