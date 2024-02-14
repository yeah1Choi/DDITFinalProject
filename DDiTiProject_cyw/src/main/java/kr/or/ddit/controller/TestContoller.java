package kr.or.ddit.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.entity.FileType;
import kr.or.ddit.service.IFileService;
import kr.or.ddit.service.ILoginService;
import kr.or.ddit.service.impl.FileService;
import kr.or.ddit.utils.UploadFileUtils;
import kr.or.ddit.vo.FilesVO;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestContoller {
	
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String home()
	 * { return "home"; }
	 */
	
	/*
	 * @RequestMapping(value="/nav", method=RequestMethod.GET) public String test()
	 * { return "/common/tiles/nav"; }
	 */
	
	// root-context.xml 에서 설정한 uploadPath 
//	@Resource(name = "uploadPath")
//	private String resourcePath;
	
	
	//파일 테스트용
	@PostMapping("/fileUpload")
	public String fileUpload(MultipartFile files, HttpServletRequest req) {
		System.out.println("files : " + files);

		FilesVO filesVO = null;
		try {
			filesVO = UploadFileUtils.uploadFile(files, FileType.BOARD, req);
		} catch (Exception e) {
			e.printStackTrace();
			//파일 업로드 실패시 처리
		}

		System.out.println("filesVO : " + filesVO);
		
		//int fileNo = fileService.addFile()
		
		return "redirect:/DYUniv/tilesTest";
	}
	
	
	@RequestMapping(value="/gridStack", method=RequestMethod.GET)
	public String gridStack() {
		return "test/testGridStack";
	}
	
	
	@RequestMapping(value="/tilesTest", method=RequestMethod.GET)
	public String tiles() {
		return "test/test001";
	}
	
	@RequestMapping(value="/lecture", method=RequestMethod.GET)
	public String lec() {
		return "test/lectureList";
	}
	
	
	//
	@RequestMapping(value="/professor/uiSliders.do", method=RequestMethod.GET)
	public String test001() {
		return "professor/uiSliders";
	}
	//
	@RequestMapping(value="/professor/attend.do", method=RequestMethod.GET)
	public String test002() {
		return "professor/attend2";
	}
	//
	@RequestMapping(value="/professor/testclass.do", method=RequestMethod.GET)
	public String test003() {
		return "professor/test_classRoom";
	}
	//
	@RequestMapping(value="/professor/datePage.do", method=RequestMethod.GET)
	public String test004() {
		return "professor/date_page";
	}

	
	@RequestMapping(value="/test1", method=RequestMethod.GET)
	public String test1() {
		return "student/classCheck";
	}
	@RequestMapping(value="/test2", method=RequestMethod.GET)
	public String test2() {
		return "student/classRoom";
	}
	@RequestMapping(value="/test3", method=RequestMethod.GET)
	public String test3() {
		return "student/classScore";
	}
	@RequestMapping(value="/test4", method=RequestMethod.GET)
	public String test4() {
		return "student/clubList";
	}
	@RequestMapping(value="/test5", method=RequestMethod.GET)
	public String test5() {
		return "student/counselList";
	}
	@RequestMapping(value="/test6", method=RequestMethod.GET)
	public String test6() {
		return "student/counselReservForm";
	}
	@RequestMapping(value="/test7", method=RequestMethod.GET)
	public String test7() {
		return "student/FacilityRentForm";
	}
	@RequestMapping(value="/test8", method=RequestMethod.GET)
	public String test8() {
		return "student/facilityRentList";
	}
	
	@RequestMapping(value="/test11", method=RequestMethod.GET)
	public String test11() {
		return "student/lectureList";
	}
	@RequestMapping(value="/test12", method=RequestMethod.GET)
	public String test12() {
		return "student/profile";
	}
	@RequestMapping(value="/test13", method=RequestMethod.GET)
	public String test13() {
		return "student/scholarship";
	}
	@RequestMapping(value="/test14", method=RequestMethod.GET)
	public String test14() {
		return "student/clubList";
	}
	@RequestMapping(value="/test15", method=RequestMethod.GET)
	public String test15() {
		return "student/ViewClubDetail";
	}
	@RequestMapping(value="/test16", method=RequestMethod.GET)
	public String test16() {
		return "employer/newStudentList";
	}
	@RequestMapping(value="/test17", method=RequestMethod.GET)
	public String test17() {
		return "student/facilityRentForm";
	}
	@RequestMapping(value="/test18", method=RequestMethod.GET)
	public String test18() {
		return "student/reserveClassForm";
	}
	@RequestMapping(value="/test19", method=RequestMethod.GET)
	public String test19() {
		return "student/anonymousBoard";
	}
	@RequestMapping(value="/test20", method=RequestMethod.GET)
	public String test20() {
		return "student/LostItemBoard";
	}
	
	@RequestMapping(value="/test21", method=RequestMethod.GET) 
	public String test21() {
		return "student/ViewClubDetail";
	}
	@RequestMapping(value="/test22", method=RequestMethod.GET)
	public String test22() {
		return "student/volunteerDetail";
	}
	
	@RequestMapping(value="/test23", method=RequestMethod.GET)
	public String test23() {
		return "student/restApplyForm";
	}
	
	@RequestMapping(value="/test24", method=RequestMethod.GET)
	public String test24() {
		return "student/counselReservForm";
	}
	
	@RequestMapping(value="/test25", method=RequestMethod.GET)
	public String test25() {
		return "student/FacilityRentForm";
	}
	
	@RequestMapping(value="/test26", method=RequestMethod.GET)
	public String test26() {
		return "student/anonymousForm";
	}
	@RequestMapping(value="/test27", method=RequestMethod.GET)
	public String test27() {
		return "student/anonymousBoard";
	}
	@RequestMapping(value="/test28", method=RequestMethod.GET)
	public String test28() {
		return "student/anonymousDetail";
	}

	@RequestMapping(value="/test29", method=RequestMethod.GET)
	public String test29() {
		return "certificate/pwCertified";
	}
	
	
}
