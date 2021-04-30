package ua.AvadaMedia.adminREST.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Scope("prototype")
public class UploadFileService {

    @Value("${uploadPath}")
    private String uploadPath;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public void mkDir(String path) {
        File uploadFolder = new File(uploadPath + path);
        if (!uploadFolder.exists())
            uploadFolder.mkdirs();
    }

    public void writeFile(String path, byte[] bytes) throws IOException {
        File uploadFolder = new File(uploadPath);
        if (!uploadFolder.exists())
            uploadFolder.mkdirs();
        FileOutputStream outputStream = new FileOutputStream(uploadPath + path);
        outputStream.write(bytes);
    }

}