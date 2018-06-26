package com.mocaste.dmv.repository;

import com.mocaste.dmv.dao.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
