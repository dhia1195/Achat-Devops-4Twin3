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
    }
}
