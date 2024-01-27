package singleton;

public class SingletonClass {
    private SingletonClass(){

    }

    private static SingletonClass instance;
    public static SingletonClass getInstance(){
        if(instance == null){
            instance = new SingletonClass();
        }

        return instance;
    }
}


/*
___________________________NOTES___________________________

----> If we want that only one object creation is allowed for a particular class then we can make that class a Singleton class which allows no more than one object creation...


---> Now our problem is that only one object should get created and no more... And we know that objects are created when the constructor is run... so number of objects are equal to number of times the constructor is run... So we have limit the running of constructor to only once... That we can do by making the constructor private and make a static function that will be run by the user in main function... We'll create an instance of the Singleton class and that instance will get instantiated only once no matter how many times user is creating an object...
 */