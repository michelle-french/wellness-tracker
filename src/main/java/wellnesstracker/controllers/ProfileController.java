package wellnesstracker.controllers;

//import wellnesstracker.data.ProfileRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

//    @Autowired
//    private ProfileRepository profileRepository;

    @GetMapping
    public String index(){ return "index"; }
}
