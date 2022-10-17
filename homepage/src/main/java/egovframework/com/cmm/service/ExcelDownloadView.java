package egovframework.com.cmm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.ibm.icu.math.BigDecimal;

public class ExcelDownloadView extends AbstractExcelView{
	@Override
	@SuppressWarnings({"unchecked", "deprecation"})
	protected void buildExcelDocument(Map model, HSSFWorkbook wb, HttpServletRequest rsq, HttpServletResponse resp) throws Exception{
		
		//ReservationAdminApplyController에서 dataMap을 가져옴
		Map<String, Object> dataMap = (Map<String, Object>)model.get("dataMap");
		
		String title = (String)dataMap.get("title");
		List<String> columMap = (List<String>) dataMap.get("columMap");
		List<Object> valueMap = (List<Object>) dataMap.get("valueMap");
		
		HSSFCell cell = null;
		HSSFCellStyle style = this.getHSSFCellStyleByHeader(wb);
		
		//컨트롤러에 설정된 타이틀값을 넣음(+26번)
		HSSFSheet sheet = wb.createSheet(title);
		
		if(columMap != null && columMap.size() > 0 ) {
			//header 정보 등록
			for(int i = 0; i < columMap.size(); i++) {
				sheet.setColumnWidth(i, 500 * 8);
				
				cell = getCell(sheet, 0 ,i);
				cell.setCellStyle(style);
				setText(cell, columMap.get(i));
			}
			
			//body 정보 등록
			Object obj = null;
			for(int i = 0; i < valueMap.size(); i++) {
				
				Map<String, Object> data = (Map<String, Object>)valueMap.get(i);
				
				for(int di = 0; di < columMap.size(); di++) {
					obj = data.get(columMap.get(di));
					cell = getCell(sheet, 1 + i, di);
					if(obj instanceof String) {
						setText(cell, (String)obj);
					}else if(obj instanceof Integer || obj instanceof Long || obj instanceof Double || obj instanceof BigDecimal || obj instanceof Float) {
						cell.setCellValue(Double.valueOf(String.valueOf(obj)));
					}else if(obj instanceof Long) {
						setText(cell, (String)obj);
					}
				}
			}
		}
	}
	
	private HSSFCellStyle getHSSFCellStyleByHeader(HSSFWorkbook wb) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
		
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setTopBorderColor(HSSFColor.BLACK.index);
		
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setRightBorderColor(HSSFColor.BLACK.index);
		
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		
		return style;
	}

}
