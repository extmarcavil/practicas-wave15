package sprint1.socialmeli.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import sprint1.socialmeli.dto.*;
import sprint1.socialmeli.service.IProductService;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

    //US 0005
    @PostMapping("/post")
    public ResponseEntity<?> save(@RequestBody RequestPostDTO post) {
        return ResponseEntity.ok().body("Creado post ID: " + productService.save(post));
    }

    // US 0006 - US 0009
    @GetMapping("/followed/{followerUserID}/list")
    public ResponseEntity<ResponsePostListDTO> get2WeeksProductsOfFollowed(@PathVariable int followerUserID, @RequestParam @Nullable String order){
        return ResponseEntity.ok(productService.get2WeeksProductsOfFollowed(followerUserID, order));
    }

    // US 0010
    @PostMapping("/promo-post")
    public ResponseEntity<?> savePromoPost(@RequestBody RequestPromoPostDTO promoPost) {
        return ResponseEntity.ok().body("Creado promo post ID: " + productService.savePromoPost(promoPost));
    }

    // US 0011
    @GetMapping("/promo-post/count")
    public ResponseEntity<ResponseCountPromoPostDTO> countPromoPost(@RequestParam (value = "user_id") int userId){
        return ResponseEntity.ok(productService.countPromoPost(userId));
    }

    // US 0012
    @GetMapping("/followed/{userId}/list/promo-post/")
    public ResponseEntity<ResponsePromoPostListDTO> getAllPromoProductByPriceRangeOfFollowed(@PathVariable int userId, @RequestParam (value = "min_price") double minPrice, @RequestParam (value = "max_price") double maxPrice){
        return ResponseEntity.ok(productService.getAllPromoProductByPriceRangeOfFollowed(userId, minPrice, maxPrice));
    }

}
