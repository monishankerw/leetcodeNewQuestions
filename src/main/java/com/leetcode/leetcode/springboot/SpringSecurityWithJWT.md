Spring Security is a powerful framework used to secure applications in the Spring ecosystem. 
It offers a wide range of functionalities, such as authentication, authorization, and protection against common security vulnerabilities (e.g., CSRF, session fixation, etc.). 
Below is a breakdown of the key annotations, methods, terms, and concepts that are important in Spring Security, which you can use for your interview preparation.

1. Key Annotations in Spring Security:
	•	@EnableWebSecurity: This annotation is used to enable Spring Security’s web security support. It’s usually placed on a configuration class that extends WebSecurityConfigurerAdapter.
	•	@Configuration: Marks a class as a configuration class in Spring. Typically used with @EnableWebSecurity to create a Spring Security configuration.
	•	@PreAuthorize: This annotation is used to define method-level security using SpEL (Spring Expression Language). It restricts access to a method based on user roles or other attributes.
	•	@Secured: Similar to @PreAuthorize, this annotation allows you to specify roles that are allowed to access a particular method.
	•	@RolesAllowed: This is a JSR-250 annotation that defines the roles allowed to access a method.
	•	@PermitAll: This annotation allows everyone to access a particular method, bypassing any security checks.
	•	@DenyAll: This annotation explicitly denies access to a method for all users.
	•	@AuthenticationPrincipal: Used to inject the current authenticated principal (user) into a method parameter.

2. Commonly Used Classes and Interfaces:
	•	WebSecurityConfigurerAdapter: The base class for customizing Spring Security’s HTTP security. It allows you to configure things like HTTP request paths, form login, CSRF protection, etc.
	•	HttpSecurity: A builder class used to configure HTTP security (e.g., which URLs require authentication, enabling/disabling CSRF, setting up form-based login, etc.).
	•	AuthenticationManager: Interface that provides authentication capabilities. It checks if the provided credentials (username, password) match the credentials stored.
	•	Authentication: This represents the current user’s authentication information (e.g., username, roles).
	•	UserDetailsService: Interface that loads user-specific data (e.g., username, password, authorities) from a data source.
	•	GrantedAuthority: Represents the authorities granted to the user. Authorities are typically roles or permissions.
	•	SecurityContextHolder: A utility class that holds the SecurityContext, which contains authentication details of the current user.

3. Key Methods in Spring Security:
	•	configure(HttpSecurity http): Used to configure HTTP security, such as URL patterns, login methods, CSRF, etc.

