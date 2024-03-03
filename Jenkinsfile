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


  stage('SCM') {
   stage('SonarQube Analysis') {
            steps {
                // Define the location of the SonarQube scanner executable
                script {
                    def scannerHome = '/path/to/sonar-scanner'  // Update this with the path to your SonarQube scanner installation
                    withSonarQubeEnv('SonarQube') {
                        // Execute the SonarQube scanner with the specified version
                        sh "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }


    }
}
