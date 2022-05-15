Node("jdk1.8") {
    stage_1("source coede") {
        //cone the clode from repo//
        git branch: ' release1.0', url: 'https://github.com/spring-petclinic/spring-petclinic-microservices.git'
    }
    
    stage_2("Build the code") {
        mvn package
    }

    stage_3("junit test resut") {
        //test the result//
        junit '**/surefire-report/*.xml'
    }

    stage_4 ("archive the package") {
        //Archival of the package//
        archiveArtifacts artifacts: '**/*.war', followSymlinks: false

    }
}