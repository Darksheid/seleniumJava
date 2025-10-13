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

        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/Darksheid/seleniumJava.git', branch: 'master'
            }
        }

        stage('Build - Clean & Install') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Run Tests & Generate Reports') {
            steps {
                bat 'mvn clean verify'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'

                    //Publish the Cucumber overview-features.html report
                    publishHTML([
                        allowMissing: true,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'Results',
                        reportFiles: '**/overview-features.html',  // Matches timestamped folder
                        reportName: 'Cucumber HTML Report'
                    ])
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('MySonarQube') {
                    bat 'mvn sonar:sonar'
                }
            }
        }
    }

    post {
        success {
            echo 'Build, Tests, Reports & Sonar Analysis completed successfully!'
        }
        failure {
            echo ' Build failed. Check logs and reports for details.'
        }
        always {
            // Optional: archive full reports folder for download
            archiveArtifacts artifacts: 'Results/**', fingerprint: true
        }
    }
}
