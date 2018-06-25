package com.mocaste.dmv.client;

import com.mocaste.dmv.dto.RegistrationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("http://dmv-repository")
public interface OwnersRestClient {

    /**
     * Retrieve owner by id
     * @param ownerId
     * @return owner
     */
    @RequestMapping(value = "/owners/{ownerId}", method = RequestMethod.GET)
    Resource<RegistrationDTO> getOwnerById(@PathVariable("ownerId") Long ownerId);
}
