package be.intecbrussel.StreamOpdracht;

import java.time.LocalDate;

public class Book {
    private String title;
    private Person Author;
    private LocalDate releaseDate;
    private String genre;

    public Book(String title, Person author, LocalDate releaseDate, String genre) {
        this.title = title;
        Author = author;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public Person getAuthor() {
        return Author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", Author=" + Author +
                ", releaseDate=" + releaseDate +
                ", genre='" + genre + '\'' +
                '}';
    }
}
