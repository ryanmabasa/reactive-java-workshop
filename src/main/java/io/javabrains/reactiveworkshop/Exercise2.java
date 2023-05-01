package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()


        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        //Whenever I get a new number in the stream, then you should run subscribe
        ReactiveSources.intNumbersFlux()
                .subscribe(e -> System.out.println(e));

        // Print all users in the ReactiveSources.userFlux stream
        //Call the subscribe method whenever it emits an event
        ReactiveSources.userFlux().subscribe(user -> System.out.println(user));

        //Events are gradually coming
        System.out.println("Press a key to end");
        System.in.read();
    }

}
