@echo off
@echo Executing Files
@echo off
@echo Excuting
for %%G in (*.sql) do sqlcmd -S DESKTOP-RNFI65U\SQLEXPRESS -d Dictionary -E -i "%%G"
Pause