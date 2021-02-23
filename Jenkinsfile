//@Library('jenkins-sharedlibs-ci-linux') _

pipeline {
    agent any

    tools {
	maven 'maven-3.6.0'
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
    }
}

