# osb12c-xquery-warmup
Recompile/warm-up any XQueries at runtime in the OSB 12c

# What is it
  - a simple application (packaged as EAR) deployed in OSB/WLS
  - activated when the OSB starting or XQuery is/was deployed (or if something is/was changed in XQuery and session is/was activated)
  - pre-compile/execute Xquery with dummy arguments - warm-up 

# Install
  - Download latest version of application...
  - Deploy it as enterprise application: _'Install this deployment as an application'_
  - Deployment Order: 20
  - Restart the OSB.

# Development
  - Build is based on the Maven
  - JVM 1.8
  - in pom.xml setup the following properties:
  
| Property        | Value       |
| ------------- |-------------| 
| wls12cHome | path to FMW WLS 12c home |
| common12cHome | path to FMW 12c Oracle Common home |
  - mvn clean install
