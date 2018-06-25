package com.mocaste.dmv.client;

import com.mocaste.dmv.dto.CarDTO;
import com.mocaste.dmv.dto.OwnerDTO;
import com.mocaste.dmv.dto.RegistrationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("http://dmv-repository")
public interface RegistrationsRestClient {

    /**
     * Retrieve registrations by id
     * @param registrationId
     * @return registration
     */
    @RequestMapping(value = "/registrations/{registrationId}", method = RequestMethod.GET)
    Resource<RegistrationDTO> getRegistrationByRegistrationId(@PathVariable("registrationId") Long registrationId);

    /**
     * Get registered car by registrationId
     * @param registrationId
     * @return
     */
    @RequestMapping(value = "/registrations/{registrationId}/car", method = RequestMethod.GET)
    Resource<CarDTO> getCarByRegistrationId(@PathVariable("registrationId") Long registrationId);

    /**
     * Get owner of registered car by registrationId
     * @param registrationId
     * @return
     */
    @RequestMapping(value = "/registrations/{registrationId}/owner", method = RequestMethod.GET)
    Resource<OwnerDTO> getOwnerByRegistrationId(@PathVariable("registrationId") Long registrationId);
}
