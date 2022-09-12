package com.medical.backend.service

import com.medical.backend.model.LoginRequest
import com.medical.backend.model.Patient
import com.medical.backend.repository.PatientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PatientLoginService(

    @Autowired
    val patientRepository: PatientRepository
) {


    //    @PostMapping("/signin")
//    fun authenticateUser(@RequestBody patient: Patient): Mono<String?>? {
//        val authentication: Authentication = authenticationManager.authenticate(
//            UsernamePasswordAuthenticationToken(
//                loginDto.getUsernameOrEmail(), loginDto.getPassword()
//            )
//        )
//        SecurityContextHolder.getContext().setAuthentication(authentication)
//        return ResponseEntity("User signed-in successfully!.", HttpStatus.OK)
//    }


    fun patientLogin(loginRequest: LoginRequest): Mono<Patient> {
        return patientRepository.findByName(loginRequest)
    }
}