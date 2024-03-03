pipeline {
    agent any

    stages {
        stage('Clean')  {
            steps {
                // Nettoyer le projet
                sh 'mvn clean'
            }
        }

        stage('Compiler') {
            steps {
                // Construire le projet avec Maven
                 sh 'mvn compile'
            }
        }
	stage('SonarQube Analysis') {
steps{
script {
//def scannerHome = tool 'scanner'
withSonarQubeEnv {
sh "mvn clean verify sonar:sonar -Dsonar.projectKey=mehdi -Dsonar.projectName='mehdi'"
}
}
}
}


    }
}
	