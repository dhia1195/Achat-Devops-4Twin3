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
                sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=mehdi -Dsonar.projectName='mehdi' -Dsonar.host.url=http://192.168.66.66:9000 -Dsonar.token=sqp_7fb3e4e7a7c337991a70aeeaa937f818934c5cf6'
            }
        }
    }
}