package controllers.beans.reports;

import java.util.List;
import java.util.Map;

import controllers.beans.codebeans.CodeGroupVo;

public class BalanceSheetVo extends ReportVo{
	
	private List<CodeGroupVo> codeGroupVoList;
	private Map<String,Integer> codeGroupVoIdMap;

	public List<CodeGroupVo> getCodeGroupVoList() {
		return codeGroupVoList;
	}

	public void setCodeGroupVoList(List<CodeGroupVo> codeGroupVoList) {
		this.codeGroupVoList = codeGroupVoList;
	}

	public Map<String,Integer> getCodeGroupVoIdMap() {
		return codeGroupVoIdMap;
	}

	public void setCodeGroupVoIdMap(Map<String,Integer> codeGroupVoIdMap) {
		this.codeGroupVoIdMap = codeGroupVoIdMap;
	}
}