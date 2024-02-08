package com.springboot_project2.service;

import com.springboot_project2.Dto.UserDto;
import com.springboot_project2.Exceptions.RessourceNotFoundException;
import com.springboot_project2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot_project2.repository.UserRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Userservice {
    @Autowired
    private UserRepo userRepo;
    public UserDto createUser(UserDto userDto) {
        User user=this.dtoToUser(userDto);
        User saveduser=this.userRepo.save(user);
        return this.userToDto(saveduser);
    }

    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user =this.userRepo.findById(userId).orElseThrow(()->new RessourceNotFoundException("user"," id ",userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(user.getPassword());
        user.setAbout(user.getAbout());
        User updateUser = this.userRepo.save(user);
        UserDto userDto1=this.userToDto(updateUser);
        return userDto1;
    }

   public UserDto getUserById(Integer userId) {
        User user =this.userRepo.findById(userId).orElseThrow(()->new RessourceNotFoundException("user"," id ",userId));
        return this.userToDto(user);
    }

    public List<UserDto> getallUser() {
        List<User> users=this.userRepo.findAll();
        List<UserDto> userDtos =users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return  userDtos;
    }

    public void deleteUser(Integer userId) {
        User user= this.userRepo.findById(userId).orElseThrow(()->new RessourceNotFoundException("user"," id ",userId));
        this.userRepo.delete(user);
    }
    private User dtoToUser(UserDto userDto){
        return  new User().setName(userDto.getName()).setEmail(userDto.getEmail()). setPassword(userDto.getPassword()).setAbout(userDto.getAbout());


    }
    public UserDto userToDto(User user){
        UserDto userDto =new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setAbout(user.getAbout());
        return userDto;
    }

}
