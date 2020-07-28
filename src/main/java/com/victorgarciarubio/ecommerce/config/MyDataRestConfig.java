package com.victorgarciarubio.ecommerce.config;

import com.victorgarciarubio.ecommerce.entity.Product;
import com.victorgarciarubio.ecommerce.entity.ProductCategory;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config){
        HttpMethod[] theUnsupportedActions = {
            HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE
        };

        config.getExposureConfiguration()
            .forDomainType(Product.class)
            .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
            .withCollectionExposure((metdata, httpMethods)-> httpMethods.disable(theUnsupportedActions));

        config.getExposureConfiguration()
            .forDomainType(ProductCategory.class)
            .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
            .withCollectionExposure((metdata, httpMethods)-> httpMethods.disable(theUnsupportedActions));

    }


}