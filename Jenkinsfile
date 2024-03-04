pipeline {
    agent any

    stages {
        stage('MAVEN-CLEAN-COMPILE') {
            steps {
                sh "mvn clean compile"
            }
        }	

        stage('SonarQube Analysis') {
            steps {
                withCredentials([string(credentialsId: 'scanner-sonar', variable: 'SONAR_TOKEN')]) {
                    sh 'mvn sonar:sonar -Dsonar.token=$SONAR_TOKEN'
                }
            }
        }
	stage('MAVEN-DEPLOY') {
            steps {
                sh "mvn deploy"
            }
        }	


    }
}