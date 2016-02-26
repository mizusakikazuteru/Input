package Chapter4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.Validator;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing.Validation;




@WebServlet("/chap04/kazuateJavaEEValidation")
public class KazuateJavaEEValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static int answerNum;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Map<String, String[]> parameterMap = request.getParameterMap();
		KazuateForm form = toKazuateForm(request);

		if(isNewGame(parameterMap) == true){
			processNewGame(request);
		}else{
			processGuess(request);
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("kazuateJavaEEValidation.jsp");
		dispatcher.forward(request, response);
	}

	private KazuateForm toKazuateForm(HttpServletRequest request){
		KazuateForm ret = new KazuateForm();

		String num = request.getParameter("num");
			if(num.isEmpty() == false){
				ret.setNum(num);
			}
			return ret;
	}


	private void processGuess(HttpServletRequest request, KazuateForm form)
	{
		Map<String, List<String>> validationMessages = validate(request,form);

		if(validateionMessage.isEmpty() == false){
			request.setAttribute("validationMessage", validationMessage);
			return;
		}

		int num = Integer.parseInt(request.getParameter("num"));
		String message;
		if(answerNum == num){
			message = "正解です!";
		}else if (answerNum < num ){
			message = "ハズレ!" + num + "は正解より大きい値です。";
		}else {
			message = "ハズレ!" + num + "は正解より小さい値です。";
		}
		request.setAttribute("message", message);
		}

	private Map<String, List<String>> validate(HttpServletRequest request,
			KazuateForm form) {

		ValidatorFactory validatorFactory = Validation
				.buildDefaultValidatorFactory();

		Validator validator = validatorFactory.getValidator();

		Set<ConstraintVioolation<KazuateForm>> validationResult=
				validator.validate(form);

		Map<String, List<String>> ret = new HashMap<Stiring, List<String>>();
			for(ConstraintViolation<kazuateForm> violation : validationResult)
			{
				String propertyPath = violation.getPropertyPath().toString();
				List<String> message = ret.get(propertyPath);
				if(message == null){
					messages = new ArrayList<String>();
					ret.put(propertyPath, messages);
				}
				message.add(violation.getMessage());
			}
			return ret;
	}

    private void processNewGame(HttpServletRequest request, KazuateFormform){
    	answerNum = StrictMath.abs(new Random(System.currentTimeMillis())
    			.nextInt() % 100);
    }

    private boolean isNewGame(Map<String, String[]> parameterMap){
    	return parameterMap.containsKey("newGame");
    }
 }




