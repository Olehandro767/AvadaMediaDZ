package ua.AvadaMedia.adminREST.ModelDAO;

import org.springframework.stereotype.Service;
import ua.AvadaMedia.adminREST.Model.Cinema;

import java.util.HashMap;
import java.util.Map;

@Service
public class TempCinemaModelDAO {

    public Map<Long, Cinema> map = new HashMap<>();

}
