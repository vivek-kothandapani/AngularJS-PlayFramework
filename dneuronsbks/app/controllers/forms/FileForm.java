package controllers.forms;

public class FileForm {
	private String fileId;
	private String filename;
	private String filetype;
	private String fileclass;
	
	public String getFileId() {
		return fileId;
	}
	public String getFilename() {
		return filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public String getFileclass() {
		return fileclass;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public void setFileclass(String fileclass) {
		this.fileclass = fileclass;
	}
}