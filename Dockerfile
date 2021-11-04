FROM jenkins/jenkins:lts-jdk11

USER root

COPY plugins.txt /usr/share/jenkins/plugins.txt
COPY jenkins-casc.yaml /usr/local/jenkins-casc.yaml
COPY SeedJobs.groovy /usr/local/SeedJobs.groovy

RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/plugins.txt

RUN apt-get update && apt-get install -y ca-certificates curl

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
ENV CASC_JENKINS_CONFIG /usr/local/jenkins-casc.yaml