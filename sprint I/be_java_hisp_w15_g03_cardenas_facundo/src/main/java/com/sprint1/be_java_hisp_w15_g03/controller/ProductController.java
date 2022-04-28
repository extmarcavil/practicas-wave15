package com.sprint1.be_java_hisp_w15_g03.controller;

import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDiscountDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.PromotionCountDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.PublicationDiscountListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPListDTO;
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
        productService.savePublication(publication);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<SellerPListDTO> getLastPublications(@PathVariable int userId,
                                                              @RequestParam(required = false) String order) {

        return new ResponseEntity<>(productService.getLastPublication(userId, order), HttpStatus.OK);
    }


    @PostMapping("/promo-post")
    public ResponseEntity<?> savePublicationWithDiscount(@RequestBody PublicationDiscountDTO publicationPromotionDTO) {
        productService.savePublicationWithPromotion(publicationPromotionDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    ResponseEntity<PromotionCountDTO> getPromotionCount(@RequestParam(name = "user_id", required = true) Integer userId) {
        return new ResponseEntity<>(productService.getCantProductsWithDiscount(userId), HttpStatus.OK);
    }
    @GetMapping("/promo-post/list")
    ResponseEntity<PublicationDiscountListDTO> getListPublicationWithDiscount(@RequestParam(name = "user_id", required = true) Integer userId){
                return new ResponseEntity<>(productService.getListPublicationWithDiscount(userId), HttpStatus.OK);
    }

}
