### Inversion of Control & Dependency Injection
IOC makes the code loosely coupled. In spring, it is the responsibility of the IOC container to inject the dependency.

    class Employee {  
        Address address;  
        Employee() {  
            address=new Address();  
        }  
    }  

The above Employee class has address tightly coupled.
Rewriting this as below removes this coupling

    class Employee {  
        Address address;  
        Employee(Address address) {  
            this.address=address;  
        }  
    }  

Dependency Injection makes the code loosely coupled making it easy to maintain and test.

### Creating a simple Spring app.
    <?xml version="1.0" encoding="UTF-8"?> 
        <beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  xmlns:p="http://www.springframework.org/schema/p" sxsi:schemaLocation="http://www.springframework.org/schema/beans  http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">  
  
        <bean id="studentbean" class="com.javatpoint.Student">  
            <property name="name" value="Vimal Jaiswal"></property>  
        </bean>  
        </beans>  

Bean element is used to define the bean for the given class.
property subelement specifies the property of the Student class called name.
The value in the property element will be set in the Student class by the Spring IOC container.

### IOC Container
The IOC container is responsible to instantiate, configure, and assemble the objects.
i.e.
Instantiate the application class.
Configure the object.
Assemble the dependencies between the objects.

There are 2 types of IOC containers.
1. BeanFactory
2. ApplicationContext

ApplicationContext interface is built on top of BeanFactory interface. It adds some extra functionality than BeanFactory, such as simple integration with Spring's AOP, message resource handling, event propagation, application layer specific context for web application.
It is better to use ApplicationContext than BeanFactory.

Using BeanFactory

    Resource resource=new ClassPathResource ("applicationContext.xml");  
    BeanFactory factory=new XmlBeanFactory(resource);  

Using ApplicationContext

    ApplicationContext context =   new       ClassPathXmlApplicationContext("applicationContext.xml";  

### Dependency Injection in Spring
DI is a design patterns that removes the dependency from the code making it loosely coupled and easy to test.

2 ways to perform DI in Spring framework.
1. By Constructor<br>
   `<constructor-arg>` subelement of `<bean>` is used.

    a. Injecting Integer value

        <bean id="e" class="com.javatpoint.Employee">` 
            <constructor-arg value="10" type="int">
            </constructor-arg>  
        </bean>

    b. Injecting String literal

        <bean id="e" class="com.javatpoint.Employee">` 
            <constructor-arg value="Hello">
            </constructor-arg>  
        </bean>

    c. Injecting Dependent Object

        <bean id="a1" class="com.javatpoint.Address">  
            <constructor-arg value="Bangalore">
            </constructor-arg>  
            <constructor-arg value="Karnataka">
            </constructor-arg>  
            <constructor-arg value="India">
            </constructor-arg>  
        </bean>  
  
    list with references

        <bean id="e" class="com.javatpoint.Employee">  
            <constructor-arg value="12" type="int">
            </constructor-arg>  
            <constructor-arg value="Sonoo">
            </constructor-arg>  
            <constructor-arg>  
                <ref bean="a1"/>  
            </constructor-arg>  
        </bean> 

    d. Injecting Collections.
        list, set, map can be injected.

        <bean id="q" class="com.javatpoint.Question">  
            <constructor-arg value="111">
            </constructor-arg>  
            <constructor-arg value="What is java?">
            </constructor-arg>  
            <constructor-arg>  
                <list>  
                    <value>Java is a programming language
                    </value>  
                    <value>Java is a Platform
                    </value>  
                    <value>Java is an Island of Indonesia
                    </value>  
                </list>  
            </constructor-arg>  
        </bean>

        <bean id="q" class="com.javatpoint.Question">  
            <constructor-arg value="11">
            </constructor-arg>  
            <constructor-arg value="What is Java?">
            </constructor-arg>  
            <constructor-arg>  
                <map>  
                    <entry key="Java is a Programming Language"  value="Ajay Kumar"></entry>  
                    <entry key="Java is a Platform" value="John Smith"></entry>  
                    <entry key="Java is an Island" value="Raj Kumar"></entry>  
                </map>  
            </constructor-arg>  
        </bean>         

    Map with references:

        <bean id="answer1" class="com.javatpoint.Answer">  
            <constructor-arg value="1"></constructor-arg>  
            <constructor-arg value="Java is a Programming Language"></constructor-arg>  
            <constructor-arg value="12/12/2001"></constructor-arg>  
        </bean>  
        
        <bean id="answer2" class="com.javatpoint.Answer">  
            <constructor-arg value="2"></constructor-arg>  
            <constructor-arg value="Java is a Platform"></constructor-arg>  
            <constructor-arg value="12/12/2003"></constructor-arg>  
        </bean>  
  
        <bean id="user1" class="com.javatpoint.User">  
            <constructor-arg value="1"></constructor-arg>  
            <constructor-arg value="Arun Kumar"></constructor-arg>  
            <constructor-arg value="arun@gmail.com"></constructor-arg>  
        </bean>  

        <bean id="user2" class="com.javatpoint.User">  
            <constructor-arg value="2"></constructor-arg>  
            <constructor-arg value="Varun Kumar"></constructor-arg>  
            <constructor-arg value="Varun@gmail.com"></constructor-arg>  
        </bean>  
  
        <bean id="q" class="com.javatpoint.Question">  
            <constructor-arg value="1"></constructor-arg>  
            <constructor-arg value="What is Java?"></constructor-arg>  
            <constructor-arg>  
                <map>  
                    <entry key-ref="answer1" value-ref="user1"></entry>  
                    <entry key-ref="answer2" value-ref="user2"></entry>  
                </map>  
            </constructor-arg>  
        </bean>  

    e. Inheriting bean

        <bean id="e1" class="com.javatpoint.Employee">  
            <constructor-arg value="101"></constructor-arg>  
            <constructor-arg  value="Sachin"></constructor-arg>  
        </bean>  
  
        <bean id="address1" class="com.javatpoint.Address">  
            <constructor-arg value="21,Lohianagar"></constructor-arg>  
            <constructor-arg value="Ghaziabad"></constructor-arg>  
            <constructor-arg value="UP"></constructor-arg>  
            <constructor-arg value="USA"></constructor-arg>  
        </bean>  
  
        <bean id="e2" class="com.javatpoint.Employee" parent="e1">  
            <constructor-arg ref="address1"></constructor-arg>  
        </bean>  

2. By setter method
    
3. 




Reference: https://www.javatpoint.com/spring-tutorial