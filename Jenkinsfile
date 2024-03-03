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

        

       stage('SonarQube Analysis') {
            steps {
                script {
                    // Use SonarQube scanner tool configured in Jenkins
                    def scannerHome = tool 'scanner'

                    // Execute SonarQube scanner
                    withSonarQubeEnv {
                sh "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }
    }

   
}
