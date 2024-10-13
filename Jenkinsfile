pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "my-image" // Update with your Docker image name
    }

    stages {
        stage('Clone Repository') {
            steps {
                echo 'Cloning repository...'
                git credentialsId: 'github-credentials',
                    url: 'https://github.com/SokmeanKao/LOAD_BALANCING_WITH_OPEN_FEIGN_CLIENT.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the Spring Boot project...'
                sh './gradlew clean build -x test'
            }
        }

        stage('Build Docker Image') {
            when {
                expression { currentBuild.currentResult == 'SUCCESS' }
            }
            steps {
                echo 'Building Docker Image...'
                sh 'docker build -t ${DOCKER_IMAGE} .'
            }
        }

        stage('Deploy') {
            when {
                expression { currentBuild.currentResult == 'SUCCESS' }
            }
            steps {
                echo 'Deploying application...'
                // Add your deployment command here, e.g., docker run:
                // sh 'docker run -d --name app-container ${DOCKER_IMAGE}'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution finished.'
        }
        failure {
            echo 'Build or deployment failed.'
        }
    }
}
