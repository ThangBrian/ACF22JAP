:: ---------------------------------------------------------------------
:: JAP COURSE - SCRIPT
:: SCRIPT W01 - CST8221 - Fall 2022
:: ---------------------------------------------------------------------
:: Begin of Script (Labs - F22)
:: ---------------------------------------------------------------------


CLS

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
ECHO "[LABS SCRIPT ---------------------]"

ECHO "1. Compiling ......................"
javac -Xlint -cp ".;src;/SOFT/copy/dev/java/javafx/lib/*" src/Lab.java -d bin 2> labs-javac.err

:: ECHO "Running  ........................."
:: start java -cp ".;bin;/SOFT/copy/dev/java/javafx/lib/*" CST8221.Main

ECHO "2. Creating Jar ..................."
cd bin
jar cvfe CST8221.jar Lab . > labs-jar.out 2> labs-jar.err

ECHO "3. Creating Javadoc ..............."
cd ..
javadoc -cp ".;bin;/SOFT/copy/dev/java/javafx/lib/*;/SOFT/COPY/dev/LIBS/jar/javax.servlet.jar" --module-path "C:\SOFT\COPY\dev\LIBS\javafx\lib" --add-modules javafx.controls -d doc -sourcepath src -subpackages CST8221 2> labs-javadoc.err

::cd src
::javadoc -cp ".;bin;/SOFT/copy/dev/java/javafx/lib/*;/SOFT/COPY/dev/LIBS/jar/javax.servlet.jar" --module-path "C:\SOFT\COPY\dev\LIBS\javafx\lib" --add-modules javafx.controls -d ../doc *.java -subpackages CST8221
::cd ..

::cd src
::javadoc -cp ".;../bin;/SOFT/COPY/dev/LIBS/jar/javax.servlet.jar" -d ../doc *.java -subpackages CST8221
::cd ..

cd bin
ECHO "4. Running Jar ...................."
start java --module-path "/SOFT/COPY/dev/LIBS/javafx/lib" --add-modules javafx.controls,javafx.fxml -jar CST8221.jar
cd ..

ECHO "[END OF SCRIPT -------------------]"
ECHO "                                   "
@echo on

:: ---------------------------------------------------------------------
:: End of Script (Labs - F22)
:: ---------------------------------------------------------------------
