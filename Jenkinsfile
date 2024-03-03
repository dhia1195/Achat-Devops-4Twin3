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
                sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=mehdi'
            }
        }
    }
}