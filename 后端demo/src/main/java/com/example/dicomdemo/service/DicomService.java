package com.example.dicomdemo.service;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.io.DicomInputStream;

import java.io.File;
import java.io.IOException;
public class DicomService {
    public static void getTags(String pathFile){
        try {
            File file = new File(pathFile);
            DicomInputStream dis = new DicomInputStream(file);
            Attributes fmi = dis.readFileMetaInformation();
            Attributes attrs = dis.readDataset(-1, -1);
            System.out.println("Series Instance UID:" + attrs.getString(Tag.SeriesInstanceUID));
            System.out.println("Study Instance UID:" + attrs.getString(Tag.StudyInstanceUID));
            System.out.println("Patient ID:" + attrs.getString(Tag.PatientID));
            System.out.println("Patient Name" + attrs.getString(Tag.PatientName));
            System.out.println("SOP Instance UID:" + attrs.getString(Tag.SOPInstanceUID));
            System.out.println(attrs.getString(Tag.ImageType));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
