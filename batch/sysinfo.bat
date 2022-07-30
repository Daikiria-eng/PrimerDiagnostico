@echo off

IF NOT EXIST "temp\" mkdir "temp\"

cmd /c systeminfo > temp\sysinfo.txt
cmd /c ..\..\awk\bin\awk.exe 'NR<=80' temp\sysinfo.txt
