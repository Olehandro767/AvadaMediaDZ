package ua.AvadaMedia.adminREST.ModelDAO;

import org.springframework.stereotype.Service;
import ua.AvadaMedia.adminREST.Model.Movie;

import java.util.HashMap;
import java.util.Map;

@Service
public class TempMovieModelDAO {

    public Map<Long, Movie> movies = new HashMap<>();

}