pushd %~dp0

REM repl.bat
call run-java-interop.bat 0<a-key-press-in-a-ms-dos-batch-file.txt
call run-uberjar.bat 0<a-key-press-in-a-ms-dos-batch-file.txt
call run.bat 0<a-key-press-in-a-ms-dos-batch-file.txt
call test-spec.bat 0<a-key-press-in-a-ms-dos-batch-file.txt
call test.bat 0<a-key-press-in-a-ms-dos-batch-file.txt
call uberjar.bat 0<a-key-press-in-a-ms-dos-batch-file.txt

popd
pause
