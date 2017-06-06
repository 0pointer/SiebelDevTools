package com.boehm.siebel.deploy.deploy;

import com.boehm.siebel.deploy.deploy.dto.SifDTO;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

@Component
public class SifDAO {
    List<SifDTO> sifLst = new ArrayList<>();

    public SifDAO() {
        sifLst.add(new SifDTO("CUT Trouble Ticket", "Workflow Process", "NC TT New Ticket Created Workflow", "Christoph"));
        sifLst.add(new SifDTO("CUT Order Management", "Workflow Process", "NC Validate Order WF", "Böhm"));
    }

    public SifDTO getSifFromFile(String file){
        SifDTO result = null;

        if(file.endsWith(".sif")){
            result = this.getSifFromFile(new File(file));
        }

        return result;
    }

    public SifDTO getSifFromFile(File file){
        return new SifDTO("","","","");
    }

    public List<SifDTO> getSifsFromFolder(String path){
        ArrayList<SifDTO> al = new ArrayList<>();
        File[] fileList = null;
        File folder = new File(path);

        if(folder.exists()){
            fileList = folder.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    if(name.contains(".sif")){
                        return true;
                    } else {
                        return false;
                    }
                }
            });

            for(File curFile : fileList){
                al.add(getSifFromFile(curFile));
            }
        }

        return al;
    }

    public List<SifDTO> getSifFromStorageViaXmlSearch(String searchString){
        ArrayList<SifDTO> result = new ArrayList<>();

        for(SifDTO curSif : sifLst){
            if(curSif.getXml().contains(searchString)){
                result.add(curSif);
            }
        }

        return result;
    }
}
