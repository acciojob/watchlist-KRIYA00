package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MovieService
{
    @Autowired
    MovieRepository movieRepository;


    public void addMovie(Movie movie)
    {
        movieRepository.addMovie(movie);
    }
    public void addDirector(Director director)
    {
        movieRepository.addDirector(director);
    }
    public void addMovieDirectorPair(String moviename,String directorname)
    {
movieRepository.addMovieDirectorPair(moviename,directorname);
    }
    public Movie getMovieByName(String name)
    {
        return movieRepository.getMovieByName(name);
    }
    public Director getDirectorByName(String name)
    {
        return movieRepository.getDirectorByName(name);
    }
    public List<String> getMoviesByDirectorName(String director)
    {
      return movieRepository.getMoviesByDirectorName(director);
    }
    public List<String>findAllMovies()
    {
        return movieRepository.findAllMovies();
    }
    public void deleteDirectorByName(String director) {
         movieRepository.deleteDirectorByName(director);
    }
    public void deleteAllDirectors()
    {
        movieRepository.deleteAllDirectors();
    }
}
