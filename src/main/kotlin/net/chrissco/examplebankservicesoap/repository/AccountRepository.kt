package net.chrissco.examplebankservicesoap.repository

import net.chrissco.examplebankservicesoap.model.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AccountRepository : JpaRepository<Account, String> {

    @Query("from Account where customerid = ?1")
    fun getAccountsForCustomerID(customerID: String): List<Account>

}