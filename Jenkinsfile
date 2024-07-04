pipeline {
    agent any

    stages {
        stage('Maven Version') {
            steps {
				 bat 'mvn -v'
            }
        }
        stage('Repo Cloning') {
            steps {
				git branch: 'main', credentialsId: 'f395ae1f-60bc-4001-9158-e90746d9faba', url: 'https://github.com/sadakar/scriptedpipeline.git'
            }
        }
        stage('Building and Testing') {
            steps {
					bat 'mvn test'
            }
        }
    }
}