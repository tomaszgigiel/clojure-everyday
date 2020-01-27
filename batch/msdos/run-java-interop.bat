md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
REM rmdir /s /q target
REM call lein do clean, uberjar
"%JAVA_HOME%"\bin\javac -cp target\uberjar\quizzes-uberjar.jar .\src\main\java\pl\tomaszgigiel\quizzes\MySpecJavaWithClojureApp.java -d .\target
"%JAVA_HOME%"\bin\java -cp target pl.tomaszgigiel.quizzes.MySpecJavaWithClojureApp
pause
popd
