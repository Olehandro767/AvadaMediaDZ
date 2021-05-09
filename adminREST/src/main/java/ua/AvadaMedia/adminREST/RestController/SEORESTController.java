package ua.AvadaMedia.adminREST.RestController;

import org.springframework.web.bind.annotation.*;
import ua.AvadaMedia.adminREST.RequestBody.SEOBlockRequestBody;

@RestController
@RequestMapping("/SEOBlock")
public class SEORESTController {

    @PostMapping("/addNewSEOBlock")
    @CrossOrigin
    @ResponseBody
    public int addNewSEOBlock(@RequestBody SEOBlockRequestBody requestBody) {
        return 1;
    }

}