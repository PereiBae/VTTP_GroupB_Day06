// compile (in the projrect group folder)
// javac -d bin --source-path src src/lambda/*.java

// run
// java -cp classes <folder>.<main> <insert args here if needed>

// package to jar

// run the jar

package lambda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import lambda.MyImplementation;;

public class App {

    public static void main(String[] args) {

        /*
         * Thread th = new Thread(new Runnable() {
         * public void run() {
         * for (int i = 0; i < 10; i++) {
         * System.out.println(Thread.currentThread().getName() + " -> " + i);
         * }
         * }
         * });
         * th.start();
         */

        MyImplementation my1 = new MyImplementation();
        MyImplementation my2 = new MyImplementation();
        MyImplementation my3 = new MyImplementation();
        MyImplementation my4 = new MyImplementation();
        MyImplementation my5 = new MyImplementation();

        // executing the tasks using a single thread

        // ExecutorService es = Executors.newSingleThreadExecutor();
        // es.execute(my1);
        // es.execute(my2);
        // es.shutdown();

        // executing the tasks using fixed thread pool. Concurrent running of the
        // executor service,

        // ExecutorService es1 = Executors.newFixedThreadPool(5);
        // es1.execute(my3);
        // es1.execute(my4);
        // es1.execute(my5);
        // es1.shutdown(); // need to do this for a loop so that it frees up memory

        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Apple iPad", "Apple tablet", "computer"));
        products.add(new Product(2L, "Apple MacBook Pro", "Apple laptop", "computer"));
        products.add(new Product(3L, "32 inch monitor", "Samsung monitor", "computer"));
        products.add(new Product(4L, "Logitec Mouse", "Mouse", "computer"));
        products.add(new Product(5L, "HuaWei 5", "huawei phone", "mobile"));
        products.add(new Product(6L, "Galaxy 24", "Samsung phone", "mobile"));
        products.add(new Product(7L, "Oppos 7 Pro", "Oppo phone", "mobile"));

        // products.forEach(Product -> System.out.println(Product.toString()));
        products.forEach(Product::print);

        System.out.println();

        // only retrieve products with category 'mobile'
        // using stream and lambda functions

        List<Product> filteredProducts = new ArrayList<>();
        filteredProducts = products
                            .stream()
                            .filter(p -> p.getCategory().equals("mobile"))
                            .collect(Collectors.toList());

        filteredProducts.forEach(Product::print);

        System.out.println();

        // Get the current date and time
        LocalDate now = LocalDate.of(1997, 5, 8);
        Date currentDate = Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Define a date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<Person> persons = new LinkedList<>();
        persons.add(new Person(1L, "Brandon", "Pereira", 6000.0, currentDate));
        persons.add((new Person(2L, "Joel", "Young", 5500.0, currentDate)));
        persons.add(new Person(3L, "Ash", "Chauhan", 7500, currentDate));
        persons.add(new Person(4L, "Jasper", "Chong", 5000, currentDate));
        persons.add(new Person(5L, "Darius", "Yeo", 11000, currentDate));
        persons.add(new Person(6L, "Kah", "Hau", 4000, currentDate));
        persons.add(new Person(7L, "Samuel", "Phuar", 6000, currentDate));
        persons.add(new Person(8L, "Joshua", "Yeo", 8000, currentDate));
        persons.add(new Person(9L, "Geraldine", "Foe", 3500, currentDate));
        persons.add(new Person(1L, "Brandon", "Gonzales", 4200.0, currentDate));

        Comparator<Person> compare = Comparator.comparing(p -> p.getFirstName());
        // Descending order
        persons.sort(compare.reversed());
        persons.forEach(Person::print);

        System.out.println();

        Comparator<Person> compareMultiple = Comparator.comparing((Person::getFirstName)).thenComparing(Person::getLastName);
        persons.sort(compareMultiple);
        persons.forEach(Person::print);

    }

}
