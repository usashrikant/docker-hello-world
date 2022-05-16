pipeline {
    agent any
	//tools {
		//maven 'Maven'
	//}
	
	environment {
		PROJECT_ID = 'possible-sun-342923'
                CLUSTER_NAME = 'my-first-cluster-1'
                LOCATION = 'us-central1-c'
                CREDENTIALS_ID = 'kubernetes'
      		DOCKERCREDS = credentials('raghukom')
	}
	
    stages {
	    stage('Scm Checkout') {
		  steps {
			    checkout scm
		    }
	    }
	    
	    
	    stage('Test') {
		    steps {
			    echo "Testing..."
			    // sh 'mvn test'
		    }
	    }
	    
	    stage('Build Docker Image') {
		    steps {
			    echo 'whoami'
			     script {
				     myimage = docker.build("raghukom/devops:${env.BUILD_ID}")
				     
				     //sh 'docker build -t raghukom/devops:latest .'
			     }
		    }
	    }
	    
	    stage("Push Docker Image") {
		    steps {
				 //sh 'echo $DOCKERCREDS_PSW | docker login -u $DOCKERCREDS_USR --password-stdin'
			          sh "docker login -u raghukom -p Raghu@1507"
				 //sh 'docker push raghukom/devops:latest'
			     //script {
				     echo "Push Docker Image"
				     //withCredentials([usernamePassword(credentialsId: 'raghukom', passwordVariable: 'dockerpwd')]) {
             				//sh 'docker login -u raghukom -p $dockerpwd'
					//sh 'echo $dockerpwd | base64'
				     //}
				     //myimage.push("${env.BUILD_ID}")			    
			     //}
		    }
	    }
	    
	    stage('Deploy to K8s Dev') {
		    steps{
			    echo "Deployment started ..."
			     sh 'ls -ltr'
			     sh 'pwd'
			     sh "sed -i 's/tagversion/${env.BUILD_ID}/g' deployment.yaml"
			     sh "sed -i 's/amerisourcebergenapp/amerisourcebergenapp-dev/g' deployment.yaml"
			    echo '${env.BRANCH_NAME}'
			        echo '${env.CHANGE_ID}'
			sh "sed -i 's/tagversion/${env.BUILD_ID}/g' deployment.yaml"
			     //echo "Start deployment of serviceLB.yaml"
			    //step([$class: 'KubernetesEngineBuilder', projectId: env.PROJECT_ID, clusterName: env.CLUSTER_NAME, location: env.LOCATION, manifestPattern: 'serviceLB.yaml', credentialsId: env.CREDENTIALS_ID, verifyDeployments: true])
				 echo "Start deployment of deployment.yaml"
				 step([$class: 'KubernetesEngineBuilder', projectId: env.PROJECT_ID, clusterName: env.CLUSTER_NAME, location: env.LOCATION, manifestPattern: 'deployment.yaml', credentialsId: env.CREDENTIALS_ID, verifyDeployments: true])
			    echo "Deployment Finished ..."
		    }
	    }
	    
	       stage('Deploy to K8s Test') {
		    steps{
			    echo "Deployment started ..."
			     sh 'ls -ltr'
			     sh 'pwd'
			     sh "sed -i 's/tagversion/${env.BUILD_ID}/g' deployment.yaml"
			     sh "sed -i 's/amerisourcebergenapp/amerisourcebergenapp-test/g' deployment.yaml"
			    echo '${env.BRANCH_NAME}'
			        echo '${env.CHANGE_ID}'
			
			     //echo "Start deployment of serviceLB.yaml"
			    //step([$class: 'KubernetesEngineBuilder', projectId: env.PROJECT_ID, clusterName: env.CLUSTER_NAME, location: env.LOCATION, manifestPattern: 'serviceLB.yaml', credentialsId: env.CREDENTIALS_ID, verifyDeployments: true])
				 echo "Start deployment of deployment.yaml"
				 step([$class: 'KubernetesEngineBuilder', projectId: env.PROJECT_ID, clusterName: env.CLUSTER_NAME, location: env.LOCATION, manifestPattern: 'deployment.yaml', credentialsId: env.CREDENTIALS_ID, verifyDeployments: true])
			    echo "Deployment Finished ..."
		    }
	    }
	    

    }
}
