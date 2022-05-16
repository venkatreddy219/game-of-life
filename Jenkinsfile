pipeline {
    agent {label 'kdk8'}
    options {
        timeout(time: 3, unit: 'HOURS')
    }
    triggers {
        cron('H * * * *')
    }
    tool {
        maven 'Apache Maven 3.8.5'
    }

    stages {
        stage('Source code') {
            steps {
                git url: 'https://github.com/venkatreddy219/spring-petclinic.git',
                branch: 'sprint1_v1'
            }          
        }
        stage ('Example'){
            steps {
                sh 'mvn --version'
            }
        }
        stage ('Build the code') {
            steps {
                sh 'mvn package'
            }            
        }
        stage ('Archive the artifacts') {
            steps {
                archiveArtifacts artifacts: '**/*.war'
            }
        }
        stage ('Publish junit test results') {
            steps {
                junit testResults:'/target/surefire-reports/*.xml'
            }            
        }
       
    }
}
post {
    success{
        //send the email//
        echo "Build success"
    }
    unsuccssfull {
        //send the email build failed//
        echo "buid failed"
    }
}