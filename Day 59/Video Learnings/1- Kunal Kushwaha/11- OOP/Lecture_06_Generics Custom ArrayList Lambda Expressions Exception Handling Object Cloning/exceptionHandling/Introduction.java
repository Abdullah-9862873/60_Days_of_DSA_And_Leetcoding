

/*
____________________________NOTES____________________________

                            Object class
                            ↓
                            Throwable
                            ↓
                 ←  ←  ←  ←   →  →  →  →
                ↓                       ↓
            Exception                  Error
                ↓
    ←  ←  ←  ←   →  →  →  →
    ↓                       ↓
    Checked                 UnChecked

_________________What are Errors__________________________
---> Errors are typically unrecoverable problems that occur at the system level, indicating serious issues that usually cannot be handled by the application.
Examples of errors include OutOfMemoryError, StackOverflowError, and VirtualMachineError...


___________________What are Exceptions______________________
---> Exceptions, on the other hand, are events that occur during the execution of a program and can be handled by the application.
Exceptions are further divided into two categories: checked exceptions and unchecked exceptions.
Checked Exceptions: These are exceptions that are checked at compile-time. The programmer is required to either handle these exceptions using a try-catch block or declare that the method may throw these exceptions using the throws clause. Examples include IOException and SQLException.
Unchecked Exceptions: These are exceptions that are not checked at compile-time. They are subclasses of RuntimeException and are usually indicative of programming errors or unexpected conditions. Examples include NullPointerException and ArrayIndexOutOfBoundsException.
*/