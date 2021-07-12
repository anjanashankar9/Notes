## Setting up a multi-AZ EKS cluster.

### Setting up the connectivity.
#### 1. Create a new VPC.

Add a name, and IPV4 CIDR block

*Example:*

Name - anjana-vpc

IPV4 CIDR block - 10.0.0.0/16

<img src="./images-eks/createVPC.png" width="700" />

#### 2. Create Subnets

Create 4 Subnets in the above VPC. 2 Public and 2 Private subnets attached to 
the above VPC.

Subnets should be created in 2 availability zones.
For the public subnet configure it to auto-assign public IP addresses.

*Example:*

Name - anjana-public-subnet1

Availability Zone - us-east-2a

IPV4 CIDR block - 10.0.1.0/24

<img src="./images-eks/public-subnet1.png" width="700" />

Name - anjana-public-subnet2

Availability Zone - us-east-2b

IPV4 CIDR block - 10.0.2.0/24

<img src="./images-eks/public-subnet2.png" width="700" />

Name - anjana-private-subnet1

Availability Zone - us-east-2a

IPV4 CIDR block - 10.0.3.0/24

<img src="./images-eks/private-subnet1.png" width="700" />

Name - anjana-private-subnet2

Availability Zone - us-east-2b

IPV4 CIDR block - 10.0.4.0/24

<img src="./images-eks/private-subnet2.png" width="700" />

#### 3. Create Internet Gateway

Create an internet gateway instance igw-xxx.

<img src="./images-eks/igw.png" width="700" />

Attach it to the above VPC `anjana-vpc`. 

<img src="./images-eks/igw-attach-vpc.png" width="700" />

<img src="./images-eks/igw-attach-vpc2.png" width="700" />

The igw is used for the worker nodes in the cluster to communicate with the cluster control plane(api server, controllers etc.) in the AWS  managed VPC.

#### 4. Create a NAT gateway

Create a nat gateway in the Public subnet earlier created in step 2.

Allocate an elastic IP address.

<img src="./images-eks/nat-gw.png" width="700" />

The nat gateway is required by the K8s worker nodes in the private subnet to communicate with the public internet.

#### 5. Create Route Tables 

Create route tables in the VPC created in step 1.

##### Create one route table for routing public subnet traffic.

*Example*

Name - anjana-public-rt

<img src="./images-eks/create-rt-public.png" width="700" />

Associate the public subnets created in Step 2 to this route table

<img src="./images-eks/rt-public-subnet-association.png" width="700" />

Add a new default route (0.0.0.0/0) to point to the igw created in Step 3.

<img src="./images-eks/rt-public-add-route-igw.png" width="700" />

##### Create another route table for routing private subnet traffic.

*Example*

Name - anjana-private-rt

<img src="./images-eks/create-rt-private.png" width="700" />

Associate the private subnets created in Step 2 to this route table

<img src="./images-eks/rt-private-subnet-association.png" width="700" />

Add a new default route (0.0.0.0/0) to point to the nat gateway created in 
Step 4.

<img src="./images-eks/rt-private-edit-route-natgw.png" width="700" />

### Creating the EKS cluster.

#### 1. Create a new security group.

<img src="./images-eks/create-sg.png" width="700" />

#### 2. Create a new EKS cluster.

Select default version.

Select eks-hchau for the cluster service role. Not everybody has the right to create a new role in the NetSec test account.

<img src="./images-eks/eks-create-cluster-configure.png" width="700" />

Use the VPC and SG created in the connectivity steps.

<img src="./images-eks/eks-create-networking.png" width="700" />

Keep the cluster endpoint access to be “Public”.

<img src="./images-eks/eks-create-cluster-endpoint-access.png" width="700" />

Enable control plane loggings if desired.

The cluster creation may take few minutes(~10-15).

#### 3. Create a Node Group 

Create a node group with the role “eksNodeInstancerole-hcahu” with the instance type “m5.xlarge” and minimum size as 3 nodes. 
Select only private subnets.

<img src="./images-eks/create-ng.png" width="700" />

<img src="./images-eks/ng-compute-config.png" width="700" />

<img src="./images-eks/ng-node-config.png" width="700" />

<img src="./images-eks/ng-network-config.png" width="700" />

Check that the node group status is active.

### Setting up Kubeconfig on your machine to reach the EKS cluster created

*Prerequisites*

AWS cli

[Link to AWS doc](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2-mac.html)

Kubectl

    brew install kubectl


##### Update the Kubeconfig for the newly created cluster.

    aws eks --region <region> update-kubeconfig --name <EKS cluster name>

E.g

    aws eks --region us-west-2 update-kubeconfig --name anjana-eks

This by default adds the connection information for this cluster to your ~/.
kube/config and sets the current context to that cluster, so we can just 
start using it.

If you’d rather that file is not edited, pass --kubeconfig to have 
it write a standalone file.

Which can be used in select terminals with export KUBECONFIG=.

    aws eks --region <region> update-kubeconfig --name <EKS cluster name> --kubeconfig <config file path>

E.g.

    aws eks --region us-west-2 update-kubeconfig --name anjana-eks --kubeconfig ~/.kube/uswestconfig
    export KUBECONFIG=~/.kube/uswestconfig


## Reference:
[Anil's Quip Doc](https://salesforce.quip.com/NyueA1W4a5sk)