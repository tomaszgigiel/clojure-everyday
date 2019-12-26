md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
call java -cp .\target\uberjar\clojure-everyday-uberjar.jar pl.tomaszgigiel.clojure_everyday.core
pause
popd
