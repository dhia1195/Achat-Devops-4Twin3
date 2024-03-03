pipeline {
    agent any

    tools {
        // Define the SonarQube Scanner tool installation
        sonarQubeScanner 'YourSonarQubeScannerInstallation'
    }

    stages {
        stage('Clean') {
            steps {
                // Nettoyer le projet
                sh 'mvn clean'
            }
        }

        stage('Compiler') {
            steps {
                // Construire le projet avec Maven
                sh 'mvn compile'
            }
        }

        stage('Checkout') {
            steps {
                // Checkout your source code
                checkout scm
            }
        }

        stage('SonarQube analysis') {
            steps {
                script {
                    // Run SonarQube analysis using the predefined tool installation
                    withSonarQubeEnv('YourSonarQubeServer') {
                        sh 'sonar-scanner'
                    }
                }
            }
        }
    }

   
}
