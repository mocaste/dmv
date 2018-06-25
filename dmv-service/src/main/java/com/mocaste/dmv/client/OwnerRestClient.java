package com.mocaste.dmv.client;

import com.mocaste.dmv.client.dto.Owner;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("http://owner-repository")
public interface OwnerRestClient {

    /**
     * Retrieve owner by id
     * @param ownerId
     * @return owner
     */
    @RequestMapping(value = "/owners/{id}", method = RequestMethod.GET)
    Owner getOwnerById(@PathVariable("id") Long ownerId);
}
