package com.example.LibraryMa.libraryservice;


import com.example.LibraryMa.library.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class Libraryservice {
    private static List<Library> libraries=new ArrayList<>();

    static{
        libraries.add(new Library("RSS","kalyan","12345678",List.of("water","AC","Paper","Diner")));
        libraries.add(new Library("saraswati","pune","29345678",List.of("juice","AC","Paper","Diner")));
        libraries.add(new Library("Relaiable","nashik","662345678",List.of("24hrs","AC","Paper","Diner")));
        libraries.add(new Library("gajanan maharaj","jalgan","10345678",List.of("material","AC","Paper","Diner")));

    }

    public void addLibrary(Library library){
            libraries.add(library);
    }

    public Library getbyName(String name){


        Predicate<? super Library> predicate= library->library.getName().equals(name);

        Library library=libraries.stream().filter(predicate).findFirst().get();
        return library;

    }

    public List<Library>findAll(){
        return libraries;
    }

    public void updateLibrary(String libraryname,Library library){
         //for(Library librar:libraries){
          //   librar.getName().equals(libraryname);
         //}
        Library librar=getbyName(libraryname);
        librar.setName(library.getName());
        librar.setAddress(library.getAddress());
        librar.setNumber(library.getNumber());
        librar.setFacilities(library.getFacilities());
    }

   public void deletebyName(String name){
       Predicate<? super Library> predicate= library->library.getName().equals(name);
       libraries.removeIf(predicate);
   }



}
