package service.operator.domain

import com.expediagroup.graphql.SchemaGeneratorConfig
import com.expediagroup.graphql.TopLevelObject
import com.expediagroup.graphql.spring.operations.Query
import com.expediagroup.graphql.toSchema
import org.springframework.stereotype.Component

@Component
class OperatorQuery : Query {
    fun operator(code: String): Operator {
        return Operator(code, "Test")
    }
}

// Generate the schema
val config = SchemaGeneratorConfig(supportedPackages = listOf("service.operator.domain"))
val queries = listOf(TopLevelObject(OperatorQuery()))
val schema = toSchema(config, queries)