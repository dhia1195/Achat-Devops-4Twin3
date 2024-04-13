pipeline {
    agent any

    
    stages {
        stage('Install dependencies') {
            steps {
                sh 'npm install'
            }
        }

       

        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool 'scanner'
                    withSonarQubeEnv {
                        sh "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }

        
        stage('Docker push') {
            steps {
                sh '''
                    docker login -u dhia2204 -p dhiaboudali
                    docker push dhia2204/frontachat:1.0.0
                '''
            }
        }

        stage('Pull Docker image') {
            steps {
                script {
                    docker.image('dhia2204/frontachat:1.0.0').pull()
                    sh 'docker-compose up -d'
                }
            }
        }
    }
}
