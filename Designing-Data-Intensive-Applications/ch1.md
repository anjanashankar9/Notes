A data-intensive application is typically built from standard building blocks that provide commonly needed functionality. For example, many applications need to:

Store data so that they, or another application, can find it again later (databases)

Remember the result of an expensive operation, to speed up reads (caches)

Allow users to search data by keyword or filter it in various ways (search indexes)

Send a message to another process, to be handled asynchronously (stream processing)

Periodically crunch a large amount of accumulated data (batch processing)


A data-intensive application is typically built from standard building blocks that provide commonly needed functionality. For example, many applications need to:

Store data so that they, or another application, can find it again later (databases)

Remember the result of an expensive operation, to speed up reads (caches)

Allow users to search data by keyword or filter it in various ways (search indexes)

Send a message to another process, to be handled asynchronously (stream processing)

Periodically crunch a large amount of accumulated data (batch processing)



The things that can go wrong are called faults, and systems that anticipate faults and can cope with them are called fault-tolerant or resilient.


Reliability
The system should continue to work correctly (performing the correct function at the desired level of performance) even in the face of adversity (hardware or software faults, and even human error). See “Reliability”.

Scalability
As the system grows (in data volume, traffic volume, or complexity), there should be reasonable ways of dealing with that growth. See “Scalability”.

Maintainability
Over time, many different people will work on the system (engineering and operations, both maintaining current behavior and adapting the system to new use cases), and they should all be able to work on it productively. See “Maintainability”.

Note that a fault is not the same as a failure[2]. A fault is usually defined as one component of the systemdeviating from its spec, whereas a failure is when the system as a whole stops providing therequired service to the user. It is impossible to reduce the probability of a fault to zero;therefore it is usually best to design fault-tolerance mechanisms that prevent faults from causingfailures.

There is no quick solution to the problem of systematic faults in software. Lots of small things canhelp: carefully thinking about assumptions and interactions in the system; thorough testing; processisolation; allowing processes to crash and restart; measuring, monitoring, and analyzing systembehavior in production. If a system is expected to provide some guarantee (for example, in a messagequeue, that the number of incoming messages equals the number of outgoing messages), it canconstantly check itself while it is running and raise an alert if a discrepancy is found