package com.lukkas_lukkas.java_rest_api.infrastructure.http.controllers.person;

import com.lukkas_lukkas.java_rest_api.application.person.get_people.GetPeopleHandler;
import com.lukkas_lukkas.java_rest_api.domain.Person;
import com.lukkas_lukkas.java_rest_api.infrastructure.http.contracts.person.GetPeopleInterface;
import com.lukkas_lukkas.java_rest_api.infrastructure.http.presenters.PersonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class GetPeopleController implements GetPeopleInterface {

    private final GetPeopleHandler handler;

    public GetPeopleController(GetPeopleHandler handler) {
        this.handler = handler;
    }

    @GetMapping
    public ResponseEntity<List<PersonView>> get() {
        var people = this.handler.handle();

        List<PersonView> peopleView = people
                .stream()
                .map(PersonView::new)
                .toList();

        return new ResponseEntity<>(peopleView, HttpStatus.OK);
    }
}
