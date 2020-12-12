# TacxAssignment (UI + API)
##  Short descreption about the framework :
I created the framework in Java as a **Cucumber/BDD** framework along with Gherkin language in feature files. I used **POM(Page Object Model)** and Singleton Design Patterns.
It includes both type of testings -> **UI+API**

### Tools used :

Tools | Purpose
------------ | -------------
Java | Main language
Maven | Build anagement tool to manage dependencies
Intellij | IDE
Cucumber | BDD Framework (Added as a dependency and as a plugin)
Gherkin | Used in feature files for scenarios (Added as plugin in IDE )
Selenium WebDriver | Used to automate browsers
JUnit | For assertions and annotations
REST Assured | For API testing
Jenkins | CI tool to run framework
Git&Github | Version Control System
Maven cucumber reporting | Generate reports
Maven surefire plugin | To manage runner classes/execute tests in parallel structure


### Design :
#### Page Object Model Design Pattern

Design of the framework is POM and Cucumber Behavior Driven Development framework. 

* **pages**
   - Basically I create Page Object Java Classes in **pages** package and each class represents a page in the application.  
   - I store all available WebElements by the help of **Page Factory** and methods in each class and I utilize them in Step Definitions.  
* **runners**
   - Runner classes are where I execute testing via Cucumber Options.  It includes **CukesRunner** and **FailedRunner**(to run failed cases) classes.
   - I am holding and managing some cucumber option features like **plugin**,**features**,**glue**,**tags** etc.
* **step_definitions**
   - Step Definition classes are in step_definitons package keeps respective behavioral steps regarding Feature File which is in resources directory. 
   - Inside this package I have **Hook** class and I am implementing @Before and @After annotations and taking SS if cases fail.
* **utilities**
   - Utilities package in which I store **Driver**(I created in Singleton Design Pattern), **BrowserUtils**(Methods in order to interract with browser when needed), **ConfigurationReader**(to read urls,credentials,keys,browser type and etc. from configuration.properties) classes has common ready methods that I’m implementing during creating test scripts.

* **resources**
   - docs (To hold some docs)
   - features
     - Feature File represents the scenarios written in Gherkin language from end-user perspective. 
   
* **configuration.properties**
   - Configuration properties file is keeping data like urls,credentials,keys,browser type based on key and value structure.
  


- **Maven** is used as a build managemet tool and it helps me to manage the dependencies. It gives me the option that I can execute my scripts from terminal or from a CI tool.

- **Rest-Assured** is used to test out REST based services. I can validate and/or verify the responses of requests. I created another feature file for API testing inside the framework -> **backendAssesment.feature**

- **Git&Github** is used as VCS.


### Jenkins 

* Jenkins is used as CI tool to automate and execute my framework.
If I have a Jenkins runnning on an EC2 machine I can use that IP and port number to reach Jenkins. If I dont, I can download and run it locally. 

#### Steps to run and execute the framework on Jenkins :
   - Download Jenkins.raw file inside the project folder.
   - In terminal go to that folder and execute the code below
     - [java -jar jenkins.war -httpPort=8080 --enable-future-java] -> Jenkins will start to listen localhost:8080 port
   - Open Jenkins on localhost:8080 and from ``Manage Jenkins -> Configure System`` , ``Manage Jenkins -> Global Tool Configuration`` I need to adjust settings for me, from ``Manage Jenkins -> Manage Plugin`` I need to add plugins like **Cucumber Reports** and **Email Extension Plugin**.

#### Steps to create a job :
   - Click ``New Item`` to create a Freestyle Project click ``OK``.
   - It opens the configure page.
   - In ``Source Code Management`` click ``Git`` radio button and provide the github repo in``Repositories``, credentials in ``Credentials`` and branch in ``Branches`` to build.
   - We can add a ``Build Triggers`` if we want to but this project I didn't add (E.g. ``Build periodically`` -> Everyday at 08:00 -> ```H 8 * * *```)
   - In ``Build`` I added ``Invoke top-level Maven target`` plugin to run my framework with a maven command -> ```verify```
   - In ``Post-build Actions`` I added ``Cucumber Reports`` and ``Editable Email Notification`` plugins.
     - In ``Editable Email Notification`` plugin, I added email in ``Project Recipient List`` to send notifications for test results.
     - I select ``Content Type`` as ``HTML``.
     - I added default content as below to receive email notification fancy :
     

```$DEFAULT_CONTENT
<br/>
<h4>Cucumber report:</h4>
<br/>
<a href="http://localhost:8081/job/TacxAssignment/${BUILD_NUMBER}/cucumber-html-reports/overview-features.html">Test Results</a>

```

   - In ``Advanced`` settings I added ``Triggers`` to send the email notifications in case of occurance of these issues. 
   - Triggers
     - Always
       - Send to ``Developers`` or ``Recipient List``
     - Failure - Any
       - Send to ``Developers`` or ``Recipient List`` ...


At the end click to ```SAVE``` it 

Go to ```Dashboard``` and click on the Jenkins job -> click ```Build``` now, Jenkins will run it and I can see Console Output and Cucumber results at the end of execution.


When I want to run in a different way, I don't need to change my scripts. I can change only run command in ``Invoke top-level Maven target``. For example :

* ```mvn verify -Dcucumber.options=“--tags @smoke” -Dbrowser=firefox ```
