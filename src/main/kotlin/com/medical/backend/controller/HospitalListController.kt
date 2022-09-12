package com.medical.backend.controller

import com.medical.backend.model.HospitalList
import com.medical.backend.repository.HospitalListRepository
import com.medical.backend.service.HospitalListService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping("v1")
class HospitalListController (

    @Autowired
    val HospitalListRepository: HospitalListRepository,
    val HospitalListService: HospitalListService
){

    @GetMapping("/hospital")
    fun getAllHospitalLists(): Flux<HospitalList> {
        return HospitalListService.findAllHospitalLists()
    }

    @GetMapping("{hospitalId}")
    fun getHospitalListById(@PathVariable hospitalId: String): Mono<HospitalList> {
        return HospitalListService.findByhospitalId(hospitalId)
    }

    @PostMapping("/HospitalLists")
    fun HospitalListSave(@RequestBody HospitalList: HospitalList): Mono<HospitalList> {
        return HospitalListService.addToHospitalList(HospitalList)
    }

    @PutMapping("/updateHospitalList/{hospitalId}")
    fun updateByHospitalId( @RequestBody  hospitalList: HospitalList): Mono<HospitalList> {
        return HospitalListService.updateHospitalList(hospitalList)
    }

//    @DeleteMapping
//    fun deleteHospitalList(): Mono<Void> {
//        return HospitalListRepository.deleteAll()
//    }


    @DeleteMapping("/HospitalLists/{hospitalId}")
    fun deleteHospitalLists(@PathVariable hospitalId: String): Mono<Void> {
        return HospitalListService.deleteByhospitalId(hospitalId)
    }
}


