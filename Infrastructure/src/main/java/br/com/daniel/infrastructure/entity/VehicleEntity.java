package br.com.daniel.infrastructure.entity;

import br.com.daniel.core.domain.Vehicle;
import br.com.daniel.core.enums.BrandEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Vehicles")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleName;
    private String urlImg;
    @Column(name = "brand")
    @Enumerated(EnumType.STRING)
    private BrandEnum brand;
    @Column(name = "yearVehicle")
    private Integer year;
    private String description;
    private Boolean isSold;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public VehicleEntity(String vehicleName, String urlImg, BrandEnum brand, Integer year, String description, Boolean isSold, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.vehicleName = vehicleName;
        this.urlImg = urlImg;
        this.brand = brand;
        this.year = year;
        this.description = description;
        this.isSold = isSold;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static VehicleEntity from(Vehicle vehicle){
        return new VehicleEntity(
                vehicle.getId(),
                vehicle.getVehicleName(),
                vehicle.getUrlImg(),
                vehicle.getBrand(),
                vehicle.getYear(),
                vehicle.getDescription(),
                vehicle.getSold(),
                vehicle.getCreatedAt(),
                vehicle.getUpdatedAt()
        );
    }

    public Vehicle toVehicle(){
        return new Vehicle(
                this.id,
                this.vehicleName,
                this.urlImg,
                this.brand,
                this.getYear(),
                this.getDescription(),
                this.isSold,
                this.createdAt,
                this.updatedAt
        );
    }
}
