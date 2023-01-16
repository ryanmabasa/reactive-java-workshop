package io.javabrains.reactiveworkshop;

import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        //Method references if you have the same argument being passed
        StreamSources.intNumbersStream().forEach(System.out::println);
        StreamSources.intNumbersStream().forEach(e -> System.out.println(e));

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream()
                .filter(number -> number < 5)
                .forEach(e -> System.out.println(e));


        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(e -> System.out.println(e));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        int value = StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(value);

        // Print first names of all users in userStream
        // TODO: Write code here
        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(user -> System.out.println(user));
        ;


        // Print first names in userStream for users that have IDs from number stream
        // This is a stream actually
        Stream<Stream<User>> streamStream = StreamSources.intNumbersStream().map(id ->
                StreamSources.userStream().filter(user -> user.getId() == id)
        );

        // Replacing each id with the result of that stream. flatmap two scenarios
        //If it is a result from a stream then use flatmap. It will return the result instead of a stream
        //flatmap works when mapping to a stream instead.
        StreamSources.intNumbersStream().flatMap(id ->
                        StreamSources.userStream().filter(user -> user.getId() == id)
                )
                .map(user -> user.getFirstName())
                .forEach(username -> System.out.println(username));

        //Better answer
        StreamSources.userStream()
                .filter(u -> StreamSources.intNumbersStream().anyMatch(i -> i == u.getId()));


        ;
    }

}
