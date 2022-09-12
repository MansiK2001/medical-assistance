package com.medical.backend.model

import org.springframework.data.annotation.Id

data class BookAppointment(

    @Id
    val patientId: String?,
    val patientName: String?,
    val doctorName:String?,
    val address :String?,
    val email:String?,
    val mobileNumber:String?,
    val dateofAppointment:String?,
//    val category:String?,
    val reason:String?,
    )