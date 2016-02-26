package Chapter4;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/chap04/kazuate") //ここ　/kazuateから/chap04/kazuateに変更
public class KazuateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static int answerNum;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("UTF-8");

		Map<String, String[]> parameterMap = request.getParameterMap();

		if(isNewGame(parameterMap) == true){
			processNewGame(request);
		}else{
			processGuess(request);
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("kazuate.jsp");
		dispatcher.forward(request, response);
	}

	private void processNewGame(HttpServletRequest request) {
		// TODO 自動生成されたメソッド・スタブ

	}

	private void processGuess(HttpServletRequest request) {
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
	private void processNewgame(HttpServletRequest request){
		answerNum = StrictMath.abs(new Random(System.currentTimeMillis())
				.nextInt() % 100);
	}

	private boolean isNewGame(Map<String, String[]> parameterMap){
		return parameterMap.containsKey("newGame");
	}
}
