import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "BookBorrowing")
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id", columnDefinition = "serial")
    private int borrow_id;

    @Column(name = "borrower_name" , nullable = false, length = 200)
    private String borrower_name;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_date")
    private LocalDate borrowing_date;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private LocalDate return_date;

    @ManyToOne
    @JoinColumn(name = "borrowed_book_id" , referencedColumnName = "book_id")
    private Book book;

    public BookBorrowing() {
    }

    public int getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
    }

    public String getBorrower_name() {
        return borrower_name;
    }

    public void setBorrower_name(String borrower_name) {
        this.borrower_name = borrower_name;
    }

    public LocalDate getBorrowing_date() {
        return borrowing_date;
    }

    public void setBorrowing_date(LocalDate borrowing_date) {
        this.borrowing_date = borrowing_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    @Override
    public String toString() {
        return "BookBorrowing{" +
                "borrow_id=" + borrow_id +
                ", borrower_name='" + borrower_name + '\'' +
                ", borrowing_date=" + borrowing_date +
                ", return_date=" + return_date +
                '}';
    }
}

