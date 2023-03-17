package cakar.sfgcs.sfgcassandrasleuth.commands;


import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
public class ProductForm {
    private String id;
    private String description;
    private String price;
    private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
