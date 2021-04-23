package net.chrissco.examplebankservicesoap.config

object AccountServiceConstants {

    // Globals
    const val TARGET_NAMESPACE = "http://www.example.org/accountservice"
    const val PORT_TYPE = "AccountService"
    const val ROOT_LOCATION_URI = "/ws"
    const val URI_MAPPINGS = "$ROOT_LOCATION_URI/*"
    const val WSDL_NAME = "account_service"

    // Local Parts
    const val GET_ACCOUNTS_LOCAL_PART = "GetAccountsRequest"

    // Schema Locations
    const val ACCOUNT_SERVICE_SCHEMA_RESOURCE = "schema/accountservice.xsd"

}