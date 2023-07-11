package pl.data;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetTime;

@Entity
@Table(name = "invoice")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Long invoiceId;

    @Column(name = "invoice_number", nullable = false, unique = true)
    private String invoiceNumber;

    @Column(name = "date_time", nullable = false)
    private OffsetTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_to_buy_id", nullable = false)
    private CarToBuyEntity carToBuy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salesman_id", nullable = false)
    private SalesmanEntity salesman;
}
