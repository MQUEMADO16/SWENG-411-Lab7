package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.model.Worker;
import java.io.*;
import java.util.ArrayList;

@Controller
public class MyController {

    @GetMapping("/worker/create")
    public String createWorker(Model model) throws IOException {
        Worker[] workerArray = new Worker[5];

        workerArray[0] = new Worker("John", 25, "Male", 3);
        workerArray[1] = new Worker("Doug", 26, "Male", 4);
        workerArray[2] = new Worker("Kenny", 25, "Male", 5);
        workerArray[3] = new Worker("Georgina", 26, "Female", 6);
        workerArray[4] = new Worker("Katie", 25, "Female", 7);

        try (FileOutputStream fos = new FileOutputStream("Worker.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(workerArray);
        }

        return "worker";
    }

    @GetMapping("/worker/{ageValue}")
    public String workerAge(@PathVariable int ageValue, Model model) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("Worker.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Worker[] workerArray = (Worker[]) ois.readObject();
        ArrayList<Worker> workersByAge = new ArrayList<>();

        for(Worker w : workerArray) {
            if (w.getAge() == ageValue) {
                workersByAge.add(w);
            }
        }

        model.addAttribute("workers", workersByAge);
        model.addAttribute("age", ageValue);
        return "workerAge";
    }

    @GetMapping("/worker/sex/{gender}")
    public String workerGender(@PathVariable String gender, Model model) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("Worker.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Worker[] workerArray = (Worker[]) ois.readObject();
        ArrayList<Worker> workersByGender = new ArrayList<>();

        for(Worker w : workerArray) {
            if (w.getGender().equalsIgnoreCase(gender.toLowerCase())) {
                workersByGender.add(w);
            }
        }

        model.addAttribute("workers", workersByGender);
        model.addAttribute("gender", gender);
        return "workerGender";
    }
}
