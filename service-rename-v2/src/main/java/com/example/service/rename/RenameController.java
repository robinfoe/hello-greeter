package com.example.service.rename;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.opentracing.Span;
import io.opentracing.Tracer;

@RestController
public class RenameController {

    @Autowired
    private Tracer tracer;

    @GetMapping("/renameGreeting")
    public String renameGreeting(@RequestParam String greeting, @RequestHeader HttpHeaders headers) {
        System.out.println("Headers: " + headers);
        Span span = tracer.scopeManager().activeSpan();
        span.log("reaming message remotely for name " + greeting);
        String response = greeting + "-- added version for mocking";
        String myBaggage = span.getBaggageItem("my-baggage");
        span.log("this is baggage " + myBaggage);
        return response;
    }
}