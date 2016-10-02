package controllers.beans.codebeans.util;

import java.util.Comparator;

import org.apache.commons.lang3.StringUtils;

import controllers.beans.codebeans.CodeGroupVo;

public class CodeGroupVoComparator implements Comparator<CodeGroupVo> {

	@Override
	public int compare(CodeGroupVo o1, CodeGroupVo o2) {

		String sortOrderStr1 =  o1.getSortOrder();
		String sortOrderStr2 =  o2.getSortOrder();
		
		Integer sortOrder1 = -100000;
		Integer sortOrder2 = -100000;
		
		if(sortOrderStr1 != null && StringUtils.isNotEmpty(sortOrderStr1))
		{
			try{
				sortOrder1 = Integer.parseInt(sortOrderStr1);
			}
			catch (Exception e)
			{
				
			}
		}
		
		if(sortOrderStr2 != null && StringUtils.isNotEmpty(sortOrderStr2))
		{
			try{
				sortOrder2 = Integer.parseInt(sortOrderStr2);
			}
			catch (Exception e)
			{
				
			}
		}
		return sortOrder1.compareTo(sortOrder2);
	}
}
