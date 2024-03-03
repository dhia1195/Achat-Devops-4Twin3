pipeline {
    agent any

    stages {
        stage('GIT') {
            steps {
                           echo 'Pulling code from git . . .'
                git branch :"yousrabacha",
                url:"https://github.com/dhia1195/Achat-Devops-4Twin3.git"
            }
        }
    
         stage('MAVEN') {
             steps {
                 sh "mvn clean compile"
            }
        }
        stage('MVN SONARQUBE'){
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonarqube';
            }
        }
       
      
    }
}