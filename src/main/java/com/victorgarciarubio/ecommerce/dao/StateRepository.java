package com.victorgarciarubio.ecommerce.dao;

import java.util.List;

import com.victorgarciarubio.ecommerce.entity.State;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "states", path="states")
public interface StateRepository extends JpaRepository<State, Integer>{
    
    List<State> findByCountryCode(@Param("code") String code);
}