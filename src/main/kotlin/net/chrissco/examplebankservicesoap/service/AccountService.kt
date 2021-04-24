package net.chrissco.examplebankservicesoap.service

import net.chrissco.examplebankservicesoap.model.Account
import net.chrissco.examplebankservicesoap.repository.AccountRepository
import net.chrissco.examplebankservicesoap.repository.CustomerRepository
import net.chrissco.examplebankservicesoap.service.utils.accountsToGetAccountsResponse
import net.chrissco.examplebankservicesoap.service.utils.findCustomerFromGetAccountsRequest
import org.example.accountservice.GetAccountsRequest
import org.example.accountservice.GetAccountsResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var accountRepository: AccountRepository

    fun getAccountsResponse(request: GetAccountsRequest) : GetAccountsResponse {
        val customer = findCustomerFromGetAccountsRequest(request, customerRepository)
        val accounts: List<Account> =
            if (customer != null) accountRepository.getAccountsForCustomerID(customer.customerID)
            else listOf()
        return accountsToGetAccountsResponse(accounts)
    }

}
