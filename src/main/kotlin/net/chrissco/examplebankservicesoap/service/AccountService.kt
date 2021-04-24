package net.chrissco.examplebankservicesoap.service

import net.chrissco.examplebankservicesoap.model.Customer
import net.chrissco.examplebankservicesoap.repository.AccountRepository
import net.chrissco.examplebankservicesoap.repository.CustomerRepository
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
        // Placeholder to ensure data reads correctly from H2
        println(customerRepository.findAll().toList())
        println(accountRepository.findAll().toList())

        // TODO: replace this with something that returns a 'real' response
        val response = GetAccountsResponse()
        response.accountsFound = 1
        val account = GetAccountsResponse.Accounts.Account()
        account.accountNumber = "12345678"
        account.accountType = "Current Account"
        account.isJointAccount = false
        account.isOpen = true
        response.accounts = GetAccountsResponse.Accounts()
        response.accounts.account.add(account)
        return response
    }

}
