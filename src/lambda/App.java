// compile (in the projrect group folder)
// javac -d bin --source-path src src/lambda/*.java

// run
// java -cp classes <folder>.<main> <insert args here if needed>

// package to jar


// run the jar

package lambda;

import java.util.concurrent.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lambda.MyImplementation;;

public class App {

    public static void main(String[] args) {

        /*Thread th = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " -> " + i);
                }
            }
        });
        th.start();*/

        MyImplementation my1 = new MyImplementation();
        MyImplementation my2 = new MyImplementation();
        MyImplementation my3 = new MyImplementation();
        MyImplementation my4 = new MyImplementation();
        MyImplementation my5 = new MyImplementation();

        //executing the tasks using a single thread

        ExecutorService es = Executors.newSingleThreadExecutor();
        // es.execute(my1);
        // es.execute(my2);
        // es.shutdown();

        //executing the tasks using fixed thread pool. Concurrent running of the executor service,

        ExecutorService es1 = Executors.newFixedThreadPool(5);
        es1.execute(my3);
        es1.execute(my4);
        es1.execute(my5);
        es1.shutdown(); // need to do this for a loop so that it frees up memory


    }

}
