md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
call lein do clean, with-profile main-create run
pause
popd
