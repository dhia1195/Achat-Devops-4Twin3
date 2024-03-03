pipeline {
    agent any

    stages {
        stage('MAVEN-CLEAN-COMPILE') {
            steps {
                sh "mvn clean compile"
            }
        }

        stage('MVN SONARQUBE') {
            steps {
                sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=mehdii -Dsonar.projectName='mehdii' -Dsonar.host.url=http://192.168.66.66:9000 -Dsonar.token=sqp_82fe71fda8d6270aba9a30f92a2eb7e740bb4f78
'
            }
        }
    }
}