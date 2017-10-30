package br.edu.ulbra.gestaoloja.demos;

import br.edu.ulbra.gestaoloja.demos.input.UploadInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Value("${gestao-loja.uploadFilePath}")
    private String uploadFilePath;

    @GetMapping
    public ModelAndView showForm(){
        ModelAndView mv = new ModelAndView("demo/upload/form");
        File directory = new File(uploadFilePath);
        File[] files = directory.listFiles();
        mv.addObject("files", files);
        return mv;
    }

    @PostMapping
    public ModelAndView uploadFileAndData(UploadInput uploadInput) throws IOException {
        ModelAndView mv = new ModelAndView("demo/upload/result");

        MultipartFile multipartFile = uploadInput.getMultipartFile();

        if (multipartFile != null){
            multipartFile.transferTo(new File(uploadFilePath));
            String fileName = uploadInput.getMultipartFile().getName();
            mv.addObject("filename", fileName);
        }
        return mv;
    }

    @GetMapping("/files/{fileName}")
    @ResponseBody
    public FileSystemResource getFile(@PathVariable("fileName") String fileName){
        return new FileSystemResource(uploadFilePath + "/" + fileName);
    }


}
