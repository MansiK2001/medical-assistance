package com.medical.backend.controller
import com.medical.backend.model.Patient
import com.medical.backend.repository.PatientRepository
import com.medical.backend.service.PatientService
import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.returnResult
import reactor.core.publisher.Flux

@WebFluxTest(PatientController::class)
@AutoConfigureWebTestClient

class PatientControllerTest {

    // need to mock the service layer responses

    @Autowired
    lateinit var client: WebTestClient

    @Autowired
    lateinit var patientService: PatientService

    @Autowired
    lateinit var patientRepository: PatientRepository

    @TestConfiguration
    class ControllerTestConfig {
        @Bean
        fun patientService() = mockk<PatientService>()

        @Bean

        fun patientRepository() = mockk<PatientRepository>()
    }

    @Test

    fun `should return list  `() {
        val patient1 = Patient(
            "12", "mansi", "karande", "riya", "9004907903", "riya@gmail.com", "female", "17/04/2001",
            "mansi@2001", "mumbai"
        )


        val expectedResult = mapOf(
            "patientId" to "12",
            "patientFirstName" to "Mansi",
            "patientLastname" to "karande",
            "userName" to "riya",
            "mobileNumber" to "9004907903",
            "email" to "riya@gmail.com",
            "gender" to "female",
            "dob" to "17/04/2001",
            "password" to "mansi@00",
            "address" to "mumbai"
        )
        every {
            patientService.findAllPatients()
        } returns Flux.just(patient1)

        val response = client.get()
            .uri("/patients/list")
            .accept(MediaType.APPLICATION_JSON)
            .exchange() //invoking the end point
            .expectStatus().is2xxSuccessful
            .returnResult<Any>()
            .responseBody

        response.blockFirst() shouldBe expectedResult

        verify(exactly = 1) {
            patientService.findAllPatients()
        }
    }

   /* @Test
    fun `should return one patient `() {

        val patient1 = Patient(
            "1", "Chaitali", "Vadhane", "chv", "9325059460", "chv@gmail.com", "female", "30/03/1997",
            "chv@00", "Pune"
        )


        val expectedResult = mapOf(
            "patientId" to "1",
            "patientFirstName" to "Chaitali",
            "patientLastname" to "Vadhane",
            "userName" to "chv",
            "mobileNumber" to "9325059460",
            "email" to "chv@gmail.com",
            "gender" to "female",
            "dob" to "30/03/1997",
            "password" to "chv@00",
            "address" to "Pune"
        )
        every {
            patientService.findById("1")
        } returns Mono.just(patient1)

        val response = client.get()
            .uri("/patients/1")
            .accept(MediaType.APPLICATION_JSON)
            .exchange() //invoking the end point
            .expectStatus().is2xxSuccessful
            .returnResult<Any>()
            .responseBody

        response.blockFirst() shouldBe expectedResult

        verify(exactly = 1) {
            patientService.findById("1")
        }
    }

    @Test
    fun `should register patient add patient when create api i…
    val exepectedResponse = mapOf(
        "patientId" to "1",
        "patientFirstName" to "Chaitali",
        "patientLastname" to "Vadhane",
        "userName" to "chv",
        "mobileNumber" to "9325059460",
        "email" to "chv@gmail.com",
        "gender" to "female",
        "dob" to "30/03/1997",
        "password" to "chv@00",
        "address" to "Pune"
    )
    val patient1 = Patient(
        "1", "Chaitali", "Vadhane", "chv", "9325059460", "chv@gmail.com", "female", "30/03/1997",
        "chv@00", "Pune"
    )

    every {
        patientService.addPatient(patient1)
    } returns Mono.just(patient1)

    val response = client.post()
        .uri("/patients/add")
        .bodyValue(patient1)
        .exchange()
        .expectStatus().is2xxSuccessful
        .returnResult<Any>().responseBody


    response.blockFirst() shouldBe exepectedResponse

    verify(exactly = 1) {
        patientService.addPatient(patient1)
    }
}


*/
}