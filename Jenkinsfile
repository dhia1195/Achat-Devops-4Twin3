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

	
       
      

        stage('NEXUS') {
            steps {
                sh "mvn clean deploy -DskipTests";
            }
        }

stage('Building image'){
            steps{
              sh  'docker build -t spartacus155/achat:1.0 .'
            }
        }

stage ('Deploy Image'){
           steps{
               sh '''docker login -u spartacus155 -p 123aze123AZE
                  docker push spartacus155/achat:1.0'''
           }
       }
	
    }
}