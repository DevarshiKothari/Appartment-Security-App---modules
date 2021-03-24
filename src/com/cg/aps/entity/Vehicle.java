package com.cg.aps.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Devarshi
 * entity class of vehicle module. vehicleNo is the primary key and joins column of owner class
 *
 */
@Entity
@Table(name = "vehicles_aps")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getBasementLevel() {
		return basementLevel;
	}
	public void setBasementLevel(String basementLevel) {
		this.basementLevel = basementLevel;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public String getParkingNo() {
		return parkingNo;
	}
	public void setParkingNo(String parkingNo) {
		this.parkingNo = parkingNo;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	@Id
	private String vehicleNo;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "ownerId"),name = "ownerId")
	@JsonIgnore
	private Owner owner;
	private String parkingNo;
	private String basementLevel;
	private String vehicleType;
	
}
