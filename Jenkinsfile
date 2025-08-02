
pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'
        jdk 'JDK 21'
    }

    environment {
        BUILD_ENV = 'dev'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Cloning source code...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Running mvn clean compile...'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo  'Running unit tests...'
                bat 'mvn test'
            }
            post {
                always {
                    echo 'Publishing test results...'
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging application...'
                bat 'mvn package -DskipTests'
            }
        }

        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                echo "Deploying build for ${BUILD_ENV} environment..."
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed. Please check logs.'
        }
    }
}
