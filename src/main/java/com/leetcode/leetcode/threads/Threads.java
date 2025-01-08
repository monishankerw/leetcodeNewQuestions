package com.leetcode.leetcode.threads;
/*
MultiTasking: Executing(ˈए᠎̮क्सिक्‍यूट्‌) server tasks simultaneously is concepts of Multitasking.
                          Two Types:
                            1. Process Based MultiTasking
                            2. Thread Based Multitasking
       Its main purpose to improve the performance of the system by readucing the response time.


       Process-Based Multitasking
       In process-based multitasking, each task runs in a separate process. This example runs multiple commands in parallel:
       Thread-Based Multitasking
       In thread-based multitasking, multiple threads run within the same process. Here’s an example using threads:
       Q. What is the main purpose of multitasking?
      Its main purpose is to improve the performance of the system by reducing the response time.

           MultiThreading: MultiThreading is a java Features, that allows concurrent execution of two or more parts of a program for maximum utilization of cpu.


    Thread:

       MultiTasking done at program level is called as thread.
       -> Threads are light weight.
       -> Threads share same address space.
       -> Separate part of execution in program.
       ->Interthread communication is less expensive.
       -> Context switching between thread is low cost.

       Process
       -> A Process is a program is execution.
       ->Process are heavy weight.
       ->Process required Separate address space.
       ->Interthread communication is expensive.
       -> Context switching between thread is costly.

       ADVANTAGE OF THREAD:
       1. Thread can be utilized to free up the main thread.
       2. Thread can be used to breakup a task into smaller unit that can be executed concurrently.

       DISVANTAGE OF THREAD:
       1. When more threads, the code becomes difficult to debug and maintain.
       2. Thread creation put a load on the system memory and cpu.

       TWO types of created by using:
       1. extending the Thread Class.
       2. implementing the Runnable Interface.

       1. extending the Thread Class.
       -> Here we inherited run method from thread we override user defined class.
       -> To start run Thread we use start method of thread class.


 */
public class Threads {
    public static class ThreadClass extends Thread{
        @Override
        public void run() {
            for (int i=0;i<1000;i++){
                System.out.println("Test1");
            }
        }

