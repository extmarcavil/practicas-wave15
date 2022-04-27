package sprint1.socialmeli.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import sprint1.socialmeli.dto.PostRequestDTO;
import sprint1.socialmeli.dto.PostResponseDTO;
import sprint1.socialmeli.service.IProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

    //US 0005: Dar de alta una nueva publicación
    //POST products/post
    //PAYLOAD:
    //{
    //    "user_id": 1235,
    //    "date": "29-04-2021",
    //    "detail": {
    //        "product_id": 1,
    //        "product_name": "Silla Gamer",
    //        "type": "Gamer",
    //        "brand": "Racer",
    //        "color": "Red & Black",
    //        "notes": "Special Edition"
    //    },
    //    "category": 100,
    //    "price": 1500.50
    //}
    //RESPONSE
    //Status Code 200 (todo OK)
    //Status Code 400 (Bad Request)
    @PostMapping("/post")
    public ResponseEntity<PostResponseDTO> save(@RequestBody PostRequestDTO post) {
        return ResponseEntity.ok(this.productService.save(post));
    }


    // US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un
    // usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por
    // fecha, publicaciones más recientes primero).
    //GET products/followed/{userId}/list
    //Ejemplo: /products/followed/4698/list
    //RESPONSE:
    //{
    //    "user_id": 4698,
    //    "posts": [ {
    //            "post_id": 32,
    //            "date": "01-05-2021",
    //            "detail": {
    //                "product_id": 62,
    //                "product_name": "Headset RGB Inalámbrico",
    //                "type": "Gamer",
    //                "brand": "Razer",
    //                "color": "Green with RGB",
    //                "notes": "Sin Batería"
    //            },
    //            "category": 120,
    //            "price": 2800.69
    //        },
    //        {
    //            "post_id": 18,
    //            "date": "29-04-2021",
    //            "detail": {
    //                "product_id": 1,
    //                "productName": "Silla Gamer",
    //                "type": "Gamer",
    //                "brand": "Racer",
    //                "color": "Red & Black",
    //                "notes": "Special Edition"
    //            },
    //            "category": 100,
    //            "price": 15000.50
    //        }
    //    ]
    //}
    @GetMapping("/followed/{followerUserID}/list")
    public ResponseEntity<List<PostResponseDTO>> get2WeeksProductsOfFollowed(@PathVariable int followerUserID, @RequestParam @Nullable String order){
        List<PostResponseDTO> posts = productService.get2WeeksProductsOfFollowed(followerUserID);
        if (order == null) {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
        return new ResponseEntity<>(productService.sort2WeeksOfPosts(posts, order), HttpStatus.OK);
    }
}
