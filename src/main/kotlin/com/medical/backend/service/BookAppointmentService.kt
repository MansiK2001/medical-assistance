package com.medical.backend.service

import com.medical.backend.model.BookAppointment
import com.medical.backend.repository.BookAppointmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import reactor.core.publisher.Mono


@Service
class BookAppointmentService(
    @Autowired
    val bookAppointmentRepository: BookAppointmentRepository

) {

    fun addAppointment(bookAppointment: BookAppointment):Mono<BookAppointment>{
        return bookAppointmentRepository.save(bookAppointment)
    }


    fun updateAppointment(bookAppointment: BookAppointment):Mono<BookAppointment>{
        return bookAppointmentRepository.save(bookAppointment)
    }

    fun deleteById(id: String): Mono<Void> {
        return bookAppointmentRepository.deleteById(id)
    }


}