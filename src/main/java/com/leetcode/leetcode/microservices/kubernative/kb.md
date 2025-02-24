
---

### **Kubernetes (K8s) Interview Questions for Spring Boot Developers**

#### **1. What is Kubernetes, and why is it used with Docker?**
**Answer:**
- Kubernetes is an open-source container orchestration platform for automating deployment, scaling, and management of containerized applications.
- Docker packages apps into containers, while Kubernetes manages those containers across clusters of machines.
- **Use Case**: Deploying a Spring Boot microservice across multiple servers with auto-scaling and self-healing.

---

#### **2. Key Kubernetes Components**
**Answer:**
- **Pod**: Smallest deployable unit (runs one or more containers, e.g., a Spring Boot app).
- **Deployment**: Manages Pods and their lifecycle (rolling updates, rollbacks).
- **Service**: Exposes Pods to internal or external traffic (e.g., LoadBalancer, NodePort).
- **ConfigMap/Secret**: Stores configuration data (e.g., Spring profiles, DB credentials).
- **Ingress**: Manages external HTTP/S traffic routing to services.

---

#### **3. How to Deploy a Spring Boot App on Kubernetes?**
**Answer:**
1. **Dockerize** the Spring Boot app (create a Docker image).
2. Define a Kubernetes **Deployment** and **Service** in a YAML file:
   ```yaml
   # deployment.yaml
   apiVersion: apps/v1
   kind: Deployment
   metadata:
     name: spring-boot-app
   spec:
     replicas: 3
     selector:
       matchLabels:
         app: spring-boot-app
     template:
       metadata:
         labels:
           app: spring-boot-app
       spec:
         containers:
         - name: app
           image: your-docker-image:latest
           ports:
           - containerPort: 8080
   ---
   # service.yaml
   apiVersion: v1
   kind: Service
   metadata:
     name: spring-boot-service
   spec:
     selector:
       app: spring-boot-app
     ports:
       - protocol: TCP
         port: 80
         targetPort: 8080
     type: LoadBalancer
   ```
3. Apply the configuration:
   ```bash
   kubectl apply -f deployment.yaml
   kubectl apply -f service.yaml
   ```

---

#### **4. How to Use Spring Profiles in Kubernetes?**
**Answer:**  
Use **ConfigMap** to inject environment variables (e.g., `SPRING_PROFILES_ACTIVE=prod`):
```yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: spring-boot-config
data:
  SPRING_PROFILES_ACTIVE: "prod"
```
Reference the ConfigMap in the Deployment:
```yaml
env:
  - name: SPRING_PROFILES_ACTIVE
    valueFrom:
      configMapKeyRef:
        name: spring-boot-config
        key: SPRING_PROFILES_ACTIVE
```

---

#### **5. Kubernetes Secrets for Database Credentials**
**Answer:**  
Store sensitive data (e.g., passwords) in a **Secret**:
```yaml
apiVersion: v1
kind: Secret
metadata:
  name: db-secret
type: Opaque
data:
  DB_PASSWORD: <base64-encoded-password>
```
Mount the Secret in the Deployment:
```yaml
env:
  - name: DB_PASSWORD
    valueFrom:
      secretKeyRef:
        name: db-secret
        key: DB_PASSWORD
```

---

#### **6. What are Liveness and Readiness Probes?**
**Answer:**
- **Liveness Probe**: Checks if the app is running (restarts the container if it fails).
- **Readiness Probe**: Checks if the app is ready to serve traffic (e.g., after startup).
- Example for Spring Boot Actuator:
  ```yaml
  livenessProbe:
    httpGet:
      path: /actuator/health/liveness
      port: 8080
  readinessProbe:
    httpGet:
      path: /actuator/health/readiness
      port: 8080
  ```

---

#### **7. Scaling a Spring Boot App in Kubernetes**
**Answer:**
- **Manual Scaling**:
  ```bash
  kubectl scale deployment spring-boot-app --replicas=5
  ```
- **Horizontal Pod Autoscaler (HPA)**:
  ```yaml
  apiVersion: autoscaling/v2
  kind: HorizontalPodAutoscaler
  metadata:
    name: spring-boot-hpa
  spec:
    scaleTargetRef:
      apiVersion: apps/v1
      kind: Deployment
      name: spring-boot-app
    minReplicas: 2
    maxReplicas: 10
    metrics:
    - type: Resource
      resource:
        name: cpu
        target:
          type: Utilization
          averageUtilization: 50
  ```

---

#### **8. Rolling Updates and Rollbacks**
**Answer:**
- **Rolling Update**: Gradually replace old Pods with new ones (zero downtime).
  ```bash
  kubectl set image deployment/spring-boot-app app=your-image:v2
  ```
- **Rollback**: Revert to a previous version:
  ```bash
  kubectl rollout undo deployment/spring-boot-app
  ```

---

#### **9. Kubernetes Ingress for Spring Boot APIs**
**Answer:**  
Route external traffic to services (e.g., using NGINX Ingress):
```yaml
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: spring-boot-ingress
spec:
  rules:
  - host: myapp.example.com
    http:
      paths:
      - path: /
        pathType: Prefix
        backend:
          service:
            name: spring-boot-service
            port:
              number: 80
```

---

#### **10. Monitoring Spring Boot Apps in Kubernetes**
**Answer:**
- Use **Prometheus** and **Grafana** for metrics (integrate with Spring Boot Actuator).
- **Example**: Expose metrics via Actuator:
  ```yaml
  management:
    endpoints:
      web:
        exposure:
          include: health, metrics, prometheus
  ```

---

### **Key Terms to Know**
- **Helm**: Package manager for Kubernetes (e.g., deploy Spring Boot apps via Helm charts).
- **StatefulSets**: For stateful apps (e.g., databases).
- **Persistent Volumes (PV)**: Storage for Kubernetes Pods.
- **Namespaces**: Logical isolation (e.g., `dev`, `prod`).

---

Let me know if you want to dive deeper into any topic! 🚀