md "%HOMEPATH%\_delete_content\"
pushd %~dp0\..\..
rmdir /s /q target
call lein do clean, uberjar
pause
popd
