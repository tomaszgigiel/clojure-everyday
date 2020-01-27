md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
REM call lein test :only pl.tomaszgigiel.quizzes.joc.quiz-joc07-test
call lein test :only pl.tomaszgigiel.quizzes.parser-test
pause
popd
