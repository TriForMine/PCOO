package TP7;

public class Main {
    public static void main(String[] args) {
        var book = PrintingHouse.getInstance().printBook("comics", "Harry Potter", "J. K. Rowling", 100, "1234567890");

        System.out.println(book instanceof Comics);
        System.out.println(book);

        try {
            PrintingHouse.getInstance().printBook("video", "Harry Potter", "J. K. Rowling", 100, "1234567890");
            throw new RuntimeException("PrintingHouse.getInstance().printBook(\"video\", \"Harry Potter\", \"J. K. Rowling\", 100, \"1234567890\") should throw an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        AudioBook audiobook = new AudioBook("Harry Potter", "J. K. Rowling", "John Doe", 20, 120);
        var audiobookAdapter = new AudiobookAdapter(audiobook);

        System.out.println(audiobookAdapter);

        LeafGenre fiction = new LeafGenre("Fiction");
        LeafGenre fantasy = new LeafGenre("Fantasy");

        CompositeGenre genre = new CompositeGenre();
        genre.add(fiction);
        genre.add(fantasy);

        System.out.println(genre.getGenre());

        LeafGenre horror = new LeafGenre("Horror");
        LeafGenre thriller = new LeafGenre("Thriller");
        LeafGenre mystery = new LeafGenre("Mystery");

        CompositeGenre genre2 = new CompositeGenre();
        genre2.add(horror);
        genre2.add(thriller);
        genre2.add(mystery);

        System.out.println(genre2.getGenre());
    }
}
