package board.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import Boardutil.UploadUtil;
import board.domain.BoardDTO;
import board.service.BoardInsertService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardInsertAction implements BoardAction {

	private String path;

	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {

		UploadUtil uploadUtil = new UploadUtil();
		Map<String, String> map = uploadUtil.requestParse(request);

		BoardDTO dto = new BoardDTO();
		dto.setTitle(map.get("title"));
		dto.setName(map.get("name"));
		dto.setContent(map.get("content"));
		dto.setPassword(map.get("password"));
		dto.setAttach(map.get("attach"));

		BoardInsertService service = new BoardInsertService();
		boolean InsertFlag = service.boardInsert(dto);
		if (!InsertFlag) {
			path = "/view/qna_board_write.jsp";
		}

		return new BoardActionForward(path, true);
	}

}
