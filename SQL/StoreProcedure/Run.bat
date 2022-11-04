@echo off
@echo Executing Files
@echo off
@echo Excuting
for %%G in (*.sql) do sqlcmd -S DESKTOP-E2TC3PE -d Dictionary -E -i "%%G"
Pause