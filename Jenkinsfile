pipeline {
    agent any

    stages {
        stage('MAVEN-CLEAN-COMPILE') {
            steps {
                sh "mvn clean compile"
            }
        }

        stage('SonarQube Analysis') {
steps{
script {
def scannerHome = tool 'scanner'
withSonarQubeEnv {
sh "${scannerHome}/bin/sonar-scanner"
}
}
}
}

    }
}