pipeline {
    agent any
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
                sh 'mvn -B -Dmaven.test.skip=true clean package'

            }
        }
        stage('Deliver') {
                    agent {
                        dockerfile {
                            dir '/var/jenkins_home/workspace/mvnPipeline'
                            label 'mvnimg'
                        }
                    }
                    steps {
                        echo "+++++++++++++++++ Deliver ++++++++++++++++++ "
                        dir('./var/jenkins_home/workspace/mvnPipeline') {
                            sh "pwd"
                        }
                        sh 'pwd'
                        sh 'docker container ls'
                        //sh 'docker build . --file  --tag mvnimg'
                        sh 'docker rm -f mvncont || true'
                        sh 'docker run --restart -p 3000:3000 --name mvncont mvnimg'
                    }
        }
    }
}