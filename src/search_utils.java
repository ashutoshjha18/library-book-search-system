import java.util.ArrayList;
import java.util.List;

public class search_utils {

    public static class Book {
        public String title;
        public String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }

    public static class SearchMatch {
        public int index;
        public Book book;

        public SearchMatch(int index, Book book) {
            this.index = index;
            this.book = book;
        }
    }

    public static int binarySearch(List<Book> books, String title) {
        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midTitle = books.get(mid).title.toLowerCase();
            String targetTitle = title.toLowerCase();

            if (midTitle.equals(targetTitle)) {
                return mid;
            } else if (midTitle.compareTo(targetTitle) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static List<SearchMatch> linearSearchAuthor(List<Book> books, String authorQuery) {
        List<SearchMatch> matches = new ArrayList<>();
        String queryLower = authorQuery.toLowerCase();

        for (int index = 0; index < books.size(); index++) {
            Book book = books.get(index);
            if (book.author.toLowerCase().contains(queryLower)) {
                matches.add(new SearchMatch(index, book));
            }
        }

        return matches;
    }
}