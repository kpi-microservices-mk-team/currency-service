docker tag _image_tag makstrexa/currency-service:
docker push makstrexa/currency-service

docker build -t currency-service:1.0.9 -f Dockerfile .
kubectl apply -f k8s/postgres
kubectl apply -f k8s/currencyservice
kubectl apply -f k8s/client