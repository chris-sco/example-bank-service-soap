package net.chrissco.examplebankservicesoap.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "accounts")
data class Account(
    val customerID: String,
    @Id val accountNumber: String,
    val accountType: String,
    val openAccount: Boolean,
    val jointAccount: Boolean
)
