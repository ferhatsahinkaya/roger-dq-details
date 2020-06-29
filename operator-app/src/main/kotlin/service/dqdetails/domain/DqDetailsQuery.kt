package service.dqdetails.domain

import com.expediagroup.graphql.SchemaGeneratorConfig
import com.expediagroup.graphql.TopLevelObject
import com.expediagroup.graphql.spring.operations.Query
import com.expediagroup.graphql.toSchema
import org.springframework.stereotype.Component

@Component
class DqDetailsQuery : Query {
    fun dqDetails(recordId: String): DqDetails {
        return DqDetails(recordId, "Test", "", "", "", "", "", "", "", "", "", "", "")
    }
}

// Generate the schema
val config = SchemaGeneratorConfig(supportedPackages = listOf("service.dqdetails.domain"))
val queries = listOf(TopLevelObject(DqDetailsQuery()))
val schema = toSchema(config, queries)