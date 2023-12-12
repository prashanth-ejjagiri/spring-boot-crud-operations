package com.prashanth.spring.rud.perations.Controller;

import com.prashanth.spring.rud.perations.model.UserModel;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class UserController
{
    Map<String, UserModel> allUser = new HashMap<>();

    @GetMapping()
    public Collection<UserModel> getMethod()
    {
        return allUser.values();
    }
    @GetMapping(path = "/{userId}")
    public UserModel getById(@PathVariable String userId)
    {
            return allUser.get(userId);
    }
    @PostMapping()
    public String postMethod(@RequestBody UserModel userdetails)
    {
        UserModel addValue = new UserModel();
        addValue.setUserId(userdetails.getUserId());
        addValue.setName(userdetails.getName());
        addValue.setEmail(userdetails.getEmail());
        allUser.put(userdetails.getUserId(),addValue);
        return "User added";
    }
    @PutMapping(path = "/{userId}")
    public String putMethod(@PathVariable String userId, @RequestBody UserModel userdetails)
    {
        if(allUser.containsKey(userId))
        {
            UserModel addValue = new UserModel();
            addValue.setUserId(userdetails.getUserId());
            addValue.setName(userdetails.getName());
            addValue.setEmail(userdetails.getEmail());
            allUser.put(userdetails.getUserId(),addValue);
            return "User Edited";
        }
        else
            return "User Id not found";
    }
    @DeleteMapping(path ="/{userId}")
    public String deleteMethod(@PathVariable String userId)
    {
        if (allUser.containsKey(userId))
        {
            allUser.remove(userId);
            return "Deleted successfully";
        } else
        {
            return "UserId not found";
        }
    }
}
