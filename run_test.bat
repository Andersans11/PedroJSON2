@echo off
echo Downloading Jackson library if not present...

if not exist "jackson-databind-2.12.7.jar" (
    echo Downloading jackson-databind...
    curl -L -o jackson-databind-2.12.7.jar "https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.12.7/jackson-databind-2.12.7.jar"
)

if not exist "jackson-core-2.12.7.jar" (
    echo Downloading jackson-core...
    curl -L -o jackson-core-2.12.7.jar "https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.12.7/jackson-core-2.12.7.jar"
)

if not exist "jackson-annotations-2.12.7.jar" (
    echo Downloading jackson-annotations...
    curl -L -o jackson-annotations-2.12.7.jar "https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.12.7/jackson-annotations-2.12.7.jar"
)

echo Compiling Java files...
javac -cp "jackson-databind-2.12.7.jar;jackson-core-2.12.7.jar;jackson-annotations-2.12.7.jar" TeamCode\src\main\java\pedroPathing\main\*.java

echo Running the test...
java -cp "jackson-databind-2.12.7.jar;jackson-core-2.12.7.jar;jackson-annotations-2.12.7.jar;TeamCode\src\main\java" pedroPathing.main.test

pause
