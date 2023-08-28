package com.example.formulario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class data {
    private static final String name = "";
    private static final String school = "";

    // Mapa para relacionar escuelas con carreras

    private static final Map<String, String> schoolToCareerMap = new HashMap<>();
    static {
        schoolToCareerMap.put("fia", "Ingeniería de Sistemas");
        schoolToCareerMap.put("fia2", "Ingeniería Electrónica");
        schoolToCareerMap.put("fia3", "Ingeniería Industrial");

        schoolToCareerMap.put("fciet", "Educación en Tecnología");
        schoolToCareerMap.put("fciet2", "Gestión de la Tecnología");
        schoolToCareerMap.put("fciet3", "Comunicaciones");
        // Agrega más escuelas y carreras según sea necesario
    }

    public static String getName() {
        return name;
    }

    public static String getSchool() {
        return school;
    }

    public static String getCareerForSchool(String schoolName) {
        return schoolToCareerMap.get(schoolName);
    }

    public static String[] getAllCareers() {
        List<String> carrerasList = new ArrayList<>();

        for (Map.Entry<String, String> entry : schoolToCareerMap.entrySet()) {
            carrerasList.addAll(Collections.singleton(entry.getValue()));
        }

        return carrerasList.toArray(new String[0]);
    }

}