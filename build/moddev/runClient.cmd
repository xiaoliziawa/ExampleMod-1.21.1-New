@echo off
setlocal
for /f "tokens=2 delims=:." %%x in ('chcp') do set _codepage=%%x
chcp 65001>nul
cd G:\IDEA Project BACKUP\ExampleMod_1.21.1\run
"C:\Program Files\Zulu\zulu-21\bin\java.exe" "@G:\IDEA Project BACKUP\ExampleMod_1.21.1\build\moddev\clientRunClasspath.txt" "@G:\IDEA Project BACKUP\ExampleMod_1.21.1\build\moddev\clientRunVmArgs.txt" "-Dfml.modFolders=exmaplemod%%%%G:\IDEA Project BACKUP\ExampleMod_1.21.1\build\classes\java\main;exmaplemod%%%%G:\IDEA Project BACKUP\ExampleMod_1.21.1\build\resources\main" net.neoforged.devlaunch.Main "@G:\IDEA Project BACKUP\ExampleMod_1.21.1\build\moddev\clientRunProgramArgs.txt"
if not ERRORLEVEL 0 (  echo Minecraft failed with exit code %ERRORLEVEL%  pause)
chcp %_codepage%>nul
endlocal