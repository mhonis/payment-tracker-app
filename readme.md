#Payment Tracker
Welcome to the implementation of a **"Payment Tracker"** application, based on a task given to applicants 
for backend development positions @ BSC.

##Assumptions
A few things were assumed regarding the implementation, as they were not fully covered in the specification.
Assumptions were made towards better user experience and ease of use.
* Application assumes the currency code can be any 3 uppercase letter combination; the application does not verify, 
whether it is an existing currency
* File loading on startup is realized using a **"load"** command, which, followed by a filename of full file path, 
will load the file data into application's memory. This command can be used any time during application runtime. However, 
this action overwrites any existing data in the app's memory and replaces them with data from the specified file.
* Application is supplied with a set of simple commands for user's comfort. A list of these commands and their 
descriptions can be seen using the **"help"** command. Commands are case insensitive.

##Requirements & instructions
###How to build
To build and run the application, **Java 8** (and higher) and **Maven 3** installed is required. Java IDE is optional, 
but recommended You can build the app using Maven command"**mvn install**", which builds the app, runs unit tests 
and produces a jar file in **/target/payment-tracker-app-1.0-SNAPSHOT.jar**

###How to run
Jar file can be executed from from a command line via java: "java -jar payment-tracker-app-1.0-SNAPSHOT.jar"
After startup, the user can then type their input into the command line.


Any feedback regarding the implementation is welcome and appreciated.
I hope you enjoy this little application!