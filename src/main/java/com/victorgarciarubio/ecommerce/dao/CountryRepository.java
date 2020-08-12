package com.victorgarciarubio.ecommerce.dao;

import com.victorgarciarubio.ecommerce.entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"https://ecommerce-app.victorgarciarubio.com", "https://frontend-ecommerce-angular.vercel.app"})
@RepositoryRestResource(collectionResourceRel = "countries", path="countries")
public interface CountryRepository extends JpaRepository<Country, Integer>{
    
}