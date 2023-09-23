package org.launchcode.hellospringcustom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests to the form /hello?name=LaunchCode
//    @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value= "hello")
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }

    // Handles requests to the form /hello/LaunchCode
    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String langs) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, langs);

        // For a bonus mission, students can change this response text to look nicer.
        // This is subjective, but students should be modifying the HTML of the response string.
    }

    public static String createMessage(String name, String langs) {
        String greeting = "";

        if (langs.equals("english")) {
            greeting = "Hello";
        }
        else if (langs.equals("french")) {
            greeting = "Bonjour";
        }
        else if (langs.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (langs.equals("spanish")) {
            greeting = "Hola";
        }
        else if (langs.equals("german")) {
            greeting = "Hallo";
        }

        return greeting + " " + name;
    }
    // Modify your HelloController class to display a form on a GET request that asks the user for both their name and
    // the language they would like to be greeted in.
    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action='hello' method='post'>" +
                            "<input type='text' name='name' />" +
                            "<select name='langs' id='lang-select'>" +
                                "<option value='english'>English</option>" +
                                "<option value='french'>French</option>" +
                                "<option value='italian'>Italian</option>" +
                                "<option value='spanish'>Spanish</option>" +
                                "<option value='german'>German</option>" +
                            "<select/>" +
                            "<input type='submit' value='Greet me!' />" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }



}
