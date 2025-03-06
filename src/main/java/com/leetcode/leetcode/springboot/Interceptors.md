Interceptor in Spring Boot

In Spring Boot, an interceptor is used to intercept HTTP requests before they reach the controller and after the response is sent. It allows you to add pre-processing and post-processing logic to requests.

1. Key Use Cases of Interceptors
   •	Logging requests and responses.
   •	Authentication and authorization.
   •	Modifying requests before they reach the controller.
   •	Measuring execution time.
   •	Implementing global pre/post-processing logic.

2. Implementing an Interceptor in Spring Boot

Step 1: Create an Interceptor Class

You need to implement HandlerInterceptor and override its methods.

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {

    // Before the request reaches the controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
            throws Exception {
        System.out.println("Pre Handle method - Interceptor: " + request.getRequestURI());
        return true; // Returning true allows the request to proceed
    }

    // After the controller method is executed, but before sending the response
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
            org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        System.out.println("Post Handle method - Interceptor");
    }

    // After the response is sent to the client
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, 
            Exception ex) throws Exception {
        System.out.println("After Completion method - Interceptor");
    }
}

Step 2: Register the Interceptor

You must register the interceptor in a WebMvcConfigurer class.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/api/**")  // Apply to specific endpoints
                .excludePathPatterns("/api/auth/**"); // Exclude authentication endpoints
    }
}

3. Explanation of Interceptor Methods

Method Name	Description
preHandle()	Executes before the request reaches the controller. If it returns false, the request is stopped.
postHandle()	Executes after the controller method but before the response is sent to the client.
afterCompletion()	Executes after the response is sent. Useful for cleanup operations.

4. Differences Between Interceptor and Filter

Feature	Interceptor	Filter
Interface	HandlerInterceptor	javax.servlet.Filter
Spring Context Access	Has access to Spring beans	No direct access to Spring beans
Execution Order	Applied to specific handlers (Controllers)	Applied to all requests before reaching DispatcherServlet
Request Modification	Can modify request/response but is limited	Can modify request/response before reaching Spring MVC

5. Use Case Example

✅ Logging Requests

@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
System.out.println("Request URL: " + request.getRequestURI());
return true;
}

✅ Checking Authentication

@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
String authHeader = request.getHeader("Authorization");
if (authHeader == null || !authHeader.startsWith("Bearer ")) {
response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
return false;
}
return true;
}

✅ Measuring Execution Time

@Override
public void preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
request.setAttribute("startTime", System.currentTimeMillis());
}

@Override
public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
long startTime = (Long) request.getAttribute("startTime");
long executionTime = System.currentTimeMillis() - startTime;
System.out.println("Execution Time: " + executionTime + "ms");
}

6. Conclusion
   •	Interceptors are useful for pre- and post-processing requests in Spring Boot.
   •	They provide cleaner and more manageable solutions compared to filters.
   •	Use cases include logging, authentication, modifying requests, and measuring execution time.

Would you like help implementing an interceptor in your banking project for security, logging, or any other use case? 🚀