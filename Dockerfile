FROM openjdk:18
COPY build/libs/jiobit-assessment-0.0.1-SNAPSHOT.jar jiobit-assessment.jar
ENTRYPOINT ["java","-jar","/jiobit-assessment.jar"]
