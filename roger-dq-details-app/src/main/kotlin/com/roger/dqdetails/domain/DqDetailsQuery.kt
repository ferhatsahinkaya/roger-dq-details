package com.roger.dqdetails.domain

import com.expediagroup.graphql.federation.execution.FederatedTypeRegistry
import com.expediagroup.graphql.federation.execution.FederatedTypeResolver
import com.expediagroup.graphql.spring.operations.Mutation
import com.expediagroup.graphql.spring.operations.Query
import graphql.schema.DataFetchingEnvironment
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

val dqDetailsMap = mutableMapOf<Long, DqDetails>()

@Component
class DqDetailsQuery : Query {
    fun dqDetails(serviceId: Long) = dqDetailsMap[serviceId]
}

@Component
class DqDetailsMutation : Mutation {
    fun dqDetails(dqDetails: DqDetailsInput): DqDetails {
        dqDetailsMap[dqDetails.serviceId] = DqDetails(
                dqDetails.type,
                dqDetails.firstNameOrInitial,
                dqDetails.surname,
                dqDetails.postcode,
                dqDetails.recordId,
                dqDetails.customerType)
        return dqDetailsMap[dqDetails.serviceId]!!
    }
}

private val serviceResolver = object : FederatedTypeResolver<Service> {
    override suspend fun resolve(environment: DataFetchingEnvironment, representations: List<Map<String, Any>>): List<Service?> = representations.map {
        val identifier = it["id"].toString().toLong()
        Service(identifier, dqDetailsMap[identifier]!!)
    }
}

@Configuration
open class SchemaConfig {
    @Bean
    open fun federatedTypeRegistry() = FederatedTypeRegistry(mapOf("Service" to serviceResolver))
}
