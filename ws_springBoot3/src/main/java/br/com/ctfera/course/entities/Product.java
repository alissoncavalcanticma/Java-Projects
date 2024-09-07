package br.com.ctfera.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="tb_product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    //Não será usado o List, devido a necessidade de garantir a não duplicidade da categoria para o mesmo produto.
    //@Transient //Usado para o JPA não interpretar esse Anottation.
    //private List<Category> categories;
    //Foi necessário instanciar logo o HashSet para garantir que não será criado com valor nulo.

    @ManyToMany
    @JoinTable(
            name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    //Relacionamento com OrderItem
    //Relacionameto OneToMany, 1 produto para vários items de pedido. Mapeamento apontando para o objeto id de OrderItem.
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    public Product(){}

    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    //Método para retornar a lista de orders relacionadas ao produto, através do relacionamento com OrderItem
    //Inserção da annotation @JsonIgnore para ajustar associação de mão dupla de Product com OrderItem
    @JsonIgnore
    public Set<Order> getOrders(){
        Set<Order> set = new HashSet<>();

        for (OrderItem x : items){
            set.add(x.getOrder());
        }
        return set;

    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        return getId().equals(product.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
