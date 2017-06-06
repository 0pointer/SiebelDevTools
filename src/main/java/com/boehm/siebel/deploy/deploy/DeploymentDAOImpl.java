package com.boehm.siebel.deploy.deploy;

import com.boehm.siebel.deploy.deploy.dto.AdmDTO;
import com.boehm.siebel.deploy.deploy.exception.DeploymentException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeploymentDAOImpl implements DeploymentDAO {
    @Override
    public List<AdmDTO> getAdmFiles(String folder) throws DeploymentException {
        File f = new File(folder);
        File[] fileList = null;
        ArrayList<AdmDTO> adms = new ArrayList<>();

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".xml")){
                    return true;
                } else {
                    return false;
                }
            }
        };

        if(f.exists() && f.isDirectory()){
            fileList = f.listFiles(filter);

            for (File curFile : fileList) {
                adms.add(new AdmDTO(curFile.getAbsolutePath()));
            }
        } else {
            throw new DeploymentException("Der Eingabepfad konnte nicht ausgelesen werden.");
        }

        return adms;
    }
}
