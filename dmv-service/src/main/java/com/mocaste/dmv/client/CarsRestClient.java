package com.mocaste.dmv.client;

import com.mocaste.dmv.dto.RegistrationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("http://dmv-repository")
public interface CarsRestClient {

    /**
     * Retrieve car by id
     * @param carId
     * @return car
     */
    @RequestMapping(value = "/cars/{carId}", method = RequestMethod.GET)
    Resource<RegistrationDTO> getCarById(@PathVariable("carId") Long carId);
}
