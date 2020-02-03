md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
REM call lein test :only pl.tomaszgigiel.quizzes.packs.joc.joc-07-01-test
REM call lein test :only pl.tomaszgigiel.quizzes.parser-test
REM call lein test :only pl.tomaszgigiel.quizzes.packs.test-test
call lein test :only pl.tomaszgigiel.quizzes.packs.clojure-exponentiation-test
pause
popd
