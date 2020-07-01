package com.roger.dqdetails.domain

data class DqDetails(
        val serviceId: Long,
        val type: String,
        val firstNameOrInitial: String,
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
        val customerType: String) {

}