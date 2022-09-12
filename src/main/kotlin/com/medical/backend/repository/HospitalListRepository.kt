package com.medical.backend.repository

import com.medical.backend.model.HospitalList
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface HospitalListRepository : ReactiveMongoRepository<HospitalList, String>