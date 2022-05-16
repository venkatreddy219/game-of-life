pipeline {
    agent { label 'JDK1.8'}

    options {
        timeout(time: 1, unit: 'HOURS')
    }

    triggers {
        cron('H * * * *')

    }
    stages {
        stage('Source code') {
            steps
            git url: 'https://github.com/venkatreddy219/spring-petclinic.git'
                branch : 'main'
        }
        stage ('Build the code') {
            steps {
                sh script : 'mvn clean packag'
            }
            
        }
        stage ('Archive the artifacts') {
            steps {
                archiveArtifacts: '**/*.war'
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
        echo "Build success full"
    }
    unsuccssfull {
        //send the email build failed//
        echo "buid failed"
    }
}