package net.chrissco.examplebankservicesoap.model

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customers")
data class Customer(
    @Id val customerID: String,
    val firstName: String,
    val surname: String,
    val dateOfBirth: LocalDate
)
