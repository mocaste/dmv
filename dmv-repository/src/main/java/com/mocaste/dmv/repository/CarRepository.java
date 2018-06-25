package com.mocaste.dmv.repository;

import com.mocaste.dmv.dao.Car;
import com.mocaste.dmv.dao.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long> {

}
