### Benefits of Distributed Systems.

Distributed Systems make it possible for many hundreds or thousands of relatively inexpensive computers to communicate with one another and work together, creating the outward appearance of a single, high-powered computer.

*Primary Benefit* os the ability to massively scale computing power relatively inexpensively, enabling organizations to scale up their businesses to a global level in a way that was not possible even a decade ago.

### Performance Problems in Distributed Systems

Operators of distributed systems must address an array of challenges that affect the performance of the system as a whole as well as individual applications’ performance. In a true distributed system, applications are split into smaller units of work, which are spread across many nodes and communicate with one another either directly or via shared input/output data.

Additional performance challenges arise with multi-tenant distributed systems, in which different users, groups, and possibly business units run different applications on the same cluster. (This is in contrast to a single, large distributed application, such as a search engine, which is quite complex and has intertask dependencies but is still just one overall application.)

#### Scheduling

Scheduling is a challenge due to following goals:
1. High overall hardware utilization
2. Predictable run times for high priority applications.
3. Reducing latency for jobs.
4. Ensuring fairness.

#### Hardware Bottlenecks

A single job can saturate the network or disk I/O, slowing down every other job. 

Centralized services used by every node in the system.

### Lack of visibility

Truly useful monitoring for multi-tenant distributed systems must track hardware usage metrics at a sufficient level of granularity for each interesting process on each node. Gathering, processing, and presenting this data for large clusters is a significant challenge, in terms of both systems engineering (to process and store the data efficiently and in a scalable fashion) and the presentation-level logic and math (to present it usefully and accurately). Even for limited, node-level metrics, traditional monitoring systems do not scale well on large clusters of hundreds to thousands of nodes.

### Impact on Business from Performance problems

1. Inconsistent, unpredictable application run times.
2. Underutilized hardware
3. Cluster instability.