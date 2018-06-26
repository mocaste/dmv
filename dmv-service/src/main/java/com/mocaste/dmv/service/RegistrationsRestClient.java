package com.mocaste.dmv.service;

import com.mocaste.dmv.dto.RegistrationDTO;
import feign.Param;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableFeignClients
@EnableDiscoveryClient
@FeignClient("registration-repository")
public interface RegistrationsRestClient {

    @RequestMapping(value = "/registrations/plateNumber", method = RequestMethod.GET)
    RegistrationDTO getRegistrationByPlateNumber(@Param("plateNumber") String plateNumber);
}
