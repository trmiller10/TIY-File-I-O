public class Book {

    private String bookTitle;
    private String authorName;
    private String bookGenre;
    private String publisherName;
    private int yearPublished;

    public Book(String bookTitle, String authorName, String bookGenre, String publisherName, int datePublished){
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.bookGenre = bookGenre;
        this.publisherName = publisherName;
        this.yearPublished = datePublished;

    }


    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getDatePublished() {
        return yearPublished;
    }

    public void setDatePublished(int datePublished) {
        this.yearPublished = datePublished;
    }

    public String toString(){
        return String.format("Book title: %s  Written by: %s  Book genre: %s  Published by: %s  Date of publishing: %s",
                this.bookTitle, this.authorName, this.bookGenre, this.publisherName, this.yearPublished);
    }
}
