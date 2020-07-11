set projectLocation=C:\Users\E0360088\eclipse-workspaceNew\MainDataProvider
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause