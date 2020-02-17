md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
REM call lein test :only pl.tomaszgigiel.quizzes.parser-test
REM call lein test :only pl.tomaszgigiel.quizzes.packs.test-test
REM call lein test :only pl.tomaszgigiel.quizzes.packs.clojure-exponentiation-test
REM call lein test :only pl.tomaszgigiel.quizzes.packs.joc.joc-06-01-test
REM call lein test :only pl.tomaszgigiel.quizzes.packs.joc.joc-06-02-test
REM call lein test :only pl.tomaszgigiel.quizzes.packs.joc.joc-06-03-test
REM call lein test :only pl.tomaszgigiel.quizzes.packs.joc.joc-06-04-test
REM call lein test :only pl.tomaszgigiel.quizzes.packs.joc.joc-07-01-test
REM call lein test :only pl.tomaszgigiel.quizzes.packs.joc.joc-07-02-test
REM call lein test :only pl.tomaszgigiel.quizzes.packs.joc.joc-07-03-test
REM call lein test :only pl.tomaszgigiel.quizzes.packs.joc.joc-07-04-test
call lein test :only pl.tomaszgigiel.quizzes.packs.joc.joc-08-00-test
pause
popd
