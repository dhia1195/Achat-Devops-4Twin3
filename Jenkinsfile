pipeline {
    agent any

    stages {
        stage('Clean')  {
            steps {
                // Nettoyer le projet
                sh 'mvn clean'
            }
        }

        
	stage('MVN SONARQUBE') {
steps{
script {

withSonarQubeEnv {
sh 'mvn clean verify sonar:sonar Dsonar.login=admin -Dsonar.password=sonarqube';
}
}
}
}


    }
}
	