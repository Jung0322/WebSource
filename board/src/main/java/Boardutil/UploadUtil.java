package Boardutil;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadUtil {
	public Map<String, String> map = new HashMap<>();

	public Map<String, String> requestParse(HttpServletRequest request) {

		String fieldName = null, fileName = null, value = null;

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if (isMultipart) {
			
			// 전송된 파일을 디스크에 저장하기 위한 객체
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 업로드 가능 사이즈 지정
			upload.setSizeMax(2000 * 1024);

			// 사용자의 request 분석
			List<FileItem> fileItems = null;
			try {
				fileItems = upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Iterator<FileItem> iter = fileItems.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();

				// text,password,checkbox....
				if (item.isFormField()) {
					// 요소명
					fieldName = item.getFieldName();
					try {
						value = item.getString("utf-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					map.put(fieldName, value);
					
				} else { // type=file
					// 요소명
					fieldName = item.getFieldName();
					// 파일명
					fileName = item.getName();

					File file = null;
					if (!fileName.isEmpty() && item.getSize()>0) {
						// 파일 저장
						String path = "e:\\upload\\";

						// 중복되지 않은 고유한 키 값 생성
						UUID uuid = UUID.randomUUID();

						// e:\\upload\\고유값_업로드파일명
						file = new File(path + uuid.toString() + "_" + fileName);
						try {
							item.write(file);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						map.put(fieldName, file.getName());
					}
				}
			}
		}
		return map;
	}
}
