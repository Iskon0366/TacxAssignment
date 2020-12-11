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

Basically I create Page Object Java Classes in **pages** directory and each class represents a page in the application. 

I store all available WebElements by the help of **Page Factory** and methods in each class and I utilize them in Step Definitions. 
Step Definitions are in step_definitons directory keeps respective behavioral steps regarding Feature File. 
Feature File represents the scenarios written in Gherkin language. 
I have Hooks class that stores Before and After methods. Runner Class is where I execute testing via Cucumber Options. 
Besides these Utilities package in which I store Driver, BrowserUtils, DBUtils classes has common ready methods that I’m implementing during creating test scripts. 
Configuration Properties file is keeping data like credentials based on key and value structure.  

Framework built in Java.
I created framework based on Cucumber/BDD structure along with the Gherkin language.
Maven is used as a build managemet tool and it helps me to manage the dependencies.
I am using Selenium Webdriver in order to interact with browsers. For assertions JUnit is used in this framework.  I used **POM**(Page Object Model) design pattern. It makes the structure more organised and reusable. It reduces duplications. 


>I used **POM**(Page Object Model) design pattern. It makes the structure more organised and reusable. It reduces duplications. 
 and I used pom.xml file to hold my dependencies,plugins,properties and versions of them.



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
