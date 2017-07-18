package com.oonurkuru.spring.services;

import com.oonurkuru.spring.domains.Person;

/**
 * Created by Onur Kuru on 18.7.2017.
 */


public class PersonService {


    public void savePerson(Person person) {

        // Kaydetme kodları
        System.out.println("KAYDETME KODLARI ÇALIŞIYOR");

    }

    public void updatePerson(Person person) {

        if (person == null) {
            System.out.println("BİR HATA OLUŞTU");
            throw new IllegalArgumentException("PERSON NULL OLAMAZ");
        }

        //Güncelleme kodları
        System.out.println("GÜNCELLEME KODLARI ÇALIŞIYOR");
    }

    public void deletePerson(Person person) {

        // silme kodları
        System.out.println("SİLME KODLARI ÇALIŞIYOR");
    }

}
