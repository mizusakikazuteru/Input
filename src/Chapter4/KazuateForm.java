package Chapter4;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.sun.istack.internal.NotNull;

/**
 * Servlet implementation class KazuateForm
 */
@WebServlet("/KazuateForm")
public class KazuateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "この項目は必須入力です。")
	@Max(value = 99, message = "{value}以下の数値を入力して下さい。")
	@Min(value = 0, message = "{value}以上の数値を入力して下さい。")
	private String num;

	public String getNum(){
		return num;
	}

	public void setNum(String num){
		this.num = num;
	}
}
