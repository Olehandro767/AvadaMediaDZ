package ua.AvadaMedia.adminREST.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.AvadaMedia.adminREST.Model.GalleryForMovie;
import ua.AvadaMedia.adminREST.Model.Movie;
import ua.AvadaMedia.adminREST.ModelDAO.TempGalleryForMovieDAO;
import ua.AvadaMedia.adminREST.ModelDAO.TempMovieModelDAO;
import ua.AvadaMedia.adminREST.ModelDAO.TempSeoModelDAO;
import ua.AvadaMedia.adminREST.RequestBody.MovieRequestBody;
import ua.AvadaMedia.adminREST.Service.UploadFileService;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/MovieREST")
public class MovieRESTController {

    private long id = 1;

    @Autowired
    private UploadFileService uploadFileService;
    @Autowired
    private TempMovieModelDAO modelDAO;
    @Autowired
    private TempGalleryForMovieDAO galleryForMovieDAO;
    @Autowired
    private TempSeoModelDAO seoModelDAO;

    private final String moviePathForFiles = "/Movie";

    @PostMapping("/addPhoto")
    @CrossOrigin
    public boolean addPhoto(@RequestParam("file") MultipartFile file) throws IOException {
//        String fileName = file.getOriginalFilename();
//        assert fileName != null;
//        String movieNamePath = moviePathForFiles + "/" + fileName.substring(0, fileName.indexOf("_"));
//        uploadFileService.mkDir(movieNamePath); // create folder with movie name
//        uploadFileService.writeFile(movieNamePath + "/" + fileName.replaceAll(fileName.substring(0, fileName.indexOf("_") + 1), ""), file.getBytes());
        return uploadFileService.addPhoto(
                moviePathForFiles,
                file.getOriginalFilename(),
                file.getBytes()
        );
    }

    @PostMapping("/addNewMovie")
    @CrossOrigin
    public boolean addNewEntity(@RequestBody MovieRequestBody requestBody) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setName(requestBody.getName());
        movie.setDescription(requestBody.getDescription());
        String path = "";
        for (File tempFile : Objects.requireNonNull(new File(uploadFileService.getUploadPath() + moviePathForFiles + "/" + requestBody.getName() + "/").listFiles())) {
            if (tempFile.getName().contains("main")) {
                path = tempFile.getAbsolutePath().substring(tempFile.getAbsolutePath().indexOf(moviePathForFiles + "/"));
            } else {
                GalleryForMovie gallery = new GalleryForMovie();
                gallery.setId(galleryForMovieDAO.map.size() + 1);
                gallery.setMovie(movie);
                gallery.setPath_to_image(tempFile.getAbsolutePath().substring(tempFile.getAbsolutePath().indexOf(moviePathForFiles + "/")));
                galleryForMovieDAO.map.put(gallery.getId(), gallery);
            }
        }
        if (!path.equals(""))
            movie.setPath_to_main_image(path);
        else
            return false;
        if (requestBody.getSeoBlockId() != -1)
            movie.setSeo_block(seoModelDAO.seoBlocks.get(requestBody.getSeoBlockId()));
        modelDAO.map.put(id, movie);
        ++id;
        return true;
    }

    @GetMapping("/getAllMovies")
    @CrossOrigin
    /**
     * TODO pagination
     */
    public Map<Long, Movie> getAll() {
        return modelDAO.map;
    }

//    @GetMapping("/getAllSoonMovies")
//    @CrossOrigin
//    public Map<Long, Movie> getAllSoonMovies() {
//        return null;
//    }

}