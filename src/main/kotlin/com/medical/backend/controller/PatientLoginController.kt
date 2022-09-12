package com.medical.backend.controller
import com.medical.backend.model.LoginRequest
import com.medical.backend.model.Patient
import com.medical.backend.repository.PatientRepository
import com.medical.backend.service.PatientLoginService
import com.medical.backend.service.PatientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import javax.servlet.http.HttpSession


@RestController
@RequestMapping("login")
class PatientLoginController(

    @Autowired
    val patientRepository: PatientRepository,
    val patientService: PatientService,
    val patientLoginService: PatientLoginService
) {

    @PostMapping("/signin")
    fun authenticateUser(@RequestBody loginRequest: LoginRequest) : Mono<Patient>
    {
        return patientLoginService.patientLogin(loginRequest)
  }
}