# Docker practice

1. `mvn -B clean package`
2. `docker build -t devops-java-lab:local .`
3. `docker run --rm -p 8080:8080 devops-java-lab:local`
4. Test `http://localhost:8080/api/hello` and `/actuator/health`.
