package net.chrissco.examplebankservicesoap.service.utils

import net.chrissco.examplebankservicesoap.model.Account
import net.chrissco.examplebankservicesoap.model.Customer
import net.chrissco.examplebankservicesoap.repository.CustomerRepository
import org.example.accountservice.GetAccountsRequest
import org.example.accountservice.GetAccountsResponse
import java.time.LocalDate
import javax.xml.datatype.XMLGregorianCalendar

/**
 * Accepts a list of Account objects and generates a GetAccountsResponse
 * object for those accounts.  Returns a count of zero and no account
 * objects if the list is empty.
 *
 * @param accounts the list of accounts to be parsed
 * @return GetAccountsResponse object representing list of accounts
 */
fun accountsToGetAccountsResponse(accounts: List<Account>): GetAccountsResponse {
    val response = GetAccountsResponse()
    response.accountsFound = accounts.size
    if (accounts.isNotEmpty()) {
        response.accounts = GetAccountsResponse.Accounts()
        accounts.forEach {
            val account = GetAccountsResponse.Accounts.Account()
            account.accountNumber = it.accountNumber
            account.accountType = it.accountType
            account.isJointAccount = it.jointAccount
            account.isOpen = it.openAccount
            response.accounts.account.add(account)
        }
    }
    return response
}

/**
 * Searches the datastore for the customer specified in the given
 * GetAccountsRequest.  Requires either a customerID or the firstName,
 * surname and dateOfBirth to match, or will return null.  If more
 * than one matching customer is found, returns null.
 *
 * @param req GetAccountsRequest object with customer data
 * @param repository CustomerRepository for query
 * @return Customer? null if not enough data provided or multiple found
 */
fun findCustomerFromGetAccountsRequest(req: GetAccountsRequest, repository: CustomerRepository): Customer? {
    val customer: Customer?
    if (!req.customerID.isNullOrEmpty()) {
        // If we have a customer ID return that record
        customer = repository.findById(req.customerID).get()
    } else {
        println(req.dateOfBirth)
        print(xmlGregorianCalendarToLocalDate(req.dateOfBirth))
        // Otherwise check the details have been provided and return
        // a single record (or nothing if none or more than one found)
        customer = if (!req.firstName.isNullOrEmpty()
                        && !req.surname.isNullOrEmpty()
                        && req.dateOfBirth != null) {
            val potentialCustomers = repository.getCustomerFromDetails(
                req.firstName, req.surname, xmlGregorianCalendarToLocalDate(req.dateOfBirth))
            if (potentialCustomers.size > 1) null else potentialCustomers[0]
        } else {
            null
        }
    }
    return customer
}

/**
 * Converts XMLGregorianCalendar(from SOAP) to LocalDate.
 *
 * @param calendar XMLGregorianCalendar to convert
 * @return LocalDate representation of XMLGregorianCalendar
 */
fun xmlGregorianCalendarToLocalDate(calendar: XMLGregorianCalendar): LocalDate {
    return LocalDate.of(calendar.year, calendar.month, calendar.day)
}
