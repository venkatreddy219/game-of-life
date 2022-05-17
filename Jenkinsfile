pipeline {
    agent {label 'jdk1.8'}
    options {
        timeout(time: 1, unit: 'HOURS') 
    }
    triggers {pollSCM('10 * * * 1-5')}
    parameters {
        choice (name: 'GOAL', choices: ['compile', 'package', 'clean'], description: 'Run on specific platform')
    }
    stages {
        stage ('sourece code') {
            steps {
                git url: 'https://github.com/venkatreddy219/game-of-life.git',
                branch 'main'
            }
        }
        stage ('build the code') {
            steps {
                sh script : "mvn ${params.GOAL}"
            }
        }
        stage ('archive the code') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar, target/*.war'
            }
        }
        stage ('junit test logs'){
            steps {
                junit testResults: 'target/surefire-reports/*.xml'
            }
        }
    }
        
}
post {
    success {
        echo "build comepleted success fully"
    }
    unsuccessful {
        echo "Build failed"
    }
}