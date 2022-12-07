package demo.demo.uploadproductpicture;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
        @javax.persistence.Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "id", nullable = false)
        private Long id;

        @Id
        @GeneratedValue( strategy = GenerationType.AUTO)
        private Integer ProductID;
        private String PName;
        private String PDescription;
        private String PCategory;
        private Double PDiscountPrice;
        private Double PActualPrice;

        public static void setProductImages(Set<Image> images) {
        }

        public void Product(Integer productID) {
            ProductID = productID;
        }

        public Integer getProductID() {
            return ProductID;
        }

        public void setProductID(Integer productID) {
            ProductID = productID;
        }

        @ManyToMany(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
        @JoinTable(name="product_images",
                joinColumns = {
                        @JoinColumn(name="productID")
                },
                inverseJoinColumns = {
                        @JoinColumn(name="imageID")
                }
        )
        private Set<Image> ProductImage;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

    }



