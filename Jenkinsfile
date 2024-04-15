pipeline {
    agent any

    stages {
        stage('GIT') {
            steps {
                           echo 'Pulling code from git . . .'
                git branch :"jellazi_mohamedaziz_4twin3",
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
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar';
            }
        }
         stage('JUNIT-MOCKITO') {
                    steps {
                        sh "mvn test -DskipTests=false"
                    }
                }
 	stage('MAVEN-DEPLOY') {
            steps {
                sh "mvn clean deploy -DskipTests"
            }
        }
      stage('Grafana') {
                 steps {
                     sh 'docker restart grafana'
                 }
             }
     stage('Building image') {
                 steps {
                     sh "docker build -t azizjellazi/achat:1.0.0 ."
                 }
             }
        stage('Docker push') {
                   steps {
                       script {
                           sh '''
                               docker login -u azizjellazi -p aziz28063828
                               docker push azizjellazi/achat:1.0.0
                           '''
                       }
                   }
               }

               stage('Pull Docker Image') {
                   steps {
                       script {
                           docker.image('azizjellazi/achat:1.0.0').pull()
                       }
                   }
               }

               stage('Docker Compose') {
                   steps {
                       sh 'docker compose up -d'
                   }
               }
      
    }
}