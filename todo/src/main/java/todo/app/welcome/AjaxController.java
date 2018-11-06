package todo.app.welcome;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

@Controller
@RequestMapping("ajaxTransactionTokenCheck")
@TransactionTokenCheck("ajaxTransactionTokenCheck")
public class AjaxController {

	@RequestMapping(params = "first", method = RequestMethod.GET)
	@TransactionTokenCheck(type = TransactionTokenType.BEGIN) 
	public String test1(Locale locale, Model model) {

		System.out.println("test1 called");

		return "welcome/test1";
	}
	
	@RequestMapping(params = "second", method = RequestMethod.GET)
	@TransactionTokenCheck
	public String test2(Locale locale, Model model) {

		System.out.println("test2 called");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "welcome/test2";
	}

	@RequestMapping(params = "third", method = RequestMethod.GET)
	@TransactionTokenCheck(type = TransactionTokenType.IN) 
	public String test3(Locale locale, Model model) {

		System.out.println("test3 called");

		return "welcome/test3";
	}
	
	@RequestMapping(value = "getTestData", method = RequestMethod.GET)
	@ResponseBody
	@TransactionTokenCheck(type = TransactionTokenType.CHECK) 
	public String[] getTestData() {

		String[] datas = { "test1", "test2", "test3" };

		return datas;
	}
}
