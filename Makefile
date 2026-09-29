.PHONY: test package docker compose-up compose-down k8s helm

test:
	mvn -B clean test
package:
	mvn -B clean package

docker: package
	docker build -t devops-java-lab:local .

compose-up: package
	docker compose up -d

compose-down:
	docker compose down

k8s:
	kubectl apply -k k8s/overlays/dev

helm:
	helm upgrade --install devops-java-lab ./helm/devops-java-lab
