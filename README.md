# Alfresco FizzBuzz exercise
## The problem
This is a simple variation on the well known http://codingdojo.org/kata/FizzBuzz/ kata exercise.

Please write code delivering the requirements of the steps that follow and execute them one by one - do one at a time please, and don’t be tempted to read the following one :).

The code should be developed using TDD so test first, be as simple as possible and self explanatory and automatable with a build file of your choice.

## Step 1
### Requirements
Write code that produces the following output for each number in a contiguous range of integers:

1. the number itself
2. ‘fizz’ for numbers that are multiples of 3
3. ‘buzz’ for numbers that are multiples of 5
4. ‘fizzbuzz’ for numbers that are multiples of 15

Being careful to avoid trailing spaces.

### Example
Running the program with a range from 1-20 should produce the following result:
```
1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz
```

Init a local git repository and create a commit with the solution.

## Step 2
### Requirements
Please enhance your existing FizzBuzz solution to perform the following requirements:

- If the number contains a three you must output the text ‘alfresco’, any other rule is skipped.

### Example
running the program with a range from 1-20 should produce the following result:
```
1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz
```

Create a branch for the alfresco variation and then a commit with the solution.

## Step 3
### Requirements
Produce a report at the end of the output showing how many times the following were printed:
```
fizz
buzz
fizzbuzz
alfresco
an integer
```

### Example
Running the program with a range from 1-20 should produce the following result:
```
1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz fizz: 4 buzz: 3 fizzbuzz: 1 alfresco: 2 integer: 10
```
(Integer is 10 because there were 10 numbers in the output that were not altered).

## Step 4
### Requirements
Wrap this in a RESTful API for a fizzbuzz integer range resource using Spring Boot or any other technology you are familiar with, and create an integration test for a successful run and for an invalid input, for example a string rather than a number.

## Step 5
### Requirements
Create a docker image with your REST API server and launch a container, then execute the same integration test as in Step 4.
Step 6

## Full Stack bonus! 
### Requirements
Create a simple JavaScript user interface providing a form for the input number calling the REST API and printing the result without page reload.

