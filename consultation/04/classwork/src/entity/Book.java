package types;

public class Book {
        private Integer id;
        private String bookAuthor;
        private String bookName;

        public Book(Integer id, String bookAuthor, String bookName)
        {
                this.id = id;
                this.bookAuthor = bookAuthor;
                this.bookName = bookName;
        }

        public String getBookAuthor()
        {
                return bookAuthor;
        }

        public String getBookName()
        {
                return bookName;
        }

        @Override
        public String toString()
        {
                return "Book{" +
                       "bookAuthor='" + bookAuthor + '\'' +
                       ", bookName='" + bookName + '\'' +
                       '}';
        }
}
