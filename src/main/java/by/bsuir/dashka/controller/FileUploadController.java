package by.bsuir.dashka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Dashka on 14.05.2015.
 */
@Controller
public class FileUploadController {

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded!";
            } catch (Exception e) {
                return "You failed to upload " + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + " because the file was empty.";
        }
    }
}
