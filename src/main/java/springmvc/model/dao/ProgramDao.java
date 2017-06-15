package springmvc.model.dao;

import java.util.List;

import springmvc.model.Program;

public interface ProgramDao {

    Program getProgram( Integer id );

    List<Program> getPrograms();

    Program saveProgram (Program prog);
    
    void removeProgram (Program prog);
    
}