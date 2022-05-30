package ru.iteco.saorder.service.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Orders extends CreateModifyTechFields implements Identified<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "complete_at", nullable = false)
    private LocalDate completeAt;

    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Column(name = "client_id", nullable = false)
    private UUID clientId;

    @ElementCollection
    @CollectionTable(
            name = "order_features",
            joinColumns=@JoinColumn(name = "order_id", referencedColumnName = "id"))
    @Column(name = "feature")
    private Set<Long> features;

    @Column(name = "contract_id", nullable = true)
    private UUID contractId;

    @Column(name = "employee_id", nullable = false)
    private long employeeId;
}
