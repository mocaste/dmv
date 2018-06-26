package com.mocaste.dmv.client;

import com.mocaste.dmv.client.dto.Registration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("registration-repository")
public interface RegistrationRestClient {

    /**
     * Retrieve registrations by id
     * @param registrationId
     * @return registration
     */
    @RequestMapping(value = "/registrations/{id}", method = RequestMethod.GET)
    Registration getRegistrationById(@PathVariable("id") Long registrationId);

}
