
Where Have I Used Multithreading?

In my current role as a Software Developer at Pay10, I have utilized multithreading in several scenarios:

1. Payment Processing System:
   •	Scenario: While processing payment transactions for merchant integration, we needed to handle multiple transactions simultaneously.
   •	Implementation: I used multithreading to:
   •	Process each transaction in a separate thread using ExecutorService.
   •	Implement retry mechanisms for failed transactions using scheduled tasks.
   •	Result: Improved throughput and reduced processing time for bulk transactions.

2. Self-Onboarding Projects:
   •	Scenario: During the merchant self-onboarding process, validation and background tasks such as database updates, email triggers, and API calls were performed.
   •	Implementation: I used the Executor framework to manage a pool of threads and execute multiple independent validation tasks concurrently.
   •	Result: Enhanced user experience by reducing the waiting time for merchants during onboarding.

3. Surge Charge Calculations:
   •	Scenario: Real-time calculations for surge charges required performing multiple calculations based on dynamic parameters.
   •	Implementation: I used multithreading to divide calculations among threads using Java’s CompletableFuture, ensuring efficient execution and quick response times.

4. File Upload and Parsing:
   •	Scenario: Bulk file uploads and parsing of merchant data needed to handle large files without blocking the application.
   •	Implementation: Multithreading was employed to:
   •	Upload files in chunks using Callable tasks.
   •	Parse multiple rows concurrently and save them in the database using worker threads.
   •	Result: Improved application scalability and responsiveness.


Here’s an example of using multithreading in a project for processing payment transactions in parallel using the ExecutorService:

Scenario: Payment Transaction Processing
•	Process multiple payment transactions concurrently.
•	Implement retry logic for failed transactions.
•	Use a thread pool to manage resources effectively.

Code Example

import java.util.concurrent.*;

public class PaymentProcessor {

    private static final int THREAD_POOL_SIZE = 10;
    private final ExecutorService executorService;

    public PaymentProcessor() {
        // Creating a fixed thread pool
        this.executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    public void processTransactions(List<String> transactionIds) {
        for (String transactionId : transactionIds) {
            executorService.submit(() -> {
                try {
                    processTransaction(transactionId);
                } catch (Exception e) {
                    System.err.println("Error processing transaction: " + transactionId);
                    retryTransaction(transactionId);
                }
            });
        }
    }

    private void processTransaction(String transactionId) throws InterruptedException {
        // Simulating transaction processing
        System.out.println("Processing transaction: " + transactionId + " by " + Thread.currentThread().getName());
        Thread.sleep(2000); // Simulate time-consuming operation
        if (Math.random() > 0.8) { // Simulate random failure
            throw new RuntimeException("Transaction failed: " + transactionId);
        }
        System.out.println("Transaction successful: " + transactionId);
    }

    private void retryTransaction(String transactionId) {
        System.out.println("Retrying transaction: " + transactionId);
        // Retry logic, e.g., resubmit the task or call an external service
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        // List of mock transaction IDs
        List<String> transactions = List.of("TXN001", "TXN002", "TXN003", "TXN004", "TXN005");

        // Start processing
        processor.processTransactions(transactions);

        // Shutdown executor service
        processor.shutdown();
    }
}

Explanation:
1.	Thread Pool Creation:
•	A fixed thread pool is created using Executors.newFixedThreadPool(THREAD_POOL_SIZE) to manage a fixed number of threads.
2.	Task Submission:
•	Each transaction is submitted as a task to the thread pool using executorService.submit().
3.	Error Handling:
•	If a transaction fails, an exception is caught, and retry logic is executed.
4.	Graceful Shutdown:
•	The thread pool is shut down after all tasks are completed using shutdown() and awaitTermination().

Results:
•	Faster processing of multiple transactions.
•	Efficient resource management with a thread pool.
•	Retry mechanism for handling failures.

Would you like me to tailor this further to your specific project details or discuss advanced features like CompletableFuture?