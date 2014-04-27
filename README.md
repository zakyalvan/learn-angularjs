learn-angularjs
===============

Learn angularjs with spring framework based app as rest back-end. Implicitly using websocket as a notification mechanism on entity state change to all clients (browser base), next we should narrow down the notification targets to interested parties only. This simple app based on tutorial found at http://g00glen00b.be/spring-websockets/ created with minor change.

Note for web-socket-message-broker configurations, based on discussions found at http://stackoverflow.com/questions/22925951/could-not-autowire-no-beans-of-simpmessagingtemplate-type-found, web-socket-message-broker should be configured in root web application context instead of dispacher servlet application context (The later causing spring-messaging's SimpMessagingTemplate could not be found at application context).

Clone and execute mvn jetty:run command via terminal on root project directory, please make sure maven3 installed on your machine. Open http://localhost:8080 on browser after jetty servlet container completelly started.


