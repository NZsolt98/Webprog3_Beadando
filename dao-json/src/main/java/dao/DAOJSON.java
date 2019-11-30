package dao;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import webprog.model.Kocsi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class DAOJSON {
    File file;
    ObjectMapper mapper;

    public DAOJSON(String filepath) throws IOException {
        this.file = new File(filepath);
        this.mapper= new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        if(!file.exists()){
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write("[]");
            writer.close();

        }
    }

    public Collection<Kocsi> readAllKocsi() throws IOException {
        Collection<Kocsi> result = new ArrayList<>();
        result= mapper.readValue(file,
                new TypeReference<ArrayList<Kocsi>>(){});
        return result;
    }

    public void addKocsi(Kocsi kocsi) throws IOException, DuplikaltAuto {
        try {
            readKocsiByRendszam(kocsi.getRendszam());
        } catch (KocsiNemTalalhato kocsiNemTalalhato) {
            Collection<Kocsi> cars = readAllKocsi();
            cars.add(kocsi);
            mapper.writeValue(file, cars);
            return;
        }
        throw new DuplikaltAuto(kocsi.getRendszam());
    }

    public Kocsi readKocsiByRendszam(String rendszam) throws IOException,
            KocsiNemTalalhato {
        Collection<Kocsi> cars = readAllKocsi();
        for(Kocsi k: cars){
            if(k.getRendszam().equalsIgnoreCase(rendszam)){
                return k;
            }
        }
        throw new KocsiNemTalalhato();
    }
}
