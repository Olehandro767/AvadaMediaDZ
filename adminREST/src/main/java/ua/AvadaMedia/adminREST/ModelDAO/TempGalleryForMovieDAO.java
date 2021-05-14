package ua.AvadaMedia.adminREST.ModelDAO;

import org.springframework.stereotype.Service;
import ua.AvadaMedia.adminREST.Model.GalleryForMovie;

import java.util.HashMap;

@Service
public class TempGalleryForMovieDAO {

    public HashMap<Long, GalleryForMovie> galleryForMovieHashMap = new HashMap<>();

}