package com.medical.backend.repository

import com.medical.backend.model.LoginRequest
import com.medical.backend.model.Patient
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface PatientRepository : ReactiveMongoRepository<Patient, String> {

    /*@Query("{'userName':?0}")
    fun findByuserName(loginRequest: LoginRequest): Patient*/

    @Query("{'userName':?0}")
    fun findByName(loginRequest: LoginRequest): Mono<Patient>
}