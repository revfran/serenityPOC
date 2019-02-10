# serenityPOC
Testing with serenity BDD


# Prerequisites
- Maven
- Firefox (tested with firefox 57.0) 

# How the project was generated
- Generate a screenplay archetype for selenium
mvn archetype:generate -Dfilter=screenplay
I used last versions when prompted. They are visible on POM.xml

- Import the project on intellij IDEA (or any other java IDE)  as maven project

- Install firefox 57.0, downgrading if needed.
	- https://ftp.mozilla.org/pub/firefox/releases/57.0/
- Get the latest geckodriver (tested with v0.24.0) and extract the binary file
        - https://github.com/mozilla/geckodriver/releases
- Set the geckodriver path in serenity.properties

# How to run
mvn verify
