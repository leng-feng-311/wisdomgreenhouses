package com.hongfeng.common.tool;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PageTag extends SimpleTagSupport {
	// 提交URL的一个约定的格式: pageSerlvet?pageIndex={0}
	private static final String TEG = "{0}";

	private String parms;
	// 当前页数
	private int pageIndex;
	// 一页显示的数量
	private int pageSize;
	// 记录总条数
	private int recordCount;
	// 提交的URL
	private String submitUrl;

	// 定义总共的页数
	private int pageCount;

	//每页显示的实际数量
	private int  pageRealSize;

	public int getPageRealSize() {
		return pageRealSize;
	}

	public void setPageRealSize(int pageRealSize) {
		this.pageRealSize = pageRealSize;
	}

	/**
	 * Pre前一页
	 * Next下一页
	 * &laquo;向←左left
	 * &raquo;向→右right
	 *
	 */
	public void doTag() throws JspException, IOException {

		StringBuilder pageWrapStr = new StringBuilder();
		StringBuffer  pageNumberStr = new StringBuffer();
		if(parms==null || parms.isEmpty() || parms.trim().length()==0){

		}else{
			submitUrl+="&"+this.getParms();
		}

		// 先判断记录总条数
		if (recordCount > 0) {
			// 计算出总共的页数
			pageCount = (recordCount % pageSize == 0) ? (recordCount / pageSize)
					: (recordCount / pageSize) + 1;
			// 判断总页数与当前页数的关系
			pageIndex = (pageIndex >= pageCount) ? pageCount : pageIndex;

			//计算该页实际显示记录数
			if(pageIndex<pageCount){
				pageRealSize=pageSize;
			}else{
				pageRealSize=recordCount-pageSize*(pageIndex-1);
			}

			pageWrapStr.append(" <div class='page-number-strip' style='height:80px;'> ");//page-number-strip

			// 确定上一页与下页是否加链接
			String tempUrl1 = submitUrl.replace(TEG, String.valueOf(1));
			pageNumberStr.append("<ul class='pagination'>");//添加boostrap分页样式

			pageNumberStr.append("<li><a  href='" + tempUrl1 + "'>&laquo;</a> </li>");
			if (pageIndex == 1) { // 当前页数为第一页时
				pageNumberStr.append("<li><span><</span> </li>"); // 头
				// 中间
				calculatePage(pageNumberStr);
				// 尾
				if (pageCount == 1) {
					pageNumberStr.append("<li><span>></span> </li>");
				} else {
					String tempUrl = submitUrl.replace(TEG,String.valueOf(pageIndex + 1));
					pageNumberStr.append("<li><a href='" + tempUrl + "'>></a> </li>");
				}
			} else if (pageIndex == pageCount) { // 当前页数为最后一页时
				String tempUrl = submitUrl.replace(TEG, String.valueOf(pageIndex - 1));
				pageNumberStr.append("<li><a href='" + tempUrl + "'><</a> </li>");
				// 中间
				calculatePage(pageNumberStr);
				// 最后一页
				pageNumberStr.append("<li><span>></span>");
			} else { // 当前页数为中间时
				String tempUrl = submitUrl.replace(TEG, String.valueOf(pageIndex - 1));
				pageNumberStr.append("<li><a href='" + tempUrl + "'><</a> </li>");
				// 中间
				calculatePage(pageNumberStr);
				// 尾
				tempUrl = submitUrl.replace(TEG, String.valueOf(pageIndex + 1));
				pageNumberStr.append("<li><a href='" + tempUrl + "'>></a> </li>");
			}
			String tempUrl2 = submitUrl.replace(TEG, String.valueOf(pageCount));
			pageNumberStr.append("<li><a href='" + tempUrl2 + "'>&raquo;</a> </li>");
			pageNumberStr.append("<li>&nbsp;&nbsp;跳到<input type='text' id='page_number_id' size='1' value='"+pageIndex+"' sytle='margin-top:5px;'/>页&nbsp;&nbsp;</li>");
			pageNumberStr.append("<li><a>当前第&nbsp;"+pageIndex+"&nbsp;页&nbsp;&nbsp;&nbsp;共&nbsp;" + pageCount + "&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共 " + recordCount + "  条记录&nbsp;&nbsp;</a></li>");
			pageNumberStr.append("<li><input type='button' value='确定' class='btn-page-confirm' style='color:#000'  onclick='doJumpPage();'/></li>");
			pageNumberStr.append("</ul>");

			// 加上跳转信息\显示信息
			pageWrapStr.append(pageNumberStr.toString());

			pageWrapStr.append(" </div> ");


			// 第二行拼接分页提示信息/ 计算出显录的开始记录条数与结束的记录条数
			int startNum = (pageIndex - 1) * pageSize + 1;
			int endNum = (pageIndex == pageCount) ? recordCount : pageIndex * pageSize;

			// 最后拼接JavaScript代码
			pageWrapStr.append("<script type=\"text/javascript\">");


			pageWrapStr.append("var doJumpPage = function(){");
			pageWrapStr.append("var pageCount = " + pageCount + ";");
			pageWrapStr.append("var url = '" + submitUrl + "';");
			pageWrapStr.append("var regu='^[0-9]+$'; var re=new RegExp(regu);");
			pageWrapStr.append("var num = document.getElementById('page_number_id').value;");
			pageWrapStr.append("if(num.search(re)==-1){alert('请输入整数！'); return false}");
			pageWrapStr.append("if (isNaN(num) ||  num < 1 || num > pageCount){alert('请输入1-"+ pageCount + "范围内的页码!');return false;}");
			pageWrapStr.append("var tempUrl = url.replace('" + TEG + "', num);");
			pageWrapStr.append("window.location.href = tempUrl;");
			pageWrapStr.append("}</script>");
			//num != Integer.parseInt(num) ||
		}
		// 如果记录条数小于等于0，直接输出
		else {
//			pageWrapStr.append("<table align='center' style='font-size:14px;'><tr><td>");
//			pageWrapStr.append("总共<span style='color:red;'>0</span>条记录，当前显示0-0条记录。");
//			pageWrapStr.append("</td></tr></table>");

			pageWrapStr.append(" <div class='page-number-strip' style='height:80px;'> ");//page-number-strip
			pageNumberStr.append("<ul class='pagination'>");
			pageNumberStr.append("<li><a>当前第&nbsp;0&nbsp;页&nbsp;&nbsp;&nbsp;共&nbsp;0&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共 0  条记录&nbsp;&nbsp;</a></li>");
			pageNumberStr.append("</ul>");

			// 加上跳转信息\显示信息
			pageWrapStr.append(pageNumberStr.toString());
			pageWrapStr.append(" </div> ");
		}

		// 输出
		this.getJspContext().getOut().println(pageWrapStr.toString());
	}

	/**
	 * 计算中间部分 [1]...[2][3]...[100]
	 *
	 * @param buder
	 */
	private void calculatePage(StringBuffer buder) {
		// 总页数小于等于10
		if (pageCount <= 10) {
			for (int i = 1; i <= pageCount; i++) {
				// 判断哪一个是当前页
				if (i == pageIndex) {
					buder.append("<li><span style='color:red;' >" + i + "</span> </li>");
				} else {
					String tempUrl = submitUrl.replace(TEG, String.valueOf(i));
					buder.append("<li><a href='" + tempUrl + "'>" + i + "</a> </li>");
				}
			}
		} else { // 三种情况: 靠近第一页\靠近最后一页\中间
			if (pageIndex <= 8) { // 靠近第一页
				for (int i = 1; i < 10; i++) {
					// 判断哪一个是当前页
					if (i == pageIndex) {
						buder.append("<li><span style='color:red;' >" + i + "</span> </li>");
					} else {
						String tempUrl = submitUrl.replace(TEG, String.valueOf(i));
						buder.append("<li><a href='" + tempUrl + "'>" + i + "</a> </li>");
					}
				}
				// 后面部分加上更多
				String tempUrl = submitUrl.replace(TEG, String.valueOf(pageCount));
				buder.append("<li><a href='javascript:void(0);'>...</a></li>").append("<li><a href='" + tempUrl + "'>" + pageCount + "</a> </li>");
			} else if (pageIndex > pageCount - 8) { // 靠近最后一页
				// 前面部分加上更多[1]...
				String tempUrl = submitUrl.replace(TEG, String.valueOf(1));
				buder.append("<li><a href='" + tempUrl + "'>1</a> </li>").append("<li><a href='javascript:void(0);'>...</a></li>");
				for (int i = pageCount - 8; i <= pageCount; i++) {
					if (i == pageIndex) {
						buder.append("<li><span style='color:red;' >" + i + "</span> </li>");
					} else {
						tempUrl = submitUrl.replace(TEG, String.valueOf(i));
						buder.append("<li><a href='" + tempUrl + "'>" + i + "</a> </li>");
					}
				}
			} else { // 中间
				// 前面部分加上更多[1]...
				String tempUrl = submitUrl.replace(TEG, String.valueOf(1));
				buder.append("<li><a href='" + tempUrl + "'>1</a> </li>").append("<li><a href='javascript:void(0);'>...</a></li>");
				for (int i = pageIndex - 4; i <= pageIndex + 4; i++) {
					if (i == pageIndex) {
						buder.append("<li><span style='color:red;' >" + i + "</span> </li>");
					} else {
						tempUrl = submitUrl.replace(TEG, String.valueOf(i));
						buder.append("<li><a href='" + tempUrl + "'>" + i + "</a> </li>");
					}
				}
				// 后面部分加上更多
				tempUrl = submitUrl.replace(TEG, String.valueOf(pageCount));
				buder.append("<li><a href='javascript:void(0);'>...</a></li>").append("<li><a href='" + tempUrl + "'>" + pageCount + "</a></li>");
			}
		}
	}

	/** setter and getter method */
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = (pageIndex < 1) ? 1 : pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public String getSubmitUrl() {
		return submitUrl;
	}

	public void setSubmitUrl(String submitUrl) {
		this.submitUrl = submitUrl;
	}

	public String getParms() {

		StringBuffer ps=new StringBuffer();
		if(parms!=null && parms.length()>0){
			//分离参数 A=b
			String[] parmsArr=parms.split("&");
			for(int i=0;i<parmsArr.length;i++){
				String parmstemp=parmsArr[i];
				String[] parmsEqArr=parmstemp.split("=");
				//分离参数 键 值
				try {
					ps.append(i > 0 ? "&" : "");
					ps.append(parmsEqArr[0]).append("=");
					if(parmsEqArr.length>1){
						ps.append( URLEncoder.encode(parmsEqArr[1],"UTF-8"));
					}
				} catch (UnsupportedEncodingException e) {
					return "";
				}
			}
		}

		return ps.toString();
	}

	public void setParms(String parms) {
		this.parms = parms;
	}

}
