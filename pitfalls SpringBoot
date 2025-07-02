
---

### 🧱 Architecture & Design

1. Tight coupling between layers
2. Skipping service layer
3. Overusing controllers
4. Fat domain objects
5. Mixing concerns (DTO + Entity)
6. Not using interfaces for services
7. Ignoring SOLID principles
8. No arch. diagrams & consistency
9. Spaghetti REST endpoints
10. Hardcoding logic in controllers

---

### 🔧 Dependency Injection

11. Field injection (`@Autowired`)
12. Not preferring constructor injection
13. Over-injecting unused beans
14. Using `@Component` for all classes
15. Not using prototype/singleton scope wisely
16. Ignoring bean lifecycle callbacks
17. Bean creation causing ambiguous dependencies
18. Circular dependencies
19. Over-scanning (`@ComponentScan`)
20. Not using `@Qualifier` when needed

---

### 🗃️ Persistence & Data

21. N+1 queries (lazy loading pitfalls)
22. Missing pagination for large queries
23. No optimistic locking
24. No batch inserts/updates
25. Misconfigured entity relationships
26. Lazy-loading in JSON serialization
27. Ignoring DB constraints & validation
28. Hardcoded schema
29. No database migrations (Flyway/Liquibase)
30. Mixing JPQL and native queries

---

### ⚙️ Configuration & Profiles

31. Hardcoded properties
32. Ignoring multiple profiles
33. Not securing external config
34. Misplacing YAML indentation
35. Credential leaks in Git
36. Bypassing `@RefreshScope` for runtime reload
37. Unused or stale config keys
38. Over-configuring beans
39. Not leveraging `@ConfigurationProperties`
40. Relying on default values that change

---

### 🔐 Security

41. No authentication or authorization
42. Poor session management
43. Weak or plain-text passwords
44. No CSRF protection
45. Exposing actuator endpoints
46. No input sanitization
47. Ignoring OpenID/OAuth2 properly
48. Not validating JWT signature
49. Mismanaging CORS
50. Hardcoded secret keys

---

### 📦 REST API Design

51. No versioning strategy
52. Inconsistent URI patterns
53. Misusing HTTP methods (GET with body)
54. Returning stack traces to clients
55. Ignoring error response formats
56. No pagination for list endpoints
57. Large payloads for GET
58. Forgetting HATEOAS when needed
59. Mismanaging HTTP status codes
60. Ignoring idempotency

---

### 🧪 Validation & Error Handling

61. No `@Valid` usage
62. Not handling validation exceptions
63. Missing `@Size`, `@Pattern`
64. No global exception handler
65. Generic error messages
66. No correlation IDs in logs
67. No error codes for clients
68. Monolithic exception blocks
69. Logging before throwing
70. No retry logic for transient failures

---

### 🧠 Caching

71. No caching for expensive calls
72. Stale/inappropriate cache invalidation
73. Caching mutable objects directly
74. Not mixing cache TTLs properly
75. Cache hit vs miss unnoticed
76. Ignoring `CacheManager` monitoring
77. Using default cache size
78. Not cache grouping by keys
79. Using heavy serializers (Java native)
80. No manual eviction strategy

---

### 🚀 Performance & Scalability

81. Blocking IO in reactive apps
82. Poor thread pool sizing
83. Ignoring connection pool settings
84. No performance monitoring
85. Heavy startup time (unused autoconfig)
86. No resource cleanup (threads/db connections)
87. No async processing
88. No compression/GZIP
89. Large session storage
90. Not using CDN or static caching

---

### 💬 Logging & Monitoring

91. `System.out.println` logging
92. No log rotation or levels
93. Logging sensitive info
94. No structured logging
95. Ignoring slow queries alerting
96. No use of Micrometer/Prometheus
97. Not exposing health/readiness checks
98. Missing audit logs for critical flows
99. No alerts on JVM metrics
100. Large log files without management

---

### ✅ What You Can Do Next

* Add **unit tests and integration tests** around these areas
* Run **static analysis tools** (SonarQube, SpotBugs)
* Integrate **CI/CD** with quality gates
* Enforce **code reviews** using this checklist
* Conduct **regular security & performance audits**

