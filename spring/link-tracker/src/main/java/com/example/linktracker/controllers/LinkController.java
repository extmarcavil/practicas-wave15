package com.example.linktracker.controllers;

import com.example.linktracker.services.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@RestController
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestParam String url, @RequestParam String pass) {
        return ResponseEntity.ok(linkService.save(url, pass));
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<?> metrics(@PathVariable Integer linkID) {
        return ResponseEntity.ok(linkService.getStatistics(linkID));
    }

    @DeleteMapping("invalidate/{linkID}")
    public void invalidate(@PathVariable Integer linkID) {
        linkService.invalidate(linkID);
    }

    @GetMapping(value = "link/{linkId}", params = {"password"})
    public void redirect(@PathVariable Integer linkId, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
        URL link = linkService.redirect(linkId, password);
        if (link != null){
            response.sendRedirect(link.toString());
        } else {
            response.sendError(404);
        }
    }
}
