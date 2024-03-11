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
                withCredentials([string(credentialsId: 'scanner', variable: 'SONAR_TOKEN')]) {
                    sh 'mvn sonar:sonar -Dsonar.token=$SONAR_TOKEN'
                }
            }
        }

        stage('MAVEN-DEPLOY') {
            steps {
                sh "mvn clean deploy -DskipTests"
            }
        }
        stage('Docker compose') {
                    steps {
                        script {
                            sh 'docker build -t dhia2204/achat-devops:1.0.0 .'
                        }
                    }
                    }
    }
}