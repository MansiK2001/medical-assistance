package com.medical.backend.service

import com.medical.backend.model.HospitalList
import com.medical.backend.repository.HospitalListRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class HospitalListService(
    @Autowired
    val HospitalListRepository: HospitalListRepository

) {

    fun findAllHospitalLists() : Flux<HospitalList> {
        return HospitalListRepository.findAll()
    }

    fun addToHospitalList(HospitalList: HospitalList):Mono<HospitalList>{
        return HospitalListRepository.save(HospitalList)
    }


    fun updateHospitalList(HospitalList: HospitalList):Mono<HospitalList>{
        return HospitalListRepository.save(HospitalList)
    }

    fun deleteByhospitalId(hospitalId: String): Mono<Void> {
        return HospitalListRepository.deleteById(hospitalId)
    }

    fun findByhospitalId(hospitalId: String): Mono<HospitalList>{
        return HospitalListRepository.findById(hospitalId)
    }


}