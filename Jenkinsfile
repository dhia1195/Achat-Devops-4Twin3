pipeline {
    agent any

    stages {
        stage('MAVEN-CLEAN-COMPILE') {
            steps {
                sh "mvn clean compile"
            }
        }

        stage('MVN SONARQUBE') {
            steps {
                sh 'mvn clean verify sonar:sonar \
  -Dsonar.projectKey=mehdii \
  -Dsonar.projectName='mehdii' \
  -Dsonar.host.url=http://192.168.66.66:9000 '
            }
        }
    }
}