package br.com.ctfera.course.entities;

import br.com.ctfera.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Annotattion @JsonFormat para definição de formatação
    //Opção "shape = JsonFormat.Shape.STRING" para definir o Shape String
    //Opção "pattern = "yyyy=MM-dd'T'HH:mm:ss'Z'"" para definir o formato da data
    //Opção "timezone = "GMT"" para definir o timezone
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne //Annotation de relação muitos para 1
    @JoinColumn(name = "client_id") //definição da coluna/campo de Join
    private User client;

    //Relacionamento de Order com OrderItem
    //Annotation OneToMany (1 Order para muitos OrderItems, setando o id.order como mapeamento(objeto OrderItemPK de OrderItem))
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    private Payment payment;

    public Order(){}

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    //function set para OrderItem
    public Set<OrderItem> getItems(){
        return items;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;

        return getId().equals(order.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
