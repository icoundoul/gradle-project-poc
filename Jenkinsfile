@Library('jenkins-sharedlibs-ci-linux') _

pipeline {
    agent { label 'slave_linux_sisn' }

    tools {
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
                checkoutBranch(BRANCH: env.BRANCH_NAME)
            }
        }

        stage('Build') {
            steps {
			 echo "In progress..."
              //gradleBuild();
            }
        }
    }
}

