md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
call lein do clean, run
pause
popd
