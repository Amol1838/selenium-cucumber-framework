pipeline {
    agent any
    triggers {
        // This makes Jenkins listen to ABC’s webhook
        githubPush()
    }
    stages {
        stage('Checkout Automation Repo') {
            steps {
                // Pull XYZ repo (automation code)
                git branch: 'master', url: 'https://github.com/Akshay9522/Practice.git'
            }
        }
        stage('Run Automation') {
            steps {
                echo 'Running automation from Repo XYZ...'
                sh './run-automation.sh'   // Example automation script
            }
        }
    }
}
