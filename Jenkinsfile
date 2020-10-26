pipeline {
	agent any
	
	stages {
		stage('Build') {
			agent {
				docker {
					image 'maven:3-jdk-8-alpine'
					args '-v /root/.m2:/root/.m2'
				}
			}
			
			steps {
				dir('CICD_JNDI_Docker_Example') {
					sh 'mvn clean package'
					sh 'mv target/CICD_JNDI_Docker_Example.war .'
					stash name: 'war', includes: 'CICD_JNDI_Docker_Example.war' , allowEmpty: false
				}
				
				stash name: 'xml', includes: 'context.xml' , allowEmpty: false
				stash name: 'yml', includes: 'docker-compose.yaml' , allowEmpty: false
				stash name: 'df', includes: 'Dockerfile' , allowEmpty: false
			}
		}
		
		stage('Deploy') {
			agent {
				docker {
					image 'docker/compose:alpine-1.27.4'
				}
			}
			steps {
				unstash 'war'
				unstash 'xml'
				unstash 'yml'
				unstash 'df'
				sh 'docker-compose build'
				sh 'docker-compose up -d'
			}
		}
	}
}