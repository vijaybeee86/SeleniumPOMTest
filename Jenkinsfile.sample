pipeline {
    agent any

    stages {
        stage(Dev) {
            steps {
                echo ("Dev Build")
            }
        }
        
        stage(UnitTC) {
            steps {
                echo ("Run Unit TC")
            }
        }
        
            stage(QA) {
            steps {
                echo ("QA Deployment")
            }
        }
        
                stage(AutoTC) {
            steps {
                echo ("Run AutoTC")
            }
        }
        
                stage(Stage) {
            steps {
                echo ("Stage Deployment")
            }
        }
        
                stage(UAT) {
            steps {
                echo ("UAT Testing")
            }
        }
        
                stage(Prod) {
            steps {
                echo ("Prod Deployment")
            }
        }
    }
}
