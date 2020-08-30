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
          sh 'wget -O /bin/hadolint https://github.com/hadolint/hadolint/releases/download/v1.16.3/hadolint-Linux-x86_64'
          sh 'chmod +x /bin/hadolint'
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