The entire set of Videos can be found at https://www.youtube.com/playlist?list=PLF206E906175C7E07

# DESIGN PATTERNS
### What is a Class?
It is a blueprint. Composed of fields (Instance variables), that is, what an object knows
and methods, that is, what an object does.

### Inheritance
What do classes have in common? Abstract out those features. Override or extend
Is A? versus Has A?
Is A helps you decide if a class should extend another. Has A helps you decide if something is a field.

### When to use inheritance?
- The subclass is a superclass. For example, “Dog is an Animal”
- When a subclass needs most of the methods in a superclass.
- Don’t use inheritance just to reuse code, or they don’t have a IS A relationship.
- Helps us Avoid duplicate code.
- Changes to superclass code is instantly reflected in all subclasses.
- User knows that all subclasses have all of the methods of the superclass.

### What is Polymorphism?
- Polymorphism allows you to write methods that don’t need to change if new subclasses are created. For example, Dog can add a new method without changing Animal. Dog can also override a method, without affecting Animal.
- You can put different subclasses in one array.
- You cannot call a non-static method or member inside a static method.
- You cannot call a private method even if you define it inside a subclass
  
### What is an Abstract Class?
- If you want the power of polymorphism without the work.
<pre><code>abstract public class Creature {
    public abstract void setName();
}</code></pre>
- There are no abstract fields
- All methods don’t have to be abstract
- You can have static methods.
- You cannot create objects from a class marked as abstract.
  
### What is an Interface?
- A class with only abstract methods
- You can add as many interfaces to class using implements as you want.
- You can only use public static and final fields
- Interfaces provide the ultimate in flexibility
- Classes from different inheritance trees can use a common interface


## STRATEGY PATTERN
You use this pattern if you need to dynamically change an algorithm used by an object at run time.
You basically define a family of algorithms, encapsulate each one, and make them interchangeable.

When to use the Strategy Pattern
* When you want to define a class that will have one behaviour that is similar to other behaviours in a list.
* When you need to use one of several behaviours dynamically.

<img src="images/StrategyPattern.png" width=700 />

## OBSERVER PATTERN
The observer pattern is a software design pattern in which an object, called the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.

Using threads with observer pattern is pretty common.

<img src="images/ObserverPattern.png" width=700 />

When you need many objects to receive an update when another object changes. Typically a Publisher-Subscriber model.
Benefit - Loose coupling

The publisher doesn’t need to know anything about the subscribers. Negatives: The publisher may send updates that don’t matter to the observer(subscriber)


## FACTORY PATTERN
You use the Factory design pattern when you want to define the class of an object at runtime. It also allows you to encapsulate object creation so that you can keep all object creation code in one place.

When a method returns one of several possible classes that share a common super class. The class is chosen at run time

<img src="images/FactoryPattern.png" width=700 />
 

## ABSTRACT FACTORY PATTERN

It is like a factory, but everything is encapsulated.
- The method that orders the object
- The factories that build the object
- The final objects
- The final objects contain objects that use the Strategy Pattern

**Composition:** Object class fields are objects
Allows you to create families of related objects without specifying a concrete class. 
Use when you have many objects that can be added, or changed dynamically during runtime
You can model anything you can imagine and have those objects interact through common interfaces

**The BAD:** Things can get complicated

## SINGLETON PATTERN

It is used when you want to eliminate the option of instantiating more than one object. Potential example : Scrabble
- Each player will share the same potential letter list.
- Each player has their own set of letters.
**Threads can wreak havoc with singleton and hence we need to have synchronised.**

<img src="images/FactoryPattern.png" width=700 />

## BUILDER PATTERN
Pattern used to create objects made from a bunch of other objects. 
When you want to build an object made up from other objects.
When you want the creation of these parts to be independent of the main object. Hide the creation of the parts from the client so both aren’t dependent.
The builder knows the specifics and nobody else does.

<img src="images/BuilderPattern.png" width=700 />

## PROTOTYPE PATTERN

Creating new object (instances) by cloning (copying) other objects.
Allows for adding of any subclass instance of a known super class at runtime When there are numerous potential classes that you want to only use if needed at


runtime.

Reduces the need for creating subclasses.
 
JAVA REFLECTION API

Class Manipulator
Used to manipulate classes and everything in a class
Can slow down a program because the JVM can’t optimise the code Cant be used with applets
Should be used sparingly




Greatest thing about Java reflection

“methodToExecute” passed as a string “methodToExecute”(int var1, String var2)


## DECORATOR PATTERN

Decorator allows you to modify an object dynamically.
You would use it when you want the capabilities of inheritance with subclasses, but you need to add functionality at run time.



