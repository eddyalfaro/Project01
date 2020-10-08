# Project 1 - _HammingDistance & DateTimeOne_
The objective  of this programming project  is to implement aJava program which can read a file, parse data,perform  some  calculation  on  data,  and some basics  on Date/Time. After  completing  the  project, students will  have  an  intermediate understanding  of reading data from a file and performing  some calculation on data and basics of Date/Time function in Java.

---

## **Problem Solving Phase**
In order to start building the two classes the first thing that I did was to check out the code within `Driver.java` and the instructions that it came with. From the starting code within this class, the following is what I saw I needed to do for each class:

1. **`DateTimeOne.java`**: I needed to crate two new methods within this class. the first one named _`.getValueOfSecond()`_ while the second one was named _`.sleepForThreeSec()`_. the following is a list of task with detailed description of what each method needs to do.

    - [x] _`getValueOfSecond()`_: this method will get the value of second from the time information obtained by the program wihtin the _`dateTimeNow()`_ method. The focus of this method is to return the obtained second time value when called. Additionaly within the method it is required to check if the second value is 58 and print out the string:
        > `The value of Second now: 58` 
    - [x] _`sleepForThreeSec()`_: from the code build in the driver this method is only alowed to sleep the program for three seconds. The runtime exceptions that may occur within the method are needed to be handled within the method since the driver cannot be edited. For this method I will use the **`TimeUnit`** class which allows me to sleep the program without using threads or runnable within the code.
1. **`HammingDistance`**: Using the information witin the driver it is known that this class has to implement at least a constructor and on _`.toString()`_ method. wihtin the other methods of the class it is needed to:
    * Read a file and store its information
    * Modify the information obtained from the file
    * Calculate Hamming Distances between two stations
    * Find the number of Hamming distances equal to a certain value

    All of these tasks have to be done within the constructor. However, the code for these tasks is done wihtin a method in the class for each.

---
## **Coding Blocks**

## 1. **`DateTimeNow.java`**

![DatetimeOne](DateTimeOne.svg)

To store the time value as a class instance variable when the method _`.now()`_ from the **LocalDatetime** clase is invoked. The private instance variable showDateTime of the tipe LocalDateTime is created. this variable is used within the void public method _`dateTimeNow()`_ to obtaine the second value and return it with the following code line.
```java
int secondNow = showDateTime.getSecond();
```
Wihtin the _`sleepForThreeSec()`_ method the following code is used to sleep the program for three seconds. The InterruptedException that may happen is handled within the method with a try-catch block.
```java
TimeUnit.MILLISECONDS.sleep(3000);
```
