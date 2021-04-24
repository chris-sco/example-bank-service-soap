package net.chrissco.examplebankservicesoap.repository

import net.chrissco.examplebankservicesoap.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, String> {}