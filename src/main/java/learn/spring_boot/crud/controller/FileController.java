package learn.spring_boot.crud.controller;

import learn.spring_boot.crud.common.ApiResponse;
import learn.spring_boot.crud.entity.FileUpload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.config.ConfigData;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/file")
@Slf4j
public class FileController {

    Path path = Path.of("uploads");
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("details") String value) throws IOException {

        log.info(value);
        String fileName = file.getOriginalFilename();
        byte[] bytes = file.getBytes();
        InputStream stream = file.getInputStream();
        Long fileSize = file.getSize();

        Map<String, Object> data = new HashMap<>();
        data.put("name", fileName);
        data.put("size", fileSize / 1024);


        ApiResponse<Object> apiResponse = ApiResponse.builder()
                .message("Le fichier a ete recu avec succes")
                .data(data)
                .build();

        Files.copy(stream, path.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        log.info("Copie du fichier sur le disque");
        return ResponseEntity.ok(apiResponse);
    }


    @GetMapping("/download")
    public ResponseEntity<?> download(@RequestParam("filename")String filename) throws IOException
    {
        Path from = path.resolve(filename);
        log.info(String.valueOf(Files.exists(from)));
        Resource resource = new UrlResource(from.toUri());
        if (resource.exists() || resource.isReadable())
        {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\""+resource.getFilename()+"\"")
                    .body(resource);
        }else
        {

            return ResponseEntity.internalServerError().build();
        }
    }

}
