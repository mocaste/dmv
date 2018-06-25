package com.mocaste.dmv.client;


import com.mocaste.dmv.client.dto.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("http://car-repository")
public interface CarRestClient {

    /**
     * Retrieve car by id
     * @param carId
     * @return car
     */
    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
    Car getCarById(@PathVariable("id") Long carId);
}
