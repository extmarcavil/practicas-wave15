package com.sprint1.be_java_hisp_w15_g03.controller;

import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationPromoDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.PromoCountDT0;
import com.sprint1.be_java_hisp_w15_g03.dto.response.PromoListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPListDTO;
import com.sprint1.be_java_hisp_w15_g03.exception.HasnotPromoException;
import com.sprint1.be_java_hisp_w15_g03.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> savePublication(@RequestBody PublicationDTO publication) {
        productService.savePublicationWithoutPromo(publication);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<SellerPListDTO> getLastPublications(@PathVariable int userId,
                                                              @RequestParam(required = false) String order) {
        return new ResponseEntity<>(productService.getLastPublication(userId, order), HttpStatus.OK);
    }


    @PostMapping("/promo-post")
    public ResponseEntity<?> savePromoPublication(@RequestBody PublicationPromoDTO promo){

        if(!promo.getHas_promo())
        {
           throw new HasnotPromoException("El articulo no esta en promo.");
        }
        productService.savePromoPublication(promo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoCountDT0> getPromoCount (@RequestParam(name = "user_id") int userId){
        return new ResponseEntity<>(productService.getPromoCount(userId),HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoListDTO> getPromoList (@RequestParam(name = "user_id") int userId){
        return new ResponseEntity<>(productService.getPromoList(userId),HttpStatus.OK);
    }

}
