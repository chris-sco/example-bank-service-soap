package net.chrissco.examplebankservicesoap.repository

import net.chrissco.examplebankservicesoap.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDate

interface CustomerRepository : JpaRepository<Customer, String> {

    @Query("from Customer where first_name = ?1 and surname = ?2 and date_of_birth = ?3")
    fun getCustomerFromDetails(firstName: String, surname: String, dateOfBirth: LocalDate) : List<Customer>

}