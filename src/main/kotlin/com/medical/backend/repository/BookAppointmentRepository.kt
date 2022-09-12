package com.medical.backend.repository

import com.medical.backend.model.BookAppointment
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface BookAppointmentRepository : ReactiveMongoRepository<BookAppointment, String> {
}