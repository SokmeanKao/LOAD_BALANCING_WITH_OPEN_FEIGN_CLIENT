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
                sh 'chmod +x gradlew && ./gradlew clean build'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                script {
                    try {
                        sh 'docker build -t $DOCKER_IMAGE .'
                    } catch (Exception e) {
                        echo 'Docker build failed'
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the Docker container...'
                script {
                    try {
                        sh '''
                            docker stop $(docker ps -q --filter ancestor=$DOCKER_IMAGE) || true
                            docker run -d --rm --name spring-service $DOCKER_IMAGE
                        '''
                    } catch (Exception e) {
                        echo 'Deployment failed'
                    }
                }
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
