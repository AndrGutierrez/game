rm build -rf
javac -sourcepath src -d build ./src/**/*.java
cd build
java main.Main
