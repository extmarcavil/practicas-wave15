package sprint1.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private Integer userId;
    private LocalDate date;
    private Product detail;
    private Integer category;
    private Double price;
}
