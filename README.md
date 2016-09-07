# Commands
mvn clean package
mvn wildfly-swarm:run
java -agentlib:jdwp=transport=dt_socket,address=8787,server=y,suspend=y -jar primus-backend-swarm.jar

# URL
http://localhost:8080/rest/swagger.json

# Chrome Plugins
https://augury.angular.io/
https://github.com/mshauneu/chrome-swagger-ui

# Info
http://ksoong.org/wildfly-swarm