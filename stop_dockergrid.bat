@REM When using this file, be sure to execute this bat file in the same directory where the docker-compose is located.
@REM the cmd will open the directory in the directory where this bat file is located.
@REM for example: cd C:\Users\admin\Desktop\automation-course-demo
docker-compose down
taskkill /f /im cmd.exe