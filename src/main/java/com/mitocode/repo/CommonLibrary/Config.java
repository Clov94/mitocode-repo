package com.mitocode.repo.CommonLibrary;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class Config {

    public static URI uri(String uuid){
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/"+uuid)
                .buildAndExpand(uuid).toUri();
    }
}
