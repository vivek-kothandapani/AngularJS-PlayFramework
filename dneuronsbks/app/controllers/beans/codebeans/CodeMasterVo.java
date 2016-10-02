package controllers.beans.codebeans;

import java.util.List;

public class CodeMasterVo {
	private List<CodeVo>  codeVoList;
	private List<CodeAccountTypeVo>  codeAccountTypeVoList;
	
	public List<CodeVo> getCodeVoList() {
		return codeVoList;
	}
	public void setCodeVoList(List<CodeVo> codeVoList) {
		this.codeVoList = codeVoList;
	}
	/**
	 * @return the codeAccountTypeVoList
	 */
	public List<CodeAccountTypeVo> getCodeAccountTypeVoList() {
		return codeAccountTypeVoList;
	}
	/**
	 * @param codeAccountTypeVoList the codeAccountTypeVoList to set
	 */
	public void setCodeAccountTypeVoList(List<CodeAccountTypeVo> codeAccountTypeVoList) {
		this.codeAccountTypeVoList = codeAccountTypeVoList;
	}
}