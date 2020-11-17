
***There are parking source codes in the following directories***
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
myproject>src>Vehicle.java
myproject>src>ParkingFeeCalculation.java
myproject>src>ParkingLot.java
myproject>src>ParkedVehicle.java
myproject>src>Parking.java
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
myproject>classes
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
myproject>TestParking.java
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 
####################################################################################
***Instructions to learn javac/java command with classpath***
1. Compile Source files at "myproject>src>*.java" to "classes" folder 
with -d <directory>  (Specify where to place generated class files)
2. at "myproject" (current directory), change directory to "src" folder by "cd src" 
-compile Vehicle.java 
C:\Users\Umaporn\Desktop\1-2563\INT101\BuildingPackage\myproject\src>javac -d ../classes Vehicle.java
-compile ParkingFeeCalculation.java
C:\Users\Umaporn\Desktop\1-2563\INT101\BuildingPackage\myproject\src>javac -d ../classes ParkingFeeCalculation.java
-compile ParkingLot.java
C:\Users\Umaporn\Desktop\1-2563\INT101\BuildingPackage\myproject\src>javac -d ../classes ParkingLot.java
-compile ParkedVehicle.java
C:\Users\Umaporn\Desktop\1-2563\INT101\BuildingPackage\myproject\src>javac -classpath .;../classes -d ../classes ParkedVehicle.java
-compile Parking.java
C:\Users\Umaporn\Desktop\1-2563\INT101\BuildingPackage\myproject\src>javac -classpath .;../classes -d ../classes Parking.java
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
***after compile related classes***
myproject>classes>vehicle>Vehicle.class
myproject>classes>parking>ParkedVehicle.class
myproject>classes>parking>Parking.class
myproject>classes>parking>ParkedFeeCalculation.class
myproject>classes>parking>ParkedLot.class
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
3. Running TestParking.java (main class)
- change folder to "myproject" by cd..
- compile TestParking.java
C:\Users\Umaporn\Desktop\1-2563\INT101\BuildingPackage\myproject>javac -classpath .;./classes TestParking.java
-run TestParking
C:\Users\Umaporn\Desktop\1-2563\INT101\BuildingPackage\myproject>java -classpath .;./classes TestParking

####################################################################################
***Instructions to make jar file (without manifest.mf)***
1. move TestParking.class to "classes" folder
2. at "classes" folder, run command 
C:\Users\Umaporn\Desktop\1-2563\INT101\BuildingPackage\myproject\classes>jar -cfv parking-not-m.jar *
3. run application with Jar file
C:\Users\Umaporn\Desktop\1-2563\INT101\BuildingPackage\myproject\classes>java -cp parking-not-m.jar TestParking

####################################################################################
***Instructions to make jar file (with manifest.mf)***
1. move TestParking.class to "classes" folder
2. at "classes" folder, run command 
C:\Users\Umaporn\Desktop\1-2563\INT101\BuildingPackage\myproject\classes>jar -cvmf manifest.mf parking.jar *
3. run application with Jar file
C:\Users\Umaporn\Desktop\1-2563\INT101\BuildingPackage\myproject\classes>java -jar parking.jar

