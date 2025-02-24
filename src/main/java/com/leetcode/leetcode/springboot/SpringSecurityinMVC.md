Spring Security is a powerful framework that integrates seamlessly with Spring MVC to handle authentication, authorization, and protection against common security vulnerabilities. Below is a step-by-step guide to using Spring Security in a Spring MVC application.

Key Features of Spring Security in MVC
	1.	Authentication: Verify user identity with a database or other provider.
	2.	Authorization: Restrict access to resources based on user roles or permissions.
	3.	CSRF Protection: Mitigate cross-site request forgery attacks.
	4.	Session Management: Secure session handling with features like session timeout and concurrent session control.

Step-by-Step Implementation

1. Add Spring Security Dependencies

In your pom.xml (Maven) or build.gradle (Gradle), include the following dependencies:

Maven:

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId> <!-- Optional for MVC View -->
</dependency>

Gradle:

implementation 'org.springframework.boot:spring-boot-starter-security'
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf' // Optional

2. Configure Spring Security

Create a class to define security rules for your application.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/", "/home", "/register").permitAll() // Publicly accessible
            .antMatchers("/admin/**").hasRole("ADMIN")         // Admin-only pages
            .antMatchers("/user/**").hasAnyRole("USER", "ADMIN") // User or Admin
            .anyRequest().authenticated()                     // All other requests
            .and()
            .formLogin()
            .loginPage("/login")                               // Custom login page
            .permitAll()
            .and()
            .logout()
            .logoutSuccessUrl("/login?logout")                 // Redirect after logout
            .permitAll();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Password hashing
    }

    @Bean
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
            .and()
            .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }
}

3. Create MVC Controllers

Set up controllers to handle your endpoints.

HomeController:

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // View name for the homepage
    }

    @GetMapping("/user")
    public String userPage() {
        return "user"; // View name for the user page
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin"; // View name for the admin page
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Custom login page
    }
}

4. Create Thymeleaf Views

Add HTML files in the src/main/resources/templates directory for each page.

home.html:

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Home</title>
</head>
<body>
    <h1>Welcome to the Home Page</h1>
    <p><a href="/user">User Page</a> | <a href="/admin">Admin Page</a> | <a href="/logout">Logout</a></p>
</body>
</html>

login.html:

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form th:action="@{/login}" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username">
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
        <br>
        <button type="submit">Login</button>
    </form>
</body>
</html>

user.html:

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>User</title>
</head>
<body>
    <h1>User Page</h1>
    <p>Welcome, User!</p>
</body>
</html>

admin.html:

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Admin</title>
</head>
<body>
    <h1>Admin Page</h1>
    <p>Welcome, Admin!</p>
</body>
</html>

5. Run the Application
	•	Navigate to /login to see the login page.
	•	Test logging in with:
	•	User: user / password (redirects to /user)
	•	Admin: admin / admin (redirects to /admin)
	•	Access /logout to log out and return to the login page.

Key Concepts to Highlight in an Interview
	1.	Custom Login Page: Defined with loginPage() in SecurityFilterChain.
	2.	Role-Based Authorization: Specify roles for URL patterns using hasRole() and hasAnyRole().
	3.	BCrypt Password Encoding: Ensure passwords are securely hashed.
	4.	Security Filter Chain: Control which requests are authorized.
	5.	Session Management: Discuss session handling and CSRF protection (enabled by default in Spring Security).

Advanced Features to Explore
	•	Database Authentication: Replace in-memory authentication with user credentials stored in a database.
	•	CSRF Protection: Explain how Spring Security mitigates CSRF attacks.
	•	OAuth2/JWT Integration: Implement token-based security for REST APIs.

Let me know if you want further examples or more details!
