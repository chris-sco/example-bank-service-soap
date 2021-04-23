package net.chrissco.examplebankservicesoap.config

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
class SoapWSConfig {

    @Bean
    fun messageDispatcherServlet(context: ApplicationContext): ServletRegistrationBean<MessageDispatcherServlet> {
        val servlet = MessageDispatcherServlet()
        servlet.setApplicationContext(context)
        servlet.isTransformWsdlLocations = true
        return ServletRegistrationBean<MessageDispatcherServlet>(servlet, AccountServiceConstants.URI_MAPPINGS)
    }

    @Bean(AccountServiceConstants.WSDL_NAME)
    fun defaultAccountServiceWsdl11Definition(schema: XsdSchema): DefaultWsdl11Definition {
        val definition = DefaultWsdl11Definition()
        definition.setPortTypeName(AccountServiceConstants.PORT_TYPE)
        definition.setLocationUri(AccountServiceConstants.ROOT_LOCATION_URI)
        definition.setTargetNamespace(AccountServiceConstants.TARGET_NAMESPACE)
        definition.setSchema(schema)
        return definition
    }

    @Bean
    fun schema(): XsdSchema {
        return SimpleXsdSchema(ClassPathResource(AccountServiceConstants.ACCOUNT_SERVICE_SCHEMA_RESOURCE))
    }

}