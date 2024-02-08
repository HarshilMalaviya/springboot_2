package com.springboot_project2.controller;

import com.springboot_project2.Dto.UserDto;
import com.springboot_project2.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    private Userservice userservice;
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser (@RequestBody UserDto userDto){
        UserDto createUserDto=this.userservice.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable Integer id){
        UserDto updatedUser=this.userservice.updateUser(userDto,id);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        this.userservice.deleteUser(id);
        return new ResponseEntity(Map.of("message","user deleted succesfully"),HttpStatus.OK);
    }
    @GetMapping("/alluser")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userservice.getallUser());
    }
    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id){
        return ResponseEntity.ok(this.userservice.getUserById(id));
    }
}
