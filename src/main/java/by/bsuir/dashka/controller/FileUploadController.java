package by.bsuir.dashka.controller;

import by.bsuir.dashka.service.fileUpload.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Dashka on 14.05.2015.
 */
@Controller
public class FileUploadController {

    @Autowired
    private IFileService fileService;

    @RequestMapping(value="/{id}/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@PathVariable Integer id, @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Dashka\\IdeaProjects\\dashbook\\src\\main\\webapp\\img\\avatars\\"+file.getOriginalFilename())));
                stream.write(bytes);
                stream.close();
                String namePath = "img/avatars/" + file.getOriginalFilename();
                fileService.updatePhoto(id, namePath);
                return "You successfully uploaded!";
            } catch (Exception e) {
                return "You failed to upload " + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + " because the file was empty.";
        }
    }
}
