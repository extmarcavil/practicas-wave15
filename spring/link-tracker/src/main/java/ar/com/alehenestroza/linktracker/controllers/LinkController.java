package ar.com.alehenestroza.linktracker.controllers;

import ar.com.alehenestroza.linktracker.dtos.LinkCreateRequestDTO;
import ar.com.alehenestroza.linktracker.services.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<?> save(@RequestBody LinkCreateRequestDTO link) {
        return ResponseEntity.ok(linkService.save(link));
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirect(@PathVariable Integer linkId, @RequestParam String password) {
        return new RedirectView(linkService.getUrl(linkId, password));
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable Integer linkId) {
        return ResponseEntity.ok(linkService.getMetrics(linkId));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidate(@PathVariable Integer linkId) {
        return ResponseEntity.ok("Eliminado link " + linkService.invalidate(linkId));
    }
}
