
pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'
        jdk 'JDK 21'
    }

    environment {
        BUILD_ENV = 'dev'
		SONAR_TOKEN = credentials('sonar-token')
    }

    stages {

		
		stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('MySonarQube') {
                    sh 'mvn sonar:sonar -Dsonar.login=$SONAR_TOKEN'
                }
            }
        }

        stage('Quality Gate') {
            steps {
                waitForQualityGate abortPipeline: true
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
