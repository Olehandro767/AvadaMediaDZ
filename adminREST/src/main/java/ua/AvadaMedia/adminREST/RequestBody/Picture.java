package ua.AvadaMedia.adminREST.RequestBody;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class Picture {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }


    public void setFile(@RequestParam("file") MultipartFile file) {
        this.file = file;
    }

}
