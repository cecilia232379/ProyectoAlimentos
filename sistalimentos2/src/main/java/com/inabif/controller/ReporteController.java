package com.inabif.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.inabif.constant.ViewConstant;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.poifs.nio.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsXlsView;

import com.inabif.constant.ViewConstant;
import com.inabif.repository.FeriadoRepository;
import com.inabif.repository.PeriodoRepository;
import com.inabif.service.PeriodoService;
import com.inabif.entity.Periodo;



import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Controller
@RequestMapping("/reporte")
public class ReporteController {
	
	private static final Log LOG = LogFactory.getLog(PeriodoController.class);
	
	@Autowired
    protected org.apache.tomcat.jdbc.pool.DataSource localDataSource;
	
	@Autowired
    private ApplicationContext appContext;
	
	@Autowired
	@Qualifier("periodoServiceImpl")
	private PeriodoService periodoService;
	
	@Autowired
	@Qualifier("periodoRepository")
	private PeriodoRepository periodoRepository;
	
	@Autowired
	@Qualifier("feriadoRepository")
	private FeriadoRepository feriadoRepository;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(ViewConstant.REPORTE);

		return mav;
		
	}
	
//	public int NumDiasCAR() {
//		
//	
	
	public int NumDiasCEDIF(String PerFecInicio,int mes,int numdias) {
		

		 List<String> fechas = new ArrayList<String>();
		 List<String> fechas_mes = new ArrayList<String>();
		 List<String> fechas_mes_sin_feriado = new ArrayList<String>();
		//agrega dias
			System.out.println("Date before Addition: "+PerFecInicio);
			//Specifying date format that matches the given date
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			try{
			   //Setting the date to the given date
			   c.setTime(sdf.parse(PerFecInicio));
			}catch(ParseException e){
				e.printStackTrace();
			 }
			   
			//Number of Days to add
			//c.add(Calendar.DATE, 1);
			c.add(Calendar.DAY_OF_MONTH, numdias);  
			//Date after adding the days to the given date
			String newDate = sdf.format(c.getTime());  
			//Displaying the new Date after addition of Days
			System.out.println("Date after Addition: "+newDate);
		//llenado de fechas
		for(int i = 0;i<numdias;i++) {
			try{
			   //Setting the date to the given date
			   c.setTime(sdf.parse(PerFecInicio));
			}catch(ParseException e){
				e.printStackTrace();
			}
			c.add(Calendar.DAY_OF_MONTH, (i+1));
			fechas.add(sdf.format(c.getTime()));
			
		}
		//verificar que todos sean del mismo mes
		for (String fecha : fechas) {
			//no es feriado
			if(Retorna_Mes(fecha)==mes) {
				fechas_mes.add(fecha);
			}
		} 
		//verifica que no sean feriado
		for (String fecha : fechas_mes) {
			//no es feriado
			if(Verifica_Feriado(fecha)==0) {
				fechas_mes_sin_feriado.add(fecha);
			}
		} 
			
		
	    return fechas_mes_sin_feriado.size();
	}
    public int Verifica_Feriado(String fev) {
    	int fee=0;
    	//Date fechaferiado;
    	//String string = "January 2, 2010";
    	DateFormat format = new SimpleDateFormat("dd/mm/yy");
    	Date fechaferiado;
		try {
			fechaferiado = format.parse(fev);
			
			 if (feriadoRepository.findByFerfechaferiado(fechaferiado) == null) {
				 fee =0;
			 }else {
				 fee =1;	
			 }
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	    	return fee;
    	
    }
	public int Retorna_Mes( String fecha)
	{
		String [] dateParts = fecha.split("/");
		String day = dateParts[0];
		String month = dateParts[1];
		String year = dateParts[2];

	    return Integer.parseInt(month);
	}

	
	@GetMapping(value = "/getlista/{ano}/{mes}/{unidad_organica}/{tipo}")
	public String showPeriodoList(Model model, @PathVariable("ano") int ano, @PathVariable("mes") int mes, @PathVariable("unidad_organica") int unidad_organica, @PathVariable("tipo") int tipo) {
	    model.addAttribute("reporte", periodoService.findPeriodosByYearAndMonth(ano, mes));
	    model.addAttribute("ano");
	    model.addAttribute("mes");
	    model.addAttribute("unidad_organica");
	    model.addAttribute("tipo");
	    return "reportetable :: resultsList";
	}

	
	@GetMapping(path = "/excel2/{mes}/{ano}/{periodo}")
    public @ResponseBody void productExcel(@PathVariable("mes") int mes, @PathVariable("ano") int ano, @PathVariable("periodo") int idperiodo, HttpServletResponse response) {
	
		try {
			final String  url="/reports/Blank_A4_Landscape.jrxml";	
			InputStream jasperStream =  this.getClass().getResourceAsStream(url);
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			
			java.sql.Connection con = localDataSource.getConnection();
			
			Map <String,Object> parameterMap = new HashMap();
			
			//JRDataSource jRdataSource = new JRBeanCollectionDataSource(periodoRepository.findPeriodosByYearAndMonth(2017,9));
			//parameterMap.put("datasource", jRdataSource);
			parameterMap.put("mes", mes);
			parameterMap.put("ano", ano);
			parameterMap.put("periodo",idperiodo);
			
			Periodo periodo = periodoRepository.findByIdperiodo(idperiodo);
			//--

	        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        String formattedDate_fecinicio = formatter.format(periodo.getPerfecinicio());
	        String formattedDate_fecfin = formatter.format(periodo.getPerfecfin());
			
			//--
			String subtittle = "SEMANA DEL "+formattedDate_fecinicio+" AL "+formattedDate_fecfin;
			System.out.println("fecha de inicio "+periodo.getPerfecinicio());
			
			//String PerFecInicio="16/10/2017";
			//String PerFecInicio="15/12/2017";
			int division=NumDiasCEDIF(formattedDate_fecinicio,mes,ViewConstant.CANTIDAD_DIAS_CEDIF);
			System.out.println(division);	
			parameterMap.put("division", division);
			
			
			parameterMap.put("title", "Consolidado de alimentos");
			parameterMap.put("subtitle", "Unidad de Desarrollo Integral de Familias");
			parameterMap.put("subbtitle", subtittle);
			
			
			//JasperPrint jasperPrint = JasperFillManager.fillReport(report,parameterMap,jRdataSource);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,parameterMap,con);
			response.setContentType("application/ms-excel");
			response.setHeader("Content-Disposition","inline; filename=Blank_A4_Landscape.xls");
			
			final OutputStream outputStream = response.getOutputStream();
			
			JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT,jasperPrint);
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,outputStream);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.FALSE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
			
			exporterXLS.exportReport();
			
			
		}catch (JRException ex) {
			LOG.info("tidak bisa membaca file jrxms");
		}
		catch (IOException ex) {
			LOG.info("tidak bisa membaca file jrxms");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    
	
	}
}
