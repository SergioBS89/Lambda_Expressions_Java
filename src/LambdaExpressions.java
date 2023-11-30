import models.Person;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.*;


public class LambdaExpressions {
    public static void main(String[] args) {

        /*
         * Example of Consumer Lambda Function
         */
        Consumer<Date> today = date -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(simpleDateFormat.format(date));
        };
        today.accept(new Date());

        /*
         * Example 2 of consumer
         */
        Consumer<String> hello = System.out::println;
        hello.accept("hello word");

        /*
         * Example BiConsumer
         */
        BiConsumer<String, Integer> description = (name, age) ->
                System.out.println("Person called ".concat(name).concat(" has ").concat(age.toString()).concat(" ages."));

        description.accept("Sergio", 34);

        /*
         * Adding name to person entity with BIConsumer
         */
        Person p = new Person();
        BiConsumer<Person, String> assignName = Person::setName;
        assignName.accept(p, "Rita");
        System.out.println(p.getName());


        /*
         * Example Supplier
         */
        Supplier<String> supplier = () -> {
            int a = 999;
            int b = 997;
            return b == a ? "Are the same" : "Are different";
        };
        System.out.println(supplier.get());

        /**
         * Example using Function lambdas (first parameter is the param is coming - second parameter is the return value)
         */
        Function<String, String> example = param -> "How is going on " + param;
        System.out.println(example.apply("Sergio"));

        Function<String, String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("sony"));

        /*
         * Examples using BiFunction lambdas
         */
        BiFunction<Integer, Integer, String> areEqualsFunction = (a, b) -> a.equals(b) ? "equals" : "different";
        System.out.println(areEqualsFunction.apply(12, 14));

        BiFunction<String, String, Boolean> comparing = String::equals;
        System.out.println(comparing.apply("Hello", "Hello"));

        /**
         * Predicate lambdas expressions
         */
        Predicate<Integer> predicateFun = num -> num < 10;
        String result = predicateFun.test(7) ? "The number is smaller than 10" : "The number is bigger than 10";
        System.out.println(result);

        Predicate<String> predicateFun2 = role -> role.equals("ROLE_ADMIN");
        String result2 = predicateFun2.test("ROLE_USER") ? "Both roles are the same" : "Roles are different";
        System.out.println(result2);
        /**
         * BiPredicate lambdas expressions
         */
        BiPredicate<Integer, Double> biPreFunc = (a, b) -> a > b;
        boolean result3 = biPreFunc.test(10, 9.9999);
        System.out.println(result3 ? "The number A is bigger than B" : "the number A is smaller than B");

        Person pA = new Person();
        Person pB = new Person();
        pA.setName("Mario");
        pB.setName("Sebastian");
        BiPredicate<Person, Person> compareNames = (a, b) -> a.getName().equals(b.getName());
        boolean resultCom = compareNames.test(pA, pB);
        System.out.println(resultCom);


        /**
         * Exercise 1 Create an lambda expression that remove spaces
         */
        String sentece = "             Hello world!          ";

        Function<String, String> removeSpacesBeginAndEnd = String::trim;
        System.out.println(removeSpacesBeginAndEnd.apply(sentece));

        Function<String, String> removeAllSpaces = s -> s.replaceAll(" ", "");
        System.out.println(removeAllSpaces.apply(sentece));

        /**
         * Exercise 2 Create a expression lambda that counts all the characters of a string(can be used other others lambdas created before)
         */
        Function<String, Integer> countCharacters = c -> {
            int counter = 0;
            for (int i = 0; i < removeAllSpaces.apply(c).length(); i++) {
                counter++;
            }
            return counter;
        };
        System.out.println(countCharacters.apply("Hello world people"));

        /**
         * Exercise 3 Create an expression lambda to uppercase the first word of a sentence
         */
        Function<String, String> capitalizeFirstWord = (s) -> {
            String[] words = s.split(" ");
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(words[0])) {
                    res.append(words[0].toUpperCase().concat(" "));
                } else {
                    if (i != words.length - 1) {
                        res.append(words[i].concat(" "));
                    } else {
                        res.append(words[i]);
                    }
                }
            }
            return res.toString();
        };

        System.out.println(capitalizeFirstWord.apply("fcb the best"));
    }
}

