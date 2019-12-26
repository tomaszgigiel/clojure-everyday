md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
call lein repl
pause
popd