It is more flexible than inheritance
Simplifies code because you add functionality using many simple classes

 
Rather than rewrite old code you can extend with new code.
 
## COMMAND PATTERN
The command pattern is a behavioural design pattern in which an object is used to represent and encapsulate all the information needed to call a method at a later time.

This information includes the method name, the object that owns the method and values for the method parameters.


Allows you to store lists of code that is executed at a later time or many times.
Client says I want a specific command to run when execute() is called on 1 of these encapsulated(hidden) objects.

An Object called the Invoker transfers this command to another object called a receiver to execute the right code.

 Benefits

Allows you to set aside a list of commands for later use.
A class is a great place to store procedures you want to be executed. You can store multiple commands in a class to use over and over. You can implement undo procedures for past commands



Negative:

 
You create many small classes that store lists of commands.
 
## ADAPTER PATTERN

Allows 2 completely incompatible interfaces to work together.
Used when the client expects a (target) interface
The Adapter class allows the use of the available interface and the target interface. Any class can work together as long as the Adapter solves the issue that all classes



must implement every method defined by the shared interface.
## FACADE PATTERN
When you create a simplified interface that performs many other actions behind the scenes.


Q. Can I withdraw $50 from the bank?


Check if the checking account is valid. Check if the security code is valid Check if funds are available
Make changes accordingly








 
## BRIDGE PATTERN
Progressively adding functionality while separating out major differences using abstract classes.

 When to use?
when you want to be able to change both the abstractions (abstract classes) and concrete classes independently.


When you want the first abstract class to define rules (Abstract TV)
The concrete class adds additional rules (Concrete TV)
An abstract class has a reference to the device and it defines abstract methods that


will be defined (Abstract Remote)

The concrete remote defines the abstract methods required.

You basically create two layers of abstraction. 

## TEMPLATE METHOD PATTERN
Used to create a group of subclasses that have to execute a similar group of methods.


You create an abstract class that contains a method called the template method.
 
 The Template method contains a series of method calls that every subclass object will call.


The subclass objects can override some of the method calls.

## ITERATOR PATTERN
The Iterator pattern provides you with a uniform way to access different collections of objects.

If you get an Array,ArrayList and Hashtable of objects, you pop out an iterator for each and treat the same.


This provides a uniform way to cycle through different collections 
You can also write polymorphic code because you can refer to each collection of objects because they’ll implement the same interface

## COMPOSITE PATTERN


Allows you to treat individual objects and compositions of objects uniformly. They allow you to represent part-whole hierarchies


Components can be further divided into smaller components
You can structure data, or represent the inner working of every part of a whole


object individually.
 
## FLYWEIGHT PATTERN

Used when you need to create a large number of similar objects.
To reduce memory usage you share objects that are similar in some way rather than creating new ones


Intrinsic State: Color Extrinsic State: Size





## STATE PATTERN
Allows an object to alter its behaviour when its internal state changes. The object will appear to change its class.

Context (Account): Maintains an instance of a concrete state subclass that defines the current state.

State: Defines an interface for encapsulating the behaviour associated with a particular state of the context.

Concrete State: Each subclass implements a behaviour associated with a state of context

 
## PROXY PATTERN

Provide a class which will limit access to another class
You may do this for security reasons, because an object is intensive to create, or is accessed from a remote location

 




## CHAIN OF RESPONSIBILITY PATTERN
This pattern sends data to an object and if that object can’t use it, it sends it to any number of other objects that may be able to use it.


Create 4 objects that can either add, subtract, multiply or divide
Send 2 numbers and a command and allow these 4 objects to decide which can handle the requested calculation.

 
## INTERPRETER PATTERN

The interpreter pattern is normally ignored.
This pattern is almost never used.
I find it to be extremely useful if combined with Java Reflection techniques. It is used to convert one representation of data into another.



 

## MEDIATOR PATTERN

It is used to handle communication between related objects (Colleagues)
All communication is handled by the mediator and the colleagues don’t need to know anything about each other.


 Gang Of Four description: Allows loose coupling by encapsulating the way disparate sets of objects interact and communicate with each other. Allows for the actions of each object set to vary independently of one another.

 

## MEMENTO PATTERN

A way to store previous states of an object easily
Memento: The basic object that is stored in different states
Originator: Sets and gets values from the currently targeted memento. Creates new


mementos and assigns current values to them.
Caretaker: Holds an array list that contains all previous versions of the memento. It can store and retrieve stored mementos.

 





## VISITOR PATTERN
Allows you to add methods to classes of different types without much altering to those classes.


You can make completely different methods depending on the class used.
Allows you to define external classes that can extend other classes without majorly editing them.

 