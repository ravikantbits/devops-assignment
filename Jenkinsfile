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
        AZURE_SP = credentials('azure_sp')
        AZURE_RESOURCE_GROUP = 'devops-assignment'
        AZURE_STAGE_AKS = 'aks-stage'
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
                sh '''
                    az login --service-principal -u $AZURE_SP_CLIENT_ID -p $AZURE_SP_CLIENT_SECRET -t $AZURE_SP_TENANT_ID
                    az aks get-credentials --resource-group $AZURE_RESOURCE_GROUP --name $AZURE_STAGE_AKS
                    kubectl apply -f deployment.yml
                '''
            }
        }
    }
}
