pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
                // Clean the project
                sh 'mvn clean'
            }
        }

        stage('Compiler') {
            steps {
                // Compile the project with Maven
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
                        sh 'mvn compile package sonar:sonar'
                    }
                }
            }
        }
    }
}
