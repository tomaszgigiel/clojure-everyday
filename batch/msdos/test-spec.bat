md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
call lein test :only pl.tomaszgigiel.quizzes.quiz-joc07-test
pause
popd
