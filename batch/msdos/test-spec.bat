md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
call lein test :only pl.tomaszgigiel.quizzes.packs.joc.joc-07-01-test
call lein test :only pl.tomaszgigiel.quizzes.parser-test
pause
popd
