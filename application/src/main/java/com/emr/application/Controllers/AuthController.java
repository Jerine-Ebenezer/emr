package com.emr.application.Controllers;
import com.emr.application.Entities.Doctor;
import com.emr.application.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://127.0.0.1:5500")
@CrossOrigin(origins = {
        "http://127.0.0.1:5500",
        "https://emr-406bs8l5h-jer20.vercel.app",
        "https://emr-amber-beta.vercel.app",
        "https://emr-pxjzewzl0-jer20.vercel.app",

})
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private DoctorRepository doctorRepository;

    // ---------------- Register ----------------
    @PostMapping("/register")
    public String registerDoctor(@RequestBody Doctor doctor) {
        if (doctorRepository.findByUsername(doctor.getUsername()) != null) {
            return "Username already exists!";
        }

        doctorRepository.save(doctor);
        return "Doctor registered successfully!";
    }

    // ---------------- Login ----------------
    @PostMapping("/login")
    public String loginDoctor(@RequestBody Doctor loginData) {
        Doctor doctor = doctorRepository.findByUsername(loginData.getUsername());

        if (doctor == null) {
            return "Invalid username!";
        }

        if (!doctor.getPassword().equals(loginData.getPassword())) {
            return "Wrong password!";
        }

        return "Login successful!";
    }
}
