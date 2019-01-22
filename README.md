# Simple Servlet Demo

This is a simple example to show how to set up a minimalist implementation using the Java Servlet framework.

## Requirements

This is a Git repo. 
To run it you need [Java 8][2], [Maven][3] and (optionally) [Intellij][4]. 

# Get started

Clone the repo. 
Import the project as a Maven project into IntelliJ.
Build the project. Then run it. 

The first time this may take a while as a lot of dependencies need to be installed.  Future runs will be quicker.

There will be a lot of console output finishing with:

    INFO: Dev App Server is now running

By default you are running from the address `http://localhost:9000` on the development server. All the paths below are relative to this, which may differ for you if you change it.

Now open a web browser and go to: `http://localhost:9000/a/b/c`. You will see a message:

    Welcome, your shop is called Demo Shop and your path is /a/b/c
    
## Technology stack in the starter

The starter uses [Jetty][1] to run an embedded web server.

The main class is Runner.java. This starts an embedded Jetty Server. 

The single servlet at this stage is DemoServlet.java.

[1]: https://eclipse.org/jetty/
[2]: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[3]: http://maven.apache.org/download.cgi
[4]: http://www.jetbrains.com/idea/
[5]: https://github.com/google/guice/wiki/GettingStarted
[6]: https://github.com/google/guice/wiki/Servlets