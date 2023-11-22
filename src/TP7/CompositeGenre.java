package TP7;

import java.util.ArrayList;
import java.util.List;

public final class CompositeGenre extends Genre {
    private List<Genre> genres = new ArrayList<>();

    public void add(Genre genre) {
        genres.add(genre);
    }

    public void remove(Genre genre) {
        genres.remove(genre);
    }

    public List<Genre> getGenres() {
        return genres;
    }

    @Override
    public String getGenre() {
        StringBuilder genre = new StringBuilder();
        for (Genre g : genres) {
            genre.append(g.getGenre());

            if (genres.indexOf(g) != genres.size() - 1) {
                genre.append(", ");
            }
        }
        return genre.toString();
    }
}
