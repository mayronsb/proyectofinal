/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.services;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

  
    final String BucketName = "remodelaciones-4e7cd.appspot.com";


    final String rutaSuperiorStorage = "remodelaciones";


    final String rutaJsonFile = "firebase";
    
   
    final String archivoJsonFile = "remodelaciones-4e7cd-firebase-adminsdk-to6jb-e6d2d928a3.json";
}
