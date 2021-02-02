package egovframework.sayit.statusboard.event;

public class TodayEventVO {

	private int fileDocnum;
	private String fileName = "";
	private String fileStartdate = "";
	private String fileEnddate = "";
	
	public int getFileDocnum() {
		return fileDocnum;
	}
	public void setFileDocnum(int fileDocnum) {
		this.fileDocnum = fileDocnum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileStartdate() {
		return fileStartdate;
	}
	public void setFileStartdate(String fileStartdate) {
		this.fileStartdate = fileStartdate;
	}
	public String getFileEnddate() {
		return fileEnddate;
	}
	public void setFileEnddate(String fileEnddate) {
		this.fileEnddate = fileEnddate;
	}

	
}
