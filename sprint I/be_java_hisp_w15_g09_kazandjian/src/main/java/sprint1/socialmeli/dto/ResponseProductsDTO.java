package sprint1.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sprint1.socialmeli.model.Post;
import sprint1.socialmeli.model.Product;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseProductsDTO {
    private Integer user_id;
    private String user_name;
    private List<Post> posts;

}
