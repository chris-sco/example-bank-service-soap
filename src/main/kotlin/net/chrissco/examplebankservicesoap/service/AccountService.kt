package net.chrissco.examplebankservicesoap.service

import org.example.accountservice.GetAccountsRequest
import org.example.accountservice.GetAccountsResponse
import org.springframework.stereotype.Service

@Service
class AccountService {

    fun getAccountsResponse(request: GetAccountsRequest) : GetAccountsResponse {
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
