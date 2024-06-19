import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", columnDefinition = "serial")
    private int author_id;

    @Column(name = "author_name")
    private String author_name;

    @Temporal(TemporalType.DATE)
    @Column(name = "author_birthday")
    private LocalDate author_birthday;


    @Column(name = "author_country")
    private String country;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;

    public Author() {
    }


    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public LocalDate getAuthor_birthday() {
        return author_birthday;
    }

    public void setAuthor_birthday(LocalDate author_birthday) {
        this.author_birthday = author_birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", author_name='" + author_name + '\'' +
                ", author_birthday=" + author_birthday +
                ", country='" + country + '\'' +
                '}';
    }
}
