package mx.com.vrm.viai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/sicop")
public class SICOPController {
	
	/** The Constant logger. 
	private static final Logger logger = LoggerFactory.getLogger(SICOPController.class);
	
	

	 @RequestMapping(value="/status", method=RequestMethod.GET,
	 produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseObj statusAll(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		 logger.info("************INICIA LA OBTENCION DEL STATUS************");
	 Datasets datasets = new Datasets();
	 List<String> listaData = new ArrayList<String>();
	 List<String> listaBackgroundColor = new ArrayList<String>();
	 List<String> listaLabels = new ArrayList<String>();
	 List<Options> listaOptions = new ArrayList<Options>();
	 Options opcion = new Options();
	 Legend legend = new Legend();
	 Title title = new Title();
	 Animation animation  = new Animation();
	 
	 listaData.add("100");
	 listaBackgroundColor.add("Green");
	 listaLabels.add("Red");
	 datasets.setData(listaData);
	 datasets.setLabel("Dataset 1");
	 
	 legend.setPosition("top");
	 title.setDisplay(true);
	 title.setText("Chart.js Doughnut Chart");
	 animation.setAnimateRotate(true);
	 animation.setAnimateScale(true);
	 
	 opcion.setResponsive(true);
	 opcion.setLegend(legend);
	 opcion.setTitle(title);
	 opcion.setAnimation(animation);
	 
	 listaOptions.add(opcion);
	 datasets.setOptions(listaOptions);
	 
	 
	 List<Datasets>  listaStatusJHE = new ArrayList<Datasets>();
     ResponseObj responseObj = new ResponseObj(eCodResp.OK, eMsgResp.OK, eTypeError.MDLWARE, listaStatusJHE);
	 return  responseObj;
	 }*/
}
