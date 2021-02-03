package com.capstone.habitbuilder.enjoyer;

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


    // Index - need to delete due to not necessary for enjoyer
    @GetMapping("/me")
    @PreAuthorize("hasRole('ENJOYER')")
    public Enjoyer getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return enjoyerRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Enjoyer", "id", userPrincipal.getId()));
    }

    // Show
    @GetMapping(path = "{enjoyerId}")
    public Enjoyer showEnjoyer(@PathVariable("enjoyerId") Long enjoyerId) {
        return enjoyerService.showEnjoyer(enjoyerId);
    }

    // Create
    @PostMapping
    public void registerNewEnjoyer(@RequestBody Enjoyer enjoyer) {
        enjoyerService.addNewEnjoyer(enjoyer);
    }

    // Update
    @PutMapping(path = "{enjoyerId}")
    public void updateEnjoyer(
            @PathVariable("enjoyerId") Long enjoyerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String photoUrl,
            @RequestParam(required = false) String about) {

        enjoyerService.updateEnjoyer(enjoyerId, name, photoUrl, about);
    }

    // Delete
    @DeleteMapping(path = "{enjoyerId}")
    public void deleteEnjoyer(@PathVariable("enjoyerId") Long enjoyerId) {
        enjoyerService.deleteEnjoyer(enjoyerId);
    }
}
