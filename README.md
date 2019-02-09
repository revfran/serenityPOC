# serenityPOC
Testing with serenity BDD


# Prerequisites
- Maven
- phantomjs

# How the project was generated
- Generate a screenplay archetype for selenium
mvn archetype:generate -Dfilter=screenplay
I used last versions when prompted. They are visible on POM.xml

- Import the project on intellij IDEA (or any other java IDE)  as maven project then switch to phantomjs browser
# How to run
mvn verify
