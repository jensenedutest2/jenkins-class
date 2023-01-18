pipeline {
    agent { label 'agent1' }

    tools {
        // Run the Maven installation named "3.8.7" and add it to the path.
        maven "3.8.7"
    }

    stages {
        stage('clean and checkout') {
            steps {
                sh 'mvn clean'
                echo 'downloading github project...'
                git credentialsId: 'jensenedutest2', url: 'https://github.com/jensenedutest2/jenkins-class.git'
            }
        }

        stage('build') {
            steps {
                echo 'building...'
                sh 'mvn test-compile'
                echo 'finished building'
            }
        }

        stage('test') {
            steps {
                echo 'starting test.....'
                sh 'mvn surefire:test'
                echo 'finished test'
            }
        }

        stage('package') {
            steps {
                echo 'packaging...'
                sh 'mvn jar:jar'
                echo 'packaged'
            }
        }
    }

    post {
        always {
            echo 'generating test report....'
            junit 'target/*reports/**/*.xml'
            echo 'test report generated'
        }
    }
}
