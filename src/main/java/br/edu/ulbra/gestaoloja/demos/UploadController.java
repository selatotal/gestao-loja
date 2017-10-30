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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/demo/upload")
public class UploadController {

    @Value("${gestao-loja.uploadFilePath}")
    private String uploadFilePath;

    @GetMapping
    public ModelAndView showForm(){
        ModelAndView mv = new ModelAndView("demo/upload/form");
        File directory = new File(uploadFilePath);
        File[] files = directory.listFiles();
        List<String> fileList = new ArrayList<>();
        for(File file : files){
            fileList.add(file.getName());
        }
        mv.addObject("files", fileList);
        return mv;
    }

    @PostMapping
    public ModelAndView uploadFileAndData(UploadInput uploadInput) throws IOException {
        ModelAndView mv = new ModelAndView("demo/upload/form");

        MultipartFile multipartFile = uploadInput.getMultipartFile();

        if (multipartFile != null){
            String fileName = uploadInput.getMultipartFile().getOriginalFilename();
            File file = new File(uploadFilePath+"/"+fileName);
            file.createNewFile();
            multipartFile.transferTo(file);
            mv.addObject("filename", fileName);
        }
        return mv;
    }

    @GetMapping("/files/{fileName:.+}")
    @ResponseBody
    public FileSystemResource getFile(@PathVariable("fileName") String fileName){
        FileSystemResource fileSystemResource = new FileSystemResource(uploadFilePath + "/" + fileName);
        return fileSystemResource;
    }


}
