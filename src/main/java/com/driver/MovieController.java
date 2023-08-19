package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController
{
    @Autowired
    MovieService movieService;
@PostMapping("POST /movies/add-movie")
    public ResponseEntity<String> addMovie(Movie movie)
{
    movieService.addMovie(movie);
    return new ResponseEntity<>("success", HttpStatus.OK);
}
@PostMapping("POST /movies/add-director")
public  ResponseEntity<String> addDirector(Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    @PutMapping("PUT /movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("moviename")String moviename,@RequestParam("directorname")
                                       String directorname)
    {
        movieService.addMovieDirectorPair(moviename,directorname);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    @GetMapping("Get Movie by movie name: GET /movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String name)
    {
        return new ResponseEntity<>(movieService.getMovieByName(name), HttpStatus.OK);

    }
    @GetMapping("GET /movies/get-director-by-name/{name}")
    public  ResponseEntity<Director> getDirectorByName(@PathVariable("name")String name)
    {
        return new ResponseEntity<>(movieService.getDirectorByName(name), HttpStatus.OK);


    }
    @GetMapping("GET /movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("name")String director)
    {
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(director), HttpStatus.OK);


    }
    @GetMapping("GET /movies/get-all-movies")
    public  ResponseEntity<List<String>> findAllMovies()
    {
        return new ResponseEntity<>( movieService.findAllMovies(), HttpStatus.OK);

    }
    @DeleteMapping("DELETE /movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director")String director)
    {
        movieService.deleteDirectorByName(director);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
@DeleteMapping(" DELETE /movies/delete-all-directors")
    public  ResponseEntity<String>deleteAllDirectors()
{
    movieService.deleteAllDirectors();
    return new ResponseEntity<>("success", HttpStatus.OK);
}


}
