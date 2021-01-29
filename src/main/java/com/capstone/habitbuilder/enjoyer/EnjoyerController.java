package com.capstone.habitbuilder.enjoyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/enjoyer")
public class EnjoyerController {
    private final EnjoyerService enjoyerService;

    @Autowired
    public EnjoyerController(EnjoyerService enjoyerService) {
        this.enjoyerService = enjoyerService;
    }

    // Index - need to delete due to not necessary for enjoyer
    @GetMapping
    public Iterable<Enjoyer> getEnjoyers() {
        return enjoyerService.getEnjoyers();
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
