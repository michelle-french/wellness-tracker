package wellnesstracker.controllers;

import wellnesstracker.data.AppointmentRepository;
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

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("title", "WELCOME");
        return "profileCrud/index"; }

    @GetMapping("profile")
    public String displayProfiles(Model model) {
        model.addAttribute("title", "PROFILES");
        model.addAttribute("profiles", profileRepository.findAll());
        return "profileCrud/profiles";
    }
     @GetMapping("create")
    public String createProfileForm(Model model){
        model.addAttribute("title", "ADD PROFILE");
        model.addAttribute(new Profile());
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "profileCrud/create";
     }

    @PostMapping("create")
    public String processCreateProfileForm(@Valid @ModelAttribute Profile newProfile, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "ADD PROFILE");
            return "profileCrud/create";
        }
        profileRepository.save(newProfile);
        return "redirect:/profile";
    }

    @GetMapping("profile/delete")
    public String deleteProfileForm(Model model) {
        model.addAttribute("title", "DELETE PROFILE");
        model.addAttribute("profiles", profileRepository.findAll());
        return "profileCrud/deleteProfile";
    }

    @PostMapping("profile/delete")
    public String processDeleteProfile(@RequestParam(required = false) int[] profileIds) {

        if (profileIds != null) {
            for (int id : profileIds) {
                profileRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

}
