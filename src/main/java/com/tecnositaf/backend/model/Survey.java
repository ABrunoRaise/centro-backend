package com.tecnositaf.backend.model;

import java.time.LocalDateTime;

import com.tecnositaf.backend.dto.DTOSurvey;
import com.tecnositaf.backend.utility.DateUtility;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document("survey")
public class Survey {

	@Id
	private String idSurvey;

	private String idDeviceFk;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timestamp;
	private Double cpu;
	private Double ram;
	private Double deviceTemperature;
	private Double ambientTemperature;
	private Double ambientPressure;
	
	public Survey(String idSurvey, String idDeviceFk, LocalDateTime timestamp, double cpu, double ram, double deviceTemperature,
			double ambientTemperature, double ambientPressure) {
		this.idSurvey = idSurvey;
		this.idDeviceFk = idDeviceFk;
		this.timestamp = timestamp;
		this.cpu = cpu;
		this.ram = ram;
		this.deviceTemperature = deviceTemperature;
		this.ambientTemperature = ambientTemperature;
		this.ambientPressure = ambientPressure;
	}
	
	public Survey() {}
	
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

	public Double getCpu() {
		return cpu;
	}
	
	public void setCpu(double cpu) {
		this.cpu = cpu;
	}
	
	public Double getRam() {
		return ram;
	}
	
	public void setRam(double ram) {
		this.ram = ram;
	}
	
	public Double getDeviceTemperature() {
		return deviceTemperature;
	}
	
	public void setDeviceTemperature(double deviceTemperature) {
		this.deviceTemperature = deviceTemperature;
	}
	
	public Double getAmbientTemperature() {
		return ambientTemperature;
	}
	
	public void setAmbientTemperature(double ambientTemperature) {
		this.ambientTemperature = ambientTemperature;
	}
	
	public Double getAmbientPressure() {
		return ambientPressure;
	}
	
	public void setAmbientPressure(double ambientPressure) {
		this.ambientPressure = ambientPressure;
	}

	@Override
	public String toString() {
		return "Survey [idSurvey=" + idSurvey + ", idDeviceFk=" + idDeviceFk + ", timestamp=" + timestamp + 
				  ",  cpu=" + cpu + ", ram=" + ram + ", deviceTemperature=" + deviceTemperature + ", ambientTemperature="
				+ ambientTemperature + ", ambientPressure=" + ambientPressure + "]";
	}

	public DTOSurvey toDtoSurvey(){
		DTOSurvey output = new DTOSurvey();
		BeanUtils.copyProperties(this , output);
		Integer storageYears = DateUtility.calculateDifferenceYear(this.getTimestamp());
		output.setStorageYears(storageYears);
		return output;
	}
}
