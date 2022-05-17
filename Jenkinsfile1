pipeline {
   agent any

   environment {
     agentname='java'
   }

  stages {
    stage('Checkout') {
      steps {
        echo 'Checkout'
        checkout scm
      }
    }

    stage('Build') {
      steps {
        // script
        sh 'mvn clean install'
      }
    }
     
     stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonarqube-server') {
                  sh 'mvn sonar:sonar'
                }
            }
        }
     
     
     stage("Quality Gate") {
            steps {
                timeout(time: 2, unit: 'MINUTES') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }
            }
        }
     
     stage("Dev Deployment") {
            steps {
                echo 'Dev'
            }
        }
     
      
     stage("Test Deployment") {
            steps {
                echo 'Test'
            }
        }
     
      
     stage("UAT Deployment") {
            steps {
                echo 'UAT'
            }
        }
     
      
     stage("Stage Deployment") {
            steps {
                echo 'Stage'
            }
        }
     
      
     stage("Prod Deployment") {
            steps {
                echo 'Prod'
            }
        }
     
     
  }

}
