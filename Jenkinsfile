pipeline {
    agent any
    tools {
        maven 'M3'
        jdk 'Java11'
    }
    environment {
        imageName = "ravikantbits.azurecr.io/devops-assignment"
        registryCredential = 'act_ravikantbits'
        registryUrl = 'ravikantbits.azurecr.io'
        dockerImage = ''
    }
    stages {
        stage('Build') {
            steps {
                echo 'Build'
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'Test'
                sh 'mvn verify'
            }
        }
        stage ('Containerization') {
            steps {
                echo 'Containerization'
                script {
                    dockerImage = docker.build imageName
                    docker.withRegistry( "http://${registryUrl}", registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy'
            }
        }
    }
}
