pipeline {
    agent any

    stages {
        stage('Clean')  {
            steps {
                // Nettoyer le projet
                sh 'mvn clean'
            }
        }


	stage('SonarQube Analysis') {
steps{
script {
//def scannerHome = tool 'scanner'
withSonarQubeEnv {
sh "mvn sonar:sonar"
}
}
}
}


    }
}
	