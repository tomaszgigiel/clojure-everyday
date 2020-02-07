md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
REM call lein test :only pl.tomaszgigiel.quizzes.packs.joc.joc-07-01-test
REM call lein test :only pl.tomaszgigiel.quizzes.packs.joc.joc-07-02-test
REM call lein test :only pl.tomaszgigiel.quizzes.packs.joc.joc-07-03-test
call lein test :only pl.tomaszgigiel.quizzes.packs.joc.joc-07-04-test
REM call lein test :only pl.tomaszgigiel.quizzes.parser-test
REM call lein test :only pl.tomaszgigiel.quizzes.packs.test-test
REM call lein test :only pl.tomaszgigiel.quizzes.packs.clojure-exponentiation-test
pause
popd
