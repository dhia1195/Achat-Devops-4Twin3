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
			withSonarQubeEnv('sonarqube-10.4.0.87286') {
      				sh "mvn sonar:sonar"
    		}
	}
    
  }



    }
}
