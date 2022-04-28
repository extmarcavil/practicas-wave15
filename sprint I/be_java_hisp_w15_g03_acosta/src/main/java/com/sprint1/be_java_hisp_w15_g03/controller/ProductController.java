package com.sprint1.be_java_hisp_w15_g03.controller;

import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationPromoDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerCountPPromoDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPPromoListDTO;
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

    /**
     * Controller para US: 0005
     * @param publication
     * @return HttpStatus.OK (Status Code 200 ok)
     */
    @PostMapping("/post")
    public ResponseEntity<?> savePublication(@RequestBody PublicationDTO publication) {
        productService.savePublication(publication);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Controller para US: 0006 y 0009
     * @param userId
     * @param order
     * @return JSON SellerPListDTO y HttpStatus.OK (Status Code 200 ok)
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<SellerPListDTO> getLastPublications(@PathVariable int userId,
                                                              @RequestParam(required = false) String order) {

        return new ResponseEntity<>(productService.getLastPublication(userId, order), HttpStatus.OK);
    }

    /**
     * Controller para US: 0010
     * @param publication
     * @return HttpStatus.OK (Status Code 200 ok)
     */
    @PostMapping("/promo-post")
            public ResponseEntity<?> savePublicationPromocion(@RequestBody PublicationPromoDTO publication) {
        productService.savePublicationPromo(publication);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Controller para US: 0011
     * @param userId
     * @return SellerCountPPromoDTO
     */
    @GetMapping("/promo-post/count")
    ResponseEntity<SellerCountPPromoDTO> getProductsPromoCount(@RequestParam(name = "user_id") Integer userId) {

        return new ResponseEntity<>(productService.ProductsPromoCount(userId), HttpStatus.OK);
    }

    /**
     * Controller para US: 0012
     * @param userId
     * @return SellerPPromoListDTO
     */
    @GetMapping("promo-post/list")
    public ResponseEntity<SellerPPromoListDTO> getPublicationsPPromoList(@RequestParam(name = "user_id") Integer userId){
        return new ResponseEntity<>(productService.getPublicationsPPromoList(userId), HttpStatus.OK);
    }

}
