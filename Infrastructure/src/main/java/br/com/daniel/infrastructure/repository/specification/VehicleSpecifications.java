package br.com.daniel.infrastructure.repository.specification;

import br.com.daniel.core.enums.BrandEnum;
import br.com.daniel.infrastructure.entity.VehicleEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class VehicleSpecifications {

    public static Specification<VehicleEntity> hasVehicleName(String vehicleName) {
        return (root, query, criteriaBuilder) -> {
            if (vehicleName == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("vehicleName"), "%" + vehicleName + "%");
        };
    }

    public static Specification<VehicleEntity> hasBrand(BrandEnum brand) {
        return (root, query, criteriaBuilder) -> {
            if (brand == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("brand"), brand );
        };
    }

    public static Specification<VehicleEntity> hasYear(Integer year) {
        return (root, query, criteriaBuilder) -> {
            if (year == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("year"), year);
        };
    }

    public static Specification<VehicleEntity> hasIsSolid(Boolean isSold) {
        return (root, query, criteriaBuilder) -> {
            if (isSold == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("isSold"), isSold );
        };
    }


    public static Specification<VehicleEntity> hasCreatedAt(LocalDateTime start, LocalDateTime end) {
        return (root, query, criteriaBuilder) -> {
            if (start == null || end == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.between(root.get("createdAt"), start, end );
        };
    }



}
