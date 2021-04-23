package net.chrissco.examplebankservicesoap.endpoint

import net.chrissco.examplebankservicesoap.config.AccountServiceConstants
import net.chrissco.examplebankservicesoap.service.AccountService
import org.example.accountservice.GetAccountsRequest
import org.example.accountservice.GetAccountsResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload

@Endpoint
class AccountServiceEndpoint {

    @Autowired
    private val service = AccountService()

    @ResponsePayload
    @PayloadRoot(namespace = AccountServiceConstants.TARGET_NAMESPACE,
                 localPart = AccountServiceConstants.GET_ACCOUNTS_LOCAL_PART)
    fun getAccounts(@RequestPayload request: GetAccountsRequest): GetAccountsResponse {
        return service.getAccountsResponse(request)
    }

}