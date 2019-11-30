package dao;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import webprog.model.Edesseg;
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

    public Collection<Edesseg> readAllEdesseg() throws IOException {
        Collection<Edesseg> result = new ArrayList<>();
        result= mapper.readValue(file,
                new TypeReference<ArrayList<Edesseg>>(){});
        return result;
    }

    public void addEdesseg(Edesseg edesseg) throws IOException, DuplikaltEdesseg {
        try {
            readEdessegByTermekszam(edesseg.getTermekszam());
        } catch (EdessegNemTalalhato edessegNemTalalhato) {
            Collection<Edesseg> sweets = readAllEdesseg();
            sweets.add(edesseg);
            mapper.writeValue(file, sweets);
            return;
        }
        throw new DuplikaltEdesseg(edesseg.getTermekszam());
    }

    public Edesseg readEdessegByTermekszam(String termekszam) throws IOException,
            EdessegNemTalalhato {
        Collection<Edesseg> sweets = readAllEdesseg();
        for(Edesseg k: sweets){
            if(k.getTermekszam().equalsIgnoreCase(termekszam)){
                return k;
            }
        }
        throw new EdessegNemTalalhato();
    }
}
