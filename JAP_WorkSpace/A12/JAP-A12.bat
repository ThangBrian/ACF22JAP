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
SET BINOUT=A12-javac.out
SET BINERR=A12-javac.err
SET JARNAME=A12.jar
SET JAROUT=A12-jar.out
SET JARERR=A12-jar.err
SET DOCDIR=doc
SET DOCPACK=a12
SET DOCOUT=a12-javadoc.out
SET DOCERR=a12-javadoc.err
SET MAINCLASSSRC=src/a12/A12.java
SET MAINCLASSBIN=a12.A12
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
javac -Xlint -cp ".;%SRCDIR%;%JAVAFXDIR%/*" %MAINCLASSSRC% -d %BINDIR% > %BINOUT% 2> %BINERR%

:: ECHO "Running  ........................."
:: start java -cp ".;%BINDIR%;%JAVAFXDIR%/*" %MAINCLASSBIN%

ECHO "2. Creating Jar ..................."
cd bin
jar cvfe %JARNAME% %MAINCLASSBIN% . > %JAROUT% 2> %JARERR%

ECHO "3. Creating Javadoc ..............."
cd ..
javadoc -cp ".;%BINDIR%;%JAVAFXDIR%/*" --module-path "%JAVAFXDIR%" --add-modules %MODULELIST% -d %DOCDIR% -sourcepath %SRCDIR% -subpackages %DOCPACK% > %DOCOUT% 2> %DOCERR%

cd bin
ECHO "4. Running Jar ...................."
start java --module-path "%JAVAFXDIR%" --add-modules %MODULELIST% -jar %JARNAME%
cd ..

ECHO "[END OF SCRIPT -------------------]"
ECHO "                                   "
@echo on

:: ---------------------------------------------------------------------
:: End of Script (Assignments - F22)
:: ---------------------------------------------------------------------
