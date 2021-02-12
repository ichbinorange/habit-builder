package com.capstone.habitbuilder.enjoyer;

import com.capstone.habitbuilder.habit.Habit;
import com.capstone.habitbuilder.oauthapi.ResourceNotFoundException;
import com.capstone.habitbuilder.security.CurrentUser;
import com.capstone.habitbuilder.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/enjoyer")
public class EnjoyerController {
    private final EnjoyerService enjoyerService;
    private final EnjoyerRepository enjoyerRepository;

    @Autowired
    public EnjoyerController(EnjoyerService enjoyerService, EnjoyerRepository enjoyerRepository) {
        this.enjoyerService = enjoyerService;
        this.enjoyerRepository = enjoyerRepository;
    }

    // Index - info about current user
    @GetMapping("/me")
    @PreAuthorize("hasRole('ENJOYER')")
    public Enjoyer getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return enjoyerRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Enjoyer", "id", userPrincipal.getId()));
    }

    // Show - info show current user's friends
    @GetMapping(path = "{enjoyerId}")
    public Enjoyer showEnjoyer(@PathVariable("enjoyerId") Long enjoyerId) {
        return enjoyerService.showEnjoyer(enjoyerId);
    }

    // Search - find a user
    @GetMapping(path = "/email/{enjoyerEmail}")
    public Enjoyer findEnjoyer(@PathVariable("enjoyerEmail") String enjoyerEmail) {
        return enjoyerRepository.findEnjoyerByEmail(enjoyerEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Enjoyer", "email", enjoyerEmail));
    }

    // Update
    @PutMapping(path = "{enjoyerId}")
    public void updateEnjoyer(@PathVariable("enjoyerId") Long enjoyerId,
                              @RequestBody Enjoyer enjoyer) {

            enjoyerService.updateEnjoyer(enjoyerId, enjoyer);
    }

    // Delete
    @DeleteMapping(path = "{enjoyerId}")
    public void deleteEnjoyer(@PathVariable("enjoyerId") Long enjoyerId) {
            enjoyerService.deleteEnjoyer(enjoyerId);
    }
}
