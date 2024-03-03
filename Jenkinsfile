pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {

                sh 'mvn clean'
            }
        }

        stage('Compiler') {
            steps {

                sh 'mvn compile'
            }
        }

        stage('SonarQube Analysis') {
                    steps {
                        script {
                            withSonarQubeEnv('SonarQube') {
                                sh 'sonar-scanner'
                    }
                }
            }
        }
    }
}
