package com.nivasana.resourceapp.controllers;

import java.util.List;

import com.nivasana.resourceapp.dtos.UserDetailsDTO;
import com.nivasana.resourceapp.feignService.UserServiceFeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserResourceController {

@Autowired
UserServiceFeign feignService;


@PostMapping("/saveUpdate")
public UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO inputUser)
{
    return feignService.saveUpdate(inputUser);
}

@GetMapping("/id/{id}")
public UserDetailsDTO getByUserId(@PathVariable Long id)
{
    return feignService.getById(id);
}


@GetMapping("/name/{name}")
public List<UserDetailsDTO> getByName(@PathVariable String name)
{
    System.out.println(" In here...");
    return feignService.getByName(name);
}   

    
}
