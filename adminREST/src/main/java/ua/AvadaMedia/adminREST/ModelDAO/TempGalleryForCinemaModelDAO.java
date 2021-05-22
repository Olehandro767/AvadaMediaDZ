package ua.AvadaMedia.adminREST.ModelDAO;

import org.springframework.stereotype.Service;
import ua.AvadaMedia.adminREST.Model.GalleryForCinema;

import java.util.HashMap;
import java.util.Map;

@Service
public class TempGalleryForCinemaModelDAO {
    public Map<Long, GalleryForCinema> map = new HashMap<>();
}
