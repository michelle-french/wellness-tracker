package wellnesstracker.controllers;

import wellnesstracker.data.ProfileRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import wellnesstracker.models.Profile;

import javax.validation.Valid;


@Controller
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("title", "WELCOME to FETTLE");
        return "index"; }

    @GetMapping("profile")
    public String displayProfiles(Model model) {
        model.addAttribute("title", "PROFILES");
        model.addAttribute("profile", profileRepository.findAll());
        return "profiles";
    }

    @GetMapping("create")
    public String displayCreateProfileForm(@Valid @ModelAttribute Profile profile, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Profile");
            model.addAttribute(new Profile());
            return "create";
        }
        profileRepository.save(profile);
        return "redirect: ";
    }

//    @PostMapping("")
}