        public static void main(String[] args) {
            ThreadClass a=new ThreadClass();
            a.start();
            for (int i=0;i<1000;i++){
                System.out.println("test2");
            }
        }
    }
    public static class A extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("Thread" + Thread.currentThread().getId() + "is Running");
            } catch (Exception e) {
                System.out.println("Exception Test:" + e);
            }
        }

        public static void main(String[] args) {
            for (int i = 0; i < 122; i++) {
                System.out.println("Task2");
             A b = new A();
                b.start();
            }
        }
    }

    public static class ThreadExp extends Thread{
        @Override
        public void run() {
            System.out.println("Hello!!!!...");
        }

        public static void main(String[] args) {
            ThreadExp threadExp=new ThreadExp();
            threadExp.start();
            threadExp.stop();
            threadExp.start();
        }//Exception in thread "main" java.lang.IllegalThreadStateException
        // at java.base/java.lang.Thread.start
        //Thread cannot be started twice
    }
    /*
     Interface Runnable
       -> Which Thread will executed how much time can not predicated by programmer as it is decided by the processor depending or it availability.

       CREATING A THREAD USING Runnable Interface
       1. create a class that implements Runnable.
       2. Provide a run method in the runnable class.
       3. Create an instance of the Thread class and pass your Runnable Object to its constructor as a parameter.
       4. call the Thread object start method.

       package com.customerService.thread;

       public class Thred implements Runnable{
           @Override
           public void run() {
               for(int i=0;i<100;i++){
                   System.out.println("Task1");
               }
           }

           public static void main(String[] args) {
               Thred thred=new Thred();
               Thread thread=new Thread(thred);
               thread.start();
               for (int i=0;i<1000;i++){
                   System.out.println("Task2");
               }
           }
       }

       THREAD CREATING BY IMPLEMENTING THE Runnable Interface
       we create a new class which implements java.lang.Runnable interface and override run() method.
       Then we instantiate a Thread object and call start() method on this object.

       Thread class and Runnable Interface
       1. If we extend the Thread class our class can not extend any other class because java does not support multiple inheritance.
       But if we implement the rRunnable interface our class can still extend other base class.
       2. We can achieve basic functionality a thread by extending Thread class because it provides same in build method like yield(),interrupt() etc.
       that are not available in runnable interface.
       3. Using runnable we goes you an object that can be shared amoung multiple thread.

       Q. Which one is the best approach and why?
       ->Best way to define a thread is by implementing Runnable interface approach recommended.
       ->If we use Thread class approach our class will always extend thread class hence we miss inheritance advantage of any oher class.
       ->But in implementing runnable approach we can inherit oher class as well and we do not miss the inheritance benefits.


       t.start() vs t.run()
       ->t.start() will create a new Thread which is responsible for the execution of run() method but in the case of t.run() a new thread
       won't be create and run() method will be executed just like a normal method call.


       Q. Overloading of run() method is possible or not?
       Overload run() method is always possible but the Thread class start() method will always invoke the no argument run() method and for the over loaded run() method we have to call it explicitly.

       Q. If we don't override the run method and call the start() method then what will be the output we will get?
       Ex:
       class Threads1 extends Thread {
           main(){
               Threads1 t1=new Threads1();
               t.start();

           }
       }
       ->If we are override run() method and call the start() method then Thread can run() method will be executed hence we cannot get any output.
       public class B extends Thread{
           public void start(){
               System.out.println("Task2");
           }
              public void run() {
                  System.out.println("Task1");
              }

              public static void main(String[] args) {
                  B b=new B();
                  b.start();
              }
          }
          //output Task2
       if we override the start() method then our start() method will be executed like a normal method call and new thread won't be created.

       q. After starting a thread if we are trying to restart the thread then what will happen.
       to get runtime exception saying illagal thread state exception.

       Q. How we can get name of a thread?
       By using Thread.current Thread().getName() method we can get the name of a thread.

       Q. How we can set name of a thread?
       By using Thread.currentThread().setName() method we can set name of a thread.


     */
    public static class RunnableClass implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<1000;i++){
                System.out.println("Test1");
            }
        }

        public static void main(String[] args) {
           RunnableClass a=new RunnableClass();
            Thread t=new Thread(a);
            t.start();
            for (int i=0;i<1000;i++){
                System.out.println("Test2");
            }
        }
    }

    /*
     Thread Life Cycle
       https://www.geeksforgeeks.org/lifecycle-and-states-of-a-thread-in-java/

                start()       <-------                                       <-------            <-------      -
       New State-------->Active state(Runnable()(sleep(),wait(),notify(),notifyAll()))----->Running----->Terminal----->Deadlock()

       1. New State
       2. Active State(running, runnable)
       3. waiting/block state
       4. Timed wating state
       5.Terminated state

       1. New State
       ->By default, a Thread will be in a new state
       -> In this state, code has not yet been run and the execution process is not yet initiated.

       2. Active State
       ->When a thread invokes the start() method, it moves from the new state to the active state.
       Two state 1. Running 2. Runnable
       1. Runnable: A thread, that is ready to run is then moved to the runnable state, it is the duty of the thread scheduler to provide the
       thread time to run, moving the thread the running state.

       Thread Scheduler: is the java is the component of jvm that determines the execution order of multiple threads on a single process(cpu)
       It decides the order in which threads should run. This process is called Thread scheduler in java.

       Running:
       ->When the thread gets the cpu,it moves from the runnable to the running state.
       Generally,the most common change in the state of the thread is form runnable to running and again back to runnable.

       3. Blocked or waiting:
       ->When ever a thread is inactive for a span of time (not permanently) then, either the thread is in the blocked state or is in the waiting state.

       4. Terminated
       ->A thread reaches the termination state because of the following reasons:
       when a thread has finished its job, then it exists or terminates normally.

       5. Abnormal termination:
       ->It occurs when some unusual events such as an unhandled exception or segmentation faults.
       public class Threads extends Thread{
           @Override
           public void run() {
               System.out.println("Running");

           }

           public static void main(String[] args) {
               Threads threads=new Threads();
               System.out.println(threads.getState());
               threads.start();
               System.out.println(threads.getState());
               try{
                   Thread.sleep(5000);
               } catch (InterruptedException e) {
                   System.out.println(e);

                   throw new RuntimeException(e);
               }
               System.out.println(threads.getState());
           }
       }
       NEW
       RUNNABLE
       Running
       TERMINATED


       package com.customerService.thread;

       public class Sleep {
           public static void main(String[] args) throws InterruptedException {
               try{
                   Thread.sleep(5000);
               }
               catch (Exception e){
                   System.out.println(e);
               }
               System.out.println("Testing");
           }
       }
       //Testing
     */
    public static class ThreadLifeCycle extends Thread {

        @Override
        public void run() {
            System.out.println("Thread is running");
            try {
                Thread.sleep(500); // Pauses the thread briefly
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
            System.out.println("Thread is completing execution");
        }

        public static void main(String[] args) {
            ThreadLifeCycle threadLifeCycle = new ThreadLifeCycle();

            // Step 1: New state - Thread is created but not started
            System.out.println("State after creation: " + threadLifeCycle.getState()); // NEW

            // Step 2: Runnable state - Thread is started
            threadLifeCycle.start();
            System.out.println("State after starting: " + threadLifeCycle.getState()); // RUNNABLE

            // Step 3: Timed Waiting - Pausing the main thread briefly
            try {
                Thread.sleep(100); // Main thread is in TIMED_WAITING state
                System.out.println("State during sleep: " + threadLifeCycle.getState()); // RUNNABLE or TIMED_WAITING (if still sleeping)
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }

            // Step 4: Wait for thread to finish and check Terminated state
            try {
                threadLifeCycle.join(); // Main thread waits for threadLifeCycle to finish
            } catch (InterruptedException e) {
                System.out.println("Join interrupted");
            }
            System.out.println("State after completion: " + threadLifeCycle.getState()); // TERMINATED
        }
    }

    /*
     Q. In how many ways we can prevent a thread execution?
       By using (yield,join and sleep) method we can stop a thread from execution.

       Q. What is the purpose of yield method?
       ->yield method causes to pass current execution thread to give the chance for waiting thread of some priority if there is no waiting
       thread or all waiting threads have low priority then same thread can contineous its execution.
       ->If multiple threads are waiting with the same priority then which waiting thread will get the chance we can not expect it depends on thread scheduler.
       ->The thread which is yielded when it will get chance once again it depends on thread scheduler and can not expect exactly.


       Q. What is the purpose of join() method?
       -> join() will until the timeout expires or thread finishes.
       ->exmp: if a thread t1 wants to wait until completing t2 and t1 has to call t2.join();
       ->If t1 executes t2.join() then immediately then t1 will be entered into waiting state until t2 completed once t2 completed then t1 can contineous its execution.



       Join(): it will until the timeout expires or thread finishes.
       Sleep(): It will just wait for the specified amount of time unless interrupted.
       wait(): it is hold execution of Thread.
       notify(): It will end the wait of any one thread so that it can resume execution.
       notifyAll():It will end the wait of all the thread at once which are in waiting states.The Thread will now execute in queue one after another.
       Q. What will happen if the thread call join() method on itself?
       If the thread calls join method on itself then the program will be stucked, in this case thread then to wait infinite amount of time.

       Q. How to threads can communicate with each other?
       Two threads can be communicate with each other by using: wait(),notify()&notifyAll() method

       ->These methods are present in object class but not in thread class.
       ->Thread can call these methods on any java object that's why there are present in object class.

       public class C extends Thread{
           int balance;
           public void run(){
               for(int i=0;i<100;i++){
                   balance=balance+1;
               }
               notify();
           }
       }

       public class Threads1 {
           public static void main(String[] args) {
               C c1=new C();
               c1.start();
               synchronized (c1){
                   try{
                       c1.wait();
                   }
                   catch (Exception e){
                       System.out.println(e);
                   }
               }
               System.out.println(c1.balance);

           }
       }/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=61885:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/monishanker/Downloads/customerService/target/test-classes:/Users/monishanker/Downloads/customerService/target/classes:/Users/monishanker/.m2/repository/org/springframework/boot/spring-boot-starter-data-jpa/2.7.6/spring-boot-starter-data-jpa-2.7.6.jar:/Users/monishanker/.m2/repository/org/springframework/boot/spring-boot-starter-aop/2.7.6/spring-boot-starter-aop-2.7.6.jar:/Users/monishanker/.m2/repository/org/springframework/spring-aop/5.3.24/spring-aop-5.3.24.jar:/Users/monishanker/.m2/repository/org/aspectj/aspectjweaver/1.9.7/aspectjweaver-1.9.7.jar:/Users/monishanker/.m2/repository/org/springframework/boot/spring-boot-starter-jdbc/2.7.6/spring-boot-starter-jdbc-2.7.6.jar:/Users/monishanker/.m2/repository/com/zaxxer/HikariCP/4.0.3/HikariCP-4.0.3.jar:/Users/monishanker/.m2/repository/org/springframework/spring-jdbc/5.3.24/spring-jdbc-5.3.24.jar:/Users/monishanker/.m2/repository/jakarta/transaction/jakarta.transaction-api/1.3.3/jakarta.transaction-api-1.3.3.jar:/Users/monishanker/.m2/repository/jakarta/persistence/jakarta.persistence-api/2.2.3/jakarta.persistence-api-2.2.3.jar:/Users/monishanker/.m2/repository/org/hibernate/hibernate-core/5.6.14.Final/hibernate-core-5.6.14.Final.jar:/Users/monishanker/.m2/repository/org/jboss/logging/jboss-logging/3.4.3.Final/jboss-logging-3.4.3.Final.jar:/Users/monishanker/.m2/repository/net/bytebuddy/byte-buddy/1.12.19/byte-buddy-1.12.19.jar:/Users/monishanker/.m2/repository/antlr/antlr/2.7.7/antlr-2.7.7.jar:/Users/monishanker/.m2/repository/org/jboss/jandex/2.4.2.Final/jandex-2.4.2.Final.jar:/Users/monishanker/.m2/repository/com/fasterxml/classmate/1.5.1/classmate-1.5.1.jar:/Users/monishanker/.m2/repository/org/hibernate/common/hibernate-commons-annotations/5.1.2.Final/hibernate-commons-annotations-5.1.2.Final.jar:/Users/monishanker/.m2/repository/org/glassfish/jaxb/jaxb-runtime/2.3.7/jaxb-runtime-2.3.7.jar:/Users/monishanker/.m2/repository/org/glassfish/jaxb/txw2/2.3.7/txw2-2.3.7.jar:/Users/monishanker/.m2/repository/com/sun/istack/istack-commons-runtime/3.0.12/istack-commons-runtime-3.0.12.jar:/Users/monishanker/.m2/repository/com/sun/activation/jakarta.activation/1.2.2/jakarta.activation-1.2.2.jar:/Users/monishanker/.m2/repository/org/springframework/data/spring-data-jpa/2.7.6/spring-data-jpa-2.7.6.jar:/Users/monishanker/.m2/repository/org/springframework/data/spring-data-commons/2.7.6/spring-data-commons-2.7.6.jar:/Users/monishanker/.m2/repository/org/springframework/spring-orm/5.3.24/spring-orm-5.3.24.jar:/Users/monishanker/.m2/repository/org/springframework/spring-context/5.3.24/spring-context-5.3.24.jar:/Users/monishanker/.m2/repository/org/springframework/spring-tx/5.3.24/spring-tx-5.3.24.jar:/Users/monishanker/.m2/repository/org/springframework/spring-beans/5.3.24/spring-beans-5.3.24.jar:/Users/monishanker/.m2/repository/org/slf4j/slf4j-api/1.7.36/slf4j-api-1.7.36.jar:/Users/monishanker/.m2/repository/org/springframework/spring-aspects/5.3.24/spring-aspects-5.3.24.jar:/Users/monishanker/.m2/repository/org/springframework/boot/spring-boot-starter-web/2.7.6/spring-boot-starter-web-2.7.6.jar:/Users/monishanker/.m2/repository/org/springframework/boot/spring-boot-starter/2.7.6/spring-boot-starter-2.7.6.jar:/Users/monishanker/.m2/repository/org/springframework/boot/spring-boot/2.7.6/spring-boot-2.7.6.jar:/Users/monishanker/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/2.7.6/spring-boot-autoconfigure-2.7.6.jar:/Users/monishanker/.m2/repository/org/springframework/boot/spring-boot-starter-logging/2.7.6/spring-boot-starter-logging-2.7.6.jar:/Users/monishanker/.m2/repository/ch/qos/logback/logback-classic/1.2.11/logback-classic-1.2.11.jar:/Users/monishanker/.m2/repository/ch/qos/logback/logback-core/1.2.11/logback-core-1.2.11.jar:/Users/monishanker/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.17.2/log4j-to-slf4j-2.17.2.jar:/Users/monishanker/.m2/repository/org/slf4j/jul-to-slf4j/1.7.36/jul-to-slf4j-1.7.36.jar:/Users/monishanker/.m2/repository/jakarta/annotation/jakarta.annotation-api/1.3.5/jakarta.annotation-api-1.3.5.jar:/Users/monishanker/.m2/repository/org/yaml/snakeyaml/1.30/snakeyaml-1.30.jar:/Users/monishanker/.m2/repository/org/springframework/boot/spring-boot-starter-json/2.7.6/spring-boot-starter-json-2.7.6.jar:/Users/monishanker/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.13.4.2/jackson-databind-2.13.4.2.jar:/Users/monishanker/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.13.4/jackson-annotations-2.13.4.jar:/Users/monishanker/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.13.4/jackson-core-2.13.4.jar:/Users/monishanker/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.13.4/jackson-datatype-jdk8-2.13.4.jar:/Users/monishanker/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.13.4/jackson-datatype-jsr310-2.13.4.jar:/Users/monishanker/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.13.4/jackson-module-parameter-names-2.13.4.jar:/Users/monishanker/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/2.7.6/spring-boot-starter-tomcat-2.7.6.jar:/Users/monishanker/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/9.0.69/tomcat-embed-websocket-9.0.69.jar:/Users/monishanker/.m2/repository/org/springframework/spring-web/5.3.24/spring-web-5.3.24.jar:/Users/monishanker/.m2/repository/org/springframework/spring-webmvc/5.3.24/spring-webmvc-5.3.24.jar:/Users/monishanker/.m2/repository/org/springframework/spring-expression/5.3.24/spring-expression-5.3.24.jar:/Users/monishanker/.m2/repository/com/mysql/mysql-connector-j/8.0.31/mysql-connector-j-8.0.31.jar:/Users/monishanker/.m2/repository/org/projectlombok/lombok/1.18.24/lombok-1.18.24.jar:/Users/monishanker/.m2/repository/org/springframework/boot/spring-boot-starter-test/2.7.6/spring-boot-starter-test-2.7.6.jar:/Users/monishanker/.m2/repository/org/springframework/boot/spring-boot-test/2.7.6/spring-boot-test-2.7.6.jar:/Users/monishanker/.m2/repository/org/springframework/boot/spring-boot-test-autoconfigure/2.7.6/spring-boot-test-autoconfigure-2.7.6.jar:/Users/monishanker/.m2/repository/com/jayway/jsonpath/json-path/2.7.0/json-path-2.7.0.jar:/Users/monishanker/.m2/repository/net/minidev/json-smart/2.4.8/json-smart-2.4.8.jar:/Users/monishanker/.m2/repository/net/minidev/accessors-smart/2.4.8/accessors-smart-2.4.8.jar:/Users/monishanker/.m2/repository/org/ow2/asm/asm/9.1/asm-9.1.jar:/Users/monishanker/.m2/repository/jakarta/xml/bind/jakarta.xml.bind-api/2.3.3/jakarta.xml.bind-api-2.3.3.jar:/Users/monishanker/.m2/repository/jakarta/activation/jakarta.activation-api/1.2.2/jakarta.activation-api-1.2.2.jar:/Users/monishanker/.m2/repository/org/assertj/assertj-core/3.22.0/assertj-core-3.22.0.jar:/Users/monishanker/.m2/repository/org/hamcrest/hamcrest/2.2/hamcrest-2.2.jar:/Users/monishanker/.m2/repository/org/junit/jupiter/junit-jupiter/5.8.2/junit-jupiter-5.8.2.jar:/Users/monishanker/.m2/repository/org/junit/jupiter/junit-jupiter-api/5.8.2/junit-jupiter-api-5.8.2.jar:/Users/monishanker/.m2/repository/org/opentest4j/opentest4j/1.2.0/opentest4j-1.2.0.jar:/Users/monishanker/.m2/repository/org/junit/platform/junit-platform-commons/1.8.2/junit-platform-commons-1.8.2.jar:/Users/monishanker/.m2/repository/org/apiguardian/apiguardian-api/1.1.2/apiguardian-api-1.1.2.jar:/Users/monishanker/.m2/repository/org/junit/jupiter/junit-jupiter-params/5.8.2/junit-jupiter-params-5.8.2.jar:/Users/monishanker/.m2/repository/org/junit/jupiter/junit-jupiter-engine/5.8.2/junit-jupiter-engine-5.8.2.jar:/Users/monishanker/.m2/repository/org/junit/platform/junit-platform-engine/1.8.2/junit-platform-engine-1.8.2.jar:/Users/monishanker/.m2/repository/org/mockito/mockito-core/4.5.1/mockito-core-4.5.1.jar:/Users/monishanker/.m2/repository/net/bytebuddy/byte-buddy-agent/1.12.19/byte-buddy-agent-1.12.19.jar:/Users/monishanker/.m2/repository/org/objenesis/objenesis/3.2/objenesis-3.2.jar:/Users/monishanker/.m2/repository/org/mockito/mockito-junit-jupiter/4.5.1/mockito-junit-jupiter-4.5.1.jar:/Users/monishanker/.m2/repository/org/skyscreamer/jsonassert/1.5.1/jsonassert-1.5.1.jar:/Users/monishanker/.m2/repository/com/vaadin/external/google/android-json/0.0.20131108.vaadin1/android-json-0.0.20131108.vaadin1.jar:/Users/monishanker/.m2/repository/org/springframework/spring-core/5.3.24/spring-core-5.3.24.jar:/Users/monishanker/.m2/repository/org/springframework/spring-jcl/5.3.24/spring-jcl-5.3.24.jar:/Users/monishanker/.m2/repository/org/springframework/spring-test/5.3.24/spring-test-5.3.24.jar:/Users/monishanker/.m2/repository/org/xmlunit/xmlunit-core/2.9.0/xmlunit-core-2.9.0.jar:/Users/monishanker/.m2/repository/org/apache/poi/poi-ooxml/5.1.0/poi-ooxml-5.1.0.jar:/Users/monishanker/.m2/repository/org/apache/poi/poi/5.1.0/poi-5.1.0.jar:/Users/monishanker/.m2/repository/commons-codec/commons-codec/1.15/commons-codec-1.15.jar:/Users/monishanker/.m2/repository/org/apache/commons/commons-math3/3.6.1/commons-math3-3.6.1.jar:/Users/monishanker/.m2/repository/com/zaxxer/SparseBitSet/1.2/SparseBitSet-1.2.jar:/Users/monishanker/.m2/repository/org/apache/poi/poi-ooxml-lite/5.1.0/poi-ooxml-lite-5.1.0.jar:/Users/monishanker/.m2/repository/org/apache/xmlbeans/xmlbeans/5.0.2/xmlbeans-5.0.2.jar:/Users/monishanker/.m2/repository/org/apache/commons/commons-compress/1.21/commons-compress-1.21.jar:/Users/monishanker/.m2/repository/commons-io/commons-io/2.11.0/commons-io-2.11.0.jar:/Users/monishanker/.m2/repository/com/github/virtuald/curvesapi/1.06/curvesapi-1.06.jar:/Users/monishanker/.m2/repository/org/apache/logging/log4j/log4j-api/2.17.2/log4j-api-2.17.2.jar:/Users/monishanker/.m2/repository/org/apache/commons/commons-collections4/4.4/commons-collections4-4.4.jar:/Users/monishanker/.m2/repository/org/apache/tomcat/embed/tomcat-embed-jasper/9.0.69/tomcat-embed-jasper-9.0.69.jar:/Users/monishanker/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/9.0.69/tomcat-embed-core-9.0.69.jar:/Users/monishanker/.m2/repository/org/apache/tomcat/tomcat-annotations-api/9.0.69/tomcat-annotations-api-9.0.69.jar:/Users/monishanker/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/9.0.69/tomcat-embed-el-9.0.69.jar:/Users/monishanker/.m2/repository/org/eclipse/jdt/ecj/3.18.0/ecj-3.18.0.jar com.customerService.thread.Threads1
       Exception in thread "Thread-0" java.lang.IllegalMonitorStateException: current thread is not owner
       	at java.base/java.lang.Object.notify(Native Method)
       	at com.customerService.thread.C.run(C.java:9)
       100


     */
    /*
    1. What is Demon Thread?
A Demon Thread is a background service which run as a low priority thread
and performs background operation like garbage collection.

Ex: If main thread runs with low memory then jvm calls garbage collector to destroyed useless objects so that
number of bytes of free memory will improve so that main thread will continue its execution.

2. How can we check the demon nature of a thread?
using Daemon() method
public Boolean isDaemon()

3. How can we convert a normal thread into demon thread?
We can make a thread demon thread by using SetDemon() method of thread class.
public void SetDemon(Boolean b)
But changing demon nature is possible before starting of a thread only.
After starting a thread if we are trying to change the demon nature then we will get illegal thread start execution.


Here are some multiple-choice questions (MCQs) based on the concept of daemon threads in Java:

### MCQs

1. **What is a daemon thread in Java?**
    - A) A thread that is set to run at the highest priority
    - B) A background service thread that runs at low priority and performs background operations
    - C) A thread that runs forever without stopping
    - D) A thread that cannot be terminated

   **Answer**: B) A background service thread that runs at low priority and performs background operations

2. **Which of the following is an example of a daemon thread in Java?**
    - A) Main thread
    - B) User-defined thread
    - C) Garbage collector thread
    - D) Any thread created with `new Thread()`

   **Answer**: C) Garbage collector thread

3. **How can you check if a thread is a daemon thread?**
    - A) Using `isDaemon()` method
    - B) Using `isAlive()` method
    - C) Using `isBackground()` method
    - D) Using `getDaemon()` method

   **Answer**: A) Using `isDaemon()` method

4. **Which of the following methods is used to convert a normal thread into a daemon thread?**
    - A) `setDaemon(boolean b)`
    - B) `setPriority(int p)`
    - C) `setBackground(boolean b)`
    - D) `setThreadType(boolean b)`

   **Answer**: A) `setDaemon(boolean b)`

5. **When must a thread be converted to a daemon thread in order to avoid an `IllegalThreadStateException`?**
    - A) Before the thread is created
    - B) Before the thread starts running
    - C) After the thread starts running
    - D) After the thread completes execution

   **Answer**: B) Before the thread starts running

6. **What happens to daemon threads when the Java Virtual Machine (JVM) stops?**
    - A) Daemon threads continue running in the background.
    - B) Daemon threads are terminated immediately.
    - C) Daemon threads throw an exception and continue running.
    - D) Daemon threads finish their tasks and then terminate.

   **Answer**: B) Daemon threads are terminated immediately.

7. **What is the output of `isDaemon()` method if a thread is a user thread?**
    - A) `true`
    - B) `false`
    - C) `1`
    - D) `0`

   **Answer**: B) `false`

8. **Which of the following statements is true about daemon threads?**
    - A) Daemon threads are always created by the JVM and cannot be created by the user.
    - B) Daemon threads must always complete execution before the JVM terminates.
    - C) Daemon threads are used for background operations and terminate automatically when no user threads are running.
    - D) Daemon threads run at the highest priority in the JVM.

   **Answer**: C) Daemon threads are used for background operations and terminate automatically when no user threads are running.

9. **What will happen if we attempt to set a thread as a daemon after it has started?**
    - A) The thread will be successfully set as a daemon.
    - B) The daemon status of the thread will not change.
    - C) An `IllegalThreadStateException` will be thrown.
    - D) The thread will terminate immediately.

   **Answer**: C) An `IllegalThreadStateException` will be thrown.

10. **Which of the following methods can be used to start a thread after setting it as a daemon?**
    - A) `setDaemon()` method
    - B) `start()` method
    - C) `run()` method
    - D) `setBackground()` method

    **Answer**: B) `start()` method
     */
    public static class DaemonThreadExample {
        public static void main(String[] args) {
            // Creating a user (non-daemon) thread
            Thread userThread = new Thread(() -> {
                System.out.println("User thread is starting...");
                try {
                    Thread.sleep(3000); // Simulate some work in the user thread
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("User thread has finished.");
            });

            // Creating a daemon thread
            Thread daemonThread = new Thread(() -> {
                while (true) {
                    System.out.println("Daemon thread is running...");
                    try {
                        Thread.sleep(1000); // Daemon thread runs in background
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // Set the daemonThread to be a daemon
            daemonThread.setDaemon(true);

            // Start both threads
            userThread.start();
            daemonThread.start();

            // Output the daemon status of each thread
            System.out.println("Is userThread a daemon? " + userThread.isDaemon()); // Output: false
            System.out.println("Is daemonThread a daemon? " + daemonThread.isDaemon()); // Output: true
        }
    }
    public static class DeadlockExample {
        private static final Object lock1 = new Object();
        private static final Object lock2 = new Object();

        public static void main(String[] args) {
            Thread thread1 = new Thread(() -> {
                synchronized (lock1) {
                    System.out.println("Thread1: Holding lock1...");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    System.out.println("Thread1: Waiting for lock2...");
                    synchronized (lock2) {
                        System.out.println("Thread1: Holding lock1 & lock2...");
                    }
                }
            });

            Thread thread2 = new Thread(() -> {
                synchronized (lock2) {
                    System.out.println("Thread2: Holding lock2...");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    System.out.println("Thread2: Waiting for lock1...");
                    synchronized (lock1) {
                        System.out.println("Thread2: Holding lock2 & lock1...");
                    }
                }
            });

            thread1.start();
            thread2.start();
        }
    }
/*
 Q. Thread pool
       ->Thread pool is collection of thread when request is handle using a thread multitasking can be performed and hence it will give a feel to user that
       all the request are being at once.
       ->Thread pool is a pool of already created threads ready to do our job.
       ->Thread pool framework also known as executor framework.
       Q. We can create a thread pool as follows:
       ->ExecutorService service=Executors.newFixedThreadPool(3);
       ->We can submit a runnable job by using submit() method.
       ->service.submit(job);
       ->we can shutdown executor service by using shutdown() method.
       ->service.shutdown().

       Q. Can we restart a dead Thread in java?
       No,if we try to restart a dead thread by using start method we will get run time exception since the thread is not alive.

       Q. Can are thread block the other thread?
       No, one thread can not block the other thread in java. It can block the current thread that is running.

       Q. Can we restart a thread already started in Java.
       A thread can be started in java using start() method in java. If we call start method second time once it is start it we cause Runtime Exception.
       A runnable thread can not be restart.

       Q. Difference between runnable and callable.

 */
    //Thread Synchronization
// When two thread are operation on a common data non-synchronous manner, data will get corrupted.
    public static class Synchronization {
        public static class A {
            private int balance;

            public static void main(String[] args) {
              Synchronization.A a = new Synchronization.A();
                a.account();
                System.out.println("Final Balance: " + a.balance);
            }

            private void account() {
                Thread thread1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        add();
                    }
                });

                Thread thread2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sub();
                    }
                });

                thread1.start();
                thread2.start();

                try {
                    thread1.join();
                    thread2.join();
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            }

            public synchronized void add() {
                for (int i = 0; i < 1000; i++) {
                    balance = balance + 1;
                }
            }

            public synchronized void sub() {
                for (int i = 0; i < 1000; i++) {
                    balance = balance - 1;
                }
            }
        }
    /*
    Synchronization Area:
   1. This area can be accessed by only one thread at a
    time having synchronized method and blocks.
    2. When ever we are performing updating operation
    (add,delete,remove/replace)
    i.s state of object is changing

    Non-Synchronization area
    1.This are can be accessed any number of thread having non-synchronized method and blocks.
    2. When even we are performing read operation state of object is changing

     */


        public static class SynchronizationDemo {

            static class SharedResource {
                private int balance = 0;

                // Synchronized method for updating balance (Synchronization Area)
                public synchronized void updateBalance(int amount) {
                    balance += amount;
                    System.out.println(Thread.currentThread().getName() + " updated balance to: " + balance);
                }

                // Non-synchronized method for reading balance (Non-Synchronization Area)
                public void readBalance() {
                    System.out.println(Thread.currentThread().getName() + " read balance as: " + balance);
                }
            }

            public static void main(String[] args) {
                Synchronization.SynchronizationDemo.SharedResource resource = new SynchronizationDemo.SharedResource();

                // Thread for updating the balance
                Thread updateThread = new Thread(() -> {
                    for (int i = 0; i < 5; i++) {
                        resource.updateBalance(10); // Increment balance by 10
                        try {
                            Thread.sleep(100); // Simulate some work
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }, "Updater");

                // Thread for reading the balance
                Thread readThread = new Thread(() -> {
                    for (int i = 0; i < 5; i++) {
                        resource.readBalance(); // Read balance without synchronization
                        try {
                            Thread.sleep(100); // Simulate some work
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }, "Reader");

                updateThread.start();
                readThread.start();

                try {
                    updateThread.join();
                    readThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        /*
       Q. When a thread need class level look?
        If a thread wants to execute Static synchronized method it required class level lock.

        Q. What is synchronized keyword where we can applicable.
        Synchronized Keyword
         -> Synchronized keyword is modifier
         -> It is applicable on method and block but not on class.
          -> If multiple threads are trying to operate simultaneously on the same java object
          then may be a chance of data inconsistency problem.
          -> To overcome the problem we should go for synchronized keyword.

        Q. Synchronization
        If a method is made synchronized then a thread which acquired the object lock can only execute
        the method.

        Every object will have only one lock which ever thread acquired a locked will execute synchronized
        method which the other thread has a wait for the lock to be released.

        Thread will released the lock only after complete execution by doing this we are sure that once a particular thread execute completely only then the next thread
        can start and this will avoid data corruption of common data.



         */
        }
    }

    /*
Q.which thread executed first is depended on priority
1. Normal Priority(represent value 5) default priority
2. Max Priority(represent value 10)
3. Min Priority (represent value 1)

Q. How to get and set priority of a thread?
by using setPriority() we can set priority of a thread
by using getPriority() we can get priority of a thread

 */

    public static class ThreadsPriority extends Thread{
        @Override
        public void run() {
            System.out.println("Running");
        }

        public static void main(String[] args) {
          ThreadsPriority t=new ThreadsPriority();
            t.start();
            t.setPriority(NORM_PRIORITY);
            System.out.println(t.getPriority());
            t.setPriority(MIN_PRIORITY);
            System.out.println(t.getPriority());
            t.setPriority(MAX_PRIORITY);
            System.out.println(t.getPriority());
        }
    }

    public static class StarvationExample {
        private static final Object lock = new Object();

        public static void main(String[] args) {
            // High-priority thread
            Thread highPriorityThread = new Thread(() -> {
                while (true) {
                    synchronized (lock) {
                        System.out.println("High-priority thread is running.");
                        try { Thread.sleep(50); } catch (InterruptedException e) {}
                    }
                }
            });
            highPriorityThread.setPriority(Thread.MAX_PRIORITY);

            // Low-priority threads
            for (int i = 1; i <= 3; i++) {
                Thread lowPriorityThread = new Thread(() -> {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + " is running.");
                    }
                });
                lowPriorityThread.setName("Low-priority Thread-" + i);
                lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
                lowPriorityThread.start();
            }

            highPriorityThread.start();
        }
    }

    //Volatile Keyword is used to modify the value of a variable by different threads
//It is also used to make classes thread safe.
//The volatile keyword can be used either with primitive type or object.
    public static class A1 {
        private volatile boolean isRunning = true;
        //When a variable is used as a flag to indicate a state change (e.g., boolean isRunning)
        public void start() {  // Changed method to public to be accessible from main
            Thread x = new Thread(() -> {
                while (isRunning) {
                    // Simulate work
                }
                System.out.println("Worker Stopped.");
            });
            x.start();
        }

        public void stop() {
            isRunning = false;
        }

        public static void main(String[] args) {
            A example = new A();
            example.start();  // Corrected to match the method name

            // Give the worker thread some time to run
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            example.stop(); // Corrected to match the method name
        }
    }

}
