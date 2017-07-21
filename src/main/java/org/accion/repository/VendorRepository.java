package org.accion.repository;

import org.accion.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface VendorRepository extends JpaRepository<Vendor,Integer> {
  public Vendor findByName(@Param("name")String name);
}
