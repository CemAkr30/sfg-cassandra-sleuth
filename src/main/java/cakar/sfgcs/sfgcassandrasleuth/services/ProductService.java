package cakar.sfgcs.sfgcassandrasleuth.services;


import cakar.sfgcs.sfgcassandrasleuth.commands.ProductForm;
import cakar.sfgcs.sfgcassandrasleuth.domain.Product;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
public interface ProductService {

    List<Product> listAll();

    Product getById(String id);

    Product saveOrUpdate(Product product);

    void delete(String id);

    Product saveOrUpdateProductForm(ProductForm productForm);
}
