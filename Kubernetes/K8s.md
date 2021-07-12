#### Sidecars
From Kubernetes 1.18 containers can be marked as sidecars, so that they startup before normal containers and shutdown after all other containers have terminated. So they still behave as normal containers, the only difference is in their lifecycle.

With the Kubernetes Sidecar feature, the pod startup lifecycle will be changed, so sidecar containers will start after init containers finished, and normal containers will only be started once the sidecars become ready. It ensures that sidecars are up and running before the main processes start.

#### Multiple KUBECONFIG
eksctl adds connection information for this cluster to your ~/.kube/config and sets your current context to that cluster, so we can just start using it. If you’d rather eksctl didn’t edit that file, you can pass --kubeconfig to have it write a standalone file, which you can use in select terminals with export KUBECONFIG=.

aws eks --region us-west-2 update-kubeconfig --name smanohar-eks --kubeconfig ~/.kube/smconfig
