package pl.example.nbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.example.nbp.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Integer> {


    public List<Product> findAllByOrderByPostingDate();
    public List<Product> findAllByOrderByPostingDateDesc();
}
