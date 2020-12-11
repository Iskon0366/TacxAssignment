# TacxAssignment (UI + API)
##  Short descreption about the framework :
I created the framework in Java as a **Cucumber/BDD** framework along with Gherkin language in feature files. I used **POM(Page Object Model)** and Singleton Design Patterns.
It includes both testing -> **UI+API**

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

* Steps to run and execute the framework on Jenkins :
   - Download Jenkins.raw file inside the project folder.
   - In terminal go to that folder and execute the code below
     - [java -jar jenkins.war -httpPort=8080 --enable-future-java] -> Jenkins will start to listen localhost:8080 port
   - 

mvn verify -Dcucumber.options=“--tags @smoke” -Dbrowser=firefox 

![GitHub Logo]()
Format: ![Alt Text](url)

http://github.com - automatic!
[GitHub](http://github.com)

* Item 1
* Item 2
 * Item 2a
 * Item 2b
 
1. Item 1
2. Item 2
3. Item 3
 * Item 3a
 * Item 3b
 
 *This text will be italic*
_This will also be italic_
**This text will be bold**
__This will also be bold__
*You **can** combine them*

As Grace Hopper said:
> I’ve always been more interested
> in the future than in the past.

\*literal asterisks\*

```javascript
function test() {
 console.log("look ma’, no spaces");
}
```

#1
github-flavored-markdown#1
defunkt/github-flavored-markdown#1

- [x] this is a complete item
- [ ] this is an incomplete item
- [x] @mentions, #refs, [links](),
**formatting**, and <del>tags</del>
supported
- [x] list syntax required (any
unordered or ordered list
supported)


First Header | Second Header
------------ | -------------
Content cell 1 | Content cell 2
Content column 1 | Content column 2


I think you should use an
`<addr>` element here instead.

- [x] @mentions, #refs, [links](), **formatting**, and <del>tags</del> supported
- [x] list syntax required (any unordered or ordered list supported)
- [x] this is a complete item
- [ ] this is an incomplete item


Any word wrapped with two tildes (like ~~this~~) will appear crossed out.

Use `git status` to list all new or modified files that haven't yet been committed.

Some basic Git commands are:
```
git status
git add
git commit
```

This site was built using [GitHub Pages](https://pages.github.com/).

- George Washington
- John Adams
- Thomas Jefferson

1. James Madison
2. James Monroe
3. John Quincy Adams

1. First list item
   - First nested list item
     - Second nested list item

     
- [ ] \(Optional) Open a followup issue
