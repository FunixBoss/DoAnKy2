@echo off
@echo Executing Files
@echo off
@echo Excuting
for %%G in (*.sql) do sqlcmd -S AUGSEC -d Dictionary -E -i "%%G"
Pause