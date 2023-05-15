compile:
	javac src/main/java/com/example/podam/*.java -d classes

run:
	java -cp classes com.example.podam.App

install:
	mvn clean install -U

integration-test:
	mvn -Dtest=IntegrationTest test