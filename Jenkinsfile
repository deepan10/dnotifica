pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        build(job: 'test1', propagate: true)
      }
    }
  }
}