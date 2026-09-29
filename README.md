# DevOps Java Lab

A deliberately tiny Java 21/Spring Boot application surrounded by a realistic DevOps/SRE practice stack.

## The only Java commands you need

```bash
mvn clean test
mvn clean package
java -jar target/devops-java-lab-1.0.0.jar
```

Then open:
- http://localhost:8080/api/hello
- http://localhost:8080/actuator/health
- http://localhost:8080/actuator/prometheus

## DevOps progression

| Stage | What to practice | Where |
|---|---|---|
| 1 | Git/GitHub | repository + `.gitignore` |
| 2 | Maven/Java CI | `pom.xml` |
| 3 | Docker | `Dockerfile`, `docker-compose.yml` |
| 4 | GitHub Actions | `.github/workflows/` |
| 5 | Jenkins | `Jenkinsfile`, `jenkins/` |
| 6 | SonarQube | `sonar-project.properties` + Jenkins stage |
| 7 | Kubernetes | `k8s/` |
| 8 | Helm | `helm/devops-java-lab/` |
| 9 | AWS + Terraform | `terraform/environments/dev/` |
| 10 | Ansible | `ansible/` |
| 11 | Prometheus | `prometheus/` |
| 12 | Grafana | `grafana/` |

## Local Docker + monitoring

First build the JAR, then start the stack:

```bash
mvn clean package
docker compose up -d
```

- App: http://localhost:8080
- Prometheus: http://localhost:9090
- Grafana: http://localhost:3000 (admin/admin)

Generate traffic:

```bash
curl http://localhost:8080/api/hello
```

## Kubernetes

For Docker Desktop Kubernetes or Minikube:

```bash
mvn clean package
docker build -t devops-java-lab:local .
kubectl apply -k k8s/overlays/dev
kubectl get pods,svc
kubectl port-forward svc/devops-java-lab 8080:80
```

For Minikube, use `minikube image load devops-java-lab:local` if needed.

## Helm

```bash
helm lint helm/devops-java-lab
helm template devops-java-lab helm/devops-java-lab
helm upgrade --install devops-java-lab helm/devops-java-lab
```

Change the image repository/tag in `helm/devops-java-lab/values.yaml` or with `--set`.

## AWS + Terraform

This lab uses VPC + EKS managed node groups so you can practice real infrastructure-as-code.

```bash
cd terraform/environments/dev
cp terraform.tfvars.example terraform.tfvars
aws configure
terraform init
terraform fmt -recursive
terraform validate
terraform plan
# Only when ready:
terraform apply
aws eks update-kubeconfig --region ap-south-1 --name devops-java-lab
```

**Cost warning:** EKS, NAT Gateway and EC2 worker nodes can incur AWS charges. Do not leave the lab running unnecessarily. Destroy when finished:

```bash
terraform destroy
```

## Jenkins

```bash
cd jenkins
docker compose up -d --build
```

Open http://localhost:8081. The Jenkinsfile contains test → Docker build → SonarQube → deployment stages.

## Ansible

Install the collection:

```bash
ansible-galaxy collection install -r ansible/requirements.yml
```

Set an actual Linux host in `ansible/inventory.ini`, then:

```bash
ansible-playbook -i ansible/inventory.ini ansible/site.yml
```

## What to add later

This repository is intentionally usable immediately. Once the basic pipeline works, add these as separate exercises rather than making the Java application more complicated:

- AWS ECR image publishing
- GitHub Actions OIDC → AWS
- Argo CD GitOps
- Kubernetes Ingress + TLS
- External Secrets / AWS Secrets Manager
- Loki + Promtail or OpenTelemetry
- Alertmanager
- Terraform remote state in S3 + locking
- Trivy image/IaC scanning
- SAST/SCA gates
- blue/green or canary deployment
- HPA based on CPU/custom metrics
