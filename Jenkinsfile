pipeline {
    agent any
    tools {
        maven 'M3'
        jdk 'Java11'
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
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy'
            }
        }
    }
}
