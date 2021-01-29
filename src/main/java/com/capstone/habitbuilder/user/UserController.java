package com.capstone.habitbuilder.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Index - need to delete due to not necessary for user
    @GetMapping
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    // Show
    @GetMapping(path = "{userId}")
    public void showUser(
            @PathVariable("userId") Long userId) {

        userService.showUser(userId);
    }

    // Create
    @PostMapping
    public void registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    // Update
    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String photoUrl,
            @RequestParam(required = false) String about) {

        userService.updateUser(userId, name, photoUrl, about);
    }

    // Delete
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }
}
