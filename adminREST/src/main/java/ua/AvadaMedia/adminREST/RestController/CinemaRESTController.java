package ua.AvadaMedia.adminREST.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.AvadaMedia.adminREST.Model.Cinema;
import ua.AvadaMedia.adminREST.Model.GalleryForCinema;
import ua.AvadaMedia.adminREST.ModelDAO.TempCinemaModelDAO;
import ua.AvadaMedia.adminREST.ModelDAO.TempGalleryForCinemaModelDAO;
import ua.AvadaMedia.adminREST.ModelDAO.TempSeoModelDAO;
import ua.AvadaMedia.adminREST.RequestBody.CinemaRequestBody;
import ua.AvadaMedia.adminREST.Service.UploadFileService;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/CinemaREST")
public class CinemaRESTController {

    private long id = 1;

    @Autowired
    private UploadFileService uploadFileService;
    @Autowired
    private TempCinemaModelDAO modelDAO;
    @Autowired
    private TempGalleryForCinemaModelDAO galleryForCinema;
    @Autowired
    private TempSeoModelDAO seoModelDAO;

    private final String cinemaPathForFiles = "/Cinema";

    @PostMapping("/addPhoto")
    @CrossOrigin
    public boolean addPhoto(@RequestParam("file") MultipartFile file) throws IOException {
        return uploadFileService.addPhoto(
                cinemaPathForFiles,
                file.getOriginalFilename(),
                file.getBytes()
        );
    }

    @PostMapping("/addNewEntity")
    @CrossOrigin
    public boolean addNewEntity(@RequestBody CinemaRequestBody requestBody) {
        Cinema cinema = new Cinema();
        cinema.setName(requestBody.getName());
        cinema.setDescription(requestBody.getDescription());
        cinema.setAbout_cinema(requestBody.getAboutCinema());
        cinema.setConditions(requestBody.getConditions());
        String path4Logo = "";
        String path4TopBanner = "";
        for (File tempFile: Objects.requireNonNull(new File(uploadFileService.getUploadPath() + cinemaPathForFiles + "/" + requestBody.getName() + "/").listFiles())) {
            if (tempFile.getName().contains("logo"))
                path4Logo = tempFile.getAbsolutePath().substring(tempFile.getAbsolutePath().indexOf(cinemaPathForFiles + "/"));
            else if (tempFile.getName().contains("top_banner"))
                path4TopBanner = tempFile.getAbsolutePath().substring(tempFile.getAbsolutePath().indexOf(cinemaPathForFiles + "/"));
            else {
                GalleryForCinema gallery = new GalleryForCinema();
                gallery.setId(modelDAO.map.size() + 1);
                gallery.setCinema(cinema);
                gallery.setPath_to_image(tempFile.getAbsolutePath().substring(tempFile.getAbsolutePath().indexOf(cinemaPathForFiles + "/")));
                galleryForCinema.map.put(gallery.getId(), gallery);
            }
        }
        if (!path4Logo.equals(""))
            cinema.setPath_to_logo_image(path4Logo);
        else
            return false;
        if (!path4TopBanner.equals(""))
            cinema.setPath_to_top_banner_image(path4TopBanner);
        if (requestBody.getSeoBlockId() != -1)
            cinema.setSeo_block(seoModelDAO.seoBlocks.get(requestBody.getSeoBlockId()));
        modelDAO.map.put(id, cinema);
        ++id;
        return true;
    }

    @GetMapping("/getAll")
    @CrossOrigin
    public Map<Long, Cinema> getAll() {
        return modelDAO.map;
    }

}