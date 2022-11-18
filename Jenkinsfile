pipeline { 
    agent any 
    options {
        skipStagesAfterUnstable()
    }
	environment {
        DOCKERHUB_CREDENTIALS=credentials('docker-hub')
    }
    stages {
         stage('Git checkout') {
            steps {
                git branch: 'yassine', url: 'https://github.com/Elchedli/devOps.git',credentialsId:'test-credential'          
            }
        }

        stage ('Unit Testing') {
            steps {
                sh 'mvn test';
            }
        }
        
        stage('SRC Analysis Testing') {
            steps {
        	    withSonarQubeEnv('sonarqube:8.9.7') { 
        		    sh "mvn sonar:sonar"
    		    }
            }
        }
        
        stage('Build Artifact') { 
            steps { 
		        sh 'mvn clean package' 
            }
        }

        stage('Building Docker Image'){
 			  steps {
                      sh 'docker build -t yassinekaroui/tpachat .'
               }
 		}

	    stage ('Deploy Artifact to Nexus') {
            steps {
                sh 'mvn deploy -DskipTests'
      	    }
    	}
		
 		stage('Deploy Image to DockerHub') {
             steps {
                 sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
                 sh 'docker push yassinekaroui/tpachat'
                 }
 		}
	    stage('Start Containers') {
	        steps {
		        sh 'docker-compose up -d'
	        }
	    }
    }
    post {
       always {
          mail to: 'karoui.yassine@esprit.tn',
             subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
             body: "${env.BUILD_URL} has result ${currentBuild.result}"
       }
     }

}

