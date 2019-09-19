# recruitment-task
Tobe able to run the project follow the instructions below

1.Navigate to root of the project

2.Build the project(mvn clean install)

3.Build docker image(docker build -t greeting-docker.jar .)

4.Run docker(docker run -p 5000:8080 greeting-docker.jar)

5.Go to your browser and use this URL=http://localhost:5000/greeting

*Consider that you should specify http headers(account,id,type)