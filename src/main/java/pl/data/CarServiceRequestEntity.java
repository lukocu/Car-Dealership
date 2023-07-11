package pl.data;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetTime;

@Entity
@Table(name = "car_service_request")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CarServiceRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_service_request_id")
    private Long carServiceRequestId;

    @Column(name = "car_service_request_number", nullable = false, unique = true)
    private String carServiceRequestNumber;

    @Column(name = "received_date_time", nullable = false)
    private OffsetTime receivedDateTime;

    @Column(name = "completed_date_time")
    private OffsetTime completedDateTime;

    @Column(name = "customer_comment")
    private String customerComment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_to_service_id", nullable = false)
    private CarToServiceEntity carToService;
}