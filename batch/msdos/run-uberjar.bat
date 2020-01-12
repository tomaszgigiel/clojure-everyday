md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
call java -cp .\target\uberjar\quizzes-uberjar.jar pl.tomaszgigiel.quizzes.core
pause
popd
