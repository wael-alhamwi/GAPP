package springmvc.model.dao;

import java.util.List;

import springmvc.model.FileClass;

public interface FileDao {

	FileClass saveFile(FileClass file);
	
	List<FileClass> getFiles(Long id);
	
	List<String> getFileNames(Integer id);
	
	FileClass getFile(Integer id);
	
	void removeFile (FileClass file);
}
