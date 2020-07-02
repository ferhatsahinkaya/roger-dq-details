package com.roger.dqdetails.domain

import com.expediagroup.graphql.federation.execution.FederatedTypeRegistry
import com.expediagroup.graphql.federation.execution.FederatedTypeResolver
import com.expediagroup.graphql.spring.operations.Mutation
import com.expediagroup.graphql.spring.operations.Query
import graphql.schema.DataFetchingEnvironment
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

val dqDetailsMap = mutableMapOf<Long, DqDetails>()

@Component
class DqDetailsQuery : Query {
    fun dqDetails(serviceId: Long) = dqDetailsMap[serviceId]
}

@Component
class DqDetailsMutation : Mutation {
    fun dqDetails(dqDetails: DqDetailsInput): DqDetails {
        if (dqDetailsMap[dqDetails.serviceId] != null) {
            dqDetailsMap[dqDetails.serviceId] = DqDetails(
                    dqDetails.serviceId,
                    dqDetails.type,
                    dqDetails.firstNameOrInitial,
                    dqDetails.surname,
                    dqDetails.postcode,
                    dqDetails.recordId,
                    dqDetails.customerType)
        }


        dqDetailsMap[dqDetails.serviceId] = DqDetails(
                dqDetails.serviceId,
                dqDetails.type,
                dqDetails.firstNameOrInitial,
                dqDetails.surname,
                dqDetails.postcode,
                dqDetails.recordId,
                dqDetails.customerType)
        return dqDetailsMap[dqDetails.serviceId]!!
    }
}

private val dqDetailsResolver = object : FederatedTypeResolver<DqDetails> {
    override suspend fun resolve(environment: DataFetchingEnvironment, representations: List<Map<String, Any>>): List<DqDetails?> = representations.map {
        dqDetailsMap[it["serviceId"]]
    }
}

@Bean
fun federatedTypeRegistry() = FederatedTypeRegistry(mapOf("DqDetails" to dqDetailsResolver))