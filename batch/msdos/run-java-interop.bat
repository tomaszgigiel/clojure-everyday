md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
REM rmdir /s /q target
call lein with-profile interop do clean, uberjar
"%JAVA_HOME%"\bin\javac -cp target\uberjar\quizzes-uberjar.jar .\src\main\java\pl\tomaszgigiel\quizzes\JavaWithClojureStrongApp.java -d .\target
"%JAVA_HOME%"\bin\java -cp target;target\uberjar\quizzes-uberjar.jar pl.tomaszgigiel.quizzes.JavaWithClojureStrongApp
pause
popd
