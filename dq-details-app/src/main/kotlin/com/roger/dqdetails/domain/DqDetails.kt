package com.roger.dqdetails.domain

import com.expediagroup.graphql.federation.directives.ExtendsDirective
import com.expediagroup.graphql.federation.directives.ExternalDirective
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective

@KeyDirective(fields = FieldSet("serviceId"))
data class DqDetails(
        val serviceId: Long,
        val type: String,
        val firstNameOrInitial: String?,
        val surname: String,
        val postcode: String,
        val recordId: String,
        val customerType: String)

data class DqDetailsInput(
        val serviceId: Long,
        val type: String,
        val firstNameOrInitial: String?,
        val surname: String,
        val postcode: String,
        val recordId: String,
        val customerType: String)

@KeyDirective(fields = FieldSet("id"))
@ExtendsDirective
data class Service(@property:ExternalDirective val id: Long,
                   val dqDetails: DqDetails)