package practice.p08_lambdas_streams;

/**
 * StreamsDemo.java — Java Streams API: Pipeline, Intermediate & Terminal Operations
 * ===================================================================================
 * CSE215 - Programming Language II
 *
 * 💡 INTUITION: A Stream is a pipeline for processing sequences of data.
 *    Think of it like a factory assembly line:
 *
 *      Raw Material → [Filter] → [Transform] → [Sort] → [Collect] → Result
 *      (source)       (where)    (select)     (order)   (gather)
 *
 *    Streams are:
 *      - Declarative: say WHAT you want, not HOW to loop
 *      - Lazy: intermediate ops don't run until a terminal op triggers them
 *      - Single-use: once consumed, a stream cannot be reused
 *
 * Topics covered:
 *   1. Creating streams (from collections, arrays, values, generators)
 *   2. Intermediate operations (filter, map, flatMap, sorted, distinct, peek, limit, skip)
 *   3. Terminal operations (collect, forEach, reduce, count, min/max, anyMatch, toArray)
 *   4. Collectors (toList, toSet, toMap, groupingBy, partitioningBy, joining)
 *   5. Primitive streams (IntStream, DoubleStream)
 *   6. Parallel streams
 *   7. Real-world examples
 *
 * 🔗 SEE ALSO: p08_LambdasAndStreams/LambdaExpressionsDemo.java
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsDemo {

        // Sample data record
        record Person(String name, int age, String city, double salary) {
        }

        public static void main(String[] args) {
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║   STREAMS API DEMO                           ║");
                System.out.println("╚══════════════════════════════════════════════╝\n");

                // Sample data
                List<Person> people = List.of(
                                new Person("Alice", 28, "New York", 75000),
                                new Person("Bob", 35, "Chicago", 85000),
                                new Person("Charlie", 22, "New York", 55000),
                                new Person("Diana", 31, "Boston", 95000),
                                new Person("Eve", 26, "Chicago", 65000),
                                new Person("Frank", 40, "Boston", 110000),
                                new Person("Grace", 29, "New York", 72000),
                                new Person("Henry", 33, "Chicago", 88000));

                // =====================================================================
                // SECTION 1: CREATING STREAMS
                // =====================================================================
                System.out.println("=== 1. CREATING STREAMS ===");

                // From Collection
                Stream<String> fromList = List.of("A", "B", "C").stream();
                System.out.println("From list: " + fromList.collect(Collectors.toList()));

                // From array
                Stream<Integer> fromArray = Arrays.stream(new Integer[] { 1, 2, 3 });
                System.out.println("From array: " + fromArray.collect(Collectors.toList()));

                // From values
                Stream<String> fromValues = Stream.of("X", "Y", "Z");
                System.out.println("From values: " + fromValues.collect(Collectors.toList()));

                // Generated/infinite streams
                Stream<Double> randoms = Stream.generate(Math::random).limit(5);
                System.out.println(
                                "Random: " + randoms.map(d -> String.format("%.2f", d)).collect(Collectors.toList()));

                Stream<Integer> counting = Stream.iterate(0, n -> n + 2).limit(5);
                System.out.println("Even numbers: " + counting.collect(Collectors.toList()));

                // IntStream range
                IntStream range = IntStream.rangeClosed(1, 5); // 1, 2, 3, 4, 5
                System.out.println("Range 1-5: " + range.boxed().collect(Collectors.toList()));

                // =====================================================================
                // SECTION 2: INTERMEDIATE OPERATIONS (Lazy — don't execute until terminal op)
                // =====================================================================
                System.out.println("\n=== 2. INTERMEDIATE OPERATIONS ===");

                /**
                 * 💡 Intermediate operations return a NEW stream.
                 * They are LAZY — nothing happens until a terminal operation triggers the
                 * pipeline.
                 *
                 * filter(predicate) → keep elements matching condition
                 * map(function) → transform each element
                 * flatMap(function) → flatten nested collections
                 * sorted() → sort (natural order or with Comparator)
                 * distinct() → remove duplicates
                 * limit(n) → take first n elements
                 * skip(n) → skip first n elements
                 * peek(consumer) → debug: look at elements without modifying
                 */

                // filter — keep only matching elements
                System.out.println("--- filter ---");
                List<Person> newYorkers = people.stream()
                                .filter(p -> p.city().equals("New York"))
                                .collect(Collectors.toList());
                System.out.println(
                                "New Yorkers: " + newYorkers.stream().map(Person::name).collect(Collectors.toList()));

                // map — transform each element
                System.out.println("\n--- map ---");
                List<String> names = people.stream()
                                .map(Person::name) // Person → String (extract name)
                                .collect(Collectors.toList());
                System.out.println("Names: " + names);

                List<String> upperNames = people.stream()
                                .map(Person::name)
                                .map(String::toUpperCase) // Chain multiple maps
                                .collect(Collectors.toList());
                System.out.println("Upper: " + upperNames);

                // flatMap — flatten nested structures
                System.out.println("\n--- flatMap ---");
                List<List<Integer>> nested = List.of(
                                List.of(1, 2, 3),
                                List.of(4, 5),
                                List.of(6, 7, 8, 9));
                List<Integer> flattened = nested.stream()
                                .flatMap(Collection::stream) // Stream<List<Int>> → Stream<Int>
                                .collect(Collectors.toList());
                System.out.println("Nested: " + nested);
                System.out.println("Flat:   " + flattened);

                // sorted
                System.out.println("\n--- sorted ---");
                List<String> sortedNames = people.stream()
                                .map(Person::name)
                                .sorted() // Natural order
                                .collect(Collectors.toList());
                System.out.println("Sorted names: " + sortedNames);

                List<Person> bySalary = people.stream()
                                .sorted(Comparator.comparingDouble(Person::salary).reversed())
                                .collect(Collectors.toList());
                System.out.println("By salary (desc): " + bySalary.stream()
                                .map(p -> p.name() + "=$" + p.salary())
                                .collect(Collectors.toList()));

                // distinct, limit, skip
                System.out.println("\n--- distinct, limit, skip ---");
                List<String> cities = people.stream()
                                .map(Person::city)
                                .distinct()
                                .collect(Collectors.toList());
                System.out.println("Unique cities: " + cities);

                List<Person> top3 = people.stream()
                                .sorted(Comparator.comparingDouble(Person::salary).reversed())
                                .limit(3)
                                .collect(Collectors.toList());
                System.out.println("Top 3 earners: " + top3.stream().map(Person::name).collect(Collectors.toList()));

                // peek – for debugging
                System.out.println("\n--- peek (debugging) ---");
                long count = people.stream()
                                .filter(p -> p.age() > 30)
                                .peek(p -> System.out.println("  After filter: " + p.name()))
                                .count();
                System.out.println("People over 30: " + count);

                // =====================================================================
                // SECTION 3: TERMINAL OPERATIONS (Trigger the pipeline)
                // =====================================================================
                System.out.println("\n=== 3. TERMINAL OPERATIONS ===");

                // collect — most common, gathers results into a collection
                // (shown in examples above)

                // forEach — performs action on each element
                System.out.println("--- forEach ---");
                people.stream()
                                .filter(p -> p.city().equals("Boston"))
                                .forEach(p -> System.out.println("  " + p.name() + " lives in Boston"));

                // count
                long youngCount = people.stream().filter(p -> p.age() < 30).count();
                System.out.println("\nPeople under 30: " + youngCount);

                // min / max
                Optional<Person> youngest = people.stream()
                                .min(Comparator.comparingInt(Person::age));
                youngest.ifPresent(p -> System.out.println("Youngest: " + p.name() + " (age " + p.age() + ")"));

                // reduce — combine all elements into one value
                System.out.println("\n--- reduce ---");
                double totalSalary = people.stream()
                                .map(Person::salary)
                                .reduce(0.0, Double::sum); // identity + accumulator
                System.out.println("Total salary: $" + String.format("%.0f", totalSalary));

                // String concatenation with reduce
                String allNames = people.stream()
                                .map(Person::name)
                                .reduce("", (a, b) -> a.isEmpty() ? b : a + ", " + b);
                System.out.println("All names: " + allNames);

                // anyMatch, allMatch, noneMatch
                System.out.println("\n--- Matching ---");
                boolean anyHighEarner = people.stream().anyMatch(p -> p.salary() > 100000);
                boolean allAdults = people.stream().allMatch(p -> p.age() >= 18);
                boolean noneMinors = people.stream().noneMatch(p -> p.age() < 18);
                System.out.println("Any earner > $100k: " + anyHighEarner);
                System.out.println("All adults:         " + allAdults);
                System.out.println("No minors:          " + noneMinors);

                // findFirst, findAny
                Optional<Person> firstChicago = people.stream()
                                .filter(p -> p.city().equals("Chicago"))
                                .findFirst();
                firstChicago.ifPresent(p -> System.out.println("First from Chicago: " + p.name()));

                // toArray
                String[] nameArray = people.stream().map(Person::name).toArray(String[]::new);
                System.out.println("Array: " + Arrays.toString(nameArray));

                // =====================================================================
                // SECTION 4: COLLECTORS (Advanced collecting)
                // =====================================================================
                System.out.println("\n=== 4. COLLECTORS ===");

                // toList, toSet, toUnmodifiableList
                List<String> nameList = people.stream().map(Person::name).collect(Collectors.toList());
                Set<String> citySet = people.stream().map(Person::city).collect(Collectors.toSet());
                System.out.println("Names: " + nameList);
                System.out.println("Cities: " + citySet);

                // toMap
                Map<String, Double> nameSalaryMap = people.stream()
                                .collect(Collectors.toMap(Person::name, Person::salary));
                System.out.println("Name→Salary: " + nameSalaryMap);

                // joining — concatenate strings
                String joined = people.stream()
                                .map(Person::name)
                                .collect(Collectors.joining(", ", "[", "]"));
                System.out.println("Joined: " + joined);

                // groupingBy — group elements by a classifier
                System.out.println("\n--- groupingBy ---");
                Map<String, List<Person>> byCity = people.stream()
                                .collect(Collectors.groupingBy(Person::city));
                byCity.forEach((city, persons) -> {
                        System.out.println("  " + city + ": " + persons.stream()
                                        .map(Person::name).collect(Collectors.toList()));
                });

                // groupingBy with downstream collector
                Map<String, Double> avgSalaryByCity = people.stream()
                                .collect(Collectors.groupingBy(
                                                Person::city,
                                                Collectors.averagingDouble(Person::salary)));
                System.out.println("\nAvg salary by city: " + avgSalaryByCity);

                Map<String, Long> countByCity = people.stream()
                                .collect(Collectors.groupingBy(Person::city, Collectors.counting()));
                System.out.println("Count by city: " + countByCity);

                // partitioningBy — split into two groups (true/false)
                System.out.println("\n--- partitioningBy ---");
                Map<Boolean, List<Person>> seniorVsJunior = people.stream()
                                .collect(Collectors.partitioningBy(p -> p.age() >= 30));
                System.out.println("Senior (≥30): " + seniorVsJunior.get(true).stream()
                                .map(Person::name).collect(Collectors.toList()));
                System.out.println("Junior (<30): " + seniorVsJunior.get(false).stream()
                                .map(Person::name).collect(Collectors.toList()));

                // summarizingDouble — statistics in one pass
                DoubleSummaryStatistics salaryStats = people.stream()
                                .collect(Collectors.summarizingDouble(Person::salary));
                System.out.println("\nSalary Statistics:");
                System.out.println("  Count:   " + salaryStats.getCount());
                System.out.println("  Min:     $" + salaryStats.getMin());
                System.out.println("  Max:     $" + salaryStats.getMax());
                System.out.println("  Average: $" + String.format("%.0f", salaryStats.getAverage()));
                System.out.println("  Sum:     $" + String.format("%.0f", salaryStats.getSum()));

                // =====================================================================
                // SECTION 5: PRIMITIVE STREAMS
                // =====================================================================
                System.out.println("\n=== 5. PRIMITIVE STREAMS ===");

                /**
                 * 💡 IntStream, LongStream, DoubleStream avoid autoboxing overhead.
                 * They also provide useful methods like sum(), average(), range().
                 */

                // IntStream
                int sum = IntStream.rangeClosed(1, 100).sum();
                System.out.println("Sum 1-100: " + sum);

                OptionalDouble avg = IntStream.of(85, 92, 78, 96, 88).average();
                avg.ifPresent(a -> System.out.println("Average score: " + String.format("%.1f", a)));

                // mapToInt — convert Stream<Object> to IntStream
                int totalAge = people.stream()
                                .mapToInt(Person::age)
                                .sum();
                System.out.println("Total age: " + totalAge);

                // =====================================================================
                // SECTION 6: PARALLEL STREAMS
                // =====================================================================
                System.out.println("\n=== 6. PARALLEL STREAMS ===");

                /**
                 * 💡 Parallel streams split work across multiple CPU cores.
                 *
                 * ⚠️ GOTCHA:
                 * - NOT always faster! Overhead of splitting/merging can outweigh gains.
                 * - Use for LARGE datasets with CPU-intensive operations.
                 * - Operations must be stateless and thread-safe.
                 * - Order may not be preserved (use forEachOrdered if needed).
                 *
                 * ✅ BEST PRACTICE: Benchmark before assuming parallel is faster.
                 */

                long start = System.currentTimeMillis();
                long parallelSum = LongStream.rangeClosed(1, 10_000_000)
                                .parallel()
                                .sum();
                long parallelTime = System.currentTimeMillis() - start;

                start = System.currentTimeMillis();
                long sequentialSum = LongStream.rangeClosed(1, 10_000_000)
                                .sum();
                long seqTime = System.currentTimeMillis() - start;

                System.out.println("Sequential: " + sequentialSum + " (" + seqTime + "ms)");
                System.out.println("Parallel:   " + parallelSum + " (" + parallelTime + "ms)");

                // =====================================================================
                // SECTION 7: REAL-WORLD EXAMPLES
                // =====================================================================
                System.out.println("\n=== 7. REAL-WORLD EXAMPLES ===");

                // Find the second highest salary
                Optional<Double> secondHighest = people.stream()
                                .map(Person::salary)
                                .distinct()
                                .sorted(Comparator.reverseOrder())
                                .skip(1)
                                .findFirst();
                secondHighest.ifPresent(s -> System.out.println("2nd highest salary: $" + s));

                // Top earner in each city
                Map<String, Optional<Person>> topEarnerByCity = people.stream()
                                .collect(Collectors.groupingBy(
                                                Person::city,
                                                Collectors.maxBy(Comparator.comparingDouble(Person::salary))));
                System.out.println("\nTop earner in each city:");
                topEarnerByCity.forEach((city, person) -> person
                                .ifPresent(p -> System.out.printf("  %-10s → %s ($%.0f)%n", city, p.name(),
                                                p.salary())));

                // Word frequency from a paragraph
                String text = "the quick brown fox jumps over the lazy dog the fox";
                Map<String, Long> wordFreq = Arrays.stream(text.split("\\s+"))
                                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
                System.out.println("\nWord frequencies: " + wordFreq);

                System.out.println("\n✅ All demos completed successfully!");
        }
}

/*
 * ╔═══════════════════════════════════════════════════════════════════╗
 * ║ STREAM OPERATIONS CHEAT SHEET ║
 * ╠═══════════════════════════════════════════════════════════════════╣
 * ║ INTERMEDIATE (lazy): │ TERMINAL (triggers pipeline): ║
 * ║ filter(Predicate) │ collect(Collector) ║
 * ║ map(Function) │ forEach(Consumer) ║
 * ║ flatMap(Function) │ reduce(identity, BinaryOp) ║
 * ║ sorted() / sorted(Comp) │ count() ║
 * ║ distinct() │ min(Comp) / max(Comp) ║
 * ║ limit(n) / skip(n) │ anyMatch / allMatch / none ║
 * ║ peek(Consumer) │ findFirst() / findAny() ║
 * ║ mapToInt/Long/Double │ toArray() ║
 * ╚═══════════════════════════════════════════════════════════════════╝
 */
