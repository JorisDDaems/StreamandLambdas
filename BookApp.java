package be.intecbrussel.StreamOpdracht;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookApp {
    public static void main(String[] args) {

        Book b1 = new Book("blinker en het bagbagjuweel", new Person("Marc", "debel", LocalDate.of(1965, 4, 7)), LocalDate.of(1998, 5, 4), "kids");
        Book b2 = new Book("blinker en de bioscoop", new Person("Marc", "debel", LocalDate.of(1965, 4, 7)), LocalDate.of(2016, 5, 4), "kids");
        Book b3 = new Book("the lord of the rings", new Person("jef", "Tolkien", LocalDate.of(1924, 4, 7)), LocalDate.of(1965, 5, 4), "fantasy");
        Book b4 = new Book("kaas", new Person("willem", "ellsschot", LocalDate.of(1888, 4, 7)), LocalDate.of(1944, 5, 4), "serieus");
        Book b5 = new Book("den humo", new Person("guy", "mortier", LocalDate.of(1925, 4, 7)), LocalDate.of(1977, 5, 4), "tijdschrift");

        Book[] books = new Book[]{b1, b2, b3, b4, b5};

        System.out.println(getNewestBook(books));
        printYoungestWriter(books);
        printSortedByTitle(books);
        countBooksPerAuthor(books);
        printBooksReleasedin2016(books);


    }

    public static Book getNewestBook(Book[] books) {
        return Stream.of(books).reduce((first, second) -> second).orElse(null);
    }

    public static void printYoungestWriter(Book[] books) {
        Book boks = Stream.of(books)
                .reduce((first, second) -> {
                    if (first.getAuthor().getDateOfBirth().isAfter(second.getAuthor().getDateOfBirth())) {
                        return first;
                    }
                    return second;
                })
                .orElse(null);
        System.out.println(boks.getAuthor());
    }


    public static void printSortedByTitle(Book[] books) {
        Stream.of(books).map(Book::getTitle).sorted().forEach(System.out::println);
    }


    public static void countBooksPerAuthor(Book[] books) {
        Map<String,Long> counted = Stream.of(books).collect(Collectors.groupingBy(book -> book.getAuthor().getLastName(),Collectors.counting()));
        System.out.println(counted);
    }


    public static void printBooksReleasedin2016(Book[] books) {
        Stream.of(books).filter(book -> book.getReleaseDate().getYear() == 2016).forEach(System.out::println);
    }
}
