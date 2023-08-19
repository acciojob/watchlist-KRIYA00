package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MovieRepository
{

    Map<String,Movie>hashmapmovie=new HashMap<>();
    Map<String,Director>hashmapdirector=new HashMap<>();
    Map<String,List<String>>hashmapmoviedirector=new HashMap<>();
    public void addMovie(Movie movie)
    {
        String name=movie.getName();
       hashmapmovie.put(name,movie);
    }
    public void addDirector(Director director)
    {
        String name=director.getName();
        hashmapdirector.put(name,director);
    }
    public void addMovieDirectorPair(String moviename,String directorname)
    {
      if(hashmapmoviedirector.containsKey(directorname))
      {
          List<String>movie=hashmapmoviedirector.get(directorname);
          movie.add(moviename);
          hashmapmoviedirector.put(directorname,movie);
      }
      else
      {
          List<String>movie=new ArrayList<>();
          movie.add(moviename);
          hashmapmoviedirector.put(directorname,movie);
      }
    }
    public Movie getMovieByName(String name)
    {
        return hashmapmovie.get(name);
    }
   public Director getDirectorByName(String name)
   {
       return hashmapdirector.get(name);
   }
    public List<String>getMoviesByDirectorName(String director)
    {
        List<String>movie;
        if(hashmapmoviedirector.containsKey(director))
        {
            movie=hashmapmoviedirector.get(director);
        }
        else
        {
            movie=new ArrayList<>();
        }
        return movie;
    }
    public List<String>findAllMovies()
    {
        List<String>movie = new ArrayList<>();
        for(List<String> list:hashmapmoviedirector.values())
        {
            for(String val:list)
            {
                movie.add(val);
            }
        }
        return movie;
    }
    public String deleteDirectorByName(String director)
    {
        if(hashmapmoviedirector.containsKey(director))
        hashmapmoviedirector.remove(director);
        return "Movies of "+ director +" removed successfully!!";
    }
}
