package br.com.daniel.core.domain;

import br.com.daniel.core.enums.BrandEnum;

import java.time.LocalDateTime;

public class Vehicle implements Cloneable{
    private Long id;
    private String vehicleName;
    private BrandEnum brand;
    private Integer year;
    private String description;
    private Boolean isSold;
    private String urlImg;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Vehicle() {
    }

    public Vehicle(String vehicleName, String urlImg, BrandEnum brand, Integer year, String description, Boolean isSold) {
        this.id = null;
        this.vehicleName = vehicleName;
        this.urlImg = urlImg;
        this.brand = brand;
        this.year = year;
        this.description = description;
        this.isSold = isSold;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;
    }

    public Vehicle(Long id, String vehicleName, String urlImg, BrandEnum brand, Integer year, String description, Boolean isSold, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.vehicleName = vehicleName;
        this.urlImg = urlImg;
        this.brand = brand;
        this.year = year;
        this.description = description;
        this.isSold = isSold;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getUrlImg() {
        return urlImg;
    }
    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public BrandEnum getBrand() {
        return brand;
    }

    public void setBrand(BrandEnum brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getSold() {
        return isSold;
    }

    public void setSold(Boolean sold) {
        isSold = sold;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;

        if (getId() != null ? !getId().equals(vehicle.getId()) : vehicle.getId() != null) return false;
        if (!getVehicleName().equals(vehicle.getVehicleName())) return false;
        if (getBrand() != vehicle.getBrand()) return false;
        if (!getYear().equals(vehicle.getYear())) return false;
        if (!getDescription().equals(vehicle.getDescription())) return false;
        if (!isSold.equals(vehicle.isSold)) return false;
        if (!getUrlImg().equals(vehicle.getUrlImg())) return false;
        if (!getCreatedAt().equals(vehicle.getCreatedAt())) return false;
        return getUpdatedAt() != null ? getUpdatedAt().equals(vehicle.getUpdatedAt()) : vehicle.getUpdatedAt() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getVehicleName().hashCode();
        result = 31 * result + getBrand().hashCode();
        result = 31 * result + getYear().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + isSold.hashCode();
        result = 31 * result + getUrlImg().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + (getUpdatedAt() != null ? getUpdatedAt().hashCode() : 0);
        return result;
    }

    @Override
    public Vehicle clone() {
        try {
            return (Vehicle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

}
