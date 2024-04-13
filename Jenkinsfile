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

        stage('JUNIT-MOCKITO') {
            steps {
                sh "mvn test -DskipTests=false"
            }
        }

        stage('Nexus') {
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

        stage('Grafana') {
            steps {
                sh 'docker restart grafana'
            }
        }

       stage('Mail') {
                   steps {
                      mail (
                           body: """Summary:
                                   - GIT: Cloned repository
                                   - Maven Build: Successfully built the project
                                   - SonarQube Analysis: Code analysis completed
                                   - Unit Tests: Executed unit tests with Mockito
                                   - Nexus Deployment: Deployed artifact to Nexus repository
                                   - Build Docker Image: Created Docker image
                                   - Push to Docker Hub: Pushed Docker image to Docker Hub
                                   - Docker Compose: Deployed services using Docker Compose
                                   - Grafana Dashboard: Configured Grafana dashboard""",
                           subject: 'Jenkins Job',
                           to: 'dhoudhou24@gmail.com',
                           from: 'esprite257@gmail.com'
                       )
                   }
        }
    }
}
