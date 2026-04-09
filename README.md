# Bank_account

Experiment-11

in vs-code:

https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.1/junit-platform-console-standalone-1.10.1.jar


javac -cp ".;lib\junit-platform-console-standalone-1.10.1.jar" -d bin Calculator.java CalculatorTest.java


java -jar lib\junit-platform-console-standalone-1.10.1.jar --class-path bin --scan-class-path --details=tree


Experiment-12

Experiment-13

Experiment-14

Jacoco Dependency-file:

<!-- ADD THIS PART -->
  <plugins>
    <plugin>
      <groupId>org.jacoco</groupId>
      <artifactId>jacoco-maven-plugin</artifactId>
      <version>0.8.11</version>

      <executions>
        <!-- Attach JaCoCo agent -->
        <execution>
          <goals>
            <goal>prepare-agent</goal>
          </goals>
        </execution>

        <!-- Generate coverage report -->
        <execution>
          <id>report</id>
          <phase>test</phase>
          <goals>
            <goal>report</goal>
          </goals>
        </execution>
      </executions>

    </plugin>
  </plugins>



  Experiment-16

  Dockerfile

FROM eclipse-temurin:17
WORKDIR /app
COPY . /app
RUN javac Sample.java
CMD ["java", "Sample"]

docker build -t myjavaapp .

docker run myjavaapp


Experiment-17

docker pull nginx

docker volume create myvolume

docker run -d -p 8080:80 -v myvolume:/usr/share/nginx/html --name mycontainer nginx

if port not avaiable:

docker rm mycontainer

docker run -d -p 8081:80 -v myvolume:/usr/share/nginx/html --name mycontainer nginx

Experiment-18

Dockerfile

FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY . /app
RUN javac Sample.java
CMD ["java", "Sample"]

docker build -t java-app 

docker login

docker tag java-app yourusername/java-app:v1

docker push yourusername/java-app:v1

Experiment-19:

docker build -t myjenkinsapp .

docker run -d -t java-app



  Experiment-20:



  Experiment 20: Simple End-to-End CI/CD Pipeline
Objective: To understand the DevOps lifecycle by building a simple end-to-end CI/CD pipeline using Jenkins and Docker.
Prerequisites

Procedure / Tasks

Step 1: Create a Git Repository
•	Add application code 
•	Include a Dockerfile 
•	Include a Jenkinsfile
•	Include pom.xml

jenkins-tomcat-maven-tested	
│
├── src/main/java/com/bnmit/HelloServlet.java
├── src/main/webapp/index.jsp
├── src/main/webapp/WEB-INF/web.xml
├── pom.xml
├── Jenkinsfile
└── README.txt

•	Java Servlets code (HelloServlet.java)
package com.example;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Deployment Successful!</h2>");
        out.println("<h3>GitHub: &rarr; Jenkins: &rarr; Docker: &rarr; Tomcat</h3>");
    }
}
Web.xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
version="3.1">
<servlet>
<servlet-name>HelloServlet</servlet-name>
<servlet-class>com.example.HelloServlet</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>HelloServlet</servlet-name>
<url-pattern>/hello</url-pattern>
</servlet-mapping>
</web-app>


Index.jsp
<html>
<head>
<title>CI/CD Demo</title>
</head>
<body>
<h1>Welcome to CI/CD Pipeline Demo</h1>
<a href="hello">Click Here</a>
</body>
</html>


HelloServletTest.java

package com.example;
import static org.mockito.Mockito.*;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
public class HelloServletTest {
    @Test
    void testDoGet() throws Exception {
        // Create servlet instance
        HelloServlet servlet = new HelloServlet();
        // Mock request and response
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        // Capture output
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        // Call servlet method
        servlet.doGet(request, response);
        writer.flush();
        String result = stringWriter.toString();
        // Assertions
        assert(result.contains("Deployment Successful!"));
        assert(result.contains("GitHub"));
        assert(result.contains("Jenkins"));
        assert(result.contains("Docker"));
        assert(result.contains("Tomcat"));
        // Verify response type set
        verify(response).setContentType("text/html");
    }
}
________________________________________
Step 2: Create Freestyle Job
•	Open Jenkins Dashboard 
•	Click New Item → Freestyle Project 
________________________________________
Step 3: Configure Pipeline Script (Jenkins File) in Github

✅ Complete CI/CD Pipeline 
pipeline {
    agent any
    tools {
        maven 'mymaven'
        jdk 'myjdk'
    }
    environment {
        IMAGE_NAME = "sample-webapp"
        CONTAINER_NAME = "sample-webapp-container"
    }
    stages {
        stage('Clone') {
            steps {
                echo 'Cloning repository'
            }
        }

        stage('Build WAR') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                bat 'docker build -t  sample-webapp .'
            }
        }
        stage('Stop Old Container') {
            steps {
                bat 'docker stop sample-webapp-container || exit 0'
                bat 'docker rm sample-webapp-container || exit 0'
            }
        }
        stage('Run Container') {
            steps {
                bat 'docker run -d -p 8087:8087 --name  sample-webapp-container sample-webapp '
            }
        }

    }
}


Dockerfile

FROM tomcat:9.0

COPY target/sample-webapp.war /usr/local/tomcat/webapps/

EXPOSE 8080

Step 4: Run the Pipeline
•	Click Build Now 
•	Monitor in Console Output 
________________________________________
Step 5: Verify Deployment
Check running containers:
docker ps
Access application using two ways:
1.download the generated war file from jenkins and deploy it to tomcat server 
Install tomcat
Then access it using localhost
http://localhost:8087

go to Manager App in tomcat

Click on WAR file to deploy Choose file and select the war file downloaded
Click on Deploy
 
 

2. Access using Localhost
http://localhost:8087

