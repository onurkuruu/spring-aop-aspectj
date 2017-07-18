package com.oonurkuru.spring.services;

import com.oonurkuru.spring.domains.Project;

/**
 * Created by Onur Kuru on 18.7.2017.
 */
public class ProjectService {

    public void saveProject(Project project) {

        // Kaydetme kodları
        System.out.println("KAYDETME KODLARI ÇALIŞIYOR");

    }

    public void updateProject(Project project) {

        if (project == null) {
            System.out.println("BİR HATA OLUŞTU");
            throw new IllegalArgumentException("PROJECT NULL OLAMAZ");
        }

        //Güncelleme kodları
        System.out.println("GÜNCELLEME KODLARI ÇALIŞIYOR");
    }

    public void deleteProject(Project project) {

        // silme kodları
        System.out.println("SİLME KODLARI ÇALIŞIYOR");
    }
}
