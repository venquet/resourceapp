package com.nivasana.resourceapp.feignService;

import java.util.List;

import com.nivasana.resourceapp.dtos.UserDetailsDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service")
public interface UserServiceFeign {
    
    @PostMapping("/api/saveUpdate")
    UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO inputUser);

    @GetMapping("/api/id/{id}")
    UserDetailsDTO getById(@PathVariable Long id);

    @GetMapping("/api/name/{name}")
    List <UserDetailsDTO> getByName(@PathVariable String name);
}
