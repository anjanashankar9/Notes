A data-intensive application is typically built from standard building 
blocks that provide commonly needed functionality. 

For example, many applications need to:
1) Store data so that they, or another application, can find it again later 
(databases)
1) Remember the result of an expensive operation, to speed up reads (caches)
1) Allow users to search data by keyword or filter it in various ways (search 
   indexes)
1) Send a message to another process, to be handled asynchronously (stream 
   processing)
1) Periodically crunch a large amount of accumulated data (batch processing)


Many new tools for data storage and processing have emerged in recent years.
They are optimized for a variety of different use cases, and they no longer neatly fit into traditional categories

For example, if you have an application-managed caching layer (using Memcached or similar), or a full-text search server (such as Elasticsearch or Solr) separate from your main database, it is normally the application code’s responsibility to keep those caches and indexes in sync with the main database. Figure 1-1 gives a glimpse of what this may look like

<img ref="images/ddia_0101.png" width=700/>

There are three main concerns that are important in most software systems.

1) Reliability
The system should continue to work correctly (performing the correct function at the desired level of performance) even in the face of adversity (hardware or software faults, and even human error). See “Reliability”.

1) Scalability
As the system grows (in data volume, traffic volume, or complexity), there should be reasonable ways of dealing with that growth. See “Scalability”.

1) Maintainability
Over time different people will work on the system (engineering and 
operations, both maintaining current behavior and adapting the system to new use cases), and they should all be able to work on it productively.


#### Reliability

For software systems, typically reliability means continuing to work 
correctly even when things go wrong.
The things that can go wrong are called **faults**, and systems that anticipate
faults and can cope with them are called *fault-tolerant* or *resilient*.

Note that a fault is not the same as a failure. A fault is usually defined 
as one component of the system deviating from its spec, whereas a failure is 
when the system as a whole stops providing the required service to the user.
It is impossible to reduce the probability of a fault to zero;therefore it 
is usually best to design fault-tolerance mechanisms that prevent faults from causing failures.

There is no quick solution to the problem of systematic faults in software. 
Lots of small things can help: carefully thinking about assumptions and 
interactions in the system; thorough testing; process isolation; allowing 
processes to crash and restart; measuring, monitoring, and analyzing system 
behavior in production. If a system is expected to provide some guarantee 
(for example, in a message queue, that the number of incoming messages equals the number of outgoing messages), it can constantly check itself while it is running and raise an alert if a discrepancy is found

Hardware Faults
Software Errors
Human Errors

#### Scalability

Scalability is the term we use to describe a system’s ability to cope with increased load.
First, we need to succinctly describe the current load on the system; only then can we discuss growth questions (what happens if our load doubles?). Load can be described with a few numbers which we call load parameters.
Once you have described the load on your system, you can investigate what happens when the load increases. You can look at it in two ways:

When you increase a load parameter and keep the system resources (CPU, memory, network bandwidth, etc.) unchanged, how is the performance of your system affected?

When you increase a load parameter, how much do you need to increase the resources if you want to keep performance unchanged?

**LATENCY AND RESPONSE TIME**
Latency and response time are often used synonymously, but they are not the same. The response time is what the client sees: besides the actual time to process the request (the service time), it includes network delays and queueing delays. Latency is the duration that a request is waiting to be handled—during which it is latent, awaiting service

When generating load artificially in order to test the scalability of a system, the load-generating client needs to keep sending requests independently of the response time. If the client waits for the previous request to complete before sending the next one, that behavior has the effect of artificially keeping the queues shorter in the test than they would be in reality, which skews the measurements

While distributing stateless services across multiple machines is fairly straightforward, taking stateful data systems from a single node to a distributed setup can introduce a lot of additional complexity. For this reason, common wisdom until recently was to keep your database on a single node (scale up) until scaling cost or high-availability requirements forced you to make it distributed.

An architecture that scales well for a particular application is built around assumptions of which operations will be common and which will be rare—the load parameters. If those assumptions turn out to be wrong, the engineering effort for scaling is at best wasted, and at worst counterproductive.

#### Maintainability

we can and should design software in such a way that it will hopefully minimize pain during maintenance, and thus avoid creating legacy software ourselves. To this end, we will pay particular attention to three design principles for software systems:

Operability
Make it easy for operations teams to keep the system running smoothly.

Simplicity
Make it easy for new engineers to understand the system, by removing as much complexity as possible from the system. (Note this is not the same as simplicity of the user interface.)

Evolvability
Make it easy for engineers to make changes to the system in the future, adapting it for unanticipated use cases as requirements change. Also known as extensibility, modifiability, or plasticity.