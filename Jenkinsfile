pipeline {
    agent any
    // DELETE these lines
    /* tools {
        // Ensure 'Maven-3' and 'JDK-21' are configured in Jenkins Global Tool Configuration
        maven 'Maven-3'
        jdk   'JDK-21'
    } */

    parameters{
        booleanParam(defaultValue: false, description: "Enable services?", name: "myBoolean")
        string(defaultValue: "TEST", description: "Which environment would you like to deploy", name: "deployEnv")
    }

    environment {
        // Skip Maven test execution across all modules
        MAVEN_OPTS = '-Dmaven.test.skip=true'
    }

    options {
        // Keep only the last 10 builds
        buildDiscarder(logRotator(numToKeepStr: '10'))
        // Abort if the build takes more than 30 minutes
        timeout(time: 59, unit: 'MINUTES')
        // Prevent concurrent builds of the same branch
        disableConcurrentBuilds()
        timestamps()
    }

    stages {
        stage("Clean up") {
            steps {
                echo '========== This is a Clean up section ========='
            }
        }

        stage('Checkout') {
            steps {
                echo '========== Checking out source code =========='
                checkout scm
            }
        }

        stage('Build & Package - Spring-Core') {
            steps {
                echo '========== Building Spring-Core modules =========='
                dir('Spring-Core') {
                    sh 'mvn clean package -DskipTests -Dmaven.test.skip=true --no-transfer-progress'
                }
            }
        }

        stage('Build & Package - Spring-Boot-Tutorials') {
            steps {
                echo '========== Building Spring-Boot-Tutorials modules =========='
                dir('Spring-Boot-Tutorials') {
                    sh 'mvn clean package -DskipTests -Dmaven.test.skip=true --no-transfer-progress'
                }
            }
        }

        stage('Build & Package - Spring-Hibernate-Tutorials') {
            steps {
                echo '========== Building Spring-Hibernate-Tutorials modules =========='
                dir('Spring-Hibernate-Tutorials') {
                    sh 'mvn clean package -DskipTests -Dmaven.test.skip=true --no-transfer-progress'
                }
            }
        }

        stage('Build & Package - Spring-Cloud-Tutorials') {
            steps {
                echo '========== Building Spring-Cloud-Tutorials modules =========='
                dir('Spring-Cloud-Tutorials') {
                    sh 'mvn clean package -DskipTests -Dmaven.test.skip=true --no-transfer-progress'
                }
            }
        }

        stage('Build & Package - Spring-Security-Fundamentals') {
            steps {
                echo '========== Building Spring-Security-Fundamentals modules =========='
                dir('Spring-Security-Fundamentals') {
                    sh 'mvn clean package -DskipTests -Dmaven.test.skip=true --no-transfer-progress'
                }
            }
        }

        stage('Archive Artifacts') {
            steps {
                echo '========== Archiving build artifacts =========='
                archiveArtifacts(
                    artifacts: '**/target/*.jar, **/target/*.war',
                    allowEmptyArchive: true,
                    fingerprint: true
                )
            }
        }

        stage("Demo"){
            steps{
                echo "boolean param is set to: ${params.myBoolean}"
                echo "Environment details : ${params.deployEnv}"
            }
        }
    }

    post {
        success {
            echo "=========================================="
            echo " BUILD SUCCESSFUL"
            echo " Branch  : ${env.BRANCH_NAME ?: 'N/A'}"
            echo " Build # : ${env.BUILD_NUMBER}"
            echo "=========================================="
        }
        failure {
            echo "=========================================="
            echo " BUILD FAILED"
            echo " Branch  : ${env.BRANCH_NAME ?: 'N/A'}"
            echo " Build # : ${env.BUILD_NUMBER}"
            echo " Check console output for details."
            echo "=========================================="
        }
        always {
            echo '========== Cleaning up workspace =========='
            cleanWs()
        }
    }
}
