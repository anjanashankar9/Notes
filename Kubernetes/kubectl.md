### Pods

##### Using kubectl explain to discover possible API object fields
    
    $ kubectl explain pods
    $ kubectl explain pod.spec

##### Using kubectl create to create the pod

    $ kubectl create -f kubia-manual.yaml

##### Retrieving the whole definition of a running pod

    $ kubectl get po kubia-manual -o yaml
    $ kubectl get po kubia-manual -o json

##### Listing Pods
    
    $ kubectl get pods

##### Retrieving a pod’s log with kubectl logs

    $ kubectl logs kubia-manual

Specifying the container name

    $ kubectl logs kubia-manual -c kubia

##### Port forwarding to a Pod

    $ kubectl port-forward kubia-manual 8888:8080

##### List Pods with labels

    $ kubectl get po --show-labels

Show only certain labels

    $ kubectl get po -L creation_method,env

Listing subsets of pods through label selectors

    $ kubectl get po -l creation_method=manual

List all pods with label env irrespective of value

    $ kubectl get po -l env

List all pods that don't have label env

    $ kubectl get po -l '!env'

##### Modifying labels of existing pods

    $ kubectl label po kubia-manual creation_method=manual

When changing existing labels, use --overwrite

    $ kubectl label po kubia-manual-v2 env=debug --overwrite

##### Deleting Pods

    $ kubectl delete po kubia-gpu
    $ kubectl delete po -l creation_method=manual

Deleting pods in a namespace

    $ kubectl delete po --all  

### Namespaces

    $ kubectl get ns

List pods belonging to certain namespace

    $ kubectl get po --namespace kube-system

Creating Namespaces

    $ kubectl create namespace custom-namespace

Creating resource in a namespace

    $ kubectl create -f kubia-manual.yaml -n custom-namespace

TODO : Switching to a different namespace


Deleting a Namespace

    $ kubectl delete ns custom-namespace

Deleting (almost) all resources in a namespace

    $ kubectl delete all --all


### Replication Controllers

    $ kubectl get rc
    $ kubectl get replicationcontroller

    $ kubectl describe rc <rc_name>

##### Scaling up the Replication Controller

    $ kubectl scale rc kubia --replicas=10

##### Deleting a ReplicationController

Without deleting the associated pods

    $ kubectl delete rc kubia --cascade=false


### ReplicaSets

    $ kubectl get rs
    $ kubectl get replicaset

### DaemonSets

    $ kubectl get ds

### Job resource

    $ kubectl get jobs
    
### Changing Namespace in the context for all subsequent requests

    $ kubectl config set-context --current 
--namespace=<insert-namespace-name-here>