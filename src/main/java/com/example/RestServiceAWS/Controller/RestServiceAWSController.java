package com.example.RestServiceAWS.Controller;

import com.example.RestServiceAWS.DTO.Person;
import com.example.RestServiceAWS.Service.PersonService;
import com.example.RestServiceAWS.Service.TestAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestServiceAWSController {

    @Autowired
    private PersonService personService;


    @RequestMapping(method = RequestMethod.GET, value = "/TestApp")
    public String getRequest(@RequestParam(value = "Name", required = true) String Name){


        TestAppService service = new TestAppService(Name);

        String response = service.MyName();

        return response;
    }

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
}
