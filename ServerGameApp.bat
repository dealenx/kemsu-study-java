chcp 1251

del /S *.class


"C:\Program Files\Java\jdk1.8.0_144\bin\javac.exe" -cp ".;.\postgresql-42.1.4.jar"  .\app\ServerGameApp.java
"C:\Program Files\Java\jre1.8.0_144\bin\java.exe" -cp ".;.\postgresql-42.1.4.jar" app.ServerGameApp
pause
