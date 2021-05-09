package ua.AvadaMedia.adminREST.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.AvadaMedia.adminREST.RequestBody.MovieRequestBody;
import ua.AvadaMedia.adminREST.Service.UploadFileService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/MovieREST")
public class MovieRESTController {

    @Autowired
    private UploadFileService uploadFileService;
    private String moviePath = "/Movie";

    @PostMapping("/addPhoto")
    @CrossOrigin
    public boolean addPhotoForMovie(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String movieNamePath = moviePath + "/" + fileName.substring(0, fileName.indexOf("_"));
        uploadFileService.mkDir(movieNamePath); // create folder with movie name
        uploadFileService.writeFile(movieNamePath + "/" + fileName.replaceAll(fileName.substring(0, fileName.indexOf("_") + 1), ""), file.getBytes());
        return true;
    }

    @PostMapping("/addNewMovie")
    @CrossOrigin
    public boolean addNewMovie(@RequestBody MovieRequestBody requestBody) {
        return true;
    }

}