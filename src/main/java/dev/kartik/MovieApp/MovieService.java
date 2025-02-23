package dev.kartik.MovieApp;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        List<Movie> movies = movieRepository.findAll();

        // ✅ Print each movie properly for debugging
        movies.forEach(movie -> System.out.println(movie.toString()));

        return movies;
    }

    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}