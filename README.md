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

### 1. `DateTimeNow`

![DatetimeOne](DateTimeOne.svg)

To store the time value as a class instance variable when the method _`.now()`_ from the **LocalDatetime** clase is invoked. The private instance variable showDateTime of the tipe LocalDateTime is created. this variable is used within the void public method _`dateTimeNow()`_ to obtaine the second value and return it with the following code line.
```java
int secondNow = showDateTime.getSecond();
```
Wihtin the _`sleepForThreeSec()`_ method the following code is used to sleep the program for three seconds. The InterruptedException that may happen is handled within the method with a try-catch block.
```java
TimeUnit.MILLISECONDS.sleep(3000);
```
### 2. `HammingDistance`

![HD](HammingDistance.svg)

When selecting the variables for this class I focussed on what was the  required output. Thus, there is a variable asociated to each input variable. Aditionally there are two static variables. One is the array of stations ID extracted from the file while the other is the reference station to which the input is compared to, to measure the hamming distance. the required output of the class when the method _`toString()`_ is called is as follows:
```java
The Hamming distance between Norman and NEWK is 3; between Norman and WEBR is 4. 
For NEWK: Number of stations with Hamming Distance 3: 20. 
For WEBR: Number of stations with Hamming Distance 4: 90.
```
the description of the value of each variable is presented in the following table:

---
| Instance Variable | Type | Description |
|---|---|---|
| `stations`| **String[]** | contains the value of the STID for each station contained within the file. this variable is assigned the return of the method  `getStations()`|
| `DEFAULT_STATION` | **String** | Value of this variable is **NRMN**. This is the variable that determines the first two hamming distances in the output.
| `cityOne` | **String** | The value of the first input in the constructor is assingned to this variable. This variable is present within the output String when `toString()` is called |
| `cityTwo` | **String** | The value of the second input in the constructor is assingned to this variable. This variable is present within the output String when `toString()` is called |
| `hdCityOne` | **int** | this variable is initialized within the constructor, and the value assigned to it, is the found hamming distance between `DEFAULT_STATION` and `cityOne`. This variable is present within the output String when `toString()` is called | 
| `hdCityTwo` | **int** | this variable is initialized within the constructor, and the value assigned to it, is the found hamming distance between `DEFAULT_STATION` and `cityTwo`. This variable is present within the output String when `toString()` is called |
| `hdStationsCityOne` | **int[]** | this variable is initialized within the constructor, and the value assigned to it, is and array with hamming distances found between each on of the stations wihtin `stations` and `cityOne`. |
| `hdStationsCityTwo` | **int[]** | this variable is initialized within the constructor, and the value assigned to it, is and array with hamming distances found between each on of the stations wihtin `stations` and `cityTwo`. |
| `hdCityOneRepetition` | **int** | this variable is initialized within the constructor. Its value is the number of times that the `hdCityOne` is present within the array `hdStationsCityOne`. The value of this variable is one of the outputs when `toString()` is called.|
| `hdCityTwoRepetition` | **int** | this variable is initialized within the constructor. Its value is the number of times that the `hdCityTwo` is present within the array `hdStationsCityTwo`. The value of this variable is one of the outputs when `toString()` is called.|
---
