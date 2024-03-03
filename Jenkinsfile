pipeline {
    agent any

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
                    def scannerHome = tool 'sonar-scanner' // Make sure you have a SonarQube Scanner tool configured in Jenkins

                    // Run SonarQube analysis
                    withSonarQubeEnv('YourSonarQubeServer') {
                        sh "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }

    }
}
