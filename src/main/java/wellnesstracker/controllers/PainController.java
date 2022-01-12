package wellnesstracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wellnesstracker.data.PainRepository;
import wellnesstracker.data.ProfileRepository;
import wellnesstracker.models.Day;
import wellnesstracker.models.Pain;
import wellnesstracker.models.Time;

import javax.validation.Valid;

@Controller
public class PainController {

    @Autowired
    PainRepository painRepository;
    @Autowired
    ProfileRepository profileRepository;

    @GetMapping("profile/tracker/pain")
    public String displayPain(Model model) {
        model.addAttribute("title", "PAIN TRACKER");
        model.addAttribute("pains", painRepository.findAll());
        return "pains/index";
    }
    @GetMapping("profile/tracker/pain/add")
    public String addPainsForm(Model model){
        model.addAttribute("title", "ADD EPISODE");
        model.addAttribute(new Pain());
        model.addAttribute("profiles", profileRepository.findAll());
        model.addAttribute("days", Day.values());
        model.addAttribute("times", Time.values());
        return"pains/create";
    }
    @PostMapping("profile/tracker/pain/add")
    public String processPainsForm(@Valid @ModelAttribute Pain newPain, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "ADD EPISODE");
            return "pains/create";
        }
        painRepository.save(newPain);
        return "redirect:/profile/tracker/pain";
    }
    @GetMapping("/profile/tracker/pain/remove")
    public String deletePainForm(Model model) {
        model.addAttribute("title", "Remove Episode");
        model.addAttribute("pains", painRepository.findAll());
        return "pains/delete";
    }
    @PostMapping("/profile/tracker/pain/remove")
    public String processDeletePain(@RequestParam(required = false) int[] painIds) {
        if (painIds != null){
            for(int id : painIds){
                painRepository.deleteById(id);
            }
        }
        return "redirect:";
    }
}