pipeline {

    // run on jenkins nodes tha has java 8 label
    agent {
        label 'java8'
        docker {
                    image 'maven:3.8.1-adoptopenjdk-11'
                    args '-v /root/.m2:/root/.m2'
                }

    }
    // global env variables
    stages {

        stage('Build with unit testing') {
            steps {
                // Run the maven build

                script {
                    // Get the Maven tool.
                    // ** NOTE: This 'M3' Maven tool must be configured
                    // **       in the global configuration.
                    echo 'Pulling...' + env.BRANCH_NAME

                }
                sh 'mvn clean package -Dmaven.test.skip=true'

            }
        }

    }

}