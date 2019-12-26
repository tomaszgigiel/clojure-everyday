md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
call lein test
pause
popd
