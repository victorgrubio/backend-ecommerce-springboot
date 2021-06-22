# Spring Ecommerce REST API

![CircleCI](https://circleci.com/gh/victorgrubio/backend-ecommerce-springboot.svg?style=svg) 
![Build status](https://img.shields.io/circleci/build/gh/victorgrubio/backend-ecommerce-springboot/master?token=ccf75fe7e2f1925687bae66dc293fe9bfca32eee) 
![Dependencies](https://img.shields.io/librariesio/github/victorgrubio/backend-ecommerce-springboot)
![Docker Pulls](https://img.shields.io/docker/pulls/victorgrubio/ecommerce-backend-spring) 

<br>Ecommerce REST API from the Udemy course "Fullstack: Spring Boot and Angular" instructed by Chad Darby. Deployed at [**Heroku**](https://heroku.com) using [**CircleCI**](https://circleci.com) for the CI/CD procedure

See the application working [**here!**](https://ecommerce-app.victorgarciar.com)

## Installation

```bash
docker pull victorgarciarubio/ecommerce-backend-spring
```

## Docs

OpenAPI v3 documentation is available [here](./openapi.yaml)


## Continuous Integration

### Jenkins

Created [Jenkinsfile](./Jenkinsfile) to setup the Continuous Integration with [Jenkins Server](https://www.jenkins.io/). Builds the application, pass the test and builds the Docker image and pushes it to Dockerhub.

### Circle CI

Created [.circleci/config.yaml](.circleci/config.yaml) to build the application and perform the test. If the tests are passed, the Docker image is built and uploaded to Dockerhub.


## Deployment

### Heroku

Automatic deployment defined in master branch.

[Procfile](./Procfile) allows Heroku to launch the application.

## Contribute

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[![MIT](https://img.shields.io/github/license/victorgrubio/backend-ecommerce-springboot) ](https://choosealicense.com/licenses/mit/)
