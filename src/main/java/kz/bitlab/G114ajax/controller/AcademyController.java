package kz.bitlab.G114ajax.controller;

import kz.bitlab.G114ajax.models.Academy;
import kz.bitlab.G114ajax.repository.AcademyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academies")
public class AcademyController
{
    @Autowired
    private AcademyRepository academyRepository;

    @GetMapping("/a")
    public List<Academy> getAcademies()
    {
        return academyRepository.findAll();
    }

    @GetMapping("/test")
    public int test()
    {
        return 22;
    }

    @PostMapping("/add")
    public Academy addAcademy(@RequestBody Academy academy)
    {
        return academyRepository.save(academy);
    }

    @GetMapping("/details/{id}")
    public Academy details(@PathVariable(name = "id") Long id)
    {
        return academyRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id)
    {
        academyRepository.deleteById(id);
    }

    @PutMapping("/edit")
    public void update(@RequestBody Academy academy)
    {
        System.out.println("IM HERE");
        academyRepository.save(academy);
    }
}
