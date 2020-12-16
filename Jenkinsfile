pipeline {
    agent any

    stages {

        stage('Pull') {
            steps {
                 git branch: 'main', url: 'https://github.com/endkarn/springboot-book-store'
            }
        }

        stage('Static Code Analysis') {
            steps {
                sh './gradlew check'
            }
        }

        stage('Run Unit Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Build Jar') {
            steps {
                sh './gradlew clean build'
            }
            post {
                success {
                    junit 'build/test-results/test/**.xml'
                    archiveArtifacts 'build/libs/*.jar'
                }
            }
        }

        stage('Build Docker Artifact') {
            steps {
                sh 'docker-compose build'
            }
        }

        stage('Setup Test Fixture') {
            steps {
                sh 'docker-compose up -d'
            }
        }

        stage('Run Acceptance Test') {
            steps {
                sh 'sleep 10'
                sh 'newman run book-store.postman_collection.json -e book-store-local.postman_environment.json'
            }
        }

        stage('Tear Down Service') {
            steps {
                sh 'docker-compose down'
            }
        }


    }
}
