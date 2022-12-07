package demo.demo.uploadproductpicture;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController

public class productController {
    @Autowired
    private ProductService productService;
    private Product product;

    @PostMapping(value = {"/addnewProduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})


    public Product addnewProduct(@RequestPart("product ") Product product,
                                 @RequestPart("imageFile") MultipartFile[] file) {
       // return productService.addnewProduct(product);
        try {
             Set<Image> images= uploadImage(file);
             Product.setProductImages(images);
             return ProductService.addnewProduct(product);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    private Set<Image> uploadImage(MultipartFile[] mulitpartfile) throws IOException {
        Set<Image> imageModels = new HashSet<>();
        for (MultipartFile file : mulitpartfile) {
            Image imageModel = new Image(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            ;
            imageModels.add(imageModel);

        }
        return  imageModels;
    }
}
