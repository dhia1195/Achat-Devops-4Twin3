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
				def scannerHome = tool 'scanner'
				withSonarQubeEnv {
					//sh "${scannerHome}/bin/sonar-scanner"
					sh "mvn sonar:sonar"
				}
			}
		}
	}



    }
}
