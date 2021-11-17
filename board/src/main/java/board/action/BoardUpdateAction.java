package board.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import Boardutil.UploadUtil;
import board.domain.BoardDTO;
import board.service.BoardUpdateService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardUpdateAction implements BoardAction {

	private String path;
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		
		//  java.lang.NumberFormatException: null
		
		UploadUtil uploadUtil = new UploadUtil();
		Map<String, String> map = uploadUtil.requestParse(request);

		BoardDTO dto = new BoardDTO();
		dto.setTitle(map.get("title"));
		dto.setBno(Integer.parseInt(map.get("bno")));
		dto.setContent(map.get("content"));
		dto.setPassword(map.get("password"));
		dto.setAttach(map.get("attach"));
		
		BoardUpdateService service = new BoardUpdateService();
		boolean updateFlag = service.update(dto);
		
		if(updateFlag) {
			//read.do?bno=1
			path +="?bno="+dto.getBno();
		}else {
			path = "/modify.do?bno="+dto.getBno();
		}
		return new BoardActionForward(path,true);
	}

}
