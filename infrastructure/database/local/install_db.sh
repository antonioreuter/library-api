#install the mysql in a minikube
echo "Installing DB in the K8"

echo "Creating a namespace..."
kubectl apply -f mysql-namespace.yaml

echo "Creating a volume..."
kubectl apply -f mysql-pv.yaml
kubectl apply -f mysql-pvc.yaml

echo "Deploying mysql..."
kubectl apply -f mysql-deployment.yaml

echo "Deploying the service..."
kubectl apply -f mysql-service.yaml

