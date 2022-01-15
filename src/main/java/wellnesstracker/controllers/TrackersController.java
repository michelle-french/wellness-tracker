package wellnesstracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import wellnesstracker.data.AppointmentRepository;
import wellnesstracker.data.ProfileRepository;
import wellnesstracker.models.Appointment;
import wellnesstracker.models.Profile;
import wellnesstracker.models.Time;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class TrackersController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("profile/tracker")
    public String displayTrackerLinks(Model model){

        model.addAttribute("title", "TRACKERS");
        return "trackers/index";
    }

    @GetMapping("profile/tracker/appts")
//    @ResponseBody
    public String displayAppts(@RequestParam(required = false) Integer profileId, Model model){

        if(profileId == null) {
            model.addAttribute("title", "All Appointments");
            model.addAttribute("appointments", appointmentRepository.findAll());
        } else {
            Optional<Profile> result = profileRepository.findById(profileId);
            if(result.isEmpty()) {
                model.addAttribute("title", "Invalid Profile: " + profileId);
            } else {
                Profile profile = result.get();
                model.addAttribute("title", "Appointments for: " + profile.getProfileFirst());
                model.addAttribute("appointments", profile.getAppointments());
            }
        }

        return "trackers/appointments";
    }

    @GetMapping("profile/tracker/appts/create")
    public String addApptsForm(Model model){
        model.addAttribute("title", "ADD APPOINTMENT");
        model.addAttribute(new Appointment());
        model.addAttribute("profiles", profileRepository.findAll());
        model.addAttribute("times", Time.values());
        return "trackers/createappts";
    }

    @PostMapping("profile/tracker/appts/create")
    public String processAddApptsForm(@Valid @ModelAttribute Appointment newAppointment, Errors errors, Model model){
        if(errors.hasErrors()) {
            model.addAttribute("title", "ADD APPOINTMENT");
            return "trackers/createappts";
        }
        appointmentRepository.save(newAppointment);
        return "redirect:/profile/tracker/appts";
    }

    @GetMapping("/profile/tracker/appts/delete")
    public String deleteApptForm(Model model){
        model.addAttribute("title", "DELETE APPOINTMENT");
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "trackers/deleteAppts";
    }

    @PostMapping("/profile/tracker/appts/delete")
    public String processDeleteAppt(@RequestParam(required = false) int[] appointmentIds) {

        if (appointmentIds != null) {
            for(int id : appointmentIds) {
                appointmentRepository.deleteById(id);
            }
        }
        return "redirect:";
    }
}
