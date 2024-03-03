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
                    withSonarQubeEnv('scanner') {
                        sh 'SonargraphReport sonargraphBuildJDK: 'JAVA_HOME''
                    }
                }
            }
        }
    }
}
