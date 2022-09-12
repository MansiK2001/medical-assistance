package com.medical.backend.model

import org.springframework.data.annotation.Id

data class HospitalList(

    @Id
    val hospitalId: String?,
    val hospitalName: String?,
    val hospitalPhNum: String?,
    val hospitalAddress :String?,
)