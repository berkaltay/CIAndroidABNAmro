job('SeedJobs') {
    scm {
        git {
            remote {
                url('https://github.com/robinbowes/jenkins-job-dsl-seed-all-demo.git')
                credentials('bitbucket-ssh-login')
            }
            branch('master')
        }
    }
    steps {
        jobDsl {
            targets('jobs/*.groovy')
            ignoreExisting(true)
        }
    }
}