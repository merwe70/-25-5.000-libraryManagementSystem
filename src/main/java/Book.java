import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // hangi stratejiyle id değerini yönetmesi gerektiğini söylüyoruz. biz identity seçtik yani benzersiz olmalı.
    @Column(name = "book_id", columnDefinition = "serial") // serial diyerek kendiliğinden her eklemede bir artması gerektiğini belirttik
    private int id;

    @Column(name = "book_name", nullable = false, length = 200)
    private String name;


    @Column(name = "book_publicationYear")
    private int publicationYear;


    @Column(name = "book_stok")
    private int stok;

    @OneToMany(mappedBy = "book")
    private List<BookBorrowing> bookBorrowingList;


    @ManyToOne
    @JoinColumn(name = "book_publisher_id", referencedColumnName = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "book_author", referencedColumnName = "author_name")
    private Author author;

    @ManyToMany
    @JoinTable(
            name = "book2category",
            joinColumns = {@JoinColumn(name = "book2category_book_id")},
            inverseJoinColumns = {@JoinColumn(name = "book2category_category_id")}
    )
    private List<Category> categoryList;



    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicationYear=" + publicationYear +
                ", stok=" + stok +
                ", publisher=" + publisher +
                ", author=" + author +
                ", categoryList=" + categoryList +
                '}';
    }
}
