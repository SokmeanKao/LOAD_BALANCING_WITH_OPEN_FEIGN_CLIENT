pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "jenkins-image"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/SokmeanKao/LOAD_BALANCING_WITH_OPEN_FEIGN_CLIENT.git',
                    credentialsId: 'github-credentials'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the Spring Boot project...'
                sh './gradlew clean build'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                sh '''
                    docker build -t $DOCKER_IMAGE .
                    docker images | grep $DOCKER_IMAGE
                '''
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the Docker container...'
                sh '''
                    docker stop $(docker ps -q --filter ancestor=$DOCKER_IMAGE) || true
                    docker run -d --rm --name spring-service $DOCKER_IMAGE
                '''
            }
        }
    }

    post {
        success {
            echo 'Build and deployment completed successfully.'
        }
        failure {
            echo 'Build or deployment failed.'
        }
    }
}
