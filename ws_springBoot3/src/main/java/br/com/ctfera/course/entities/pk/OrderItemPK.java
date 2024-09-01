package br.com.ctfera.course.entities.pk;

import br.com.ctfera.course.entities.Order;
import br.com.ctfera.course.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;


@Embeddable //Anottation para identificar classe de composição
//Classe auxiliar para composição de chave primária composta
public class OrderItemPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemPK that)) return false;

        return getOrder().equals(that.getOrder()) && getProduct().equals(that.getProduct());
    }

    @Override
    public int hashCode() {
        int result = getOrder().hashCode();
        result = 31 * result + getProduct().hashCode();
        return result;
    }
}
