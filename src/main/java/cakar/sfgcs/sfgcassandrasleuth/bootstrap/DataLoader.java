package cakar.sfgcs.sfgcassandrasleuth.bootstrap;

import cakar.sfgcs.sfgcassandrasleuth.domain.Product;
import cakar.sfgcs.sfgcassandrasleuth.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {


     private final ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {
        productRepository.save(Product.builder().id("1").description("Product 1").price("12.99").imageUrl("http://example.com/product1").build());
    }

}
