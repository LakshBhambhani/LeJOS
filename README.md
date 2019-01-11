# LeJOS

## What is LeJOS?
LeJOS is a firmware replacement for Lego Mindstorms programmable bricks. 
Different variants of the software support the original Robotics Invention System, the NXT, and the EV3. It includes a Java
virtual machine, which allows Lego Mindstorms robots to be programmed in the Java programming language. All the codes in this repo will work only with the EV3 Brick and may or may not work with others

## Installing LeJOS on the brick
### Mac Users
Follow the instructions provided on the following website: http://www.bartneck.de/2017/06/04/tutorial-on-how-to-install-andrun-java-on-lego-mindstorms-ev3-using-eclipse-on-mac-os-x/

### Windows users
Follow the instructions provided on the following website: https://sourceforge.net/p/lejos/wiki/Windows%20Installation/

## Hello World
Use HelloWorld.java to print out Hello World! on the EV3 Brick Screen. 


## Move Foward
Use MoveForward.java to move a simple robot with two motors attached to the motor ports of the brick


## IR Sensor Demo
This project contains 3 files: The demo file, ir sensor object file, lcd object file. Use and play with it to compare the 
distances between the IR sensor connected to the brick and any obstacle


## Touch Sensor Demo
This project contains 3 files: The demo file, touch sensor object file, lcd object file. Use and play with it to check if the touch sensor is pressed or unpressed (prints a boolean value. True is pressed and false is unpressed)


## Colour Sensor Demo
This project contains 3 files: The demo file, the colour sensor object file, lcd object file. Use and play with it to know the colour of the object placed in front of the colour sensor which is connected to the brick


## Obstacle Avoider
Use ObstacleAvoider.java to code a robot that avoids obstacles


## Mapping Surroundings
Use this project to get an image of the robot's surroundings. Requires 2 Motors and 1 IR Sensor


## Rubix's Cube Scanner (Still under Development)
Use this project to build a LEGO EV3 Rubixs cube Solver bot and then implement this code to scan a cube that you provide to your robot.

