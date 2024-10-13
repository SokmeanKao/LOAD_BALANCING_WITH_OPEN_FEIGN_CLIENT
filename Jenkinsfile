pipeline {
    agent any
    environment {
        DOCKER_IMAGE = "asd-image" // Update with your image name
    }
    stages {
        stage('Clone Repository') {
            steps {
                echo 'Cloning repository...'
                git credentialsId: 'github-credentials', url: 'https://github.com/SokmeanKao/LOAD_BALANCING_WITH_OPEN_FEIGN_CLIENT.git'
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
                not {
                    failed()
                }
            }
            steps {
                echo 'Building Docker Image...'
                sh 'docker build -t ${DOCKER_IMAGE} .'
            }
        }
        stage('Deploy') {
            when {
                not {
                    failed()
                }
            }
            steps {
                echo 'Deploying application...'
                // Add your Docker run or deployment logic here, e.g.,:
                // sh 'docker run -d --name app-container ${DOCKER_IMAGE}'
            }
        }
    }
    post {
        always {
            echo 'Pipeline finished.'
        }
        failure {
            echo 'Build or deployment failed.'
        }
    }
}
