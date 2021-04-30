package ua.AvadaMedia.adminREST.RequestBody;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public class MovieRequestBody {

    private MultipartFile file;

//    public String login;
//    public String movieName;
//    public String description;
//    public Picture mainPictureFileInput;
//    public Picture[] gallery;
//    public String link;
//    public boolean twoD;
//    public boolean threeD;
//    public boolean imaxD;


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}