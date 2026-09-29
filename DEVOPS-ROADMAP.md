# Practice roadmap

Do these in order. Do not add more Java code unless you need a test scenario.

1. Git: branch, commit, merge, tag, revert.
2. Maven: clean/test/package; inspect target and test reports.
3. Docker: image layers, non-root user, healthcheck, logs, exec, resource limits.
4. GitHub Actions: CI on PR; artifact retention; image build; GHCR push.
5. SonarQube: quality gate, coverage, bug/code-smell/security findings.
6. Jenkins: reproduce CI as a Jenkinsfile; credentials; parameters; approvals.
7. Kubernetes: Deployment, Service, probes, ConfigMap, Secret, rollout/rollback.
8. Helm: values, templates, release history, upgrade/rollback.
9. AWS: IAM, VPC, subnets, security groups, ECR, EKS, CloudWatch.
10. Terraform: init/plan/apply/state/import, modules, variables, outputs, remote state.
11. Ansible: inventory, idempotence, variables, roles, handlers.
12. Observability: Prometheus metrics → Grafana dashboard → alerting.
13. Logging: add Loki/OpenSearch and correlate logs with requests.
14. Tracing: add OpenTelemetry Collector and Jaeger/Tempo.
15. Security: Trivy, dependency scanning, secrets management, RBAC.
16. Delivery: GitOps with Argo CD; blue/green or canary releases.
17. Reliability: HPA, PDB, resource tuning, failure injection, backup/restore.

The application stays intentionally boring. Your infrastructure and delivery system become the real project.
