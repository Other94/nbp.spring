package pl.example.nbp.controller;

import org.springframework.web.bind.annotation.*;
import pl.example.nbp.model.Product;
import pl.example.nbp.repository.ProductRepository;
import pl.example.nbp.service.RestClient;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {
    private final ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @GetMapping
    public List<Product> getProduct(){
        return productRepository.findAll();
    }
    @PostMapping
    public Product addProduct(@RequestBody @Valid Product product) throws IOException {

        RestClient restClient = new RestClient();

        double usdRate = restClient.calculateUsdToPLN(product.getPostingDate());
        product.setPricePLN(usdRate * product.getPriceUSD());

        return productRepository.save(product);
    }

    @GetMapping("/sort-date")
    public List<Product> getProductByDate(){
        return productRepository.findAllByOrderByPostingDate();
    }

    @GetMapping("/sort-date-desc")
    public List<Product> getProductByDateDesc(){
        return productRepository.findAllByOrderByPostingDateDesc();
    }

}
