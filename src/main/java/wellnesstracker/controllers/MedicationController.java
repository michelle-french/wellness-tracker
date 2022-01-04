package wellnesstracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wellnesstracker.data.AppointmentRepository;
import wellnesstracker.data.MedicationRepository;
import wellnesstracker.data.ProfileRepository;
import wellnesstracker.models.Medication;

import javax.validation.Valid;

@Controller
public class MedicationController {

    @Autowired
    MedicationRepository medicationRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("profile/tracker/meds")
    public String displayMeds(Model model){
        model.addAttribute("title", "MEDICATIONS");
        model.addAttribute("medications", medicationRepository.findAll());
        return "medications/medications";
    }

    @GetMapping("profile/tracker/meds/create")
    public String addMedsForm(Model model){
        model.addAttribute("title", "ADD MEDICATION");
        model.addAttribute(new Medication());
        model.addAttribute("profiles", profileRepository.findAll());
        return"medications/createMeds";
    }

    @PostMapping("profile/tracker/meds/create")
    public String processAddMedsForm(@Valid @ModelAttribute Medication newMedication, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title", "ADD MEDICATION");
            return "medications/createMeds";
        }
        medicationRepository.save(newMedication);
        return "redirect:/profile/tracker/meds";
    }

    @GetMapping("/profile/tracker/meds/delete")
    public String deleteMedForm(Model model) {
        model.addAttribute("title", "DELETE MEDICATION");
        model.addAttribute("medications", medicationRepository.findAll());
        return "medications/deleteMeds";
    }

    @PostMapping("/profile/tracker/meds/delete")
    public String processDeleteMed(@RequestParam(required = false) int[] medicationIds) {

        if (medicationIds != null){
            for(int id : medicationIds) {
                medicationRepository.deleteById(id);
            }
        }
        return "redirect:";
    }
}
