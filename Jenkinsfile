pipeline {
    agent {label 'agent'} 
  

     
    stages {
       stage('Compilation du Projet'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/oussama']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Elchedli/devOps']]])
             sh 'mvn clean install'
            }  
        }   		
        /*stage('Build Artifact') {
            steps {
              sh "mvn clean package -DskipTests=true"
              archive 'target/*.jar' //so that they can be downloaded later
            }
        } */  
        
     
        
        stage('Package') {
            steps {
                sh 'mvn package'
                // bat '.\\mvnw package'
            } 
        }
       
      	
        stage('MOCKITO + JUnit') {
            steps {
           sh 'mvn clean test -Dtest=com.esprit.examen.services.SecteurActiviteServiceImplTest' 
            }
        }

        stage('Jacoco') {
            steps {
                sh 'mvn clean jacoco:prepare-agent package' 
            }
        }

        stage('Build image') {
            steps {
                sh "docker build -t tpachat ."
            }
        }

        stage('NEXUS'){
            steps{
                sh "mvn deploy -DskipTests=true"
            }
        } 

        stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar  -Dsonar.login=admin -Dsonar.password=admin'
                
            }
        } 

       
    }
       post {
                success {
                     mail to: "oussama.zribi@esprit.tn",
                     subject: "success",
                     body: "success on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL}"
                }
        failure {
                    mail to: "oussama.zribi@esprit.tn",
                     subject: "Failure",
                     body: "Failure on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL} "     
                }
            }
}



