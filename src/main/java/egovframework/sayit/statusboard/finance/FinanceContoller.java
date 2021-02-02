package egovframework.sayit.statusboard.finance;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.sayit.statusboard.sotong.SotongVO;

@Controller
public class FinanceContoller {
	@Resource(name="financeService")
    private FinanceService financeService;

    @RequestMapping(value="/getTotalFinance.do")
    public @ResponseBody Object selectTotalFinance(
    		@ModelAttribute("financeVO") FinanceVO financeVO,
    		HttpServletRequest request,
    		HttpServletResponse response) throws Exception{

    	Map<String, Object> mp = new HashMap<String, Object>();
    	JSONObject json = new JSONObject();
    	
    	FinanceVO budgetVO = new FinanceVO();
    	FinanceVO incomeVO = new FinanceVO();
    	FinanceVO expensesVO = new FinanceVO();
    	
    	String budget = "";
    	String income = "";
    	String expenses = "";
    	String incomePer = "";
    	String expensesPer = "";
    	
    	int tempBg;
    	int tempInc;
    	int tempEx;

    	
    	Calendar cal = Calendar.getInstance();
    	int year = cal.get ( cal.YEAR );
    	String stYear = year + "";
    	
    	financeVO.setFinanceYear(stYear);
    	
    	budgetVO = financeService.selectTotalBuget(financeVO);

    	incomeVO = financeService.selectTotalIncome(financeVO);
    	
    	expensesVO = financeService.selectTotalExpenses(financeVO);
    	
    	budget = budgetVO.getBudget();
    	income = incomeVO.getIncome();
    	expenses = expensesVO.getExpenses();
//    	
    	json.put("budget", budget);
    	json.put("income", income);
    	json.put("expenses", expenses);

    	mp.put("finance", json);
			
		return getJsonStringFromMap(mp, response);
				 
    }

	public static JSONObject getJsonStringFromMap( Map<String, Object> map, HttpServletResponse response ) throws IOException {

		response.setContentType("text/plain; charset=utf-8");
   		PrintWriter out = response.getWriter();
		
		JSONObject json = new JSONObject();
		JSONObject json2 = new JSONObject();
		for( Map.Entry<String, Object> entry : map.entrySet() ) {
			String key = entry.getKey();
			Object value = entry.getValue();
			json.put(key, value);
		}
		
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.print(json);
		printWriter.flush();
		printWriter.close();
		
		return null;
	}
}
