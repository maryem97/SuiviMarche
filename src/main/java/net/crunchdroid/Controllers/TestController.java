package net.crunchdroid.Controllers;


import net.crunchdroid.Dto.TestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/")
    public String test(){
        return "test ok";
    }

    @PostMapping("/add")
    public String testAdd(@RequestBody TestDto testDto){
        System.out.println(testDto.getAb());
        System.out.println(testDto.getAc());
        return "test ok";
    }
}