@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/user/**").hasRole("USER")
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll();
}


	•	configure(AuthenticationManagerBuilder auth): Used to configure in-memory, JDBC, or custom authentication mechanisms.

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("user").password(passwordEncoder().encode("password")).roles("USER");
}


	•	passwordEncoder(): Configures a PasswordEncoder bean that will be used to encode passwords (e.g., BCryptPasswordEncoder).
	•	filterChain(HttpSecurity http): Another way of defining HTTP security and configuring filters for security actions like CSRF, CORS, etc.

4. Key Concepts and Terminology:
	•	Authentication vs Authorization:
	•	Authentication: Verifying the identity of the user (e.g., by checking username and password).
	•	Authorization: Granting access to resources based on user roles or authorities.
	•	Principal: The user or entity that is authenticated and performing actions in the system.
	•	Role-based Authorization: Spring Security allows you to secure methods or endpoints based on user roles or authorities. For example, @PreAuthorize("hasRole('ADMIN')").
	•	Method-Level Security: Security annotations such as @PreAuthorize, @Secured, and @RolesAllowed are used to secure methods by evaluating the security context of the currently authenticated user.
	•	CSRF (Cross-Site Request Forgery): A security feature that prevents unauthorized commands from being submitted by a user on behalf of an authenticated user. By default, Spring Security enables CSRF protection.
	•	Session Fixation: A type of attack where an attacker takes over a session by setting a session ID. Spring Security protects against this by invalidating the session after login.
	•	Access Control Lists (ACLs): Fine-grained access control model to manage which user can access which object or resource in an application.
	•	Remember-Me Authentication: Allows users to stay logged in even after the session has expired by saving a token in a cookie.
	•	OAuth2 and OpenID Connect: Spring Security provides support for integrating third-party authentication systems like Google, Facebook, etc., using OAuth2 or OpenID Connect protocols.
	•	JWT (JSON Web Tokens): A method of securely transmitting information between parties as a JSON object. Spring Security integrates with JWT for token-based authentication.
	•	SecurityContext: Contains information about the current authenticated user. SecurityContextHolder.getContext().getAuthentication() returns the current Authentication object.

5. Common Security Configurations:
	•	Basic Authentication: Involves sending the username and password as part of the HTTP header.

http
    .authorizeRequests()
        .antMatchers("/api/**").authenticated()
        .and()
    .httpBasic();


	•	Form-based Authentication: Allows users to authenticate via a login form.

http
    .authorizeRequests()
        .antMatchers("/login").permitAll()
        .and()
    .formLogin()
        .loginPage("/login")
        .permitAll();


	•	JWT Authentication: Typically involves setting up a filter to intercept the request, validate the JWT token, and authenticate the user.
	•	In-memory Authentication: Stores users and their roles in memory.

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
        .withUser("user").password(passwordEncoder().encode("user")).roles("USER");
}



6. Filters in Spring Security:
	•	UsernamePasswordAuthenticationFilter: A filter that processes HTTP requests to authenticate users based on the username and password.
	•	BasicAuthenticationFilter: A filter that handles HTTP Basic Authentication.
	•	OncePerRequestFilter: A base class for filters that ensures that a filter is only applied once per request.

7. Security Best Practices:
	•	Always use BCryptPasswordEncoder or another strong hashing algorithm to store passwords.
	•	Use @PreAuthorize or @Secured to control access to methods at the service layer.
	•	Enable HTTPS to ensure secure communication between clients and servers.
	•	Configure CORS (Cross-Origin Resource Sharing) correctly to control which origins can access your resources.
	•	Ensure CSRF protection is enabled for web-based applications that involve forms or state-changing operations.

These concepts and terms should give you a comprehensive understanding of Spring Security and help you prepare for interviews where Spring Security knowledge is required.

Implementing Spring Security with JWT involves several steps. 

Step-by-Step Implementation

1. Set Up Your Spring Boot Project
	1.	Dependencies: Add the required dependencies in pom.xml (Maven) or build.gradle (Gradle).

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
	•	Authentication mechanisms (e.g., form login, HTTP Basic Authentication, etc.).
	•	Authorization mechanisms (e.g., role-based access control).
	•	Protection against common vulnerabilities (e.g., CSRF, session fixation).
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>
	•	Create and sign JWTs.
	•	Parse and validate JWTs.
	•	Extract claims from JWTs (such as the subject, expiration date, etc.).
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.5</version>
</dependency>
	•	The ability to sign, parse, and validate JWTs.
	•	JWT creation using algorithms such as HMAC, RSA, etc.
	•	Handling JWT claims such as exp (expiration), iat (issued at), sub (subject), etc.

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.11.5</version>
</dependency>
	1.	Spring Security (spring-boot-starter-security) handles the overall security of 
                your application, such as authentication and authorization.
	2.	JJWT (jjwt-api, jjwt-impl, and jjwt-jackson) provides the tools to create,
                parse, and validate JWT tokens.

	2.	Project Structure:
	•	config/ (Security configuration classes)
	•	controller/ (Controller classes for handling APIs)
	•	filter/ (JWT filter for request processing)
	•	model/ (User and token-related classes)
	•	service/ (Service layer for authentication and user details)

2. Create the JWT Utility Class

This class will handle the generation, validation, and extraction of claims from JWT tokens.

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "your_secret_key";

    // Generate token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Extract username from token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Extract specific claim
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    // Validate token
    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
}

3. Configure Spring Security

Create a configuration class to set up security filters and authentication mechanisms.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll() // Allow unauthenticated access to auth endpoints
                .anyRequest().authenticated();
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder encoder, MyUserDetailsService userDetailsService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder)
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

4. Implement the UserDetailsService

Spring Security needs a service to fetch user details during authentication.

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from database (mocked for this example)
        if ("user".equals(username)) {
            return new User("user", "$2a$10$7lI1EfnT7FwOjYZyTpyQgu8UQqH1LKBOjJH.rNHtBXmZTx.aVzR1u", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}

Here, the password "$2a$10$..." is a BCrypt hash for the plain text password “password”.

5. Create JWT Authentication Filter

This filter intercepts requests, validates JWT tokens, and sets the authentication context.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (jwtUtil.validateToken(jwt, userDetails.getUsername())) {
                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));
            }
        }

        chain.doFilter(request, response);
    }
}

6. Create Authentication Controller

This controller handles login and returns a JWT token.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public String createToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Invalid username or password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        return jwtUtil.generateToken(userDetails.getUsername());
    }
}

class AuthRequest {
    private String username;
    private String password;

    // Getters and setters
}

Key Points to Mention in an Interview
	1.	JWT Workflow:
	•	The client sends login credentials.
	•	The server authenticates and generates a JWT token.
	•	The client includes the token in the Authorization header for future requests.
	2.	Stateless Authentication: No session is maintained; JWT validates the user.
	3.	Security Measures:
	•	Use a strong secret key.
	•	Set token expiration.
	•	Use HTTPS to secure token transmission.
	4.	Advantages of JWT: Scalability, reduced server overhead.


