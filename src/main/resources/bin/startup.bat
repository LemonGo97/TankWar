@echo off & setlocal enabledelayedexpansion

cd %~dp0

set CLASS_PATH="..;..\conf;..\lib\*"

set MAIN_CLASS=top.elizabath.mongoproxy.ApplicationBootStrap

java -server -Xmx2g -Xms2g -Xmn1g -Xss256k -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 -Dfile.encoding=UTF-8 -classpath %CLASS_PATH% %MAIN_CLASS%

pause
