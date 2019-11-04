// -----------------------------------------------------------------------------------------
// ----------------------------------Payment Tracker
// ------------------------------------------
// -----------------------------------------------------------------------------------------

Welcome to the implementation of a "Payment Tracker" application, based on a task given to applicants for backend development positions @ BSC.


// -----------------------------------------------------------------------------------------
// ------------------------------------ Assumptions
// --------------------------------------------
// -----------------------------------------------------------------------------------------

* Application assumes the currency code can be any 3 uppercase letter combination; the application does not verify whether it is an existing currency
* File loading on startup is realized using a "load" command, which, followed by a filename of full file path, will load the required data into memory.
  This command can be used any time during application runtime. However, this action overwrites any existing data in the app's memory and replaces them with data from the specified file.
* Application is supplied with a set of simple commands for user's comfort. A list of these commands and their descriptions can be seen using
  the "help" command. Commands are case insensitive.


// -----------------------------------------------------------------------------------------
// ----------------------------- Requirements & instructions
// --------------------------------------------
// -----------------------------------------------------------------------------------------

To build and run the application, Java 8 and Maven installed is necessary. You can build the app using maven command
"mvn install", which builds the app, runs unit tests and produces a jar file in /target/payment-tracker-app-1.0-SNAPSHOT.jar

Jar file can be executed from command line via java - "java -jar payment-tracker-app-1.0-SNAPSHOT.jar"