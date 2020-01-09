md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
call lein test :only pl.tomaszgigiel.clojure-everyday.faq-joc07-test
pause
popd
