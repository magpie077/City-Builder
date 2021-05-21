# City-Builder
ADS Project



## Problem Statement:

Wayne Enterprises is developing a new city. They are constructing many buildings and plan to use software to keep track of all buildings under construction in this new city. A building record has the following fields:
buildingNum: unique integer identifier for each building.
executed_time: total number of days spent so far on this building.
total_time: the total number of days needed to complete the construction of the building.
 
## The needed operations are:
1. Print (buildingNum) prints the triplet buildingNume,executed_time,total_time.
2. Print (buildingNum1, buildingNum2) prints all triplets bn, executed_tims, total_time for which buildingNum1 <= bn <= buildingNum2.
3. Insert (buildingNum,total_time) where buildingNum is different from existing building numbers and executed_time = 0.
 
In order to complete the given task, you must use a min-heap and a Red-Black Tree (RBT). You must write your own code the min heap and RBT. Also, you may assume that the number of active buildings will not exceed 2000.
 
A min heap should be used to store (buildingNums,executed_time,total_time) triplets ordered by executed_time. You mwill need a suitable mechanism to handle duplicate executed_times in your min heap. An RBT should be used store (buildingNums,executed_time,total_time) triplets ordered by buildingNum. You are required to maintain pointers between corresponding nodes in the min-heap and RBT.
 
Wayne Construction works on one building at a time. When it is time to select a building to work on, the building with the lowest executed_time (ties are broken by selecting the building with the lowest buildingNum) is selected. The selected building is worked on until complete or for 5 days, whichever happens first. If the building completes during this period its number and day of completion is output and it is removed from the data structures. Otherwise, the building’s executed_time is updated. In both cases, Wayne Construction selects the next building to work on using the selection rule. When no building remains, the completion date of the new city is output.


## Objectives:
•	To implement Min Heap and Red Black Tree

## Solution

I used the Java programming language and Eclipse IDE to write the source code of this project. The algorithm that I developed to solve the problem statement is as follows:
1.	Maintain a variable called ‘gt’, which is the global timer that is initialized to 0 at the declaration.
2.	Create a minheap using a nx3 matrix where the 1st column stores the building number, the 2nd column stores the executed time and the 3rd column stores the total time.
3.	Maintain a cur (current) pointer which gives the number of buildings in the city (at the current moment)
4.	Insert the first building into the minheap.
5.	Increment the execution time and the ‘gt’ of the root node of the minheap by either 5 or by the difference of total time and execution time, whichever is smaller.
6.	If the difference of total time and execution time is less than 5, then remove the root (because that building is completed) and print it’s completion time.
7.	Iterate through all the commands in the input file, for which the counter value is less than or equal to the value of ‘global’. These commands are either an Insert command or a Print command. For the Insert command, do the insert into the minheap and the rbtree. For the Print command, print the triplet.
8.	Min Heapify, just in case.
9.	Go to step 5 and keep executing till either the minheap becomes empty.


#

The risingCity class contains the main method, and this is where the execution of the program begins. It calls the heapify, insert_mh and print as and when required.


