pipeline{
    agent any

    stages{
        stage ("Build"){
            steps {
                sh 'mvn clean install'
            }
        }
        /* stage ("SonarAnalysis"){
            steps {
                withSonarQubeEnv('sonarcloud') { 
                    sh 'sonar-scanner'
                }
            }
        } */
    }
}