package ua.AvadaMedia.adminREST.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.AvadaMedia.adminREST.Model.SEOBlock;
import ua.AvadaMedia.adminREST.ModelDAO.TempSeoModelDAO;
import ua.AvadaMedia.adminREST.RequestBody.SEOBlockRequestBody;

@RestController
@RequestMapping("/SEOBlock")
public class SEORESTController {

    @Autowired
    private TempSeoModelDAO modelDAO;

    private int id = 1;

    @PostMapping("/addNewSEOBlock")
    @CrossOrigin
    @ResponseBody
    public long addNewSEOBlock(@RequestBody SEOBlockRequestBody requestBody) {
        SEOBlock seoBlock = new SEOBlock();
        seoBlock.setId(id);
        seoBlock.setSeo_url(requestBody.getSeoURL());
        seoBlock.setSeo_title(requestBody.getSeoTitle());
        seoBlock.setSeo_keywords(requestBody.getSeoKeyword());
        seoBlock.setSeo_description(requestBody.getSeoDescription());
        modelDAO.seoBlocks.put(seoBlock.getId(), seoBlock);
        ++id;
        return seoBlock.getId();
    }

}