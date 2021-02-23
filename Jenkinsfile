//@Library('jenkins-sharedlibs-ci-linux') _

pipeline {
    agent any

    tools {
	maven 'maven-3.6.0'
	gradle 'gradle-6.8.2'
	jdk 'jdk-8'
    }

    options {
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '3', artifactNumToKeepStr: '3'))
    }
	
	triggers {
        pollSCM 'H/59 * * * *'
    }

    stages {
        stage('Clean') {
            steps {
                deleteDir()
            }
        }

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
	      sh 'chmod +x ./gradlew'
	      sh './gradlew clean build'
            }
        }

	/*stage('Publish Artifact to Nexus') {
            steps {
                sh './gradlew publish --no-daemon'
            }
        }*/


    }
}

