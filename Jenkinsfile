pipeline {
    agent any

    stages {

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
	