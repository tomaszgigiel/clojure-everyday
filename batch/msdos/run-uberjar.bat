md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
if not exist ".\target\uberjar\quizzes-uberjar.jar" (
  rmdir /s /q target
  call lein do clean, uberjar
)
call java -cp .\target\uberjar\quizzes-uberjar.jar pl.tomaszgigiel.quizzes.core
pause
popd
