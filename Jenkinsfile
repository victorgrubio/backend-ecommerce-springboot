pipeline {
  environment {
    registry = "victorgrubio/ecommerec-backend-spring"
    registryCredential = 'dockerhub'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Build docker'){
      steps{
        withEnv(["HOME=${env.WORKSPACE}"]) {
          sh 'hadolint Dockerfile'
        }
        script {
          docker.withRegistry( '', registryCredential) {
            dockerImage = docker.build registry + ":1.0.0"
            dockerImage.push()
          }
        }
      }
    }
  }
}