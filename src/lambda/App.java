// compile (in the projrect group folder)
// javac -d bin --source-path src src/lambda/*.java

// run
// java -cp classes <folder>.<main> <insert args here if needed>

// package to jar


// run the jar

package lambda;

public class App {

    public static void main(String[] args) {

        Thread th = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " -> " + i);
                }
            }
        });
        th.start();

    }

}
