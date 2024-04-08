package br.com.daniel.infrastructure.repository;

import br.com.daniel.infrastructure.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long>, JpaSpecificationExecutor<VehicleEntity> {
}
