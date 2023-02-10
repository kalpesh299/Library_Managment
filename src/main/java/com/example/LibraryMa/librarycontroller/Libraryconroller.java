package com.example.LibraryMa.librarycontroller;

import com.example.LibraryMa.library.Library;
import com.example.LibraryMa.libraryservice.Libraryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class Libraryconroller {
    @Autowired
    private Libraryservice libraryservice;


    //http://localhost:8080/api/library/add-library
    @PostMapping("add-library")//adding library

    public void addlibrary(@RequestBody Library library){

libraryservice.addLibrary(library);

    }

    //http://localhost:8080/api/library/library-byname/RSS
    @GetMapping("library-byname/{name}")//print by Path variable
    public Library getbyname(@PathVariable String name){
        return libraryservice.getbyName(name);
    }
    //http://localhost:8080/api/library/library-byname?name=RSS
    @GetMapping("library-byname")//print by Request param
    public Library getbynam(@RequestParam String name){
        return libraryservice.getbyName(name);
    }

    //http://localhost:8080/api/library/all-libraryData
    @GetMapping("all-libraryData")//print all
    public List<Library> findall(){
        return libraryservice.findAll();
    }

    //http://localhost:8080/api/library/update-libraray/name/RSS
   @PutMapping("update-libraray/name/{libraryname}")//updating library
    public void updatebyName(@PathVariable String libraryname,@RequestBody Library library){

        libraryservice.updateLibrary(libraryname,library);

   }
   //http://localhost:8080/api/library/delete-library/saraswati
   @DeleteMapping("delete-library/{name}")//delete by name
    public void deleteLibrary(@PathVariable String name){
        libraryservice.deletebyName(name);
   }



}
