package com.roger.dqdetails.domain

import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective

@KeyDirective(fields = FieldSet("recordId"))
data class DqDetails (
        val serviceId: Long,
        val type: String,
        val firstNAmeOrInitial: String,
        val surname: String,
        val specialEquipment: String,
        val specialTypeface: String,
        val premises: String,
        val thoroughfare: String,
        val locality: String,
        val postcode: String,
        val recordId: String,
        val marketingPreference: String,
        val nddReferenceNumber: String,
        val customerType: String)
{

}