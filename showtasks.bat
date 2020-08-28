call runcrud

if "%ERRORLEVEL%" == "0" goto openbrowser
echo.

echo Cannot run runcrud.bat - breaking work
goto fail

:openbrowser
start chrome http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Cannot open browser - breaking work
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished