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
                withCredentials([string(credentialsId: 'scanner-sonar', variable: 'SONAR_TOKEN')]) {
                    sh 'mvn sonar:sonar -Dsonar.token=$SONAR_TOKEN'
                }
            }
        }

	stage('Building image'){
            steps{
              sh  'docker build -t achat/achat:1.0 .'
            }
        }
       
      

        stage('MAVEN-DEPLOY') {
            steps {
                sh "mvn clean deploy -DskipTests";
            }
        }
	
    }
}