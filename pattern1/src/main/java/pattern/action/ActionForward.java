package pattern.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ActionForward {
	//이동경로와 이동방식 저장
	private String path;
	private boolean redirect;
}
