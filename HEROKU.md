# Deploying a Spring Boot application to Heroku via connecting to Github

To deploy this application to Heroku:

1. Create a Heroku account on the free plan.

   You should not need to enter a credit card, but you may need to verify your email.

   To avoid confusion, and ensure you get credit for your work, 
   please use your `___@ucsb.edu` email.

2. Login to your Heroku account and navigate to the Heroku Dashboard.

   Create a new Heroku Application with the *exact* name specified in the assignment.
   It is important to follow that naming convention to ensure that the graders can
   find your work.
   
3. Ensure that your repo contains a `Procfile` with appropriate contents, as explained below.

   A `Procfile` is a file simply called `Procfile` (exactly with that
   spelling, uppercase/lowercase, and no file extension, i.e. `Procfile`,
   not `Procfile.txt`).  It will contain something like this:

   ```
   web: java $JAVA_OPTS -jar target/demo-spring-backend-1.0.0.jar
   ```

   Here's the short explanation of how to check if the contents of this file are correct:

   * Do a `mvn clean package` in your repo
   * Then, type in the command you see *without* the `web:` and `$JAVA_OPTS` parts, e.g.
     ```
     java -jar target/demo-spring-backend-1.0.0.jar
     ```
     If this starts up the application on `http://localhost:8080` then the line is
     likely correct.

     If not, then see the longer explanation later in this file under
     "Explanation of the Procfile".
     
4. Navigate to the application you created on the Heroku Dashboard. 

   Navigate to <https://dashboard.heroku.com/> and login with your account.

   If not already there, select the application you created.

   You will see a `Deploy` tab.   Click on this, and you'll then see a GitHub button
   towards the middle of the screen. Click on this, and you'll have an opportunity to
   select your repo and connect it to the Heroku application.

   Once you've connected your repo, scroll down to the `Manual Deploy` section
   select the appropriate branch (likely `main`) and click `Deploy Branch`.

   This should launch a window where a log of the activity while deploying comes up.
   It may take a while (e.g. 5 minutes) before the process is finished.  When it is
   finished, you should be able to navigate to your repo either by pressing the
   `Open App` button at the upper right hand corner of the Dashboard interface, or
   by navigating to <https://your-app-name.herokuapp.com>.

  
# Explaining the `Procfile`

Here's a longer explanation of the `Procfile`:

* The `web: java JAVA_OPTS` part should always be present:
  * The name `web:` indicates that what follows is the command that should be used
    to start up the command. 
  * The `java` part indicates that we are starting up the Java Virtual Machine (JVM).
  * The `$JAVA_OPTS` part is necessary for Heroku to ensure that
    the the Java Virtual Machine (JVM) is configured appropriately for Heroku.

* The `-jar target/demo-spring-backend-1.0.0.jar` part should be changed based on the name of the
  the `.jar` file produced when you type `mvn package`.  This may change if the
  the `artifact` and/or `version` elements in the `pom.xml` are altered.

 
