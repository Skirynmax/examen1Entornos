/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionfruteria;

/**
 *
 * @author alban
 */
class stopWatch {
     private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime(); // Inicia el cronómetro
    }

    public void stop() {
        endTime = System.nanoTime(); // Detiene el cronómetro
    }

    public long getElapsedTime() {
        return endTime - startTime; // Calcula la diferencia
    }
}
