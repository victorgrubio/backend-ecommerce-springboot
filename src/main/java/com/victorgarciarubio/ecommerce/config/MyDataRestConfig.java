package com.victorgarciarubio.ecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import com.victorgarciarubio.ecommerce.entity.Product;
import com.victorgarciarubio.ecommerce.entity.ProductCategory;
import com.victorgarciarubio.ecommerce.entity.Country;
import com.victorgarciarubio.ecommerce.entity.State;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager myEntityManager){
        entityManager = myEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config){
        // DisableMethods = PUT POST GET
        HttpMethod[] unsupportedActions = {
            HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE
        };

        // Disable HTTP methods for Product
        disableHttpMethods(Product.class, config, unsupportedActions);
        // Disable HTTP methods for ProductCategory
        disableHttpMethods(ProductCategory.class, config, unsupportedActions);
        // Disable HTTP methods for Country
        disableHttpMethods(Country.class, config, unsupportedActions);
        // Disable HTTP methods for State
        disableHttpMethods(State.class, config, unsupportedActions);

        // call internal helper method
        exposeIds(config);

    }

    private void disableHttpMethods(Class disabledClass, RepositoryRestConfiguration config, HttpMethod[] unsupportedActions) {
        config.getExposureConfiguration()
            .forDomainType(disabledClass)
            .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
            .withCollectionExposure((metdata, httpMethods)-> httpMethods.disable(unsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config){
        // expose entity ids

        // - get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();

        for (EntityType tempEntityType : entities){
            entityClasses.add(tempEntityType.getJavaType());
        }

        // expose the entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }


}
