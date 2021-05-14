package ua.AvadaMedia.adminREST.ModelDAO;

import org.springframework.stereotype.Service;
import ua.AvadaMedia.adminREST.Model.SEOBlock;

import java.util.HashMap;
import java.util.Map;

@Service
public class TempSeoModelDAO {

    public Map<Long, SEOBlock> seoBlocks = new HashMap<>();

}