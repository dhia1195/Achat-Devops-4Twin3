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

            stage('Docker build') {
                steps {
                    script {
                        sh 'docker build -t dhia2204/achat:1.0.0 .'
                    }
                }
            }

            stage('Docker push') {
                steps {
                    script {
                        sh '''
                            docker login -u dhia2204 -p dhiaboudali
                            docker push dhia2204/achat:1.0.0
                        '''
                    }
                }
            }
             stage('Pull Docker Image') {
                        steps {
                            script {
                                docker.image('dhia2204/achat:1.0.0').pull()
                            }
                        }
                    }
                        stage('Docker Compose') {
                                steps {
                                    sh 'docker compose up -d'
                                }
                            }
        }
    }
