package com.medical.backend.controller

import com.medical.backend.model.BookAppointment

import com.medical.backend.repository.BookAppointmentRepository
import com.medical.backend.service.BookAppointmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono


@RestController
@RequestMapping("v1")
class
 BookAppointmentController (

    @Autowired
    val bookAppointmentService: BookAppointmentService

        ){

    @PostMapping("/bookAppointment")
    fun save(@RequestBody bookAppointment: BookAppointment) : Mono<BookAppointment> {
        return bookAppointmentService.addAppointment(bookAppointment)
    }


    @PutMapping("/updateAppointment/{id}")
    fun update(@PathVariable("id") id: String,@RequestBody bookAppointment: BookAppointment): Mono<BookAppointment> {
        return bookAppointmentService.updateAppointment(bookAppointment)
    }

    @DeleteMapping("/Appointment/{id}")
    fun delete(@PathVariable id: String): Mono<Void> {
        return bookAppointmentService.deleteById(id)
    }


}