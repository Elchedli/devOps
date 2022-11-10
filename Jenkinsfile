pipeline { 
    agent any 
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build Artifact') { 
            steps { 
		        sh 'mvn clean package' 
            }
        }
	    stage ('Deploy Artifact to Nexus') {
            steps {
                sh 'mvn deploy -DskipTests'
      	    }
    	}
        stage('SRC Analysis Testing') {
            steps {
        	    withSonarQubeEnv('sonarqube:8.9.7') { 
        		    sh "mvn sonar:sonar"
    		    }
            }
        }
	    stage('Start Containers') {
	        steps {
		        sh 'mvn docker-compose up'
	        }
	    }
    }
}
