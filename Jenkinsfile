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
			withSonarQubeEnv() {
      				sh "mvn clean verify sonar:sonar"
    		}
	}
    
  }



    }
}
