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
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=dhia'
            }
        }
    }
}
