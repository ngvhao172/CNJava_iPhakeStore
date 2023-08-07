package tdtu.edu.vn.Lab10.models;
import jakarta.persistence.*;
import lombok.*;

import java.text.DecimalFormat;

@Entity
@Table(name = "tbl_product")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    private String brand;
    private String detail;
    private String image;
}
