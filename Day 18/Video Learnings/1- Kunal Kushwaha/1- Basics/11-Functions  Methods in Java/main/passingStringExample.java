package com.abdullah;

public class passingStringExample {
    public static void main(String[] args) {
        String name = "Abdullah Sultan";
        changeName(name);
        System.out.println(name);
    }

    static void changeName(String naam) {
        naam = "Abdullah";
    }
}

/*
 * In java there is no pass by reference. Its only pass by value;
 * The code that I have written on the top where the changeName() function is
 * basically trying to change the original name. But it doesn't work and the
 * reason is that at first there is a reference variable that is pointing
 * towards the value i-e "Abdullah Sultan"......
 * 
 * And when I pass this name in the function then function is creating another
 * reference variable named "naam" which is pointing towards the same value
 * "Abdullah Sultan"...
 * 
 * When the "naam" is updated to "Abdullah" then it won't change the original
 * varaiable rather there will be two variables now... One is the:
 * "name" -----> Abdullah Sultan
 * "naam" -----> Abdullah
 * 
 */
