pipeline {
  agent any
  environment { IMAGE = "devops-java-lab:${BUILD_NUMBER}" }
  stages {
    stage('Test') { steps { sh 'mvn -B clean verify' } }
    stage('Docker Build') { steps { sh 'docker build -t ${IMAGE} .' } }
    stage('SonarQube') { steps { withSonarQubeEnv('sonarqube') { sh 'mvn -B sonar:sonar' } } }
    stage('Deploy') { steps { echo 'Add your kubectl/Helm deployment command here.' } }
  }
}
