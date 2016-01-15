# Site
Deployment and configuring on AWS

1 Log into https://us-west-1.console.aws.amazon.com/console
2 Select EC2 Virtual servers
3 Instances > create instance
4 Select ubuntu server
5 Select instance and follow steps
6 Create key pair and save in on your pc
7 In security groups open ports:
-22 for SSH
-8080 for application
8 Goto https://us-west-1.console.aws.amazon.com/console and select elastic beanstalk
9 create new environment
10 Make some changes:
in webapp/resources/script.js change url value to <instance DNS>:8080
11 upload project
  project structure:
  -src
  -pom
  -Buildfile (add line into file build: mvn clean install -Dmaven.test.skip=true)
  -Procfile (add line web: java -jar target/reigninwildWeb-0.0.1-SNAPSHOT.war)
Add this file to archive .zip
upload this file when selecting project
12 Wait until the project would be builded

Connecting to your ubuntu
setup putty
in address: ec2-user@<server DNS>
in connection-SSH-Auth open your .ppk key (key should be converted from .pem via puttygen)

To browse files on ubuntu server use WinSCP

