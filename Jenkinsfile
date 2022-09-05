pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.8.1-adoptopenjdk-11'
                    args '-v /root/.m2:/root/.m2'

                }
            }
            steps {
                echo "+++++++++++++++++ Build +++++++++++++++++++++++++"
                sh 'mvn -B -DskipTests clean package'
                sh 'docker build -t mvnImg'
            }
        }
        stage('Deliver') {
                    steps {
                        echo "+++++++++++++++++ Deliver ++++++++++++++++++"
                        sh 'docker rm -f mvnCont || true'
                        sh 'docker run --restart -p 3000:3000 --name mvnCont mvnImg'
                    }
        }
    }
}