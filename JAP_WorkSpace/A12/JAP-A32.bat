:: ---------------------------------------------------------------------
:: JAP COURSE - SCRIPT
:: ASSIGNMENTS - CST8221 - Fall 2022
:: ---------------------------------------------------------------------
:: Begin of Script (Assignments - F22)
:: ---------------------------------------------------------------------


CLS

:: LOCAL VARIABLES ....................................................
SET JAVAFXDIR=C:/JavaSDK/javafx-sdk-18.0.2/lib
SET SRCDIR=src
SET BINDIR=bin
SET BINOUT1=server-javac.out
SET BINOUT2=client-javac.out
SET BINERR1=server-javac.err
SET BINERR2=client-javac.err
SET JARNAME1=server.jar
SET JARNAME2=client.jar
SET JAROUT1=server-jar.out
SET JAROUT2=client-jar.out
SET JARERR1=server-jar.err
SET JARERR2=client-jar.err
SET DOCDIR=doc
SET DOCPACK=a12
SET DOCOUT=a32-javadoc.out
SET DOCERR=a32-javadoc.err
SET MAINCLASSSRC1=src/server/Server.java
SET MAINCLASSSRC2=src/client/Client.java
SET MAINCLASSBIN1=server.Server
SET MAINCLASSBIN2=client.Client
SET MODULELIST=javafx.controls,javafx.fxml

@echo off

ECHO " _________________________________ "
ECHO "|     __    _  ___    ___  _      |"
ECHO "|    |  |  / \ \  \  /  / / \     |"
ECHO "|    |  | /   \ \  \/  / /   \    |"
ECHO "|    |  |/  _  \ \    / /  _  \   |"
ECHO "|  __|  |  / \  \ \  / /  / \  \  |"
ECHO "|  \____/_/   \__\ \/ /__/   \__\ |"
ECHO "|                                 |"
ECHO "| .. ALGONQUIN COLLEGE - 2022F .. |"
ECHO "|_________________________________|"
ECHO "                                   "
ECHO "[ASSIGNMENT SCRIPT ---------------]"

ECHO "1. Compiling ......................"
javac -Xlint -cp ".;%SRCDIR%;%JAVAFXDIR%/*" %MAINCLASSSRC1% -d %BINDIR% > %BINOUT1% 2> %BINERR1%
javac -Xlint -cp ".;%SRCDIR%;%JAVAFXDIR%/*" %MAINCLASSSRC2% -d %BINDIR% > %BINOUT2% 2> %BINERR2%

:: ECHO "Running  ........................."
:: start java -cp ".;%BINDIR%;%JAVAFXDIR%/*" %MAINCLASSBIN%

ECHO "2. Creating Jar ..................."
cd bin
jar cvfe %JARNAME1% %MAINCLASSBIN1% . > %JAROUT1% 2> %JARERR1%
jar cvfe %JARNAME2% %MAINCLASSBIN2% . > %JAROUT2% 2> %JARERR2%

ECHO "3. Creating Javadoc ..............."
cd ..
javadoc -cp ".;%BINDIR%;%JAVAFXDIR%/*" --module-path "%JAVAFXDIR%" --add-modules %MODULELIST% -d %DOCDIR% -sourcepath %SRCDIR% -subpackages %DOCPACK% > %DOCOUT% 2> %DOCERR%

cd bin
ECHO "4. Running Jar ...................."
start java --module-path "%JAVAFXDIR%" --add-modules %MODULELIST% -jar %JARNAME1%
start java --module-path "%JAVAFXDIR%" --add-modules %MODULELIST% -jar %JARNAME2%
cd ..

ECHO "[END OF SCRIPT -------------------]"
ECHO "                                   "
@echo on

:: ---------------------------------------------------------------------
:: End of Script (Assignments - F22)
:: ---------------------------------------------------------------------
