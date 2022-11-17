pipeline { 
    agent any 
    options {
        skipStagesAfterUnstable()
    }
	environment {
        DOCKERHUB_CREDENTIALS=credentials('docker-hub')
    }
    stages {
        // stage('SRC Analysis Testing') {
        //     steps {
        // 	    withSonarQubeEnv('sonarqube:8.9.7') { 
        // 		    sh "mvn sonar:sonar"
    	// 	    }
        //     }
        // }
        
        stage('Build Artifact') { 
            steps { 
		        sh 'mvn clean package' 
            }
        }

	    // stage ('Deploy Artifact to Nexus') {
        //     steps {
        //         sh 'mvn deploy -DskipTests'
      	//     }
    	// }
		
		// stage('Building Docker Image'){
 		// 	  steps {
        //               sh 'docker build -t yassinekaroui/tpachat .'
        //        }
 		// }

 		// stage('Pushing Docker image') {
        //      steps {
        //          sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
        //          sh 'docker push yassinekaroui/tpachat'
        //          }
 		// }
	    stage('Start Containers') {
	        steps {
		        sh 'docker-compose up -d'
	        }
	    }
    }
}
