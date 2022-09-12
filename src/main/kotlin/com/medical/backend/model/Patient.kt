package com.medical.backend.model

import org.springframework.data.annotation.Id

data class Patient(

   @Id
   val patientId: String?,
   val patientFirstName: String?,
   val patientLastname: String?,
   val userName: String?,
   val mobileNumber: String?,
   val email: String?,
   val gender: String?,
   val dob: String?,
   val password: String?,
   val address: String?
)