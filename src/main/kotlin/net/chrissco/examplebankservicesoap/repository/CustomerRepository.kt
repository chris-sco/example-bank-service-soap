package net.chrissco.examplebankservicesoap.repository

import net.chrissco.examplebankservicesoap.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, String> {}