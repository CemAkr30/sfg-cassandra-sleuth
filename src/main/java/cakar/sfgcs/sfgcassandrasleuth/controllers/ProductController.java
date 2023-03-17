package cakar.sfgcs.sfgcassandrasleuth.controllers;


import cakar.sfgcs.sfgcassandrasleuth.commands.ProductForm;
import cakar.sfgcs.sfgcassandrasleuth.converters.ProductToProductForm;
import cakar.sfgcs.sfgcassandrasleuth.domain.Product;
import cakar.sfgcs.sfgcassandrasleuth.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jt on 1/10/17.
 */
@RestController
@Slf4j
public class ProductController {
    private ProductService productService;

    private ProductToProductForm productToProductForm;

    @Autowired
    public void setProductToProductForm(ProductToProductForm productToProductForm) {
        this.productToProductForm = productToProductForm;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/")
    public String redirToList(){
        log.info("redirecting to product list");
        return "redirect:/product/list";
    }

    @RequestMapping({"/product/list", "/product"})
    public String listProducts(Model model){
        log.info("getting product list");
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }

    @RequestMapping("/product/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        log.info("getting product with id: " + id);
        model.addAttribute("product", productService.getById(id));
        return "product/show";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Product product = productService.getById(id);
        ProductForm productForm = productToProductForm.convert(product);
        log.info("getting product with id: " + id);
        model.addAttribute("productForm", productForm);
        return "product/productform";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("productForm", new ProductForm());
        log.info("getting new product form");
        return "product/productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Validated ProductForm productForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "product/productform";
        }
        log.info("saving product: " + productForm.toString());
        Product savedProduct = productService.saveOrUpdateProductForm(productForm);

        return "redirect:/product/show/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        log.info("deleting product with id: " + id);
        productService.delete(id);
        return "redirect:/product/list";
    }
}
