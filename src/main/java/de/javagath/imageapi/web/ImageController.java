package de.javagath.imageapi.web;

import jakarta.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/image")
public class ImageController {

  @GetMapping(
      value = "/**",
      produces = MediaType.IMAGE_PNG_VALUE)
  public @ResponseBody InputStreamResource getImage(HttpServletRequest request) throws IOException {
    String url = request.getRequestURI();
    String[] parts = url.split("/", 3);
    MediaType contentType = MediaType.IMAGE_PNG;
    File initialFile = new File("../images/" + parts[2]);
    InputStream imgFile = new FileInputStream(initialFile);
    return ResponseEntity.ok()
        .contentType(contentType)
        .body(new InputStreamResource(imgFile)).getBody();
  }
}