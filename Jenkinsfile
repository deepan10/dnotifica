pipeline{
    agent any

    stages{
        stage ("Build"){
            steps {
                sh 'echo hi'
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
