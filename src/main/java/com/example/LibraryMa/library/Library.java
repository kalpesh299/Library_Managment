package com.example.LibraryMa.library;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class Library {
    private String name;
    private String address;
    private String number;
    private List<String> facilities;
}
