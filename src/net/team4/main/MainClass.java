package net.team4.main;

import net.team4.codes.CreateFile;
import net.team4.codes.SourceCodes;
import net.team4.mvc.controller.ControllerLogin;
import net.team4.mvc.model.ModelLogin;
import net.team4.mvc.view.ViewLogin;

public class MainClass {
    
    public static void main(String[] args) throws Exception{
        if(CreateFile.getInstance().createFile()){
            new ControllerLogin(new ViewLogin(), new ModelLogin());
        }else{
            SourceCodes.getInstance().sendMessageError("Error: No se pudo crear los archivos, vuelva a intentarlo o verifique la consola");
        }
    }
    
}
