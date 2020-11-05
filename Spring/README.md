### Inversion of Control & Dependency Injection
IOC makes the code loosely coupled. In spring, it is the responsibility of the IOC container to inject the dependency.

<pre>
<code>
class Employee {  
    Address address;  
    Employee() {  
        address=new Address();  
    }  
}  
</code>
</pre>

The above Employee class has address tightly coupled.
Rewriting this as below removes this coupling

<pre>
<code>
class Employee {  
    Address address;  
    Employee(Address address) {  
        this.address=address;  
    }  
}  
</code>
</pre>

Dependency Injection makes the code loosely coupled making it easy to maintain and test.

### Creating a simple Spring app.
<pre>
<code>
<?xml version="1.0" encoding="UTF-8"?>  
<beans  
    xmlns="http://www.springframework.org/schema/beans"  
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
    xmlns:p="http://www.springframework.org/schema/p"  
    xsi:schemaLocation="http://www.springframework.org/schema/beans  
               http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">  
  
<bean id="studentbean" class="com.javatpoint.Student">  
<property name="name" value="Vimal Jaiswal"></property>  
</bean>  
</beans>  
</code>
</pre>

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
<pre><code>
Resource resource=new ClassPathResource("applicationContext.xml");  
BeanFactory factory=new XmlBeanFactory(resource);  
</code></pre>

Using ApplicationContext
<pre><code>
ApplicationContext context =   
    new ClassPathXmlApplicationContext("applicationContext.xml");  
</code></pre>

### Dependency Injection in Spring
DI is a design patterns that removes the dependency from the code making it loosely coupled and easy to test.

2 ways to perform DI in Spring framework.
1. By Constructor<br>
   a. `<constructor-arg>` subelement of `<bean>` is used.
   <pre><code>
   <bean id="e" class="com.javatpoint.Employee">  
    <constructor-arg value="10" type="int"></constructor-arg>  
   </code></pre>
2. By setter method




Reference: https://www.javatpoint.com/spring-tutorial